package br.com.letscode.moviesbattle.movie;

import br.com.letscode.moviesbattle.client.ResultSearch;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("Movies")
@RequiredArgsConstructor
public class MovieRestController {

    private final MovieService movieService;

    //fazer um @GetMapping para escolher multiplos filmes e salvar em arquivo, se quiser.

    @GetMapping("movies")
    public ResultSearch queryMultipleMovies(@RequestParam List<String> name) throws IOException {
        return movieService.queryMultipleMovies(name);
    }

    @GetMapping
    public List<Movie> listar() throws IOException {
        return movieService.escolherFilme();
    }
}
