package de.schulung.spring.accounts;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.UUID;

@Getter
@Setter
public class Customer {

  @JsonProperty(access = JsonProperty.Access.READ_ONLY)
  private UUID uuid;
  @NotNull
  private String name;
  @JsonProperty("birthdate")
  @NotNull
  private LocalDate birthDate;
  private String state;

}
