package ru.nikolaev.bank.controller.client.mapper;

import org.mapstruct.Mapper;
import ru.nikolaev.bank.controller.client.dto.request.CreateClientRequest;
import ru.nikolaev.bank.controller.client.dto.response.ClientResponse;
import ru.nikolaev.bank.service.client.dto.ClientDto;
import ru.nikolaev.bank.service.client.dto.CreateClientDto;

@Mapper(componentModel = "spring")
public interface ClientResponseMapper {
    ClientResponse toResponse(ClientDto dto);
}
