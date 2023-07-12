package com.teachmeskills.springbooteshop.dto;

import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@Builder
@EqualsAndHashCode
public class RoleDto {

    private Long id;
    private String role;
}
