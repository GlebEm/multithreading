package task1709;

/* 
Предложения
Не используя synchronized сделай так, чтобы количество сделанных и принятых предложений было одинаковым.


Requirements:
1. Класс Solution должен содержать нить MakeProposal.
2. Класс Solution должен содержать нить AcceptProposal.
3. Класс Solution должен содержать публичную статическую переменную int proposal.
4. Программа не должна содержать synchronized методов или synchronized блоков.
5. Переменная int proposal не должна находится в локальном кэше.
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
                System.out.println("Сделано предложение №" + (thisProposal + 1));
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
                    System.out.println("Принято предложение №" + proposal);
                    thisProposal = proposal;
                }

            }
        }
    }
}
