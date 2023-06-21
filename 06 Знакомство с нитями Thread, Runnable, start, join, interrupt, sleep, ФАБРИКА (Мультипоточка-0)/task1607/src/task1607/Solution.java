package task1607;

import java.util.ArrayList;
import java.util.List;

/* 
Horse Racing
���������, ��� ������ ���������.
�������� ����� calculateHorsesFinished.
�� ������:
1. ��������� ���������� �������������� ������� � ���������� ���. ��������� ����� isFinished().
2. ���� ������ ��� �� ������ � ������ (!isFinished()), ��:
2.1. ������� � ������� "Waiting for " + horse.getName().
2.2. ���������, ���� ��� �������� �����. �������, ����� ����� ����� ������������ ��� �����.
2.3. �� ������� ����� ������ ��������������.


Requirements:
1. ����� calculateHorsesFinished ������ ������� ���������� �������������� �������.
2. ����� calculateHorsesFinished ������ �������� ����� isFinished � ������ ������ �� ����������� ������.
3. ���� �����-���� �� ���������� � ������ ������� ��� �� ������������, ����� calculateHorsesFinished ������ ������� � ������� "Waiting for " + horse.getName(). ������ ��������� ��� ������ ������: "Waiting for Horse_01".
4. ���� �����-���� �� ���������� � ������ ������� ��� �� ������������, ����� calculateHorsesFinished ������ ��������� ���� ��� ����������. ��������� ���������� ����� ��� ��������.
5. ����� ���������� ������ ���������, ������� ������ ��������� ���������� � ���, ��� ��� ������ ������������. ������ ��������� ��� ������ ������: "Horse_01 has finished the race!".*/

public class Solution {

    public static void main(String[] args) throws InterruptedException {
        List<Horse> horses = prepareHorsesAndStart(10);
        while (calculateHorsesFinished(horses) != horses.size()) {
        }
        System.out.println("������������: " + calculateHorsesFinished(horses) + " �������");
        System.out.println("����� ����������: " + horses.size() + " �������");
    }

    public static int calculateHorsesFinished(List<Horse> horses) throws InterruptedException {
        int finishedCount = 0;
        for (Horse horse : horses)
            if (horse.isFinished() != true) {
                System.out.println("Waiting for " + horse.getName());
                horse.join();
            } else {
                finishedCount++;
            }
//        for (int i = 0; i < horses.size(); i++)
//            if (horses.get(i).isFinished())
//            {
//                finishedCount++;
//            }
//            else if (horses.get(i).isFinished() == false) {
//                System.out.println("Waiting for " + horses.get(i).getName());
// //               horses.get(i).join();
//                Thread.sleep(999);
//            }

        return finishedCount;
    }

    public static List<Horse> prepareHorsesAndStart(int horseCount) {
        List<Horse> horses = new ArrayList<>(horseCount);
        String number;
        for (int i = 1; i < horseCount + 1; i++) {
            number = i < 10 ? ("0" + i) : "" + i;
            horses.add(new Horse("Horse_" + number));
        }

        System.out.println("All horses start the race!");
        for (int i = 0; i < horseCount; i++) {
            horses.get(i).start();
        }
        return horses;
    }
}

class Horse extends Thread {

    private boolean isFinished;

    public Horse(String name) {
        super(name);
    }

    public boolean isFinished() {
        return isFinished;
    }

    public void run() {
        String s = "";
        for (int i = 0; i < 1002; i++) {   // Delay
            s += "" + i;
            if (i == 1000) {
                s = " has finished the race!";
                System.out.println(getName() + s);
                isFinished = true;
            }
        }
    }
}