package ru.nikolaev.bank.service.account;

import org.springframework.stereotype.Service;
import ru.nikolaev.bank.data.AccountRepository;
import ru.nikolaev.bank.data.ClientRepository;
import ru.nikolaev.bank.model.Account;
import ru.nikolaev.bank.model.Client;
import ru.nikolaev.bank.service.account.dto.AccountDto;
import ru.nikolaev.bank.service.account.dto.CreateAccountDto;
import ru.nikolaev.bank.service.account.mapper.AccountMapper;
import ru.nikolaev.bank.utils.exception.ApplicationException;

import java.math.BigDecimal;
import java.util.Random;

@Service
public class AccountService {
    private final AccountRepository accountRepository;
    private final ClientRepository clientRepository;

    private final AccountMapper accountMapper;

    private final BigDecimal START_BALANCE = new BigDecimal("0.00");

    public AccountService(AccountRepository accountRepository, ClientRepository clientRepository, AccountMapper accountMapper) {
        this.accountRepository = accountRepository;
        this.clientRepository = clientRepository;
        this.accountMapper = accountMapper;
    }

    public AccountDto createAccount(CreateAccountDto request) {
        Client client = clientRepository.findById(request.clientId())
                .orElseThrow(() -> new ApplicationException("Client with id " + request.clientId() + " not found"));

        Account account = Account.builder()
                .number(generateNumber())
                .client(client)
                .currency(request.currency())
                .balance(START_BALANCE)
                .build();

        accountRepository.save(account);

        return accountMapper.toDto(account);
    }

    private static String generateNumber() {
        java.security.SecureRandom random = new java.security.SecureRandom();
        StringBuilder sb = new StringBuilder(12);

        for (int i = 0; i < 12; i++) {
            sb.append(random.nextInt(10));
        }

        return sb.toString();
    }
}
