package com.stefanpetcu.api.employeebonuses.presentation;

import com.stefanpetcu.api.employeebonuses.application.EmployeeBonusesCalculatorService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(EmployeeController.class)
public class EmployeeControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @MockBean(name = "employeeBonusesCalculator") // I'd probably use the real service in this simple case
    private EmployeeBonusesCalculatorService mockedEmployeeBonusesCalculator;

    @Test
    public void testBonuses_willReturnBonusesResponse_givenArrayOfEmployeeCodeOutputs() throws Exception {
        when(mockedEmployeeBonusesCalculator.bonusesFor(new int[]{10, 20, 30})).thenReturn(new int[]{1, 2, 3});

        mockMvc.perform(post("/bonuses")
                .content("{\"employeesCodeOutputs\": [10, 20, 30]}")
                .contentType(MediaType.APPLICATION_JSON)
        ).andExpect(status().isOk())
                .andExpect(content().json("{\"bonuses\": [1, 2, 3]}"));
    }
}
