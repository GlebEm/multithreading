package task1604;

/* 
����� ����-������
1. ������� ���� (public static ����� SpecialThread, ������� ��������� ��������� Runnable).
2. SpecialThread ������ �������� � ������� ���� ����-�����.

���������: main thread ��� ������� � ������� ���� ����-�����.


Requirements:
1. ������ � ����� Solution ��������� ����������� ����� SpecialThread.
2. ����� SpecialThread �� ������ ���� ����������� �� ������-���� ��������������� ������.
3. ����� SpecialThread ������ ������������� ��������� Runnable.
4. ����� run ������ SpecialThread ������ �������� ���� ����-�����.*/

import java.util.Arrays;

public class Solution {
    public static class SpecialThread implements Runnable{

        @Override
        public void run() {
            for (StackTraceElement element : Thread.currentThread().getStackTrace()) {
                System.out.println(element);
            }
            //System.out.println("����-�����: "+ Arrays.toString(Thread.currentThread().getStackTrace()));
        }
    }
    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(new SpecialThread());
        thread.start();

        System.out.println("*****************");

        for (StackTraceElement element : Thread.currentThread().getStackTrace()) {
            System.out.println(element);
        }
    }
}
