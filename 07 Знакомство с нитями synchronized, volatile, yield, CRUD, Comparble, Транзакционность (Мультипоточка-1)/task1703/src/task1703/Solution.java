package task1703;

import java.util.ArrayList;
import java.util.List;

/* 
������������������ �������
1. ����� Note ����� �������������� ������. ������� ������ ���, ����� ��������� � ����� notes ����������� ������� notes, �� this
2. ��� System.out.println �� ������ ���� ������������� (����������������), �.�. �� ������ ���������� � ����� synchronized


Requirements:
1. ����� addNote() ������ ��������� ������� � ������ notes.
2. ����� removeNote() ������ ������� ������� �� ������ notes.
3. � ������ addNote() ������ ���������� synchronized ����.
4. � ������ removeNote() ������ ���������� synchronized ����.
5. Synchronized ���� � ������ addNote() ������ ����������� ������� notes.
6. Synchronized ���� � ������ removeNote() ������ ����������� ������� notes.
7. � synchronized ����� ������ addNote() ������ ���������� ����� ������ add � notes.
8. � synchronized ����� ������ removeNote() ������ ���������� ����� ������ remove � notes.
9. ��� ������� ������ �� ����� �� ������ ���������� � ����� synchronized.*/

public class Solution {

    public static void main(String[] args) {
        Note note = new Note();
        note.addNote(0, "������");
        note.removeNote(0);
    }

    public static class Note {

        public final List<String> notes = new ArrayList<String>();

        public void addNote(int index, String note) {
            System.out.println("������ ����� ��������� ������� [" + note + "] �� ������� " + index);
            synchronized (notes) {
                notes.add(index, note);
            }
            System.out.println("��� ��������� ������� [" + note + "]");
        }

        public void removeNote(int index) {
            System.out.println("������ ����� ������� ������� � ������� " + index);
            String note;
            synchronized (notes) {
                note = notes.remove(index);
            }
            System.out.println("��� ������� ������� [" + note + "] � ������� " + index);
        }
    }

}
