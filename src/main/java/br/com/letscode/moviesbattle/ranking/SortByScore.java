package br.com.letscode.moviesbattle.ranking;

import java.util.Comparator;

public class SortByScore implements Comparator<Ranking> {

    public int compare(Ranking a, Ranking b) {
        return a.getScore() - b.getScore();
    }
}
