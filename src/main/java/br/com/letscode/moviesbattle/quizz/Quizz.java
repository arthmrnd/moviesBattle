package br.com.letscode.moviesbattle.quizz;

import br.com.letscode.moviesbattle.jogador.Jogador;
import lombok.*;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Quizz {

    private Jogador jogador;
    private String imdbId;
    private Boolean resposta;
}
