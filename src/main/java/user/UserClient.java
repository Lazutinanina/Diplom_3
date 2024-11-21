package user;

import io.restassured.http.ContentType;

import static constants.Endpoints.BASE_URI;
import static io.restassured.RestAssured.given;

public class UserClient {

    public static void createUser(User user) {
        given().contentType(ContentType.JSON)
                .body(user)
                .post(BASE_URI + "/api/auth/register");
    }


    public static void deleteUser(User user) {
        String accessToken = given()
                .contentType(ContentType.JSON)
                .body(user)
                .post(BASE_URI + "/api/auth/login")
                .body().path("accessToken");
        given().contentType(ContentType.JSON)
                .header("Authorization", accessToken)
                .body(user).delete(BASE_URI + "/api/auth/user");
    }

}
