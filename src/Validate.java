import java.util.Scanner;

public class Validate {


    public static int readInt(Scanner s) {
        int count = 3;
        while (count > 0) {
            String line = s.nextLine();
            try {
                return Integer.parseInt(line);
            } catch (NumberFormatException e) {
                System.err.println("Введите 1, 2 или 3");
                count--;
                if (count == 0) {
                    System.out.println("Попыток больше нет");
                } else if (count == 2){
                    System.out.println("Осталось " + count + " попытки");
                } else if (count == 1) {
                    System.out.println("Осталось " + count + " попытка");
                }
            }
        }
        return 0;
    }
}
