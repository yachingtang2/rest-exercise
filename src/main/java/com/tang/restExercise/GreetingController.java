package com.tang.restExercise;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.atomic.AtomicLong;

@RestController
public class GreetingController {

  private static final String template = "Hello, %s";
  private final AtomicLong counter = new AtomicLong();

  @RequestMapping(value = "/greeting", method = RequestMethod.GET)
  public Greeting greeting(@RequestParam(name="name", required=false, defaultValue="world") String name) throws JsonProcessingException {
    ObjectMapper objectMapper = new ObjectMapper();
    System.out.println("YCT - " + objectMapper.writeValueAsString(new Greeting(1, "yct")));
    return new Greeting(counter.incrementAndGet(), String.format(template, name));
  }
}
