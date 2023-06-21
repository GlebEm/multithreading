package task1714;

/* 
Comparable
Реализуй интерфейс Comparable<Beach> в классе Beach. Пляжи(Beach) будут использоваться нитями,
поэтому позаботься, чтобы все методы были синхронизированы.
Реализуй метод compareTo так, чтобы при сравнении двух пляжей он выдавал:
– положительное число, если первый пляж лучше;
– отрицательное число, если второй пляж лучше;
– ноль, если пляжи одинаковые.
Сравни каждый критерий по отдельности, чтобы победителем был пляж с лучшими показателями по большинству критериев.
Учти при сравнении, чем меньше расстояние к пляжу (distance), тем пляж лучше.


Requirements:
1. Класс Beach должен содержать три поля: String name, float distance, int quality.
2. Класс Beach должен реализовывать интерфейс Comparable<Beach>.
3. Метод compareTo класса Beach должен учитывать качество пляжа (quality) и дистанцию (distance).
4. Все методы класса Beach, кроме метода main, должны быть синхронизированы.
*/

import java.util.Random;

public class Beach implements Comparable<Beach> { //2. Класс Beach должен реализовывать интерфейс Comparable<Beach>.
    private String name;      //название
    private float distance;   //расстояние
    private int quality;    //качество

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

    public static void main(String[] args) {  //– положительное число, если первый пляж лучше;
        Random random = new Random();
        Beach beach1 = new Beach();         //– отрицательное число, если второй пляж лучше;
        beach1.setName("Первый");           //– ноль, если пляжи одинаковые.
        beach1.setDistance(random.nextInt(180));
        beach1.setQuality(random.nextInt(5));
        System.out.println("Расстояние до первого пляжа: " + beach1.getDistance() + " Оценка первого пляжа: " + beach1.getQuality());
        Beach beach2 = new Beach();
        beach2.setName("Второй");
        beach2.setDistance(random.nextInt(180));
        beach2.setQuality(random.nextInt(5));
        System.out.println("Расстояние до второго пляжа: " + beach2.getDistance() + " Оценка второго пляжа: " + beach2.getQuality());
        System.out.println(beach1.compareTo(beach2));
        if (beach1.compareTo(beach2) == 1) {
            System.out.println(beach1.getName() + " пляж лучше");
        } else if (beach1.compareTo(beach2) == -1) {
            System.out.println(beach2.getName() + " пляж лучше");
        } else System.out.println("Пляжи равны");
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

