import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

// Реализуйте структуру телефонной книги с помощью HashMap, учитывая,
// что 1 человек может иметь несколько телефонов.
// Добавить функции 1) Добавление номера
// 2) Вывод всего
// Пример:
// Я ввожу: 1
// К: Введите фамилию
// Я: Иванов
// К: Введите номер
// Я: 1242353
// К: Введите 1) Добавление номера
// 2) Вывод всего
// Я ввожу: 1
// К: Введите фамилию
// Я: Иванов
// К: Введите номер
// Я: 547568
// К: Введите 1) Добавление номера
// 2) Вывод всего
// Я: 2
// Иванов: 1242353, 54756

/**
 * Task1
 */

 public class Task1 {

    public static void addPhone(Map<String, ArrayList<Integer>> phoneBook) {
        System.out.println("Enter a surname: ");
        Scanner iScanner = new Scanner(System.in);
        String surname = iScanner.nextLine();
        System.out.println("Enter a phone number: ");
        if (phoneBook.containsKey(surname)) {
            phoneBook.get(surname).add(Integer.parseInt(iScanner.nextLine()));
        } else {
            ArrayList<Integer> phones = new ArrayList<>();
            phones.add(Integer.parseInt(iScanner.nextLine()));
            phoneBook.put(surname, phones);
        }
    }

    public static void printAll(Map<String, ArrayList<Integer>> phoneBook) {
        for (var item : phoneBook.entrySet()) {
            System.out.printf("\n"+item.getKey() + ": ");
            for (int element : item.getValue()) {
                System.out.printf(Integer.toString(element) + ", ");
            }
        }
        System.out.println("\n");
    }


    public static void main(String[] args) {
        System.out.println("Enter 1 - to add phone, 2 - to print all.\nEnter stop to exit the programm.");
        Scanner iScanner = new Scanner(System.in);
        Map<String, ArrayList<Integer>> phoneBook = new HashMap<>();
        String answer = iScanner.nextLine();
        while (!answer.equals("stop")) {
            if (Integer.parseInt(answer) == 1)
                addPhone(phoneBook);
            if (Integer.parseInt(answer) == 2)
                printAll(phoneBook);
            System.out.println("Enter 1 - to add phone, 2 - to print all.\nEnter stop to exit the programm.");
            answer = iScanner.nextLine();
        }
        iScanner.close();
    }
}