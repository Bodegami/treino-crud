package br.com.renato.crud.livro;


import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/livros")
public class LivroResource {

    private final LivroService livroService;

    public LivroResource(LivroService livroService) {
        this.livroService = livroService;
    }

    @PostMapping
    public ResponseEntity<String> cadastraLivro(@RequestBody NovoLivroRequest request, UriComponentsBuilder builder) {
        Livro livro = request.toModel();
        livroService.salvar(livro);
        URI uri = builder.path("/livros/{id}").buildAndExpand(livro.getId()).toUri();
        return ResponseEntity.created(uri).body("Efetuado cadastro com sucesso!");
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> atualizaLivro(@RequestBody NovoLivroRequest request, @PathVariable Long id) {
        livroService.atualizar(id, request);
        return ResponseEntity.ok("Livro atualizado com sucesso!");
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deletaLivro(@PathVariable Long id) {
        livroService.deleta(id);
        return ResponseEntity.ok("Livro excluido!");
    }

    @GetMapping
    public ResponseEntity<List<LivroResponse>> listaDeLivros() {
        List<LivroResponse> lista = livroService.listaTodosLivros();
        return ResponseEntity.ok(lista);
    }

}
