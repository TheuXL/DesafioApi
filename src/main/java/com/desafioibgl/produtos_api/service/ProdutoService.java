package com.desafioibgl.produtos_api.service;

import com.desafioibgl.produtos_api.model.Produto;
import com.desafioibgl.produtos_api.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import java.util.List;

@Service
public class ProdutoService {

    @Autowired
    private ProdutoRepository repository;

    public List<Produto> listarTodos() {
        return repository.findAll();
    }

    public Produto buscarPorId(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    public Produto salvar(Produto produto) {
        return repository.save(produto);
    }

    public Produto atualizar(Long id, Produto produtoAtualizado) {
        Produto produto = buscarPorId(id);
        produto.setNome(produtoAtualizado.getNome());
        produto.setPreco(produtoAtualizado.getPreco());
        produto.setDescricao(produtoAtualizado.getDescricao());
        produto.setCategoria(produtoAtualizado.getCategoria());
        return repository.save(produto);
    }

    public void deletar(Long id) {
        Produto produto = buscarPorId(id);
        repository.delete(produto);
    }
}