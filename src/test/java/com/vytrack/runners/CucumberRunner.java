package com.vytrack.runners;


import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/features",        //   /Users/banu/IdeaProjects/Summer2019OnLineCucumberSelenium/src/test/resources/features
            glue = "com/vytrack/step_definitions",      //  /Users/banu/IdeaProjects/Summer2019OnLineCucumberSelenium/src/test/java/com/vytrack/step_definitions
            dryRun = true,
            tags = "",
            plugin = {"html:target/default-cucumber-reports"}   // create the report
)
public class CucumberRunner {



}
