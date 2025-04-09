package ru.nikolaev.bank.controller.client.mapper;

import org.mapstruct.Mapper;
import ru.nikolaev.bank.controller.client.dto.request.CreateClientRequest;
import ru.nikolaev.bank.controller.client.dto.request.UpdateClientRequest;
import ru.nikolaev.bank.service.client.dto.CreateClientDto;
import ru.nikolaev.bank.service.client.dto.UpdateClientDto;

@Mapper(componentModel = "spring")
public interface ClientRequestMapper {
    CreateClientDto toCreateDto(CreateClientRequest request);
    UpdateClientDto toUpdateDto(UpdateClientRequest request);
}
