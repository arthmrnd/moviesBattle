package br.com.letscode.moviesbattle.ranking;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class Ranking {

    private String user;
    private int score;

    public String toString() {
        return "Nome :" + user +
                ", score: " + score + "\n";
    }
}
