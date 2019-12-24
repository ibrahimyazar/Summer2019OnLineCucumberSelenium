package com.vytrack.runners;


import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
//        features = {
//                "src/test/resources/features/activities"
//                "src/test/resources/features/fleet"},
        features = "src/test/resources/features",      // where is tjhe features files   //   /Users/banu/IdeaProjects/Summer2019OnLineCucumberSelenium/src/test/resources/features
            glue = "com/vytrack/step_definitions",    // where is the step definitions  //  /Users/banu/IdeaProjects/Summer2019OnLineCucumberSelenium/src/test/java/com/vytrack/step_definitions
            dryRun = false,
            tags = "  @Column_names",
            plugin = {"html:target/default-cucumber-reports",
            "json:target/cucumber.json"}   // create the report
)
public class CucumberRunner {



}
