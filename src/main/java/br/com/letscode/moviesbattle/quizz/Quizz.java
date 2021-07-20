package br.com.letscode.moviesbattle.quizz;

import br.com.letscode.moviesbattle.jogador.Jogador;
import lombok.*;
import org.springframework.stereotype.Component;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Quizz {

    private Jogador jogador;
    private String imdbId;
    private Boolean resposta;
}
