package org.example;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class BuscaNomeRunnable implements Runnable{

    private final String nomeArquivo;
    private final String nomeBuscado;

    public BuscaNomeRunnable(String nomeArquivo, String nomeBuscado){
        this.nomeArquivo = nomeArquivo;
        this.nomeBuscado = nomeBuscado;
    }

    @Override
    public void run() {

        Thread thread = Thread.currentThread();

        System.out.println(
        "Iniciando buaca no arquivo: " + nomeArquivo + " / Virtual Thread: " + thread.isVirtual()+
                " / Thread ID: " + thread.threadId()
        );

        int ocorrencias = 0;

        try (BufferedReader br = Files.newBufferedReader(Path.of(nomeArquivo))){
            String conteudo;
            int numeroLinha = 0;

            while((conteudo = br.readLine()) != null){
                numeroLinha++;
                if (conteudo.contains(nomeBuscado)){
                    ocorrencias++;
                    System.out.println("["+nomeArquivo+"] Linha "+ numeroLinha+" : "+ conteudo);
                }
            }

            System.out.println("Busca finalizada! Ocorrencias: "+ ocorrencias);

        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Erro ao ler o arquivo: "+ nomeArquivo);
        }
    }
}
