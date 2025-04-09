package ru.nikolaev.bank.controller.account;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.nikolaev.bank.controller.account.dto.request.CreateAccountRequest;
import ru.nikolaev.bank.controller.account.dto.response.AccountResponse;
import ru.nikolaev.bank.controller.account.mapper.AccountRequestMapper;
import ru.nikolaev.bank.controller.account.mapper.AccountResponseMapper;
import ru.nikolaev.bank.service.account.AccountService;
import ru.nikolaev.bank.service.account.dto.AccountDto;

@RestController
@RequestMapping("api/accounts")
public class AccountController {
    private final AccountService accountService;
    private final AccountResponseMapper accountResponseMapper;
    private final AccountRequestMapper accountRequestMapper;

    public AccountController(AccountService accountService, AccountResponseMapper accountResponseMapper, AccountRequestMapper accountRequestMapper) {
        this.accountService = accountService;
        this.accountResponseMapper = accountResponseMapper;
        this.accountRequestMapper = accountRequestMapper;
    }

    @PostMapping
    public AccountResponse createAccount(@RequestBody CreateAccountRequest request) {
        AccountDto result = accountService.createAccount(accountRequestMapper.toCreateDto(request));
        return accountResponseMapper.toResponse(result);
    }
}
