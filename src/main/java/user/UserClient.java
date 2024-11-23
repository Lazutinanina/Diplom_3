package user;

import io.restassured.http.ContentType;

import static constants.Endpoints.*;
import static io.restassured.RestAssured.given;

public class UserClient {

    public static void createUser(User user) {
        given().contentType(ContentType.JSON)
                .body(user)
                .post(ENDPOINT_FOR_REGISTRATION);
    }


    public static void deleteUser(User user) {
        String accessToken = given()
                .contentType(ContentType.JSON)
                .body(user)
                .post(ENDPOINT_FOR_LOGIN_USER)
                .body().path("accessToken");

        given().contentType(ContentType.JSON)
                .header("Authorization", accessToken)
                .body(user).delete(ENDPOINT_FOR_USER);
    }

}
