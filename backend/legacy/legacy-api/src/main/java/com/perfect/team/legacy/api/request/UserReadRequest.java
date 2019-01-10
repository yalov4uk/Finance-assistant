package com.perfect.team.legacy.api.request;

import javax.ws.rs.QueryParam;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NonNull;

@Data
public class UserReadRequest {

  @NonNull
  @QueryParam("id")
  private Long id;

  @QueryParam("name")
  private String name;

  @QueryParam("email")
  private String email;
}
