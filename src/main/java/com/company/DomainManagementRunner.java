package com.company;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;




@RunWith(Cucumber.class)
@CucumberOptions(features = {"src/test/java/Features/TestSteps/StudiesPage.feature"}, glue = "Steps", dryRun = true)
public class DomainManagementRunner {

}
