package br.com.letscode.moviesbattle.quizz;

import org.springframework.stereotype.Repository;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Repository
public class QuizzRepository {
    private final String path = "src/main/resources/dados/lista-de-pontuacao.csv";

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
