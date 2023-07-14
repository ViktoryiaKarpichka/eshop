package com.teachmeskills.springbooteshop.mapper;

import com.teachmeskills.springbooteshop.dto.UserDto;
import com.teachmeskills.springbooteshop.entities.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface UserMapper {

    @Mapping(source = "roleDto", target = "role")
    User convertToUser(UserDto userDto);

    @Mapping(source = "role", target = "roleDto")
    UserDto convertToUserDto(User user);
}
