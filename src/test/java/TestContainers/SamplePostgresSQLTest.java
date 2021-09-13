package TestContainers;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.testcontainers.containers.PostgreSQLContainer;
import org.testcontainers.utility.DockerImageName;

import java.sql.ResultSet;
import java.sql.SQLException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class SamplePostgresSQLTest extends AbstractContainerDatabaseTest {
    private static PostgreSQLContainer<?> postgres;

    @BeforeEach
    public void setup() {
        postgres = new PostgreSQLContainer<>(DockerImageName.parse("postgres:11.13-alpine"));
    }

    @AfterEach
    public void teardown() {
        postgres.stop();
    }


    @Test
    public void testSimple() throws SQLException {
        postgres.start();
        ResultSet resultSet = performQuery(postgres, "SELECT 1");
        int resultSetInt = resultSet.getInt(1);
        System.out.println("ResultSet : " + resultSetInt);
        assertEquals(1, resultSetInt,"A basic SELECT query succeeds");
    }


    @Test
    public void testWithInitScript() throws SQLException {
        postgres.withInitScript("samplePostgresSchema.sql");
        postgres.start();
        ResultSet resultSet = performQuery(postgres, "SELECT * FROM VADIVELU_MOVIES");
        resultSet.absolute(3);
        System.out.println(resultSet.getString(1) + " " + resultSet.getString(2) + " " + resultSet.getString(3));
        resultSet = performQuery(postgres, "SELECT NAME FROM VADIVELU_MOVIES WHERE STATUS='SuperHit'");
        String columnValue = resultSet.getString(1);
        assertEquals(columnValue, "Kaipulla", "Value from init script should equal real value");
    }


    @Test
    public void updateAColumn() throws SQLException {
        postgres.withInitScript("samplePostgresSchema.sql");
        postgres.start();
        performQueryUpdate(postgres, "UPDATE VADIVELU_MOVIES SET STATUS='MegaHit' WHERE MOVIE='Imsai Arasan'");
        ResultSet resultSet = performQuery(postgres, "SELECT STATUS FROM VADIVELU_MOVIES WHERE MOVIE='Imsai Arasan'");
        String changedValue = resultSet.getString(1);
        System.out.println(changedValue);
        assertNotEquals(changedValue, "Hit", "Value from init script should equal real value");
    }


}
