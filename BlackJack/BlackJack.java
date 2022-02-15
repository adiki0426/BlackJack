package Github;

import java.util.Arrays;
import java.util.Scanner;

public class BlackJack {
    public static void main(String[] args) {
        BlackJack_rule rule = new BlackJack_rule();
        int[] dealer = rule.dealer();
        int dealer_int = Arrays.stream(dealer).sum();
        int player = rule.player();

        // 플레이어 카드 출력
        System.out.println(player);
        // 패배 룰 적용
        if (dealer_int > 21) {
            System.out.println("[딜러 패배]");
        } else if (player > 21) {
            System.out.println("[플레이어 패배]");
        }
        // hit & stop 적용
        while (true) {
            Scanner sc = new Scanner(System.in);
            System.out.println("Hit = 1, Stop = 2 키를 눌러주십시오");
            String qus = sc.next();
            if (qus.equals("1")) {
                int card = (int) (Math.random() * 12) + 1;
                System.out.println("카드 : " + card);
                player += card;
                System.out.println("플레이어 : " + player);
            } else if (qus.equals("2")) {
                break;
            } else {
                System.out.println("잘못된 입력입니다.");
            }
        }


        System.out.println("[딜러 카드]");
        System.out.println(dealer[0] + ", " + dealer[1]);
        System.out.println("딜러 카드 총 합계");
        System.out.println(dealer_int);
        while (true) {
            if (dealer_int < 17) {
                int card = (int) (Math.random() * 12) + 1;
                System.out.println("딜러 Hit! : " + card);
                dealer_int += card;
                System.out.println("딜러 카드 총 합계");
                System.out.println(dealer_int);

            } else {
                System.out.println("딜러 Stop!");
                break;
            }

        }
        if (player > 21) {
            System.out.println("플레이어 패배!");

        }
        else if (dealer_int > 21){
            System.out.println("딜러 패배!");
        }
        else if (dealer_int > player) {
            System.out.println("딜러 승!");
        } else if (dealer_int < player) {
            System.out.println("플레이어 승!");
        }
        else if (dealer_int == player){
            System.out.println("무승부!");
        }
        else {
            System.out.println("오류 발생");
        }
    }

}


class BlackJack_rule {
    int[] dealer() {
        int[] temp = new int[2];
        int cnt = 0;
        System.out.println("[딜러 카드]");
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
        System.out.println("[플레이어 카드]");
        int firstCard = (int) (Math.random() * 12) + 1;
        int secondCard = (int) (Math.random() * 12) + 1;
        System.out.println(firstCard + ", " + secondCard);
        temp = firstCard + secondCard;
        return temp;
    }
}
