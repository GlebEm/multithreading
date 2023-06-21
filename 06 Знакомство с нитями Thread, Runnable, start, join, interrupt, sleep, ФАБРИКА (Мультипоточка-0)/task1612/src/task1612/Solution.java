package task1612;

/* 
Stopwatch (����������)
1. ���������, ��� ������ ���������.
2. �������� ������ ������ doStep ���, ����� ����������� �������� ������.
2.1. ����� getSpeed() � ������ Runner ����������, ������� ����� � ������� ������ �����.
�����, ����� ����� ������������� ����� �������� ���������� ����� � �������.
���� ������ ������ 4 ���� � �������, �� �� 2 ������� �� ������� 8 �����.
���� ������ ������ 2 ���� � �������, �� �� 2 ������� �� ������� 4 ����.
2.2. ����� sleep � ������ Thread ��������� �������� ���� long.

�����! ��������� ����� Thread.sleep(), � �� Stopwatch.sleep().


Requirements:
1. ����� getSpeed ������ ���������� int.
2. ���� speed ������ Runner ������ ����� ��� int.
3. ����������� ������ Runner ������ ��������� String � int.
4. ����� doStep ������ ��������� �������� ������. ���� �������� ������ 2 ���� � �������,
����� ������ �������� ��� �������; ���� �������� ������ 4 ���� � �������, ����� ������ �������� �������� �������.
5. ����� ��������� ������ ���������� ������� ����� ������� ������ � ������ �� 2 �������.*/

public class Solution {
    public static volatile boolean isStopped = false;

    public static void main(String[] args) throws InterruptedException {
        Runner ivanov = new Runner("Ivanov", 4);
        Runner petrov = new Runner("Petrov", 2);
        //�� �����!
        //��������!
        //����!
        ivanov.start();
        petrov.start();
        Thread.sleep(2000);
        isStopped = true;
        Thread.sleep(1000);
    }

    public static class Stopwatch extends Thread {
        private Runner owner;
        private int stepNumber;

        public Stopwatch(Runner runner) {
            this.owner = runner;
        }

        public void run() {
            try {
                while (!isStopped) {
                    doStep();
                }
            } catch (InterruptedException e) {
            }
        }

        private void doStep() throws InterruptedException { /**4. ����� doStep ������ ��������� �������� ������.
                                                ���� �������� ������ 2 ���� � �������,����� ������ ��������
                                                ��� �������; ���� �������� ������ 4 ���� � �������, ����� ������ �������� �������� �������.*/
            stepNumber++;
//            Thread.sleep(1000 / owner.getSpeed());
            if(owner.getSpeed()==2){
                Thread.sleep(500);
            }else if(owner.getSpeed()==4){
                Thread.sleep(250);
            }
            //add your code here - ������ ��� ���
            System.out.println(owner.getName() + " ������ ��� �" + stepNumber + "!");
        }
    }

    public static class Runner {
        Stopwatch stopwatch;
        private String name;
        private int speed;  //2. ���� speed ������ Runner ������ ����� ��� int.

        public Runner(String name, int speed) { //3. ����������� ������ Runner ������ ��������� String � int.
            this.name = name;
            this.speed = speed;
            this.stopwatch = new Stopwatch(this);
        }

        public String getName() {
            return name;
        }

        public int getSpeed() { //1. ����� getSpeed ������ ���������� int.
            return speed;
        }

        public void start() {
            stopwatch.start();
        }
    }
}
