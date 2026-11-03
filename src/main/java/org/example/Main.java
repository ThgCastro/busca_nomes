package org.example;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {
    static void main(String[] args) throws InterruptedException {
            String procurado = "Thiago";
            System.out.println("Procurado: " + procurado);

            long inicio = System.currentTimeMillis();

            String[] arquivos = {
                    "signatarios-fev-2002.txt",
                    "signatarios-jun-2016.txt",
                    "signatarios-out-2014.txt"
            };

            Thread[] threads = new Thread[arquivos.length];

            try(ExecutorService executor = Executors.newVirtualThreadPerTaskExecutor()){
                for(String arquivo: arquivos){
                    BuscaNomeRunnable busca = new BuscaNomeRunnable(arquivo, procurado);
                    executor.execute(busca);
                }
            }

            long fim = System.currentTimeMillis();
            System.out.println();
            System.out.println("Todas as buscas finalizadas!");
            System.out.println("Tempo total: " + (fim - inicio) + " ms");
        }
    }