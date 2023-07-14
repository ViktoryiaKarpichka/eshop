package com.teachmeskills.springbooteshop.mapper;

import com.teachmeskills.springbooteshop.dto.RoleDto;
import com.teachmeskills.springbooteshop.entities.Role;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface RoleMapper {

    Role convertToRole(RoleDto roleDto);

    RoleDto convertToRoleDto(Role role);
}
