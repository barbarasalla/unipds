package org.example;

import java.io.*;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.List;
import java.util.stream.Collectors;

public class FileChannerTraining {

    public static void main(String[] args){
        lerAqruivoGrande();
        copiarArquivoTextoLinhaPorLinha();
        copiarArquivoTextoByteAByte();
        readerAndWriter();
        escreverInteirosBinarios();
        lerInteirosBinarios();
    }

    private static void lerInteirosBinarios() {
        Path path = Path.of("numeros.bin");

        try (FileChannel channel = FileChannel.open(
                path,
                StandardOpenOption.READ)) {

            ByteBuffer buffer = ByteBuffer.allocate(4 * 10);
            channel.read(buffer);

            buffer.flip();

            while (buffer.hasRemaining()) {
                int valor = buffer.getInt();
                System.out.println("Lido: " + valor);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void escreverInteirosBinarios() {
        Path path = Path.of("numeros.bin");

        try (FileChannel channel = FileChannel.open(
                path,
                StandardOpenOption.CREATE,
                StandardOpenOption.WRITE)) {

            ByteBuffer buffer = ByteBuffer.allocate(4 * 10); // 10 ints * 4 bytes

            for (int i = 1; i <= 10; i++) {
                buffer.putInt(i);   // grava cada int
            }

            buffer.flip(); // prepara para escrever
            channel.write(buffer);

            System.out.println("Arquivo binário criado com 10 inteiros!");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void readerAndWriter() {
        try {
            // 1. Ler todas as linhas
            Path pathEntrada = Paths.get("entrada.txt");
            List<String> linhas = Files.readAllLines(pathEntrada);

            // 2. Transformar em maiúsculo
            List<String> linhasUpper = linhas.stream()
                    .map(String::toUpperCase)
                    .collect(Collectors.toList());

            // 3. Escrever no novo arquivo
            Path pathSaida = Paths.get("saida.txt");
            Files.write(pathSaida, linhasUpper);

            System.out.println("Arquivo convertido para maiúsculo com sucesso!");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void copiarArquivoTextoByteAByte() {
        try (FileInputStream in = new FileInputStream("entrada.txt");
             FileOutputStream out = new FileOutputStream("saida.txt")) {

            byte[] buffer = new byte[1024]; // copia por blocos de 1KB
            int bytesLidos;

            while ((bytesLidos = in.read(buffer)) != -1) {
                out.write(buffer, 0, bytesLidos);
            }

            System.out.println("Cópia realizada com sucesso!");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void copiarArquivoTextoLinhaPorLinha() {
        try (BufferedReader reader = new BufferedReader(new FileReader("entrada.txt"));
             BufferedWriter writer = new BufferedWriter(new FileWriter("saida.txt"))) {

            String line;
            while ((line = reader.readLine()) != null) {
                writer.write(line);
                writer.newLine(); // preserva quebras de linha
            }

            System.out.println("Cópia concluída!");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void lerAqruivoGrande() {
        Path path = Path.of("dados.txt");

        try(FileChannel fileChannel = FileChannel.open(path, StandardOpenOption.READ)){
            ByteBuffer buffer = ByteBuffer.allocate(1024); // vai ler 1024 bytes por vez (1 KB)
            StringBuilder conteudo = new StringBuilder();

            int bytesLidos;
            while ((bytesLidos = fileChannel.read(buffer)) != -1) { //Lê um pedaço do arquivo e retorna -1 quando acabar (Lê até não haver mais bytes)

                buffer.flip(); // Prepara o buffer para leitura (inverte de write → read).
                byte[] dados = new byte[bytesLidos];
                buffer.get(dados); // Extrai os bytes do buffer.

                conteudo.append(new String(dados, StandardCharsets.UTF_8));

                buffer.clear(); // prepara o buffer para próxima leitura
            }

            System.out.println("Conteúdo do arquivo:");
            System.out.println(conteudo);
        } catch (IOException e){
            e.printStackTrace();
        }
    }
}
