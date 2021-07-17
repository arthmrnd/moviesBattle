package br.com.letscode.moviesbattle.client;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ResultSearch {

    @JsonProperty("Search")
    private List<MovieDetail> resultList;
    private Integer total;
    private Boolean response;

    @JsonProperty("Response")
    public void setResponse(Boolean response) {
        this.response = response;
    }

    @JsonProperty("totalResults")
    public void setTotal(Integer total) {
        this.total = total;
    }
}