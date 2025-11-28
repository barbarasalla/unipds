package org.example;

import java.io.*;

public class TrainingFileWriterAndReader {
    public static void main(String[] args) {

        // Criar
        try(FileWriter writer = new FileWriter("dados.txt")) { //cria um arquivo e se já existir é sobreescrito
            writer.write("Olá, Bárbara!\n");
            writer.write("Revisando manipulação de arquivos");
        } catch (IOException e){
            e.printStackTrace();
        }

        // Leitura
        try(BufferedReader bufferedReader = new BufferedReader(new FileReader("dados.txt"))){ // BufferRead ideal para ler linha por linha / new FileReader("dados.txt") Abre o arquivo criado no exercício anterior.
            String line;
            while ((line = bufferedReader.readLine()) != null){ // Lê cada linha até ficar null (fim do arquivo)
                System.out.println(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}


















