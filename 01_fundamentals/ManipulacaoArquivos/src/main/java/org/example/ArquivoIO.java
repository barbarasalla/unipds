package org.example;

import java.io.BufferedReader;
import java.io.FileReader;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.List;

public class ArquivoIO {

    public static void main(String[] args) throws Exception {
        Path path = Paths.get("benchmark.txt");

        // Java IO - Classico
        long t1_init, t1_fim;
        t1_init = System.currentTimeMillis();
        BufferedReader br = new BufferedReader(new FileReader(path.toFile()));
        while (br.readLine()!=null);
        br.close();
        t1_fim = System.currentTimeMillis();
        System.out.println("demorou "+ (t1_fim-t1_init)+" ms");

        // Java NIO usando FileChannel
        long t2_init, t2_fim;
        t2_init = System.currentTimeMillis();
        FileChannel channel = FileChannel.open(path, StandardOpenOption.READ);
        ByteBuffer buffer = ByteBuffer.allocate(8192);
        while (channel.read(buffer) != -1){
            buffer.flip(); //Prepara um buffer para uma nova sequência de operações de escrita no canal ou de obtenção relativa : define o limite para a posição atual e, em seguida, define a posição como zero.
            buffer.clear(); //Prepara um buffer para uma nova sequência de operações de leitura de canal ou de inserção relativa : define o limite de capacidade e a posição como zero.
        }
        channel.close();
        t2_fim = System.currentTimeMillis();
        System.out.println("Demorou "+ (t2_fim-t2_init)+" ms");

        // Java NIO2 - ReadAllLines
        long t3_ini, t3_fim;
        t3_ini = System.currentTimeMillis();
        List<String> lines = Files.readAllLines(path);
        t3_fim = System.currentTimeMillis();
        System.out.println("JAVA NI02 ReadAllLines - Demorou "+(t3_fim-t3_ini)+ " ms");
    }
}
