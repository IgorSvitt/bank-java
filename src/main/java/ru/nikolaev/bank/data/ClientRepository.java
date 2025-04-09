package ru.nikolaev.bank.data;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.nikolaev.bank.model.Client;

@Repository
public interface ClientRepository extends JpaRepository<Client, Integer> {
}
