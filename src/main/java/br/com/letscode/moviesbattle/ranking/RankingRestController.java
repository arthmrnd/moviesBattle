package br.com.letscode.moviesbattle.ranking;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.List;

@RequestMapping("/ranking")
@RestController
public class RankingRestController {

    private final RankingRestRepository rankingRestRepository;

    public RankingRestController(RankingRestRepository rankingRestRepository) {
        this.rankingRestRepository = rankingRestRepository;
    }

    @GetMapping
    public List<Ranking> ranking() throws IOException {
        return rankingRestRepository.sort();
    }

}
