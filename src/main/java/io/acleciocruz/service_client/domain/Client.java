package io.acleciocruz.service_client.domain;

import io.acleciocruz.service_client.application.representation.ClientRequest;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@Entity(name = "CLIENT")
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Client implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String cpf;
    private String nome;
    private Integer idade;


    public ClientRequest toConverter(Client dados) {
        return new ClientRequest(dados.cpf, dados.nome, dados.idade);
    }
}
