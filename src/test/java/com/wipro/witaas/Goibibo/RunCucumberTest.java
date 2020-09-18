package com.wipro.witaas.Goibibo;

import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(glue="com.wipro.witaas.Goibibo",
                features = "classpath:",
                plugin = { "pretty", "html:target/site/cucumber-pretty", "json:target/cucumber.json" })
public class RunCucumberTest {
}


