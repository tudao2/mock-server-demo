package org.example.client;

import org.example.client.domain.User;
import org.example.client.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cloud.contract.stubrunner.spring.AutoConfigureStubRunner;
import org.springframework.cloud.contract.stubrunner.spring.StubRunnerProperties;
import reactor.test.StepVerifier;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.NONE)
@AutoConfigureStubRunner(ids = {"org.example:server:0.0.1-SNAPSHOT:stubs:8080"}, stubsMode = StubRunnerProperties.StubsMode.LOCAL)
class ClientApplicationTests {
  @Autowired
  UserService userService;

  @Test
  void contextLoads() {
  }

  @Test
  void testGetUser() {
    StepVerifier.create(userService.getUserById("123").map(User::name))
        .expectNext("tu")
        .verifyComplete();

  }

}
