import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.security.KeyStore.Entry;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

// Пусть дан список сотрудников:
// Иван Иванов
// Светлана Петрова
// Кристина Белова
// Анна Мусина
// Анна Крутова
// Иван Юрин
// Петр Лыков
// Павел Чернов
// Петр Чернышов
// Мария Федорова
// Марина Светлова
// Мария Савина
// Мария Рыкова
// Марина Лугова
// Анна Владимирова
// Иван Мечников
// Петр Петин
// Иван Ежов

// Написать программу, которая найдет и выведет повторяющиеся
// имена с количеством повторений.
// Отсортировать по убыванию популярности Имени.

/**
 * Task2
 */

 public class Task2 {
    // Функция считает колчество повторений

    public static Map<String, Integer> countRepeat(Map<Integer, ArrayList<String>> map) {

        Map<String, Integer> names = new HashMap<>();
        int count = 0;
        for (var elementI : map.entrySet()) {
            if (!names.containsKey(elementI.getValue().get(0))) {
                String name = elementI.getValue().get(0);
                for (var elementJ : map.entrySet()) {
                    if (elementJ.getValue().get(0).equals(name))
                        count += 1;
                }
                names.put(name, count);
                count = 0;
            }
        }
        for (var element : names.entrySet())
            System.out.printf(element.getKey() + " " + element.getValue() + "\n");
        return names;
    }

    // Функция выводит имена по убыванию популярности.
    public static void sortList(Map<String, Integer> map) {
        for (int i = map.size()-1; i>0; i--) {
            for (var element : map.entrySet()) {
                if (element.getValue() == i) {
                    System.out.printf(element.getKey() + " " + element.getValue()+", ");
                }
            }
        }
    }

    public static void main(String[] args) {
        String[] listStaff = new String[] { "Иван Иванов", "Светлана Петрова", "Кристина Белова", "Анна Мусина",
                "Анна Крутова", "Иван Юрин", "Петр Лыков", "Павел Чернов", "Петр Чернышов", "Мария Федорова",
                "Марина Светлова", "Мария Савина", "Мария Рыкова", "Марина Лугова", "Анна Владимирова", "Иван Мечников",
                "Петр Петин", "Иван Ежов" };
        Map<Integer, ArrayList<String>> wholeList = new HashMap<>();
        for (int i = 0; i < listStaff.length; i++) {
            String[] stafferArr = listStaff[i].split(" ");
            ArrayList<String> staffer = new ArrayList<>();
            for (int j = 0; j < stafferArr.length; j++) {
                staffer.add(stafferArr[j]);
            }
            wholeList.put(i + 1, staffer);
        }
        Map<String, Integer> names = countRepeat(wholeList);
        sortList(names);
    }
}