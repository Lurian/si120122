/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Sistema;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author Lurian
 */
class ThreadContadoraDePalavrasJava extends Thread {
    
    private InteressadoNaContagemDePalavrasJava interessado;
    private List<String> palavrasReservadasJava;
    private HashMap<String, Integer> mapaDaContagem;
    private File arquivoAtual;

    public ThreadContadoraDePalavrasJava(InteressadoNaContagemDePalavrasJava interessado) {
        this.interessado = interessado;
        this.palavrasReservadasJava = Arrays.asList(PalavrasReservadasJava.getPalavras());
        this.mapaDaContagem = new HashMap<String, Integer>();
        resetaContagem();
    }

    private void resetaContagem() {
        for (String palavra : palavrasReservadasJava) {
            mapaDaContagem.put(palavra, 0);
        }
    }

    @Override
    public void run() {
        while (true) {
            arquivoAtual = interessado.proximoArquivo();
            if (arquivoAtual == null) {
                break;
            }   
            analisaArquivo();
            interessado.avisaContagemTerminada(mapaDaContagem);
            resetaContagem();
        }

    }

    private void analisaArquivo() {
        BufferedReader reader;
        try {
            reader = new BufferedReader(new FileReader(arquivoAtual));

            Pattern padrao = Pattern.compile("[a-z]+");
            Matcher matcher;

            String linha = reader.readLine();
            while (linha != null) {
                matcher = padrao.matcher(linha);
                while (matcher.find()) {
                    String palavra = matcher.group();
                    if (palavrasReservadasJava.contains(palavra)) {
                        mapaDaContagem.put(palavra, mapaDaContagem.get(palavra) + 1);
                    }
                }
                linha = reader.readLine();
            }
            reader.close();
        } catch (FileNotFoundException e) {
        } catch (IOException e) {
        }

    }
}
