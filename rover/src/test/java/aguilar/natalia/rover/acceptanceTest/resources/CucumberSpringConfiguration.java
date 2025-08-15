package aguilar.natalia.rover.acceptanceTest.resources;


import aguilar.natalia.rover.RoverApplication;
import io.cucumber.spring.CucumberContextConfiguration;
import org.springframework.boot.test.context.SpringBootTest;


@CucumberContextConfiguration
@SpringBootTest(
        classes= {RoverApplication.class},
        webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT

)
public class CucumberSpringConfiguration {


}
