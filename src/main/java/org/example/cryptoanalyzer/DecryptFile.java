package org.example.cryptoanalyzer;

import java.io.*;
import java.nio.file.Path;

public class DecryptFile {

    static char zamena;

    public static void decrypteFile(int key, Path path, Path pathWrite) {
        try (BufferedReader reader = new BufferedReader(new FileReader(String.valueOf(path)));
             BufferedWriter writer = new BufferedWriter(new FileWriter(String.valueOf(pathWrite)))) {
            int character;
            while ((character = reader.read()) != -1) {
                for (int i = 0; i < Alphabet.ALPHABET.length; i++) {
                    if (Alphabet.ALPHABET[i] == character) {
                        if ((i - key) < 0) {
                            zamena = Alphabet.ALPHABET[i + Alphabet.ALPHABET.length - key];
                            writer.write(zamena);
                        } else {
                            zamena = Alphabet.ALPHABET[i - key];
                            writer.write(zamena);
                        }

                    }
                }
            }


        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
