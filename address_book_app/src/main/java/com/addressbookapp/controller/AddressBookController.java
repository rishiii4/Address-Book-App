package com.addressbookapp.controller;

import com.addressbookapp.dto.ContactDTO;
import com.addressbookapp.mapper.ContactMapper;
import com.addressbookapp.model.Contact;
import com.addressbookapp.service.ContactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    // Adding a contact in List
    @PostMapping("/add")
    public ResponseEntity<Contact> addEmployee(@RequestBody ContactDTO contactDTO){
        return ResponseEntity.ok(contactService.addContact(contactDTO));
    }

    // Deleting a contact by id
    @DeleteMapping("/remove/{id}")
    public ResponseEntity<String> deleteContact(@PathVariable("id") int id){
        if(contactService.deleteContact(id)){
            return ResponseEntity.ok("Deletion Successful!");
        }else {
            return ResponseEntity.ok("Id not Found!");
        }
    }

    // Getting all contacts
    @GetMapping("/all")
    public ResponseEntity<List<Contact>> getAllContacts(){
        return ResponseEntity.ok(contactService.getAllContact());
    }

    // Getting a contact by id
    @GetMapping("get/{id}")
    public ResponseEntity<Contact> getContactById(@PathVariable("id") int id){
        return ResponseEntity.ok(contactService.getContactById(id));
    }

    // Updating a contact by id
    @PutMapping("/update/{id}")
    public ResponseEntity<Contact> updateContact(@PathVariable("id") int id, @RequestBody ContactDTO contactDTO){
        Contact update = contactService.updateContact(id, contactDTO);
        if(update != null){
            ContactDTO updateDTO = ContactMapper.INSTANCE.toDto(update);
            return ResponseEntity.ok(update);
        }else {
            return ResponseEntity.notFound().build();
        }

    }
}
