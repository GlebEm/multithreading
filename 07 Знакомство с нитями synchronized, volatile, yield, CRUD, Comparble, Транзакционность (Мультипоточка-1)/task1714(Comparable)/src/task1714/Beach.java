package task1714;

/* 
Comparable
�������� ��������� Comparable<Beach> � ������ Beach. �����(Beach) ����� �������������� ������,
������� ����������, ����� ��� ������ ���� ����������������.
�������� ����� compareTo ���, ����� ��� ��������� ���� ������ �� �������:
� ������������� �����, ���� ������ ���� �����;
� ������������� �����, ���� ������ ���� �����;
� ����, ���� ����� ����������.
������ ������ �������� �� �����������, ����� ����������� ��� ���� � ������� ������������ �� ����������� ���������.
���� ��� ���������, ��� ������ ���������� � ����� (distance), ��� ���� �����.


Requirements:
1. ����� Beach ������ ��������� ��� ����: String name, float distance, int quality.
2. ����� Beach ������ ������������� ��������� Comparable<Beach>.
3. ����� compareTo ������ Beach ������ ��������� �������� ����� (quality) � ��������� (distance).
4. ��� ������ ������ Beach, ����� ������ main, ������ ���� ����������������.
*/

import java.util.Random;

public class Beach implements Comparable<Beach> { //2. ����� Beach ������ ������������� ��������� Comparable<Beach>.
    private String name;      //��������
    private float distance;   //����������
    private int quality;    //��������

    public Beach() {
        this.name = name;
        this.distance = distance;
        this.quality = quality;
    }

    public synchronized String getName() {
        return name;
    }

    public synchronized void setName(String name) {
        this.name = name;
    }

    public synchronized float getDistance() {
        return distance;
    }

    public synchronized void setDistance(float distance) {
        this.distance = distance;
    }

    public synchronized int getQuality() {
        return quality;
    }

    public synchronized void setQuality(int quality) {
        this.quality = quality;
    }

    public static void main(String[] args) {  //� ������������� �����, ���� ������ ���� �����;
        Random random = new Random();
        Beach beach1 = new Beach();         //� ������������� �����, ���� ������ ���� �����;
        beach1.setName("������");           //� ����, ���� ����� ����������.
        beach1.setDistance(random.nextInt(180));
        beach1.setQuality(random.nextInt(5));
        System.out.println("���������� �� ������� �����: " + beach1.getDistance() + " ������ ������� �����: " + beach1.getQuality());
        Beach beach2 = new Beach();
        beach2.setName("������");
        beach2.setDistance(random.nextInt(180));
        beach2.setQuality(random.nextInt(5));
        System.out.println("���������� �� ������� �����: " + beach2.getDistance() + " ������ ������� �����: " + beach2.getQuality());
        System.out.println(beach1.compareTo(beach2));
        if (beach1.compareTo(beach2) == 1) {
            System.out.println(beach1.getName() + " ���� �����");
        } else if (beach1.compareTo(beach2) == -1) {
            System.out.println(beach2.getName() + " ���� �����");
        } else System.out.println("����� �����");
    }

    @Override
    public synchronized int compareTo(Beach o) {
        if (this.quality > o.quality) {
            return 1;
        } else if (this.quality < o.quality) {
            return -1;
        } else {
            if (this.distance > o.distance) {
                return -1;
            } else if (this.distance < o.distance) {
                return 1;
            } else {
                return 0;
            }
        }
        //return 10000 * name.compareTo(obj.getName()) + 100 * second + first;
    }
}

