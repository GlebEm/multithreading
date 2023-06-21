package task1610;

/* 
�������� ������ ������� join()
1. ���������, ��� ������ ���������.
2. �������� ������ ������� join() ���, ����� ��� ������ ����� ����������� ���������:
2.1. ������� ����� ������ �����.
2.2. ����� ��� ������ �������� �� �������� � ������������ �������.
2.3. � ����� ����� �������� �� ����� � ��������.
2.4. ��� ������� ��� ����� ����� ����� ���� ���������� � ��������� ��� ������ �����.
2.5. �������� ��� ����� (200 ��) � investigateWorld.


Requirements:
1. � ������� ������� (������� ���� Kitten) ������ ���� ������ ����� join.
2. ����� investigateWorld ������ ������������ ��� ������� �� 200 ��. ��������� ����� Thread.sleep(200).
3. ��������� ������ ��������� ��� ����� � ������� �����.
4. ������, ������� �������� �� ����� � �������, �� ��������.
5. ����� ��������� ������ ���������� ���������� ���������� �������.*/

public class Solution {
    public static void main(String[] args) throws InterruptedException {
        Cat cat1 = new Cat("�����");
        Cat cat2 = new Cat("�������");
    }

    private static void investigateWorld() throws InterruptedException {
        Thread.sleep(200);
    }

    public static class Cat extends Thread {
        protected Kitten kitten1;
        protected Kitten kitten2;

        public Cat(String name) {
            super(name);
            kitten1 = new Kitten("������� 1, ���� - " + getName());
            kitten2 = new Kitten("������� 2, ���� - " + getName());
            start();
        }

        public void run() {
            System.out.println(getName() + " ������ 2 �����");
            try {
                initAllKittens();
                // kitten1.join();
                // kitten2.join();
            } catch (InterruptedException e) {
            }
            System.out.println(getName() + ": ��� ������ � ��������. " + getName() + " ������� �� �����");
        }

        private void initAllKittens() throws InterruptedException {
            kitten1.start();
            kitten1.join();
            kitten2.start();
            kitten2.join();
        }
    }

    public static class Kitten extends Thread {
        public Kitten(String name) {
            super(name);
        }

        public void run() {
            System.out.println(getName() + ", ����� �� ��������");
            try {
                investigateWorld();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
