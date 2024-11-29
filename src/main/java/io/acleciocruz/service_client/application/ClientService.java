package io.acleciocruz.service_client.application;

import com.netflix.appinfo.ApplicationInfoManager;
import io.acleciocruz.service_client.domain.Client;
import io.acleciocruz.service_client.infra.repositories.ClientRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Slf4j
@Service
@RequiredArgsConstructor
public class ClientService {

    private final ClientRepository clientRepository;

    public Client save(Client client) {
        return clientRepository.save(client);
    }

    public Optional<Client> getClientByCpf(String cpf) {
        return clientRepository.findByCpf(cpf);
    }

    public List<Client> allClients() {
        return clientRepository.findAll();
    }
}
