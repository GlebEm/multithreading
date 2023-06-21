package task1614;

import java.util.ArrayList;
import java.util.List;

/* 
�������� ������
1. ���������, ��� ������ ���������.
2. �������� ������ ������ printCountdown ���, ����� ��������� ������ ���������� �������� ������ �� ���������� list.
�������� ����� � �������� ������� - �� ����������� � Countdown ������� �� ����.

������:
������� ������ 3

������ ������ � �������:
������ 2
������ 1
������ 0


Requirements:
1. ����� printCountdown ������ �������� �������� ����������.
2. ����� printCountdown ������ ��������� (����������������) �������� ���������� countFrom �� 1.
3. ����� printCountdown ������ �������� ������� ������ list � �������� ������ ������ �������� countFrom.
4. ����� main ������ ��������� ���� ������ ���� Countdown.
5. ����� ��������� ������ ��������������� ������� �� �������.*/

public class Solution {
    public static volatile List<String> list = new ArrayList<String>(5);

    static {
        for (int i = 0; i < 5; i++) {
            list.add("������ " + i);
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Thread t = new Thread(new Countdown(5), "Countdown");
        t.start();
    }

    public static class Countdown implements Runnable {
        private int countFrom;

        public Countdown(int countFrom) {
            this.countFrom = countFrom;
        }

        public void run() {
            try {
                while (countFrom > 0) {
                    printCountdown();
                }
            } catch (InterruptedException e) {
            }
        }

        public void printCountdown() throws InterruptedException {
            for (int i = (countFrom - 1); i >= 0; i--) {
                Thread.sleep(220);
                System.out.println(list.get(i));
                countFrom--;
            }
            //add your code here - ������ ��� ���
        }
    }
}
