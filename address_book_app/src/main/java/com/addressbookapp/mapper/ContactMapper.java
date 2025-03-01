package com.addressbookapp.mapper;


import com.addressbookapp.dto.ContactDTO;
import com.addressbookapp.model.Contact;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface ContactMapper {
    ContactMapper INSTANCE = Mappers.getMapper(ContactMapper.class);
    Contact toEntity(ContactDTO dto);
    ContactDTO toDto(Contact entity);
}
