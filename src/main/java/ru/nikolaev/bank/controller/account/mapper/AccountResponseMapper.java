package ru.nikolaev.bank.controller.account.mapper;

import org.mapstruct.Mapper;
import ru.nikolaev.bank.controller.account.dto.response.AccountResponse;
import ru.nikolaev.bank.controller.client.dto.response.ClientResponse;
import ru.nikolaev.bank.service.account.dto.AccountDto;
import ru.nikolaev.bank.service.client.dto.ClientDto;

@Mapper(componentModel = "spring")
public interface AccountResponseMapper {
    AccountResponse toResponse(AccountDto dto);
}
