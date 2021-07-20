package br.com.letscode.moviesbattle.quizz;

import br.com.letscode.moviesbattle.quizz.jogadorquizz.JogadorQuizz;
import org.springframework.stereotype.Repository;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

@Repository
public class QuizzRestRepository {
    private final String path = "src/main/resources/dados/ranking.csv";

    public void gravarPontuacao(List<JogadorQuizz> jogadorQuizzList) throws IOException {
        Files.deleteIfExists(Paths.get(path));
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(path, true))){
            for (JogadorQuizz jogadorQuizz : jogadorQuizzList){
                String line = jogadorQuizz.getNome()+","+jogadorQuizz.getScore()+"\n";
                bw.write(line);
            }
            bw.flush();
        }
    }
}
