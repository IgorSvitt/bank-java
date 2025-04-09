package ru.nikolaev.bank.data;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.nikolaev.bank.model.Account;

@Repository
public interface AccountRepository extends JpaRepository<Account, Integer> {
}
