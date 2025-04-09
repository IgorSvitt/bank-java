package ru.nikolaev.bank.service.client;

import org.springframework.stereotype.Service;
import ru.nikolaev.bank.data.ClientRepository;
import ru.nikolaev.bank.model.Client;
import ru.nikolaev.bank.service.client.dto.ClientDto;
import ru.nikolaev.bank.service.client.dto.CreateClientDto;
import ru.nikolaev.bank.service.client.dto.UpdateClientDto;
import ru.nikolaev.bank.service.client.mapper.ClientMapper;
import ru.nikolaev.bank.utils.exception.NotFoundException;

import java.util.ArrayList;
import java.util.List;

@Service
public class ClientService {
    private final ClientRepository clientRepository;
    private final ClientMapper clientMapper;

    public ClientService(ClientRepository clientRepository, ClientMapper clientMapper) {
        this.clientRepository = clientRepository;
        this.clientMapper = clientMapper;
    }

    public List<ClientDto> findAll() {
        List<Client> clients = clientRepository.findAll();
        List<ClientDto> dtos = new ArrayList<>();
        for (Client client : clients) {
            dtos.add(clientMapper.toDto(client));
        }
        return dtos;
    }

    public ClientDto findById(int id) {
        Client client = clientRepository.findById(id).orElseThrow(() -> new NotFoundException("Client with id " + id + " not found"));
        return clientMapper.toDto(client);
    }

    public ClientDto create(CreateClientDto clientDto) {
        Client client = clientMapper.toEntity(clientDto);
        clientRepository.save(client);
        return clientMapper.toDto(client);
    }

    public void deleteById(int id) {
        Client client = clientRepository.findById(id).orElseThrow(() -> new NotFoundException("Client with id " + id + " not found"));
        clientRepository.deleteById(id);
    }

    public ClientDto update(int id, UpdateClientDto dto) {
        Client client = clientRepository.findById(id).orElseThrow(() -> new NotFoundException("Client with id " + id + " not found"));
        client.setName(dto.name());
        clientRepository.save(client);

        return clientMapper.toDto(client);
    }
}
