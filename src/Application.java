import java.util.Scanner;

public class Application {
    public static void main(String[] args) {
        System.out.println("Wellcome to my Cryptoanalyser");
        System.out.println("1. Шифорвание.\n2. Расшифровка с ключом.\n3. Выход.");
        Scanner userInput = new Scanner(System.in);
        System.out.println("Выберете один из вариантов:");
        int userChoce = readInt(userInput);

        if (userChoce == 1) {
            System.out.println("1");
        } else if (userChoce == 2) {
            System.out.println("2");
        } else if (userChoce == 3){
            System.out.println("3");
        } else if (userChoce == 0) {
            System.out.println("Программа завершена!");
        }

    }

    private static int readInt(Scanner s) {
        int count = 3;
        while (count > 0) {
            String line = s.nextLine();
            try {
                return Integer.parseInt(line);
            } catch (NumberFormatException e) {
                System.err.println("Введите 1, 2 или 3");
                System.out.println("Осталось " + count + " попыток");
                count--;
            }
        }
        return 0;
    }
}
