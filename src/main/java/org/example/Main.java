package org.example;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

public class Main {
    static void main(String[] args) throws InterruptedException {
        AtomicInteger totalOcorrencias = new AtomicInteger(0);

        System.out.println("========================================\n" +
                "       SISTEMA DE BUSCA DE NOMES\n" +
                "========================================\n");
            String procurado = "Thiago";
            System.out.println("Procurado: " + procurado+"\n");

            long inicio = System.currentTimeMillis();

            String[] arquivos = {
                    "signatarios-fev-2002.txt",
                    "signatarios-jun-2016.txt",
                    "signatarios-out-2014.txt"
            };

            Thread[] threads = new Thread[arquivos.length];
            System.out.println("Iniciando busca nos arquivos...\n");

            try(ExecutorService executor = Executors.newVirtualThreadPerTaskExecutor()){
                for(String arquivo: arquivos){
                    BuscaNomeRunnable busca = new BuscaNomeRunnable(arquivo, procurado, totalOcorrencias);
                    executor.execute(busca);
                }
            }

            long fim = System.currentTimeMillis();
            System.out.println("----------------------------------------");
            System.out.println("Todas as buscas foram finalizadas.");
            System.out.println("Total de ocorrências: " + totalOcorrencias.get());
            System.out.println("Tempo total: " + (fim - inicio) + " ms");
            System.out.println("========================================");
        }
    }