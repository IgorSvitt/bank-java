package ru.nikolaev.bank.service.account.dto;

import java.math.BigDecimal;

public record AccountDto(int id, BigDecimal balance, String currency) {
}