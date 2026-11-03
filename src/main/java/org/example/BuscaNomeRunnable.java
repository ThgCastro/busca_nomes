package org.example;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.concurrent.atomic.AtomicInteger;

public class BuscaNomeRunnable implements Runnable{

    private final String nomeArquivo;
    private final String nomeBuscado;
    private AtomicInteger totalOcorrencias;

    public BuscaNomeRunnable(String nomeArquivo, String nomeBuscado, AtomicInteger totalOcorrencias){
        this.nomeArquivo = nomeArquivo;
        this.nomeBuscado = nomeBuscado;
        this.totalOcorrencias = totalOcorrencias;
    }

    @Override
    public void run() {

        Thread thread = Thread.currentThread();

        int ocorrencias = 0;

        try (BufferedReader br = Files.newBufferedReader(Path.of(nomeArquivo))){
            String conteudo;
            int numeroLinha = 0;

            while((conteudo = br.readLine()) != null){
                numeroLinha++;
                if (conteudo.contains(nomeBuscado)){
                    ocorrencias++;
                    totalOcorrencias.incrementAndGet();
                    System.out.println("["+nomeArquivo+"]\n Linha "+ numeroLinha+" : "+ conteudo+"\n");
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Erro ao ler o arquivo: " + nomeArquivo);
        }
    }
}
