package com.tang.restExercise;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class HelloController {

  @RequestMapping(value={"hello", "yct"})
  public String index() {
    return "Greeting from Spring Boot! YCT";
  }
}
