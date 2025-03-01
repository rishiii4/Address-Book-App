package com.addressbookapp.controller;

import com.addressbookapp.service.ContactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/addressbook")
public class AddressBookController {

    private final ContactService contactService;

    @Autowired
    public AddressBookController(ContactService contactService){
        this.contactService = contactService;
    }

    // For testing the connection
    @GetMapping
    public ResponseEntity<String> greet(){
        return ResponseEntity.ok("Welcome to Address Book App!");
    }
}
