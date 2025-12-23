# 📦 Projeto de Microservices com Spring Boot e Kafka

Este projeto foi desenvolvido durante o curso **“Spring Boot + Kafka: Arquitetura Completa de Microservices”**, oferecido pela **Udemy** e ministrado pelo **Professor Dougllas Sousa**.

📌 **Status do Projeto:** *Em andamento*

---

## 🛠️ Tecnologias e Ferramentas Utilizadas

- **Java 21**
- **Spring Boot**
- **Apache Kafka**
- **Docker**
- **PostgreSQL**
- **MinIO**

---

## 🏗️ Arquitetura

- Arquitetura baseada em **Microservices**

Os serviços são independentes, com responsabilidades bem definidas, promovendo escalabilidade, organização do código e facilidade de manutenção.

---

## 📋 Descrição do Projeto

O projeto consiste na implementação de um sistema para **simulação de compras virtuais**, estruturado em microserviços, onde cada serviço é responsável por um domínio específico da aplicação:

### 🔹 Microserviços

- **Servico**  
  Responsável pelos arquivos de configuração e orquestração dos serviços de infraestrutura, como:
  - `docker-compose`
  - Banco de dados (**PostgreSQL**)
  - Mensageria (**Apache Kafka**)
  - Armazenamento de objetos (**MinIO**)

- **Cliente**  
  Responsável pelo gerenciamento das informações dos clientes.

- **Produto**  
  Responsável pelo gerenciamento das informações dos produtos.

- **Pedido**  
  Responsável pelo gerenciamento dos pedidos realizados.  
  Ao criar um pedido, um evento é publicado no **Apache Kafka**, que será consumido por outros serviços.

- **Faturamento**  
  Responsável pelo processamento do faturamento.  
  Consome e Produz as mensagens do Kafka e gera um **relatório com os dados da compra do cliente**.

- **Logistica**  
  Responsável pelas notificações sobre envio do produto.  
  Consome e Produz mensagens para o Kafka, gera o codigo de rastreio do produto e atualiza o status do pedido.

---

## 🎯 Objetivo do Projeto

Aplicar na prática os principais conceitos de:
- Arquitetura de microserviços
- Comunicação assíncrona utilizando Apache Kafka
- Integração entre serviços
- Containerização com Docker
- Persistência de dados e armazenamento de arquivos

---
