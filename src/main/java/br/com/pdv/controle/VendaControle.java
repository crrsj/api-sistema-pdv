package br.com.pdv.controle;

import br.com.pdv.conversor.ConversorDeDto;
import br.com.pdv.dto.VendaRequestDTO;
import br.com.pdv.dto.VendaResponseDTO;
import br.com.pdv.servico.VendaServico;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/vendas")
@RequiredArgsConstructor
@CrossOrigin(origins = "*")
public class VendaControle {

    private final VendaServico vendaServico;

    private final ConversorDeDto conversorDeDto;

    @PostMapping
    @Operation(summary = "Endpoint responsável por registrar vendas.")
    @ApiResponse(responseCode = "201",description = " sucesso",content = {
            @Content(mediaType = "application.json",schema = @Schema(implementation = ResponseEntity.class))
    })
    public ResponseEntity<VendaResponseDTO>registrarVenda(@RequestBody VendaRequestDTO vendaRequestDTO){
        var salvar = vendaServico.registrarVenda(vendaRequestDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(conversorDeDto.converterParaDTO(salvar));
    }
}
