package br.com.letscode.moviesbattle.ranking;

import com.opencsv.CSVReader;
import org.springframework.stereotype.Component;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Component
public class RankingRestRepository {
    private List<Ranking> rankings;

    private final String path = "src/main/resources/dados/ranking.csv";

    public List<Ranking> sort() throws IOException {
        rankings = new ArrayList<>();
        CSVReader reader = new CSVReader(new FileReader(path));
        String[] line;
        while ((line = reader.readNext()) != null) {
            var ranking = new Ranking();
            ranking.setUser(line[0]);
            ranking.setScore(Integer.parseInt(line[1]));
            this.rankings.add(ranking);
        }
        Collections.sort(rankings, new SortByScore());
        Collections.reverse(rankings);
        return rankings;
    }
}
