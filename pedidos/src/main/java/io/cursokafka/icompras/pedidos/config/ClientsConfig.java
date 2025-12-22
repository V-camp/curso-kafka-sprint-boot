package io.cursokafka.icompras.pedidos.config;

import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableFeignClients(basePackages = "io.cursokafka.icompras.pedidos.client")
public class ClientsConfig {
}
