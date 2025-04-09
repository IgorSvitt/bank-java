package ru.nikolaev.bank.controller.account.dto.request;

import ru.nikolaev.bank.model.Currency;

public record CreateAccountRequest(int clientId, Currency currency) {
}
