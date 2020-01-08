package com.vytrack.runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;



    @RunWith(Cucumber.class)
    @CucumberOptions(

            features = "@target/rerun.txt",      // where is tjhe features files   //   /Users/banu/IdeaProjects/Summer2019OnLineCucumberSelenium/src/test/resources/features
            glue = "com/vytrack/step_definitions",    // where is the step definitions  //  /Users/banu/IdeaProjects/Summer2019OnLineCucumberSelenium/src/test/java/com/vytrack/step_definitions
            plugin = {
                    "html:target/rerun-default-cucumber-reports"  // create the report
            }
    )
    public class FailedRunner {

    }
    
