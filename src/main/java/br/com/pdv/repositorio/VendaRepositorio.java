package br.com.pdv.repositorio;

import br.com.pdv.entidade.Venda;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VendaRepositorio extends JpaRepository<Venda,Long> {
}
