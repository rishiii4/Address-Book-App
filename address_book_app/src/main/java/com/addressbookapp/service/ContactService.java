package com.addressbookapp.service;

import com.addressbookapp.dto.ContactDTO;
import com.addressbookapp.mapper.ContactMapper;
import com.addressbookapp.model.Contact;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
// Logging
@Slf4j
public class ContactService {
    private final List<Contact> contactList = new ArrayList<>();

    public Contact addContact(ContactDTO contactDTO) {
        Contact contact = ContactMapper.INSTANCE.toEntity(contactDTO);
        contact.setId(contactList.size()+1);
        log.info("Adding Contacts: {}", contactDTO.getName());
        contactList.add(contact);
        return contact;
    }

    public boolean deleteContact(int id){
        log.info("Deleting a Contact by his Id");
        for(Contact con : contactList){
            if(id == con.getId()){
                contactList.remove(con);
                return true;
            }
        }
        return false;
    }

    public List<Contact> getAllContact(){
        log.info("Fetching all Contact");
        return contactList;
    }

    public Contact getContactById(int id){
        log.info("Getting a Contact by his Id");
        for(Contact con : contactList){
            if(id == con.getId()){
                return con;
            }
        }
        return null;
    }

    public Contact updateContact(int id, ContactDTO contactDTO){
        log.info("Contact Update Process Started");
        for (Contact contact:contactList){
            if(id == contact.getId()){
                contact.setName(contactDTO.getName());
                contact.setEmail(contactDTO.getEmail());
                return contact;
            }
        }
        return null;
    }

}
