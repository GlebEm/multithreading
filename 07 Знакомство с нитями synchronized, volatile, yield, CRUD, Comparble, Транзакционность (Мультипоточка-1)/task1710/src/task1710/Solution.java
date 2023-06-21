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

��������� ����������� � ����� �� ��������� ������� ����������:
-c name sex bd
-r id
-u id name sex bd
-d id

�������� ����������:
name - ���, String
sex - ���, "�" ��� "�", ���� �����
bd - ���� �������� � ��������� ������� 15/04/1990
-c - ��������� �������� � ��������� ����������� � ����� allPeople, ������� id (index) �� �����
-r - ������� �� ����� ���������� � �������� � id: name sex (�/�) bd (������ 15-Apr-1990)
-u - ��������� ������ �������� � ������ id
-d - ���������� ���������� �������� �������� � id, �������� ��� ��� ������ �� null

id ������������� ������� � ������.
��� ���� ������ ��������� � allPeople.
��������� Locale.ENGLISH � �������� ������� ��������� ��� SimpleDateFormat.

������ ����������:
-c ������� � 15/04/1990

������ ������ ��� ��������� -r:
������� � 15-Apr-1990

���� ��������� �������� � �����������, �� ��� �������� � ������ args (�������� ������ main - String[] args).
��������, ��� ������� ��������� c �����������:
-c name sex bd
������� � ������ main
args[0] = "-c"
args[1] = "name"
args[2] = "sex"
args[3] = "bd"
��� ������� ���� � ����������� � IDE IntellijIDEA ����� �� ��������� � ���� Program arguments � ���� Run -> Edit Configurations.


Requirements:
1. ����� Solution ������ ��������� public static ���� allPeople ���� List<Person>.
2. ����� Solution ������ ��������� ����������� ����, � ������� ����������� ��� �������� � ������ allPeople.
3. ��� ������� ��������� � ���������� -� ��������� ������ ��������� �������� � ��������� ����������� � ����� ������ allPeople, � �������� id (index) �� �����.
4. ��� ������� ��������� � ���������� -r ��������� ������ �������� �� ����� ������ � �������� � �������� id �� ������� ���������� � �������.
5. ��� ������� ��������� � ���������� -u ��������� ������ ��������� ������ �������� � �������� id � ������ allPeople.
6. ��� ������� ��������� � ���������� -d ��������� ������ ��������� ������� �������� � �������� id � ������ allPeople.
*/

public class Solution {
    public static List<Person> allPeople = new ArrayList<Person>(); //1. ����� Solution ������ ��������� public static ���� allPeople ���� List<Person>.

    static { //2. ����� Solution ������ ��������� ����������� ����, � ������� ����������� ��� �������� � ������ allPeople.
        allPeople.add(Person.createMale("������ ����", new Date()));  //������� �������    id=0
        allPeople.add(Person.createMale("������ ����", new Date()));  //������� �������    id=1
    }

    public static void main(String[] args) throws ParseException {

        DateFormat dateFormatInput = new SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH); //
        DateFormat dateFormatOutput = new SimpleDateFormat("dd-MMM-yyyy", Locale.ENGLISH);

        if (args[0].equals("-c")) {
            Date date = null;
            try {
                date = dateFormatInput.parse(args[3]); //������ ���� ��������
            } catch (ParseException e) {
                e.getMessage();
            }
            if (args[2].equals("�")) {
                Person person = Person.createMale(args[1], date); //������� ������� � ����������� ����� � ������
                allPeople.add(person);                          //�������� ��� � ����� ������
                System.out.println(allPeople.indexOf(person)); //�������� ������ �������, ������������ � ����� ������
            } else {                                            //�����
                Person person = Person.createFemale(args[1], date);//������� ������� � ����������� ����� � ������
                allPeople.add(person);                          // �������� �� � ����� ������
                System.out.println(allPeople.indexOf(person)); //�������� ������ �������, ������������ � ����� ������
            }
        }
        if (args[0].equals("-u")) { //�������� ��� ���������� �������� � ������    -u id name sex bd
            int index = Integer.parseInt(args[1]); //����� �������� � ������, ���������� � ��������� �����
            Person person = allPeople.get(index); //������ �������� �� ��� ����� �������� �����
            person.setName(args[2]); //�������� ��� �������� � ������, �������� �����������
            if (args[3].equals("�")) {  //���� �������� ���� "�" -
                person.setSex(Sex.MALE); //�������� ��� �� �������
            } else {
                person.setSex(Sex.FEMALE); //����� ��������� ��� �� �������
            }
            Date date = null; //������ ����
            try {
                date = dateFormatInput.parse(args[4]); //������� ������� ���� �� �����
            } catch (ParseException e) {
                e.getMessage();
            }
            person.setBirthDate(date); //��������� ���� ��������
        }
        if (args[0].equals("-d")) { //���������� ���������� �������� �������� � id, �������� ��� ��� ������ �� null   -d id
            int index = Integer.parseInt(args[1]); //�������� ������ �������� � ��������� ���������
            Person person = allPeople.get(index); //����� �������� �� �������� �������
            person.setBirthDate(null); //���������� ������� ���� ��������
            person.setSex(null);       //��������� ������� ���
            person.setName(null);      //��������� ������� ���
            System.out.println(person.getName()+" "+person.getSex()+" "+person.getBirthDate());

        }
        if (args[0].equals("-r")) {  //-r id //-r - ������� �� ����� ���������� � �������� � id: name sex (�/�) bd (������ 15-Apr-1990)
            int index = Integer.parseInt(args[1]); ////�������� ������ �������� � ��������� ���������
            Person person = allPeople.get(index); ////����� �������� �� �������� �������
            System.out.println(person.getName() + " " + (person.getSex() == Sex.MALE ? "�" : "�") +
                   dateFormatOutput.format(person.getBirthDate()));

        }
    }
}
