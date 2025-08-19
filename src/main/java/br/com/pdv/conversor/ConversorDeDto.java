package br.com.pdv.conversor;

import br.com.pdv.dto.VendaResponseDTO;
import br.com.pdv.entidade.Venda;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ConversorDeDto {


    public VendaResponseDTO converterParaDTO(Venda venda) {
        List<VendaResponseDTO.ItemResponseDTO> itensDTO = venda.getItens().stream()
                .map(item -> new VendaResponseDTO.ItemResponseDTO(
                        item.getProduto().getNome(),
                        item.getProduto().getPreco(),
                        item.getQuantidade(),
                        item.getProduto().getPreco() * item.getQuantidade()
                ))
                .toList();

        double total = itensDTO.stream()
                .mapToDouble(VendaResponseDTO.ItemResponseDTO::subtotal)
                .sum();

        return new VendaResponseDTO(
                venda.getId(),
                venda.getDataHora(),
                venda.getFormaPagamento(),
                total,
                itensDTO
        );
    }
}
