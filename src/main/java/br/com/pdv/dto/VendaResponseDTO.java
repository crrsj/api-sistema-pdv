package br.com.pdv.dto;

import java.time.LocalDateTime;
import java.util.List;

public record VendaResponseDTO(
        Long id,
        LocalDateTime dataHora,
        String formaPagamento,
        Double total,
        List<ItemResponseDTO> itens

) {
    public record ItemResponseDTO(
            String nomeProduto,
            Double precoUnitario,
            Integer quantidade,
            Double subtotal
    ) {}
}
