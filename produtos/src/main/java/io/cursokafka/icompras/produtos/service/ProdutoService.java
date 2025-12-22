package io.cursokafka.icompras.produtos.service;

import io.cursokafka.icompras.produtos.model.Produto;
import io.cursokafka.icompras.produtos.repository.ProdutoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ProdutoService {

    private final ProdutoRepository repository;

    public Produto salvar(Produto produto) {
        return repository.save(produto);
    }

    public Optional<Produto> obterPorCodigo(Long codigo) {
        return repository.findById(codigo);
    }

    public List<Produto> obterTodos() {
        return repository.findAll();
    }
}
