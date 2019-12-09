package com.tang.restExercise;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import java.net.MalformedURLException;
import java.net.URL;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class HelloControllerIT {

  @LocalServerPort
  private int port;

  private URL base;

  @Autowired
  private TestRestTemplate template;

  @Before
  public void setUp() throws MalformedURLException {
    this.base = new URL("http://localhost:" + port + "/hello");
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
