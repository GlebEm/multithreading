package task1619;

/* 
� ��� interrupt �����?
���������, ��� �������� ���������.
�������� ����� ourInterruptMethod ����� �������, ����� �� �������� ���� TestThread. ������� ��������� ��� ���������, ���� ��� ����������. ������ ������������ ����� interrupt.


Requirements:
1. � ������ Solution ������ ���� ��������� ����������� ����� ourInterruptMethod ��� ����������.
2. ����� run ������ �������� ������� "he-he" ������ ��� �������, ���� �� ����� ������ ����� ourInterruptMethod.
3. ���������� �������� ������� ����� while � ������ run.
4. ����� main ������ ��������� ������ ���� Thread ��������� � ����������� ������ ���� TestThread.
5. ����� main ������ �������� ����� start � ������� ���� Thread.
6. ����� main ������ �������� ����� ourInterruptMethod.*/

public class Solution {
    public static boolean finish = true; //�������� ������� ����������

    public static void main(String[] args) throws InterruptedException {
        Thread t = new Thread(new TestThread());
        t.start(); //��������� �����, ���� ����� ���������
        Thread.sleep(3000); //����� �������� 3 �������, ������� 6 he-he
        ourInterruptMethod(); //����� ������ ������� �� ����, ���� �������������
        System.out.println("����� ���������");
    }

    public static void ourInterruptMethod() {
        finish = false; //����� ������ ������� ��������� �� ����
    }

    public static class TestThread implements Runnable {
        public void run() {
            while (finish) { //���� �������� ���� ������� ���������� ���
                try {
                    System.out.println("he-he");
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                }
            }
        }
    }
}
