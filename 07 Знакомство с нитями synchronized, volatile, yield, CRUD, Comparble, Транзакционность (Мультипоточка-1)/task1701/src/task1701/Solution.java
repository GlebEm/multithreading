package task1701;

import java.util.ArrayList;
import java.util.List;

/* 
�������
������������� ���������� �����.
1. ����� Note ����� �������������� ������.
2. ������ public static ���� NoteThread (Runnable �� �������� �����), ������� � ������ run 1000 ��� (index = 0-999) ������� ��������� ��������:
2.1. ��������� ����� addNote ������� ������� � ������ [getName() + "-Note" + index], ��������, ��� index=4
"Thread-0-Note4"
2.2. ������ �� 1 ������������
2.3. ��������� ����� removeNote ������ �������
2.4. � �������� ��������� � removeNote ������� ��� ���� - ����� getName()


Requirements:
1. ����� Solution ������ ��������� public static ����� NoteThread.
2. ����� NoteThread ������ ���� �����.
3. � ������ run ������ NoteThread ������ ���� ����.
4. ����� run ������ NoteThread ������ 1000 ��� �������� ����� addNote c ���������� (getName() + "-Note" + index).
5. ����� run ������ NoteThread ������ 1000 ��� �������� Thread.sleep() c ���������� (1).
6. ����� run ������ NoteThread ������ 1000 ��� �������� ����� removeNote c ���������� (getName()).
*/

public class Solution {
    public static class NoteThread extends Thread{
        public void run(){
            for (int i =0; i<1000;i++){
            Note.addNote(getName() + "-Note" + i);
                try {
                    Thread.sleep(1);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                Note.removeNote(getName());
            }
        }

    }
    public static void main(String[] args) {
        new NoteThread().start();
        new NoteThread().start();
    }

    public static class Note {

        public static final List<String> notes = new ArrayList<>();

        public static void addNote(String note) {
            notes.add(0, note);
        }

        public static void removeNote(String threadName) {
            String note = notes.remove(0);
            if (note == null) {
                System.out.println("������ ���� ������� ���� �������");
            } else if (!note.startsWith(threadName)) {
                System.out.println("���� [" + threadName + "] ������� ����� ������� [" + note + "]");
            } else {
                System.out.println("���� [" + threadName + "] ������� ���� ������� [" + note + "]");
            }
        }
    }
}
