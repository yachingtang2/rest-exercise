package com.tang.restExercise;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Value;

@AllArgsConstructor
@Getter
public class Greeting {
  private long id;
  private String content;
}
