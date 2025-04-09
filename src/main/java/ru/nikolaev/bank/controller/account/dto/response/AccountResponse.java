package ru.nikolaev.bank.controller.account.dto.response;

import java.math.BigDecimal;

public record AccountResponse(int id, BigDecimal balance, String currency) {
}
