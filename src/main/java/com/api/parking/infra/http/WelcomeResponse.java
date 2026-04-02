package com.api.parking.infra.http;

public record WelcomeResponse(
  String message,
  String version
) {
} 
