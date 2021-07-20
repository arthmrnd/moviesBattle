package br.com.letscode.moviesbattle.quizz;

import br.com.letscode.moviesbattle.jogador.Jogador;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Component
public class Quizz {

    private Jogador jogador;
    private Integer vidas = 3;
    private Integer score = 0;



    public String toString(){
        return  jogador.getUser()+" - pontuação: "+this.getScore();
    }

    public void setJogador(Jogador jogador) {
        this.jogador = jogador;
    }

    public void setVidas() {
        this.vidas--;
    }

    public void setScore() {
        this.score += 50;
    }
}
