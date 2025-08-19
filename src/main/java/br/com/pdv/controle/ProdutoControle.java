package br.com.pdv.controle;

import br.com.pdv.entidade.Produto;
import br.com.pdv.repositorio.ProdutoRepositorio;
import br.com.pdv.servico.ProdutoServico;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/produtos")
@RequiredArgsConstructor
@CrossOrigin(origins = "*")
public class ProdutoControle {

    private final ProdutoServico produtoServico;

    @PostMapping
    @Operation(summary = "Endpoint responsável por cadastrar o produto.")
    @ApiResponse(responseCode = "2001",description = " sucesso",content = {
            @Content(mediaType = "application.json",schema = @Schema(implementation = ResponseEntity.class))
    })
    public ResponseEntity<Produto>salvarProduto(@RequestBody Produto produto){
        return ResponseEntity.status(HttpStatus.CREATED).body(produtoServico.salvar(produto));
    }

    @GetMapping
    @Operation(summary = "Endpoint responsável por listar produtos.")
    @ApiResponse(responseCode = "200",description = " sucesso",content = {
            @Content(mediaType = "application.json",schema = @Schema(implementation = ResponseEntity.class))
    })
    public ResponseEntity<List<Produto>>listarProdutos(){
        return ResponseEntity.ok().body(produtoServico.listar());
    }
}
