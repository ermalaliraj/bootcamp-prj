package com.bootcamp.ms.profile.dto.mapper;

import com.bootcamp.ms.profile.model.Role;
import com.bootcamp.ms.profile.dto.RoleDto;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(config = DtoMapperConfiguration.class)
public abstract class RoleDtoMapper {

    public abstract RoleDto toDto(Role entity);

    public abstract Role toEntity(RoleDto dto);

    public abstract List<Role> toEntity(List<RoleDto> dtos);

    public abstract List<RoleDto> toDto(List<Role> entities);

}
