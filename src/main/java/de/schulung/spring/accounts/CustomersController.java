package de.schulung.spring.accounts;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;

@Controller
@RequestMapping("/customers")
public class CustomersController {

  String[] CustomerState = {"active", "locked", "disabled"};

  @GetMapping(
    produces = MediaType.APPLICATION_JSON_VALUE
  )
  @ResponseBody
  String getAllCustomers(@RequestParam(value = "state", required = false) String state) {
    if (state != null && !Arrays.asList(CustomerState).contains(state)) {
      throw new IllegalArgumentException("Invalid state parameter");
    }
    return "[]";
  }

  @ExceptionHandler(IllegalArgumentException.class)
  @ResponseStatus(HttpStatus.BAD_REQUEST)
  public String handleIllegalArgumentException(IllegalArgumentException ex) {
    return ex.getMessage();
  }
  
}
