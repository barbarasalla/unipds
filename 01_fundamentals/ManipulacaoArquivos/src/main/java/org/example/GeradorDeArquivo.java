package org.example;

import java.io.BufferedWriter;
import java.io.FileWriter;

public class GeradorDeArquivo {
    public static void main(String[] args) {

        String fileName = "benchmark.txt";
        String linhaBase = "Esta é uma linha de exemplo para branchmark de leitura de arquivos";
        long tamanho = 200L * 1024 * 1024; //200M

        try {
            long tamanhoAtual = 0;
            BufferedWriter writer = new BufferedWriter(new FileWriter(fileName));
            while(tamanhoAtual < tamanho){
                writer.write(linhaBase);
                tamanhoAtual += linhaBase.getBytes().length;
            }

        } catch (Exception e){

        }
    }
}