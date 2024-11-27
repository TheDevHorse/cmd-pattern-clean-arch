package com.thedevhorse.cmdpatterncleanarch.controller.dto;

import com.thedevhorse.cmdpatterncleanarch.domain.Status;

import java.util.UUID;

public record OrderRequest(UUID orderId, Status status, Double price) {
}
