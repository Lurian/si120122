/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Sistema;

import java.io.File;
import java.io.FileFilter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

/**
 *
 * @author Lurian
 */
public class ContadorDePalavrasJava implements InteressadoNaContagemDePalavrasJava {
    
    private HashMap<String, Integer> mapaDaContagemTotal;
    private List<File> arquivosSendoContados;
    private static ContadorDePalavrasJava instance;
    private List<InteressadoNoContadorDePalavrasJava> interessadosNoContador;
    private Iterator<File> iteradorAtualDeArquivos;
    int threadsFinalizadas;
    int numeroDeThreads;
    long tempoInicial;
   

    public static ContadorDePalavrasJava getInstance() {
       if(instance == null){
           instance = new ContadorDePalavrasJava();
       }
       return instance;
    }
    
    private ContadorDePalavrasJava(){
        this.interessadosNoContador = new ArrayList<InteressadoNoContadorDePalavrasJava>();
        this.mapaDaContagemTotal = new HashMap<String, Integer>();
        for (String palavra : PalavrasReservadasJava.getPalavras()) {
            mapaDaContagemTotal.put(palavra, 0);
        }
    }
     
        private void resetaContagem() {
        for (String palavra : PalavrasReservadasJava.getPalavras()) {
            mapaDaContagemTotal.put(palavra, 0);
        }
        
         this.arquivosSendoContados = new ArrayList<File>();
    }

    public void contaPalavrasJava(String dir, int numeroDeThreads) {
        resetaContagem();
        
        tempoInicial = GregorianCalendar.getInstance().getTimeInMillis();

        preparaArquivos(new File(dir));
        iteradorAtualDeArquivos = arquivosSendoContados.iterator();

        for (InteressadoNoContadorDePalavrasJava interessado : interessadosNoContador) {
            interessado.avisaNumeroDeArquivos(arquivosSendoContados.size());
        }

        this.numeroDeThreads = numeroDeThreads;
        preparaEIniciaThreads();

    }

    public void preparaArquivos(File dir) {
        if (!dir.isDirectory()) {
            return;
        }
        File[] arquivosJava = dir.listFiles(new FileFilter() {

            @Override
            public boolean accept(File pathname) {
                return pathname.isFile()
                        && pathname.getAbsolutePath().endsWith(".java");
            }
        });
        if (arquivosJava != null) {
            arquivosSendoContados.addAll(Arrays.asList(arquivosJava));
        }
        File subPastas[] = dir.listFiles(new FileFilter() {

            @Override
            public boolean accept(File pathname) {
                return pathname.isDirectory();
            }
        });
        if (subPastas != null) {
            for (File subPasta : subPastas) {
                preparaArquivos(subPasta);
            }
        }
    }

    public HashMap<String, Integer> getMapaDaContagem() {
        return mapaDaContagemTotal;
    }

    @Override
    public synchronized File proximoArquivo(){
        if(iteradorAtualDeArquivos.hasNext()){
            return iteradorAtualDeArquivos.next();
        }
        
        threadsFinalizadas++;
        if (threadsFinalizadas == numeroDeThreads) {
            for (InteressadoNoContadorDePalavrasJava interessado : interessadosNoContador) {
                interessado.avisaTerminoDaContagem(getTempoGasto());
            }
        }
        return null;
    }
    


    @Override
    public synchronized void avisaContagemTerminada(HashMap<String, Integer> mapaDaContagem) {
        for (String palavra : mapaDaContagemTotal.keySet()) {
            mapaDaContagemTotal.put(palavra, mapaDaContagemTotal.get(palavra) + mapaDaContagem.get(palavra));
        } 
        
        for(InteressadoNoContadorDePalavrasJava interessado : interessadosNoContador){
            interessado.avisaAtualizacaoDoContador();
        }
    }

    public void adicionaNovoInteressadoNoContador(InteressadoNoContadorDePalavrasJava interessado) {
        interessadosNoContador.add(interessado);
    }

    private void preparaEIniciaThreads() {
        threadsFinalizadas = 0;
        
        if (numeroDeThreads == 0) {
            numeroDeThreads = 5;
        }
        for (int i = numeroDeThreads; i > 0; i--) {
            ThreadContadoraDePalavrasJava thread = new ThreadContadoraDePalavrasJava(this);
            thread.start();
        }
    }

    private long getTempoGasto() {
        return GregorianCalendar.getInstance().getTimeInMillis() - tempoInicial;
    }
}
