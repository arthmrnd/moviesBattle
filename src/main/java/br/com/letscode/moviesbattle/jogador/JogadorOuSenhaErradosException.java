package br.com.letscode.moviesbattle.jogador;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.UNAUTHORIZED)
public class JogadorOuSenhaErradosException extends RuntimeException {
    public JogadorOuSenhaErradosException() {
        super("Inform um jogador e/ou senha corretas");
    }
}