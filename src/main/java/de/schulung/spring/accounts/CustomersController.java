package de.schulung.spring.accounts;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/customers")
public class CustomersController {

  @GetMapping(
    // produces = MediaType.APPLICATION_JSON_VALUE
  )
  @ResponseBody
  String getAllCustomers() {
    return "[]";
  }
}
