import com.jayway.restassured.http.ContentType;
import com.jayway.restassured.module.mockmvc.RestAssuredMockMvc;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import pro.redsoft.springmvcexample.WebConfig;

import static org.hamcrest.core.IsEqual.equalTo;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = WebConfig.class)
@WebAppConfiguration
public class GreetingControllerTest extends BackendBaseTest {

    @Test
    public void exampleRestTest() {
        RestAssuredMockMvc.given()
                .contentType(ContentType.JSON)
                .when()
                .get("/greeting")
                .then()
                .statusCode(200)
                .body("id", equalTo(1))
                .body("content", equalTo("Hello, Johan!"));
    }
}
