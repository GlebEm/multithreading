package task1710;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

/* 
CRUD
CRUD - Create, Read, Update, Delete.

Программа запускается с одним из следующих наборов параметров:
-c name sex bd
-r id
-u id name sex bd
-d id

Значения параметров:
name - имя, String
sex - пол, "м" или "ж", одна буква
bd - дата рождения в следующем формате 15/04/1990
-c - добавляет человека с заданными параметрами в конец allPeople, выводит id (index) на экран
-r - выводит на экран информацию о человеке с id: name sex (м/ж) bd (формат 15-Apr-1990)
-u - обновляет данные человека с данным id
-d - производит логическое удаление человека с id, заменяет все его данные на null

id соответствует индексу в списке.
Все люди должны храниться в allPeople.
Используй Locale.ENGLISH в качестве второго параметра для SimpleDateFormat.

Пример параметров:
-c Миронов м 15/04/1990

Пример вывода для параметра -r:
Миронов м 15-Apr-1990

Если программа запущена с параметрами, то они попадают в массив args (аргумент метода main - String[] args).
Например, при запуске программы c параметрами:
-c name sex bd
получим в методе main
args[0] = "-c"
args[1] = "name"
args[2] = "sex"
args[3] = "bd"
Для запуска кода с параметрами в IDE IntellijIDEA нужно их прописать в поле Program arguments в меню Run -> Edit Configurations.


Requirements:
1. Класс Solution должен содержать public static поле allPeople типа List<Person>.
2. Класс Solution должен содержать статический блок, в котором добавляются два человека в список allPeople.
3. При запуске программы с параметром -с программа должна добавлять человека с заданными параметрами в конец списка allPeople, и выводить id (index) на экран.
4. При запуске программы с параметром -r программа должна выводить на экран данные о человеке с заданным id по формату указанному в задании.
5. При запуске программы с параметром -u программа должна обновлять данные человека с заданным id в списке allPeople.
6. При запуске программы с параметром -d программа должна логически удалять человека с заданным id в списке allPeople.
*/

public class Solution {
    public static List<Person> allPeople = new ArrayList<Person>(); //1. Класс Solution должен содержать public static поле allPeople типа List<Person>.

    static { //2. Класс Solution должен содержать статический блок, в котором добавляются два человека в список allPeople.
        allPeople.add(Person.createMale("Иванов Иван", new Date()));  //сегодня родился    id=0
        allPeople.add(Person.createMale("Петров Петр", new Date()));  //сегодня родился    id=1
    }

    public static void main(String[] args) throws ParseException {

        DateFormat dateFormatInput = new SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH); //
        DateFormat dateFormatOutput = new SimpleDateFormat("dd-MMM-yyyy", Locale.ENGLISH);

        if (args[0].equals("-c")) {
            Date date = null;
            try {
                date = dateFormatInput.parse(args[3]); //задали день рождения
            } catch (ParseException e) {
                e.getMessage();
            }
            if (args[2].equals("м")) {
                Person person = Person.createMale(args[1], date); //создали мужчину с переданными датой и именем
                allPeople.add(person);                          //добавили его в конец списка
                System.out.println(allPeople.indexOf(person)); //получили индекс мужчины, добавленного в конец списка
            } else {                                            //иначе
                Person person = Person.createFemale(args[1], date);//создали женщину с переданными датой и именем
                allPeople.add(person);                          // добавили ее в конец списка
                System.out.println(allPeople.indexOf(person)); //получили индекс женщины, добавленного в конец списка
            }
        }
        if (args[0].equals("-u")) { //Параметр для обновления человека в списке    -u id name sex bd
            int index = Integer.parseInt(args[1]); //место человека в списке, полученное с параметра ввода
            Person person = allPeople.get(index); //ставим человека на его место ОБНОВИЛИ Место
            person.setName(args[2]); //ОБНОВИЛИ Имя человека в списке, согласно переданному
            if (args[3].equals("м")) {  //Если аргумент пола "м" -
                person.setSex(Sex.MALE); //ОНОВЛЯЕМ пол на мужской
            } else {
                person.setSex(Sex.FEMALE); //Иначе ОБНОВЛЯЕМ пол на женский
            }
            Date date = null; //Задаем дату
            try {
                date = dateFormatInput.parse(args[4]); //Пробуем считать дату со входа
            } catch (ParseException e) {
                e.getMessage();
            }
            person.setBirthDate(date); //ОБНОВЛЯЕМ день рождения
        }
        if (args[0].equals("-d")) { //производит логическое удаление человека с id, заменяет все его данные на null   -d id
            int index = Integer.parseInt(args[1]); //Получаем индекс человека с входящего параметра
            Person person = allPeople.get(index); //Берем человека по заданном индексу
            person.setBirthDate(null); //Логические удаляем день рождения
            person.setSex(null);       //Логически удаляем пол
            person.setName(null);      //Логически удаляем имя
            System.out.println(person.getName()+" "+person.getSex()+" "+person.getBirthDate());

        }
        if (args[0].equals("-r")) {  //-r id //-r - выводит на экран информацию о человеке с id: name sex (м/ж) bd (формат 15-Apr-1990)
            int index = Integer.parseInt(args[1]); ////Получаем индекс человека с входящего параметра
            Person person = allPeople.get(index); ////Берем человека по заданном индексу
            System.out.println(person.getName() + " " + (person.getSex() == Sex.MALE ? "м" : "ж") +
                   dateFormatOutput.format(person.getBirthDate()));

        }
    }
}
