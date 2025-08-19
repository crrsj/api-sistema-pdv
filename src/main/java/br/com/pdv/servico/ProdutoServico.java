package br.com.pdv.servico;

import br.com.pdv.entidade.Produto;
import br.com.pdv.repositorio.ProdutoRepositorio;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProdutoServico {

    private final ProdutoRepositorio produtoRepositorio;

    public Produto salvar(Produto produto) {
        return produtoRepositorio.save(produto);
    }

    public List<Produto> listar() {
        return produtoRepositorio.findAll();
    }



}
