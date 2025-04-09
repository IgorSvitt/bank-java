package ru.nikolaev.bank.service.client.mapper;

import org.mapstruct.Mapper;
import ru.nikolaev.bank.model.Client;
import ru.nikolaev.bank.service.client.dto.ClientDto;
import ru.nikolaev.bank.service.client.dto.CreateClientDto;
import ru.nikolaev.bank.service.client.dto.UpdateClientDto;

@Mapper(componentModel = "spring")
public interface ClientMapper {
    Client toEntity(CreateClientDto createClientDto);
    Client toEntity(UpdateClientDto createClientDto);

    ClientDto toDto(Client client);
}
