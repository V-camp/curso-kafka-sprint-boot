package io.cursokafka.icompras.clientes.repository;

import io.cursokafka.icompras.clientes.model.Clientes;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteRepository extends JpaRepository<Clientes, Long> {}
