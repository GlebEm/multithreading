package task1619;

/* 
А без interrupt слабо?
Разберись, как работает программа.
Реализуй метод ourInterruptMethod таким образом, чтобы он прерывал нить TestThread. Исправь остальной код программы, если это необходимо. Нельзя использовать метод interrupt.


Requirements:
1. В классе Solution должен быть публичный статический метод ourInterruptMethod без параметров.
2. Метод run должен выводить надпись "he-he" каждые пол секунды, пока не будет вызван метод ourInterruptMethod.
3. Необходимо изменить условие цикла while в методе run.
4. Метод main должен создавать объект типа Thread передавая в конструктор объект типа TestThread.
5. Метод main должен вызывать метод start у объекта типа Thread.
6. Метод main должен вызывать метод ourInterruptMethod.*/

public class Solution {
    public static boolean finish = true; //объявили булевую переменную

    public static void main(String[] args) throws InterruptedException {
        Thread t = new Thread(new TestThread());
        t.start(); //запустили поток, цикл начал крутиться
        Thread.sleep(3000); //поток работает 3 секунды, выводит 6 he-he
        ourInterruptMethod(); //метод меняет булевую на фолс, цикл заканчивается
        System.out.println("Поток отработал");
    }

    public static void ourInterruptMethod() {
        finish = false; //метод меняет булевую перменную на фолс
    }

    public static class TestThread implements Runnable {
        public void run() {
            while (finish) { //цикл работает пока булевая переменная тру
                try {
                    System.out.println("he-he");
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                }
            }
        }
    }
}
