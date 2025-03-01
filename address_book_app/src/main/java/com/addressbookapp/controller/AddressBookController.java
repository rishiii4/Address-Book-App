package com.addressbookapp.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/addressbook")
public class AddressBookController {

    // For testing the connection
    @GetMapping
    public ResponseEntity<String> greet(){
        return ResponseEntity.ok("Welcome to Address Book App!");
    }
}
