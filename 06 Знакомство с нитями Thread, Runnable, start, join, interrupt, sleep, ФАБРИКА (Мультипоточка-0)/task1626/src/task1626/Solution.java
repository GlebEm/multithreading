package task1626;

/* 
�������� �� �������
���������, ��� �������� ���������.
�� ������ � ������� CountdownRunnable ������ ���� CountUpRunnable, ������� ������� �������� � ���������� ������� - �� 1 �� number.


Requirements:
1. ����� CountUpRunnable ������ ������������� ��������� Runnable.
2. ����� CountUpRunnable ������ ����� ��������� ����� run ��� ����������.
3. ����� run ������ CountUpRunnable ������ �������� �������� 2,5 �������.
4. ����� run ������ CountUpRunnable ������ ������ ���������� �������� ��� ������, ��������� � �������� �������� �� 1 �� 5 (��������: "�����������: 1").
5. ����� run ������ CountUpRunnable ������ �������� Thread.sleep(500).*/

public class Solution {
    public static int number = 5;

    public static void main(String[] args) throws InterruptedException {
        new Thread(new CountdownRunnable(), "���������").start();
        Thread.sleep(2500);
        new Thread(new CountUpRunnable(), "�����������").start();
    }

    public static class CountUpRunnable implements Runnable {
        private int countIndexUp = Solution.number -4;

        @Override
        public void run() {
            try {
                while (true) {
                    System.out.println(toString());
                    countIndexUp += 1;
                    if (countIndexUp == 5) return;
                    Thread.sleep(500);
                }
            } catch (InterruptedException e) {

//            try {
//                for(int i =1; i<=number;i++){
//                    Thread.sleep(500);
//                    System.out.println("�����������: "+i);
//                }
//            }catch (InterruptedException e){
//                e.printStackTrace();
//            }
            }
            //Add your code here - ������ ��� ���
        }
        public String toString() {
            return Thread.currentThread().getName() + ": " + countIndexUp;
        }
    }


    public static class CountdownRunnable implements Runnable {
        private int countIndexDown = Solution.number;

        public void run() {
            try {
                while (true) {
                    System.out.println(toString());
                    countIndexDown -= 1;
                    if (countIndexDown == 0) return;
                    Thread.sleep(500);
                }
            } catch (InterruptedException e) {
            }
        }

        public String toString() {
            return Thread.currentThread().getName() + ": " + countIndexDown;
        }
    }
}
