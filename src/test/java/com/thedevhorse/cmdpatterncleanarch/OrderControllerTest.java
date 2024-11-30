package com.thedevhorse.cmdpatterncleanarch;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.thedevhorse.cmdpatterncleanarch.controller.OrderController;
import com.thedevhorse.cmdpatterncleanarch.controller.dto.OrderRequest;
import com.thedevhorse.cmdpatterncleanarch.domain.Status;
import com.thedevhorse.cmdpatterncleanarch.usecase.CompletedOrderUseCase;
import com.thedevhorse.cmdpatterncleanarch.usecase.InProgressOrderUseCase;
import com.thedevhorse.cmdpatterncleanarch.usecase.OrderUseCaseInputPort;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.Map;
import java.util.UUID;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(OrderController.class)
class OrderControllerTest {

    @Autowired
    private MockMvc mvc;

    @MockBean
    private CompletedOrderUseCase completedOrderUseCase;

    @MockBean
    private InProgressOrderUseCase inProgressOrderUseCase;

    @Autowired
    private ObjectMapper objectMapper;

    @BeforeEach
    void setUp() {
        Map<String, OrderUseCaseInputPort> orderUseCaseInputPortMap = Map.of(
                "COMPLETED", completedOrderUseCase,
                "IN_PROGRESS", inProgressOrderUseCase
        );

        mvc = MockMvcBuilders.standaloneSetup(new OrderController(orderUseCaseInputPortMap)).build();
    }

    @Test
    void givenOrderWithCompletedStatus_whenUpdateOrderIsCalled_thenCompletedUseCaseIsExecuted() throws Exception {
        // Given
        UUID orderId = UUID.randomUUID();
        OrderRequest orderRequest = new OrderRequest(orderId, Status.COMPLETED, 100.0);

        // When
        mvc.perform(put("/api/order")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(orderRequest)))
                .andExpect(status().isOk());

        // Then
        verify(completedOrderUseCase, times(1)).execute(any());
    }

    @Test
    void givenOrderWithInProgressStatus_whenCreateOrderIsCalled_thenInProgressUseCaseIsExecuted() throws Exception {
        // Given
        OrderRequest orderRequest = new OrderRequest(null, Status.IN_PROGRESS, 100.0);

        // When
        mvc.perform(post("/api/order")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(orderRequest)))
                .andExpect(status().isOk());

        // Then
        verify(inProgressOrderUseCase, times(1)).execute(any());
    }

}
