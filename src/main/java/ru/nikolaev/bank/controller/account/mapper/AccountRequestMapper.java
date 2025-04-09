package ru.nikolaev.bank.controller.account.mapper;

import org.mapstruct.Mapper;
import ru.nikolaev.bank.controller.account.dto.request.CreateAccountRequest;
import ru.nikolaev.bank.service.account.dto.CreateAccountDto;

@Mapper(componentModel = "spring")
public interface AccountRequestMapper {
    CreateAccountDto toCreateDto(CreateAccountRequest request);
}
