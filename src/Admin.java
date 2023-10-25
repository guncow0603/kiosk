
import java.util.ArrayList;
import java.util.Scanner;

public class Admin extends Menu{
    Scanner sc = new Scanner(System.in);

    ArrayList<Products> finishedOrders = new ArrayList<>(); // 완료된주문 저장
    ArrayList<Products> waitingOrders = new ArrayList<>(); // 대기중인주문을 저장
    public void adminMode() {

            while (true) {
                System.out.println();
                System.out.println("1. 대기주문 목록 \n2. 완료주문 목록 \n3. 상품 생성 \n4. 상품 삭제 \n0.메뉴판으로 돌아가기");
                System.out.println("사용하실 메뉴를 선택하세요.");
                int adminNum = sc.nextInt();
                sc.nextLine();
                if(adminNum==0){
                    break;
                }
                switch (adminNum) {
                    case 1:
                        waitOrder(); // 대기주문
                        break;
                    case 2:
                        finishedOrder(); // 완료주문관리
                        break;
                    case 3:
                        createFood(); // 상품생성
                        break;
                    case 4:
                        deleteFood(); // 상품삭제
                        break;
                    default:
                        System.out.println("1~4번의 숫자만 입력 가능합니다.");
                        break;
                }
            }
    }

    public void createFood() { // 상품생성
        System.out.println("추가할 상품의 메뉴를 선택하세요.");
        System.out.print("1. 버거    2. 아이스크림    3. 음료    4. 맥주 : ");
        int categoryNum = sc.nextInt();
        sc.nextLine();

        switch (categoryNum) {
            case 1: // 버거선택
                System.out.println("버거 메뉴생성을 선택하셨습니다.");
                burger.addAll(createMenu());
                break;

            case 2: // 아이스크림 메뉴
                System.out.println("아이스크림 메뉴생성을 선택하셨습니다.");
                frozenCustard.addAll(createMenu());
                break;

            case 3: // 음료 메뉴
                System.out.println("음료 메뉴생성을 선택하셨습니다.");
                drink.addAll(createMenu());
                break;

            case 4: // 맥주 메뉴
                System.out.println("맥주 메뉴생성을 선택하셨습니다.");
                beer.addAll(createMenu());
                break;
            default:
                System.out.println("1~4번의 숫자만 입력 가능합니다.");
        }
    }




    public ArrayList<Products> createMenu() {
        ArrayList<Products> Rlist= new ArrayList<>();
        Scanner sc=new Scanner(System.in);
        System.out.print("상품이름을 입력하세요 : ");
        String Name = sc.nextLine();


        System.out.print("상품가격을 입력하세요 (단위 : W x.x) : ");
        double Price = sc.nextDouble();
        sc.nextLine();

        System.out.print("설명을 입력하세요 : ");
        String Description = sc.nextLine();


        System.out.println("\n이름 : " + Name + "  가격 : " + Price + "  설명 : " + Description);
        System.out.println("위와 같은 메뉴를 추가하시겠습니까?");
        System.out.println("1. 확인       2. 취소       ");
        int checkNum = sc.nextInt();
        sc.nextLine();

        if (checkNum == 1) {
            System.out.println("메뉴추가를 완료 하였습니다. \n");
            Rlist.add(new Products(Name, Price, Description));
        } else if (checkNum == 2) {
            System.out.println("메뉴추가를 취소 하셨습니다. \n");
        } else {
            System.out.println("번호를 잘못 입력 하셨습니다.\n");
        }
        return Rlist;
    }


    public void deleteFood() { // 상품삭제
        System.out.println("삭제할 상품의 메뉴를 선택하세요");
        System.out.print("1. 버거    2. 아이스크림    3. 음료    4. 맥주 : ");
        int choiceNum = sc.nextInt();
        sc.nextLine();

        switch (choiceNum) {
            case 1: // 버거 선택
                System.out.println("\n버거 메뉴 삭제를 선택하셨습니다.\n");
                deleteMenu(burger);
                break;

            case 2: // 아이스크림 선택
                System.out.println("\n아이스크림 메뉴 삭제를 선택하셨습니다.\n");
                deleteMenu(frozenCustard);
                break;

            case 3: // 음료 선택
                System.out.println("\n음료 메뉴 삭제를 선택하셨습니다.\n");
                deleteMenu(drink);
                break;

            case 4: // 맥주 선택
                System.out.println("\n맥주 메뉴 삭제를 선택하셨습니다.\n");
                deleteMenu(beer);
                break;

            default:
                System.out.println("1~4번의 숫자만 입력 가능합니다.");
        }
    }

