package br.com.pdv.repositorio;

import br.com.pdv.entidade.Produto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProdutoRepositorio extends JpaRepository<Produto,Long> {
}
