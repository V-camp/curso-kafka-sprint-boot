package io.cursokafka.icompras.clientes.service;

import io.cursokafka.icompras.clientes.model.Clientes;
import io.cursokafka.icompras.clientes.repository.ClienteRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ClienteService {

    private final ClienteRepository repository;

    public Clientes salvar(Clientes cliente) {
        return repository.save(cliente);
    }

    public Optional<Clientes> obterPorCodigo(Long codigo) {
        return repository.findById(codigo);
    }
}
