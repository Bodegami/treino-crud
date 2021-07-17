package br.com.renato.crud.livro;


import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

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


}
