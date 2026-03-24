package com.desafioibgl.produtos_api.service;

import com.desafioibgl.produtos_api.model.Produto;
import com.desafioibgl.produtos_api.repository.ProdutoRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.web.server.ResponseStatusException;
import java.util.Optional;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class ProdutoServiceTest {

    @Mock
    private ProdutoRepository repository;

    @InjectMocks
    private ProdutoService service;

    @Test
    void deveRetornarProdutoPorId() {
        Produto produto = new Produto(1L, "Notebook", 3000.0, "i5", "Informatica");
        when(repository.findById(1L)).thenReturn(Optional.of(produto));

        Produto resultado = service.buscarPorId(1L);

        assertNotNull(resultado);
        assertEquals("Notebook", resultado.getNome());
        verify(repository, times(1)).findById(1L);
    }

    @Test
    void deveLancarExcecaoQuandoNaoEncontrar() {
        when(repository.findById(99L)).thenReturn(Optional.empty());

        assertThrows(ResponseStatusException.class, () -> {
            service.buscarPorId(99L);
        });
    }
}