    public void deleteMenu(ArrayList<Products>Ilist) {


        for (int i = 0; i < Ilist.size(); i++) {
            Products menu = Ilist.get(i);
            System.out.println((i + 1) + ". " + menu.getName() + "   | " + menu.getPrice() + " | " + menu.getDescription());
        }

        System.out.print("\n삭제할 메뉴의 이름을 입력하세요 : ");
        String Name = sc.nextLine();

        boolean existence = false;
        for (int i = 0; i < Ilist.size(); i++) {
            Products list = Ilist.get(i);
            if (list.getName().equals(Name)) {
                System.out.print(list.getName() + " 를 메뉴에서 삭제시키겠습니까? (1. 삭제        2. 취소) : ");
                int Check = sc.nextInt();
                sc.nextLine();
                if (Check == 1) {
                    Ilist.remove(i);
                    existence = true;
                    break;

                } else if (Check == 2) {
                    System.out.println("삭제를 취소합니다.");
                    System.out.println();
                }
            }
        }
        if (existence) {
            System.out.println(Name + " 이 메뉴에서 삭제되었습니다.");
            System.out.println();

        } else if (!existence) {
            System.out.println("존재하지 않는 메뉴이름을 입력하였습니다.");
            System.out.println();
        }
    }

    public void printListData(ArrayList<Products> list) {
        System.out.println(" 주문 상품 목록 ");
        for (Products m : list) {
            System.out.println(m.getName() + "   | " + m.getPrice() + " | " + m.getDescription());
        }
        System.out.println();
    }

    public void waitOrder() {

        System.out.println("대기주문관리를 선택하셨습니다.");
        System.out.println("대기중인 주문입니다.\n");

        for (Order o : orderList) {
            if (!o.finished) {
                System.out.println("=============================================");
                System.out.println(" 주문 번호 : " + o.getOrderNumber());
                printListData(o.getBasket());
                System.out.println(" total : W " + o.totalPrice());
                System.out.println(" 요청사항 : " + o.getRequirements());
                System.out.println(" 주문 일시 : " + o.orderTime);
            }

        }
        System.out.println("\n수행할 기능을 입력하세요 (1. 주문완료처리       2. 관리자 메뉴로 돌아가기) ");
        int check = sc.nextInt();
        sc.nextLine();

        if (check == 1) {
            System.out.println("완료처리 할 주문 번호를 입력해주세요. : ");
            int orderNum = sc.nextInt();

            for (Order o : orderList) {
                if (o.getOrderNumber() == orderNum) {
                    if (!o.finished) {
                        o.finished = true;
                        o.finishedTime = setDate();

                        for (int i = 0; i < waitingOrders.size(); i++) {
                            Products waits = waitingOrders.get(i);
                            finishedOrders.add(waits);
                        }

                        waitingOrders.clear();
                        System.out.println(o.getOrderNumber() + "번 주문을 완료했습니다.");
                        break;
                    }
                }
            }

        }

    }

    public void finishedOrder() { // 완료주문관리 메서드
        System.out.println("완료주문관리를 선택하셨습니다.");
        System.out.println("완료된 주문입니다.\n");

        for (Order o : orderList) {
            if (o.finished) {
                System.out.println("=============================================");
                System.out.println(" 주문 번호 : " + o.getOrderNumber());
                printListData(o.getBasket());
                System.out.println(" total : W " + o.totalPrice());
                System.out.println(" 요청사항 : " + o.getRequirements());
                System.out.println(" 주문 일시 : " + o.orderTime);
                System.out.println(" 완료 일시 : " + o.finishedTime);
            }
        }

        System.out.println("\n수행할 기능을 입력하세요 (1. 완료처리내역 삭제       2. 관리자 메뉴로 돌아가기)  ");
        int check = sc.nextInt();
        sc.nextLine();

        if (check == 1) {
            System.out.println("완료 내역에서 삭제 할 주문 번호를 입력하세요. : ");
            int orderNum = sc.nextInt();

            for (Order o : orderList) {
                if (o.getOrderNumber() == orderNum) {
                    orderList.remove(o);
                    System.out.println(o.getOrderNumber() + " 번 완료 내역이 삭제되었습니다. ");
                    break;
                }
            }
        }

    }
}
