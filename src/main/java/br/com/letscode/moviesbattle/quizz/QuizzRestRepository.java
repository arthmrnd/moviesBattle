package br.com.letscode.moviesbattle.quizz;

import org.springframework.stereotype.Repository;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

@Repository
public class QuizzRestRepository {
    private final String path = "src/main/resources/dados/ranking.csv";

    private List<Quizz> pontuacoes = new ArrayList<>();

    public void gravarPontuacao(Quizz quizz) throws IOException {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(path, true))){
            bw.write(quizz.toString());
        }
    }

    public void listaScore()throws IOException{
        try (BufferedReader br = new BufferedReader(new FileReader(path))){
           String line = br.readLine();
           while (line != null){
               System.out.println(line);
               line = br.readLine();
           }
        }
    }
}
