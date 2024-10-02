package org.example.wiremockjunit;

import com.github.tomakehurst.wiremock.junit5.WireMockRuntimeInfo;
import com.github.tomakehurst.wiremock.junit5.WireMockTest;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

import static com.github.tomakehurst.wiremock.client.WireMock.*;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@SpringBootTest
@WireMockTest
class WiremockJunitApplicationTests {

	@Test
	void testWireMock(WireMockRuntimeInfo wmRuntimeInfo) throws IOException, InterruptedException {
		// stubbing
		stubFor(get("/my/resource")
				.withHeader("Content-Type", containing("json"))
				.willReturn(ok()
						.withHeader("Content-Type", "application/json")
						.withBody("{\"name\": \"abc\"}")));
		// Setup HTTP POST request (with HTTP Client embedded in Java 11+)
		final HttpClient client = HttpClient.newBuilder().build();
		final HttpRequest request = HttpRequest.newBuilder()
				.uri(URI.create(wmRuntimeInfo.getHttpBaseUrl() + "/my/resource"))
				.header("Content-Type", "application/json")
				.build();

		// Send the request and receive the response
		final HttpResponse<String> response =
				client.send(request, HttpResponse.BodyHandlers.ofString());

		// Verify the response (with AssertJ)
		assertThat(response.statusCode()).as("Wrong response status code").isEqualTo(200);
		assertThat(response.body()).as("Wrong response body").contains("abc");
	}

}
