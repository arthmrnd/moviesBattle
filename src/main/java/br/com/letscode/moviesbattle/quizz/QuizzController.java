package br.com.letscode.moviesbattle.quizz;

import br.com.letscode.moviesbattle.jogador.Jogador;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RequestMapping("/quizz")
@RestController
public class QuizzController{

    private  QuizzService service;
    private Quizz quizz;

    @GetMapping
    public void jogar(@RequestBody Jogador jogador) throws IOException {
        service.jogar(jogador);
    }

}
