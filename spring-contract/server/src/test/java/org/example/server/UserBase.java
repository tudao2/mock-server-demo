package org.example.server;

import io.restassured.module.webtestclient.RestAssuredWebTestClient;
import org.example.server.controller.UserController;
import org.junit.jupiter.api.BeforeEach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.reactive.WebFluxTest;

@WebFluxTest(UserController.class)
public class UserBase {

  @Autowired
  private UserController userController;

  @BeforeEach
  public void setup() {
    RestAssuredWebTestClient.standaloneSetup(userController);
  }
}
