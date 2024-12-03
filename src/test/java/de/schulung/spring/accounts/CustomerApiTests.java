package de.schulung.spring.accounts;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.endsWith;
import static org.hamcrest.Matchers.startsWith;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class CustomerApiTests {

  @Autowired
  MockMvc mockMvc;

  @Test
  void shouldReturnCustomers() throws Exception {
    mockMvc
      .perform(
        get("/customers")
          .accept(MediaType.APPLICATION_JSON)
      )
      .andExpect(status().isOk())
      .andExpect(content().contentType(MediaType.APPLICATION_JSON))
      .andExpect(content().string(startsWith("[")))
      .andExpect(content().string(endsWith("]")));
  }

  @Test
  void testGETCustomersWithAcceptTextHTML() throws Exception {
    mockMvc.perform(
        get("/customers")
          .accept(MediaType.TEXT_HTML))
      .andExpect(status().is(406));
  }

  @Test
  void testGETCustomersWithParameter() throws Exception {
    mockMvc.perform(
        get("/customers?state=blubb")
          .accept(MediaType.APPLICATION_JSON))
      .andExpect(status().is(400));
  }
}
