package br.com.letscode.moviesbattle.controller;

import br.com.letscode.moviesbattle.domain.Jogador;
import br.com.letscode.moviesbattle.domain.JogadoresList;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.security.NoSuchAlgorithmException;

@RequestMapping("/login")
@RestController
public class JogadorLoginRestController {

    @GetMapping
    public String login(@RequestBody Jogador jogador) throws NoSuchAlgorithmException, IOException {
        JogadoresList jogadoresList = new JogadoresList();
        if(jogadoresList.compareJogador(jogador.getUser(), jogador.getPassword())){
            return "Login bem sucedido";
        }
        else {
            return "Login mal sucedido";
        }
    }

}
