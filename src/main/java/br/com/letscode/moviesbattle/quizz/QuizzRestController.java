package br.com.letscode.moviesbattle.quizz;

import br.com.letscode.moviesbattle.movie.Movie;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.util.List;

@RequestMapping("/quizz")
@RestController
@RequiredArgsConstructor
public class QuizzRestController {

    private final QuizzRestService quizzService;

    @GetMapping
    public List<Movie> listarFilmes() throws IOException {
        return this.quizzService.listMovies();
    }

    @PostMapping
    public String jogada(@RequestBody Quizz quizz) throws NoSuchAlgorithmException, IOException {
        try {
            return String.valueOf(quizzService.jogada(quizz));
        } catch (JogadorOuSenhaErradosException | AcabouJogoException e) {
            return e.getMessage();
        }
    }
}
