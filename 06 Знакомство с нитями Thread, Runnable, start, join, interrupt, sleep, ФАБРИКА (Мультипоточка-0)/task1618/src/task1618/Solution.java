package task1618;

/* 
����� interrupt
������ ���� TestThread.
� ������ main ������ ��������� ����, �������, � ����� ������ �� ��������� ����� interrupt().


Requirements:
1. ����� TestThread ������ ���� ����������� �� Thread.
2. ����� TestThread ������ ����� public void ����� run.
3. ����� main ������ ��������� ������ ���� TestThread.
4. ����� main ������ �������� ����� start � ������� ���� TestThread.
5. ����� main ������ �������� ����� interrupt � ������� ���� TestThread.*/

public class Solution {
    public static void main(String[] args) throws InterruptedException {
        TestThread testThread = new TestThread();
        testThread.start();
        Thread.sleep(1);
        testThread.interrupt();
        //Add your code here - ������ ��� ���
    }

    //Add your code below - ������ ��� ����
    public static class TestThread extends Thread {
        public void run() {
            while (true) {
                System.out.println("*****����� ����****** ");
                if (isInterrupted()) {
                    System.out.println("����� ����� ������� ������");
                    break;
                }
            }
        }
    }
}