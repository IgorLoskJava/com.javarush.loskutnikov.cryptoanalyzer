import java.io.*;

public class FileReadWriteUncode {
    private static final char[] ALPHABET = {'а', 'б', 'в', 'г', 'д', 'е', 'ё', 'ж', 'з',
            'и', 'й', 'к', 'л', 'м', 'н', 'о', 'п', 'р', 'с', 'т', 'у', 'ф', 'х', 'ц', 'ч', 'ш', 'щ',
            'ъ', 'ы', 'ь', 'э', 'ю', 'я', '.', ',', '«', '»', '"', '\'', ':', '!', '?', ' ', ';', '-'};


    static char zamena;
    //static int key = 5;


    public static void fileRead(int key) {
        try (BufferedReader reader = new BufferedReader(new FileReader("d:\\test2.txt"));
             BufferedWriter writer = new BufferedWriter(new FileWriter("d:\\test3.txt"))) {
            int character;
            while ((character = reader.read()) != -1) {
                for (int i = 0; i < ALPHABET.length; i++) {
                    if (ALPHABET[i] == character) {
                        if ((i - key) < 0) {
                            zamena = ALPHABET[i + ALPHABET.length - key];
                            writer.write(zamena);
                        } else {
                            zamena = ALPHABET[i - key];
                            writer.write(zamena);
                        }

                    }
                }
            }


        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
