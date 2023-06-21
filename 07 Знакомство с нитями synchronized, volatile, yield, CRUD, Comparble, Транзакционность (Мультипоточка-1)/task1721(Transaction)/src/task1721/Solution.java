package task1721;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

/* 
����������������
������� ����� joinData ��������������, �.�. ���� ��������� ����, �� ������ �� ������ ���� ��������.
1. ������� � ������� 2 ����� �����.
2. ������� ��������� ������ �� ������. �� ������� ����� - � allLines, �� ������� - � forRemoveLines.
� ������ joinData:
3. ���� ������ allLines �������� ��� ������ �� forRemoveLines, �� ������� �� ������ allLines ��� ������, ������� ���� � forRemoveLines.
4. ���� ������� �� �.3 �� ���������, ��:
4.1. �������� allLines �� ������
4.2. ��������� ���������� CorruptedDataException
����� joinData ������ ���������� � main. ��� ���������� ����������� � ������ main.
�� ������ ������� ������.


Requirements:
1. ����� Solution ������ ��������� public static ���� allLines ���� List<String>.
2. ����� Solution ������ ��������� public static ���� forRemoveLines ���� List<String>.
3. ����� Solution ������ ��������� public void ����� joinData() ������� ����� ������� ���������� CorruptedDataException.
4. ��������� ������ ��������� c ������� ����� ���� ������.
5. ��������� ������ ��������� ��������� ������ �� ������� ����� � ������ allLines.
6. ��������� ������ ��������� ��������� ������ �� ������� ����� � ������ forRemoveLines.
7. ����� joinData ������ ������� � ������ allLines ��� ������ �� ������ forRemoveLines, ���� � allLines ����������� ��� ������ �� ������ forRemoveLines.
8. ����� joinData ������ �������� ������ allLines � ��������� ���������� CorruptedDataException, ���� � allLines �� ����������� ��� ������ �� ������ forRemoveLines.
9. ����� joinData ������ ���������� � main.
*/

public class Solution {
    public static List<String> allLines = new ArrayList<String>(); //1. ����� Solution ������ ��������� public static ���� allLines ���� List<String>
    public static List<String> forRemoveLines = new ArrayList<String>(); //2. ����� Solution ������ ��������� public static ���� forRemoveLines ���� List<String>.

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String way1 = reader.readLine();
        String way2 = reader.readLine();
        reader.close();
        File file1 = new File(way1);  //   C:/Users/Admin/Desktop/Test.txt
        File file2 = new File(way2); //    C:/Users/Admin/Desktop/Test2.txt
        Scanner scanner1 = new Scanner(file1);
        System.out.println("������ ����, ��������� �� ������� �����");
        while (scanner1.hasNext()) {
//            System.out.println(scanner1.nextLine());
            allLines.add(scanner1.nextLine());   //5. ��������� ������ ��������� ��������� ������ �� ������� ����� � ������ allLines.
        }
        System.out.println(allLines);

        Scanner scanner2 = new Scanner(file2);
        System.out.println("������ ����, ��������� �� ������� �����");
        while (scanner2.hasNext()) {
//            System.out.println(scanner2.nextLine());
            forRemoveLines.add(scanner2.nextLine());  //6. ��������� ������ ��������� ��������� ������ �� ������� ����� � ������ forRemoveLines.
        }
        System.out.println(forRemoveLines);
        try {
            new Solution().joinData();
        } catch (CorruptedDataException e) {
            System.out.println("�������� ��� ��� ���� ����� ������");
        }
        System.out.println("������ ����:" + "\n" + allLines);
        System.out.println("������ ����:" + "\n" + forRemoveLines);
    }

    /**
     * 7. ����� joinData ������ ������� � ������ allLines ��� ������ �� ������ forRemoveLines, ���� �
     * allLines ����������� ��� ������ �� ������ forRemoveLines.
     * 8. ����� joinData ������ �������� ������ allLines � ��������� ���������� CorruptedDataException,
     * ���� � allLines �� ����������� ��� ������ �� ������ forRemoveLines.
     * 9. ����� joinData ������ ���������� � main.
     */

    public void joinData() throws CorruptedDataException { //3. ����� Solution ������ ��������� public void ����� joinData() ������� ����� ������� ���������� CorruptedDataException
        if (allLines.containsAll(forRemoveLines)) {
            allLines.removeAll(forRemoveLines);
            return;
        } else {
            allLines.clear();
            throw new CorruptedDataException();
        }
    }
}
