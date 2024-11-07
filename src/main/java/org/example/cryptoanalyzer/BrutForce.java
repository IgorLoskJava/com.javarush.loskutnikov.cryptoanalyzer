package org.example.cryptoanalyzer;

import java.io.*;
import java.nio.file.Path;

public class BrutForce {

    static char zamena;

    public static String brutForce(StringBuilder sb, int key, Path path) {

        try (BufferedReader reader = new BufferedReader(new FileReader(String.valueOf(path)))) {
            int character;
            int count = 0;

            while ((character = reader.read()) != -1 && count <= 50) {
                for (int i = 0; i < Alphabet.ALPHABET.length; i++) {
                    if (Alphabet.ALPHABET[i] == character) {
                        if ((i - key) < 0) {
                            zamena = Alphabet.ALPHABET[i + Alphabet.ALPHABET.length - key];
                            sb.append(zamena);
                        } else {
                            zamena = Alphabet.ALPHABET[i - key];
                            sb.append(zamena);
                        }

                    }
                }
                count++;
            }


        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return sb.toString();
    }
}
