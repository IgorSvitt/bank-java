package ru.nikolaev.bank.controller.client.dto.response;

import ru.nikolaev.bank.controller.account.dto.response.AccountResponse;

import java.util.List;

public record ClientResponse(int id, String name, List<AccountResponse> accounts) {
}
