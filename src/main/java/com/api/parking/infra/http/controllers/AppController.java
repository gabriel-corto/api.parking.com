package com.api.parking.infra.http.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.api.parking.infra.http.WelcomeResponse;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;


@RestController
@RequestMapping("/")
public class AppController {
  @GetMapping("")
  public ResponseEntity<WelcomeResponse> welcome() {
      return ResponseEntity.ok(new WelcomeResponse("Welcome to api.parking.com", "1.0"));
  } 
}

