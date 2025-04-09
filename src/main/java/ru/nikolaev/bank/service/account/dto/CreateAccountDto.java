package ru.nikolaev.bank.service.account.dto;

import ru.nikolaev.bank.model.Currency;

public record CreateAccountDto(int clientId, Currency currency) {
}
