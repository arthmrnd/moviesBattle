package br.com.letscode.moviesbattle.quizz;

import br.com.letscode.moviesbattle.jogador.Jogador;
import br.com.letscode.moviesbattle.movie.Movie;
import br.com.letscode.moviesbattle.movie.MovieService;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;
import java.util.Scanner;

@Service
public class QuizzService {

    private QuizzRepository repository;
    private MovieService movieService;
    private Quizz quizz;

    public List<Movie> movies = this.movieService.escolherFilme();

    public QuizzService() throws IOException {
    }


    public void escolherFilme(Jogador jogador){
        quizz.setJogador(jogador);
        Scanner sc = new Scanner(System.in);
        System.out.println("Indique o filme com o maior rating. Filme 1 ou Filme 2. \n Digite o número do filme: ");
        Integer escolha = sc.nextInt();
        if(escolha != 1 || escolha != 2){
            System.out.println("escolha 1 ou 2");
        } else if(escolha == 1 && movies.get(0).getRating() > movies.get(1).getRating()){
            System.out.println("Acertou!!");
            quizz.setScore();
        } else{
            System.out.println("Errou!!");
            quizz.setVidas();
        }
        sc.close();
    }

    public void validarJogador(Jogador jogador){
    }



    public void jogar(Jogador jogador) throws IOException {
        //Quizz quizz = new Quizz();
        do{
            escolherFilme(jogador
            );
        }while (quizz.getVidas() != 0);

        System.out.println("Fim de Jogo!!");
        repository.gravarPontuacao(quizz);
    }
}
