package ru.nikolaev.bank.service.account.mapper;

import org.mapstruct.Mapper;
import ru.nikolaev.bank.model.Account;
import ru.nikolaev.bank.service.account.dto.AccountDto;
import ru.nikolaev.bank.service.account.dto.CreateAccountDto;

@Mapper(componentModel = "spring")
public interface AccountMapper {
    Account toEntity(CreateAccountDto accountDto);

    AccountDto toDto(Account account);
}
