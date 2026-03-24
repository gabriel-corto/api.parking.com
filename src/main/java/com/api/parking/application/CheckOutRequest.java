package com.api.parking.application;

import java.util.UUID;

public record CheckOutRequest (String vehicleBoard, UUID ticketId) {}
