package task1721;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

/* 
Транзакционность
Сделать метод joinData транзакционным, т.е. если произошел сбой, то данные не должны быть изменены.
1. Считать с консоли 2 имени файла.
2. Считать построчно данные из файлов. Из первого файла - в allLines, из второго - в forRemoveLines.
В методе joinData:
3. Если список allLines содержит все строки из forRemoveLines, то удалить из списка allLines все строки, которые есть в forRemoveLines.
4. Если условие из п.3 не выполнено, то:
4.1. очистить allLines от данных
4.2. выбросить исключение CorruptedDataException
Метод joinData должен вызываться в main. Все исключения обработайте в методе main.
Не забудь закрыть потоки.


Requirements:
1. Класс Solution должен содержать public static поле allLines типа List<String>.
2. Класс Solution должен содержать public static поле forRemoveLines типа List<String>.
3. Класс Solution должен содержать public void метод joinData() который может бросать исключение CorruptedDataException.
4. Программа должна считывать c консоли имена двух файлов.
5. Программа должна считывать построчно данные из первого файла в список allLines.
6. Программа должна считывать построчно данные из второго файла в список forRemoveLines.
7. Метод joinData должен удалить в списке allLines все строки из списка forRemoveLines, если в allLines содержаться все строки из списка forRemoveLines.
8. Метод joinData должен очистить список allLines и выбросить исключение CorruptedDataException, если в allLines не содержаться все строки из списка forRemoveLines.
9. Метод joinData должен вызываться в main.
*/

public class Solution {
    public static List<String> allLines = new ArrayList<String>(); //1. Класс Solution должен содержать public static поле allLines типа List<String>
    public static List<String> forRemoveLines = new ArrayList<String>(); //2. Класс Solution должен содержать public static поле forRemoveLines типа List<String>.

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String way1 = reader.readLine();
        String way2 = reader.readLine();
        reader.close();
        File file1 = new File(way1);  //   C:/Users/Admin/Desktop/Test.txt
        File file2 = new File(way2); //    C:/Users/Admin/Desktop/Test2.txt
        Scanner scanner1 = new Scanner(file1);
        System.out.println("Первый лист, считанный из первого файла");
        while (scanner1.hasNext()) {
//            System.out.println(scanner1.nextLine());
            allLines.add(scanner1.nextLine());   //5. Программа должна считывать построчно данные из первого файла в список allLines.
        }
        System.out.println(allLines);

        Scanner scanner2 = new Scanner(file2);
        System.out.println("Второй лист, считанный из второго файла");
        while (scanner2.hasNext()) {
//            System.out.println(scanner2.nextLine());
            forRemoveLines.add(scanner2.nextLine());  //6. Программа должна считывать построчно данные из второго файла в список forRemoveLines.
        }
        System.out.println(forRemoveLines);
        try {
            new Solution().joinData();
        } catch (CorruptedDataException e) {
            System.out.println("Проверка как там дела после чистки");
        }
        System.out.println("Первый лист:" + "\n" + allLines);
        System.out.println("Второй лист:" + "\n" + forRemoveLines);
    }

    /**
     * 7. Метод joinData должен удалить в списке allLines все строки из списка forRemoveLines, если в
     * allLines содержаться все строки из списка forRemoveLines.
     * 8. Метод joinData должен очистить список allLines и выбросить исключение CorruptedDataException,
     * если в allLines не содержаться все строки из списка forRemoveLines.
     * 9. Метод joinData должен вызываться в main.
     */

    public void joinData() throws CorruptedDataException { //3. Класс Solution должен содержать public void метод joinData() который может бросать исключение CorruptedDataException
        if (allLines.containsAll(forRemoveLines)) {
            allLines.removeAll(forRemoveLines);
            return;
        } else {
            allLines.clear();
            throw new CorruptedDataException();
        }
    }
}
