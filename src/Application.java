import java.util.Scanner;

public class Application {
    public static void main(String[] args) {
        System.out.println("Wellcome to my Cryptoanalyser");
        System.out.println("1. Шифорвание.\n2. Расшифровка с ключом.\n3. Выход.");
        Scanner userInput = new Scanner(System.in);
        System.out.println("Выберете один из вариантов:");
        Validate validate = new Validate();
        int userChoce = Validate.readInt(userInput);

        if (userChoce == 1) {
            System.out.println("Введите ключ шифрования: ");
            int keyInput = Validate.readInt(userInput);
            FileReadCode.fileRead(keyInput);
        } else if (userChoce == 2) {
            System.out.println("Введите ключ шифрования: ");
            int keyInput = Validate.readInt(userInput);
            FileReadWriteUncode.fileRead(keyInput);
        } else if (userChoce == 0 || userChoce == 3) {
            System.out.println("Программа завершена!");
        }
    }
}
