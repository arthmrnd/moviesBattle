package br.com.letscode.moviesbattle.jogador;

import com.opencsv.CSVReader;

import java.io.FileReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.List;

public class JogadorRestRepository {
    List<Jogador> jogadoresList;

    public JogadorRestRepository() throws IOException {
        jogadoresList = new ArrayList<>();
        CSVReader reader = new CSVReader(new FileReader("jogadores.csv"));
        String[] line;
        while ((line = reader.readNext()) != null) {
            var jogador = new Jogador();
            jogador.setUser(line[0]);
            jogador.setPassword(line[1]);
            this.jogadoresList.add(jogador);
        }
    }

    public Boolean compareJogador(String user, String password) throws NoSuchAlgorithmException {
        MessageDigest algorithm = MessageDigest.getInstance("SHA-1");
        byte[] passwordHash = algorithm.digest(password.getBytes(StandardCharsets.UTF_8));

        var passwordHex = new StringBuilder();
        for (byte b : passwordHash) {
            passwordHex.append(String.format("%02X", 0xFF & b));
        }
        for (Jogador jogador : jogadoresList) {
            if (user.equals(jogador.getUser())){
                return passwordHex.toString().equals(jogador.getPassword());
            }
        }
        return false;
    }
}
