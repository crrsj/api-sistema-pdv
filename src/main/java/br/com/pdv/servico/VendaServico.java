package br.com.pdv.servico;

import br.com.pdv.dto.ItemDTO;
import br.com.pdv.dto.VendaRequestDTO;
import br.com.pdv.entidade.ItemVenda;
import br.com.pdv.entidade.Produto;
import br.com.pdv.entidade.Venda;
import br.com.pdv.repositorio.ProdutoRepositorio;
import br.com.pdv.repositorio.VendaRepositorio;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class VendaServico {

    private final ProdutoRepositorio produtoRepositorio;
    private final VendaRepositorio vendaRepositorio;

    public Venda registrarVenda(VendaRequestDTO dto) {

        Venda venda = new Venda();
        venda.setDataHora(java.time.LocalDateTime.now());
        venda.setFormaPagamento(dto.formaPagamento());

        for (ItemDTO itemDTO : dto.itens()) {
            Produto produto = produtoRepositorio.findById(itemDTO.produtoId())
                    .orElseThrow(() -> new RuntimeException("Produto não encontrado: " + itemDTO.produtoId()));

            ItemVenda item = new ItemVenda();
            item.setProduto(produto);
            item.setQuantidade(itemDTO.quantidade());
            venda.addItem(item);
        }

        return vendaRepositorio.save(venda);
    }


}