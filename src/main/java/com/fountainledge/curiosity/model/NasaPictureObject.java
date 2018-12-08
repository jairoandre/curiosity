package com.fountainledge.curiosity.model;

import com.google.gson.annotations.SerializedName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class NasaPictureObject {
  private Integer id;
  @SerializedName("img_src")
  private String imgSrc;
}
