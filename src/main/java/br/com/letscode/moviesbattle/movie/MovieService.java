package br.com.letscode.moviesbattle.movie;

import br.com.letscode.moviesbattle.client.MovieMinimalRestRepository;
import br.com.letscode.moviesbattle.client.ResultSearch;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class MovieService {

    private final MovieRestRepository movieRepository;
    private final MovieMinimalRestRepository restRepository;

    public List<Movie> listarTodos() throws IOException {
        return movieRepository.listAll();
    }

    private Movie filmeAleatorio() throws IOException  {
        var movies = listarTodos();
        var random = new Random();
        return movies.get(random.nextInt(movies.size()));
    }

    public List<Movie> escolherFilme() throws IOException {
        List<Movie> list = new ArrayList<>();
        var primeiroFilme = filmeAleatorio();
        list.add(primeiroFilme);
        Movie segundoFilme;
        do {
            segundoFilme = filmeAleatorio();
        } while (primeiroFilme.equals(segundoFilme));
        list.add(segundoFilme);
        return list;
    }

    public ResultSearch queryMultipleMovies(List<String> name) throws IOException {
        List<ResultSearch> resultList = name.stream()
                .map(this.restRepository::search)
                .collect(Collectors.toList());
        for(int i = 0; i < resultList.size(); i++) {
            movieRepository.inserirArquivo(resultList.get(i).getResultList().get(i));
        }
        return reduce(resultList);
    }

    private ResultSearch reduce(List<ResultSearch> resultList) {
        ResultSearch result = new ResultSearch();
        result.setResultList(resultList.stream().map(ResultSearch::getResultList).flatMap(Collection::stream).collect(
                Collectors.toList()));
        result.setResponse(resultList.stream().map(ResultSearch::getResponse).reduce(true, Boolean::logicalAnd));
        result.setTotal(resultList.stream().map(ResultSearch::getTotal).reduce(0, Integer::sum));
        return result;
    }
}