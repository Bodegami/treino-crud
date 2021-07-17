package br.com.renato.crud.livro;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class LivroService {

    private final LivroRepository livroRepository;

    public LivroService(LivroRepository livroRepository) {
        this.livroRepository = livroRepository;
    }

    @Transactional
    public void salvar(Livro livro) {
        livroRepository.save(livro);
    }

    @Transactional
    public Livro atualizar(Long id, NovoLivroRequest request) {
        Livro livro = livroRepository.getById(id);
        livro.setAutor(request.getAutor());
        livro.setIsbn(request.getIsbn());
        livro.setPreco(request.getPreco());
        livro.setNome(request.getNome());
        return livroRepository.save(livro);
    }

    @Transactional
    public void deleta(Long id) {
        livroRepository.deleteById(id);
    }

    @Transactional
    public List<LivroResponse> listaTodosLivros() {
        List<Livro> lista = livroRepository.findAll();
        return lista.stream().map(LivroResponse::new).collect(Collectors.toList());
    }
}
