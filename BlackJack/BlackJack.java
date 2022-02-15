package Github;

import java.util.Arrays;
import java.util.Scanner;

public class BlackJack {
    public static void main(String[] args) {
        BlackJack_rule rule = new BlackJack_rule();
        int[] dealer = rule.dealer();
        int dealer_int = Arrays.stream(dealer).sum();
        int player = rule.player();

        // �÷��̾� ī�� ���
        System.out.println(player);
        // �й� �� ����
        if (dealer_int > 21) {
            System.out.println("[���� �й�]");
        } else if (player > 21) {
            System.out.println("[�÷��̾� �й�]");
        }
        // hit & stop ����
        while (true) {
            Scanner sc = new Scanner(System.in);
            System.out.println("Hit = 1, Stop = 2 Ű�� �����ֽʽÿ�");
            String qus = sc.next();
            if (qus.equals("1")) {
                int card = (int) (Math.random() * 12) + 1;
                System.out.println("ī�� : " + card);
                player += card;
                System.out.println("�÷��̾� : " + player);
            } else if (qus.equals("2")) {
                break;
            } else {
                System.out.println("�߸��� �Է��Դϴ�.");
            }
        }


        System.out.println("[���� ī��]");
        System.out.println(dealer[0] + ", " + dealer[1]);
        System.out.println("���� ī�� �� �հ�");
        System.out.println(dealer_int);
        while (true) {
            if (dealer_int < 17) {
                int card = (int) (Math.random() * 12) + 1;
                System.out.println("���� Hit! : " + card);
                dealer_int += card;
                System.out.println("���� ī�� �� �հ�");
                System.out.println(dealer_int);

            } else {
                System.out.println("���� Stop!");
                break;
            }

        }
        if (player > 21) {
            System.out.println("�÷��̾� �й�!");

        }
        else if (dealer_int > 21){
            System.out.println("���� �й�!");
        }
        else if (dealer_int > player) {
            System.out.println("���� ��!");
        } else if (dealer_int < player) {
            System.out.println("�÷��̾� ��!");
        }
        else if (dealer_int == player){
            System.out.println("���º�!");
        }
        else {
            System.out.println("���� �߻�");
        }
    }

}


class BlackJack_rule {
    int[] dealer() {
        int[] temp = new int[2];
        int cnt = 0;
        System.out.println("[���� ī��]");
        for (int i = 0; i < temp.length; i++) {
            int firstCard = (int) (Math.random() * 12) + 1;
            temp[i] = firstCard;
        }
        System.out.println(temp[0]+", ?");
//        int secondCard = (int) (Math.random() * 12) + 1;
//        temp[1] = secondCard;
        return temp;
    }


    int player() {
        int temp = 0;
        int cnt = 0;
        System.out.println("[�÷��̾� ī��]");
        int firstCard = (int) (Math.random() * 12) + 1;
        int secondCard = (int) (Math.random() * 12) + 1;
        System.out.println(firstCard + ", " + secondCard);
        temp = firstCard + secondCard;
        return temp;
    }
}
