package com.dashboardjusttalk;


import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import io.cucumber.spring.CucumberContextConfiguration;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

//@RunWith(SpringRunner.class)
//@CucumberContextConfiguration
//@SpringBootTest()
//class DashboardJustTalkApplicationTests {
//
//	@Test
//	void contextLoads() {
//	}
//
//}
@RunWith(Cucumber.class)
@CucumberContextConfiguration
@CucumberOptions(features = "src/test/java/resources/features", glue = "Steps",publish = true)
public class DashboardJustTalkApplicationTests {
}

