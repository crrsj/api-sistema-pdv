package br.com.pdv.dto;

import java.util.List;

public record VendaRequestDTO(

        List<ItemDTO> itens,
        String formaPagamento


) {
}
