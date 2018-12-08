package com.fountainledge.curiosity.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class NasaPictureFeed {
  private List<NasaPictureObject> photos;
}
