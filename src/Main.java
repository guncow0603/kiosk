import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Admin admin = new Admin();
        while (true) {
            System.out.println("========================================================");
            System.out.println("\"SHAKESHACK BURGER에 오신걸 환영합니다.\"");
            System.out.println("아래 메뉴판을 보시고 메뉴를 골라 입력해주세요.");
            System.out.println();
            System.out.println("[ SHAKESHACK MENU ]");
            System.out.println("1. Burgers         | 앵거스 비프 통살을 다져 만든 버거");
            System.out.println("2. Forzen Custard  | 매장에서 신선하게 만드는 아이스크림");
            System.out.println("3. Drinks          | 매장에서 직접 만드는 음료");
            System.out.println("4. Beer            | 뉴욕 브루클린 브루어리에서 양조한 맥주");
            System.out.println();
            System.out.println("[ ORDER MENU ]");
            System.out.println("5. Order       | 장바구니를 확인 후 주문 합니다.");
            System.out.println("6. Cancel      | 진행중인 주문을 취소 합니다.");
            System.out.println();
            System.out.println("0.관리자 메뉴로 이동.       ");
            System.out.println();
            System.out.print("메뉴선택 : ");
            int choice = sc.nextInt();
            sc.nextLine();
            System.out.println("========================================================");
            switch (choice) {
                case 0:
                    admin.adminMode();
                    break;
                case 1:
                    admin.showBurger();
                    break;
                case 2:
                    admin.showFrozenCustard();
                    break;
                case 3:
                    admin.showDrink();
                    break;
                case 4:
                    admin.showBeer();
                    break;
                case 5:
                    admin.takeOrder();
                    break;
                case 6:
                    admin.Cancel();
                    break;
                default:
                    System.out.println("잘못된 입력 입니다.");
                    break;
            }
        }
    }
}
