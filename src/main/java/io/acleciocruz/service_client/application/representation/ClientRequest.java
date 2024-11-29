package io.acleciocruz.service_client.application.representation;

import io.acleciocruz.service_client.domain.Client;

public record ClientRequest(
        String cpf,
        String nome,
        Integer idade) {

    public Client toModel() {
        return Client.builder()
                .cpf(cpf)
                .nome(nome)
                .idade(idade)
                .build();
    }
}
