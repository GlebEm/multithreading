package task1709;

/* 
�����������
�� ��������� synchronized ������ ���, ����� ���������� ��������� � �������� ����������� ���� ����������.


Requirements:
1. ����� Solution ������ ��������� ���� MakeProposal.
2. ����� Solution ������ ��������� ���� AcceptProposal.
3. ����� Solution ������ ��������� ��������� ����������� ���������� int proposal.
4. ��������� �� ������ ��������� synchronized ������� ��� synchronized ������.
5. ���������� int proposal �� ������ ��������� � ��������� ����.
*/

public class Solution {
   volatile public static int proposal = 0;

    public static void main(String[] args) throws InterruptedException {
        new MakeProposal().start();
        new AcceptProposal().start();
    }

    public static class MakeProposal extends Thread {
        @Override
        public void run() {
            int thisProposal = proposal;

            while (proposal < 10) {
                System.out.println("������� ����������� �" + (thisProposal + 1));
                proposal = ++thisProposal;
                try {
                    Thread.sleep(200);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }


            }
        }
    }

    public static class AcceptProposal extends Thread {
        @Override
        public void run() {
            int thisProposal = proposal;

            while (thisProposal < 10) {
                if (thisProposal != proposal) {
                    System.out.println("������� ����������� �" + proposal);
                    thisProposal = proposal;
                }

            }
        }
    }
}
