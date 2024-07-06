package com.example.testassignmentpotikha.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class ShapeControllerTest {
    @Autowired
    private MockMvc mockMvc;

    private final String path = "/shape/calculate";

    @Test
    public void testCalculateCircle() throws Exception {
        String jsonRequest = "{\"name\":\"circle\",\"circumference\":50.0}";

        mockMvc.perform(post(path)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(jsonRequest))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.area").value(198.94367886486916))
                .andExpect(jsonPath("$.perimeter").value(50.0));
    }

    @Test
    public void testCalculateRectangleByTwoSide() throws Exception {
        String jsonRequest = "{\"name\":\"rectangle\",\"length\":20.0,\"width\":15.0}";

        mockMvc.perform(post(path)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(jsonRequest))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.area").value(300.0))
                .andExpect(jsonPath("$.perimeter").value(70.0));
    }

    @Test
    public void testCalculateRectangleByOneSideAndDiagonal() throws Exception {
        String jsonRequest = "{\"name\":\"rectangle\",\"length\":20.0,\"diagonal\":25.0}";

        mockMvc.perform(post(path)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(jsonRequest))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.area").value(300.0))
                .andExpect(jsonPath("$.perimeter").value(70.0));
    }

    @Test
    public void testCalculateSquare() throws Exception {
        String jsonRequest = "{\"name\":\"square\",\"side\":3.0}";

        mockMvc.perform(post(path)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(jsonRequest))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.area").value(9.0))
                .andExpect(jsonPath("$.perimeter").value(12.0));
    }

    @Test
    public void testCalculateTriangleByThreeSide() throws Exception {
        String jsonRequest = "{\"name\":\"triangle\",\"a\":5.0,\"b\":8.0,\"c\":7.0}";

        mockMvc.perform(post(path)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(jsonRequest))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.area").value(17.320508075688775))
                .andExpect(jsonPath("$.perimeter").value(20.0));
    }

    @Test
    public void testCalculateTriangleBySideAndAngle() throws Exception {
        String jsonRequest = "{\"name\":\"triangle\",\"lengthOne\":5.0,\"lengthTwo\":8.0,\"angle\":60.0}";

        mockMvc.perform(post(path)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(jsonRequest))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.area").value(17.32050807568877))
                .andExpect(jsonPath("$.perimeter").value(20.0));
    }
}