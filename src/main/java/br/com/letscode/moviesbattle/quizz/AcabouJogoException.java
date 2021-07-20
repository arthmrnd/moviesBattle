package br.com.letscode.moviesbattle.quizz;

import br.com.letscode.moviesbattle.ranking.Ranking;

import java.util.List;

public class AcabouJogoException extends RuntimeException {
    public AcabouJogoException(List<Ranking> rankingList) {
        super("O jogo acabou\n" +
                "Ranking de pontuação:\n" +
                rankingList);
    }
}
