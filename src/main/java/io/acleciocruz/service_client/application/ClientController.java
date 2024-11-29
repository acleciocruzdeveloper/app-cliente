package io.acleciocruz.service_client.application;

import io.acleciocruz.service_client.application.representation.ClientRequest;
import io.acleciocruz.service_client.domain.Client;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/clients")
@RequiredArgsConstructor
public class ClientController {

    private final ClientService service;

    @PostMapping
    public ResponseEntity<ClientRequest> save(@RequestBody ClientRequest request) {
        Client client = service.save(request.toModel());
        URI haderLocaltion = ServletUriComponentsBuilder.fromCurrentRequest()
                .query("cpf=${cpf}")
                .buildAndExpand(client.getCpf())
                .toUri();
        return ResponseEntity.created(haderLocaltion).body(client.toConverter(client));
    }

    @GetMapping(params = "cpf")
    public ResponseEntity<Client> dadosClient(@RequestParam("cpf") String cpf) {
        return service.getClientByCpf(cpf).map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());

    }

    @GetMapping
    public ResponseEntity<List<Client>> getAllClients() {
        return ResponseEntity.ok().body(service.allClients());
    }
}
