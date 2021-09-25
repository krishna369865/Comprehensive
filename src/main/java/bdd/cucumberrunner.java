package bdd;


import java.io.File;
import java.io.FileReader;

import org.junit.runner.RunWith;
import org.testng.annotations.AfterClass;

import com.cucumber.listener.Reporter;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import cucumber.api.testng.AbstractTestNGCucumberTests;

@RunWith(Cucumber.class)
@CucumberOptions(
		features="src/main/java/features/Bdd.feature",
		glue="bdd")

public class cucumberrunner extends AbstractTestNGCucumberTests {

	
}
