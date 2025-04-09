package ru.nikolaev.bank.service.client.dto;

import ru.nikolaev.bank.service.account.dto.AccountDto;

import java.util.List;

public record ClientDto(int id, String name, List<AccountDto> accounts) {
}
