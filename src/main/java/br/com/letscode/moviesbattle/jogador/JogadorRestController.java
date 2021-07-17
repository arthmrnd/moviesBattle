package br.com.letscode.moviesbattle.jogador;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.security.NoSuchAlgorithmException;

@RequestMapping("/login")
@RestController
public class JogadorRestController {

    @GetMapping
    public String login(@RequestBody Jogador jogador) throws NoSuchAlgorithmException, IOException {
        JogadorRestRepository jogadorRestRepository = new JogadorRestRepository();
        if(jogadorRestRepository.compareJogador(jogador.getUser(), jogador.getPassword())){
            return "Login bem sucedido";
        }
        else {
            return "Login mal sucedido";
        }
    }

}
