package com.tang.restExercise;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.ResponseEntity;

import java.net.MalformedURLException;
import java.net.URL;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class HelloControllerIT {

  @LocalServerPort
  private int port;

  private URL base;

  private TestRestTemplate template;

  @BeforeEach
  public void setUp() throws MalformedURLException {
    base = new URL("http://localhost:" + port + "/hello");
    template = new TestRestTemplate();
  }

  @Test
  public void getHello() {
    ResponseEntity<String> response = template.getForEntity(base.toString(), String.class);
    assertThat(response.getBody(), is("Greeting from Spring Boot! YCT"));
  }

  @Test
  public void getYCT() throws MalformedURLException {
    this.base = new URL("http://localhost:" + port + "/yct");
    ResponseEntity<String> response = template.getForEntity(base.toString(), String.class);
    assertThat(response.getBody(), is("Greeting from Spring Boot! YCT"));
  }
}
