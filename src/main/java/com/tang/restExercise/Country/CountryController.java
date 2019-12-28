package com.tang.restExercise.Country;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
//@RequestMapping("/")
public class CountryController {

  @PostMapping(value = "/save")
  public String save(@RequestBody Country country) {
    return "saved";
  }
}
