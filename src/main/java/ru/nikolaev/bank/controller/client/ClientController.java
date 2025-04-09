package ru.nikolaev.bank.controller.client;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.nikolaev.bank.controller.client.dto.request.CreateClientRequest;
import ru.nikolaev.bank.controller.client.dto.request.UpdateClientRequest;
import ru.nikolaev.bank.controller.client.dto.response.ClientResponse;
import ru.nikolaev.bank.controller.client.mapper.ClientRequestMapper;
import ru.nikolaev.bank.controller.client.mapper.ClientResponseMapper;
import ru.nikolaev.bank.service.client.ClientService;
import ru.nikolaev.bank.service.client.dto.ClientDto;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/clients")
public class ClientController {
    private final ClientService clientService;
    private final ClientRequestMapper clientRequestMapper;
    private final ClientResponseMapper clientResponseMapper;

    public ClientController(ClientService clientService, ClientRequestMapper clientRequestMapper, ClientResponseMapper clientResponseMapper) {
        this.clientService = clientService;
        this.clientRequestMapper = clientRequestMapper;
        this.clientResponseMapper = clientResponseMapper;
    }

    @GetMapping
    public List<ClientResponse> getClients() {
        List<ClientDto> clientDtos = clientService.findAll();
        return clientDtos.stream().map(clientResponseMapper::toResponse).collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public ClientResponse getClient(@PathVariable int id) {
        return clientResponseMapper.toResponse(clientService.findById(id));
    }

    @PostMapping
    public ClientResponse createClient(@RequestBody CreateClientRequest request) {
        return clientResponseMapper.toResponse(clientService.create(clientRequestMapper.toCreateDto(request)));
    }

    @PutMapping("/{id}")
    public ClientResponse updateClient(@PathVariable int id, @RequestBody UpdateClientRequest request) {
        ClientDto clientDto = clientService.update(id, clientRequestMapper.toUpdateDto(request));
        return clientResponseMapper.toResponse(clientDto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteClient(@PathVariable int id) {
        clientService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
