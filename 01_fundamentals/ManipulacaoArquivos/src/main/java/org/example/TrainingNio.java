package org.example;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.nio.file.attribute.BasicFileAttributes;

public class TrainingNio {

    public static void main (String[] args) throws IOException {
        createAndWriteFile();
        listFilesByFolder();
        copyFile();
    }

    private static void copyFile() throws IOException {
        Files.copy(Path.of("nio.txt"), Path.of("nio-copy.txt"), StandardCopyOption.REPLACE_EXISTING); //StandardCopyOption.REPLACE_EXISTING: Sobrescreve o arquivo destino se já existir, evitando erro.
    }

    private static void listFilesByFolder() {

        try {
            Files.list(Path.of(".")) // lista arquivos do diretório atual
                    .forEach(file -> {
                        try {
                            BasicFileAttributes attrs = Files.readAttributes(file, BasicFileAttributes.class); //Permite obter: tamanho (size), data de criação, data de modificação, se é diretório, se é arquivo regular

                            System.out.println("-----------------------------");
                            System.out.println("Nome: " + file.getFileName());
                            System.out.println("É diretório? " + attrs.isDirectory());
                            System.out.println("Tamanho (bytes): " + attrs.size());

                        } catch (IOException e) {
                            throw new RuntimeException(e);
                        }
                    });
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    private static void createAndWriteFile() throws IOException {
        Path path = Paths.get("nio.txt"); // ou Paths.of("nio.txt");

        // Files.write(path, "Adicionando texto no arquivo".getBytes()); // enviando conteudo como bytes
        Files.writeString(path, "Adicionando texto no arquivo"); // enviando conteudo como String

        System.out.println(Files.readString(path));
    }
}
