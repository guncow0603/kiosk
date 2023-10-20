import java.util.ArrayList;
import java.util.Scanner;

public class Menu {

    ArrayList<Products> burger = new ArrayList<>();
    ArrayList<Products> frozenCustard = new ArrayList<>();
    ArrayList<Products> drink = new ArrayList<>();
    ArrayList<Products> beer = new ArrayList<>();

    Order order = new Order();
    Scanner sc = new Scanner(System.in);
    public Menu() { // 각각의 리스트에 이름, 가격, 설명 추가
        burger.add(new Products("ShackBurger", 6.9, "토마토, 양상추, 쉑소스가 토핑된 치즈버거"));
        burger.add(new Products("SmokeShack", 8.9, "베이컨, 체리 페퍼에 쉑소스가 토핑된 치즈버거"));
        burger.add(new Products("Shroom Burger", 9.4, "몬스터 치즈와 체다 치즈로 속을 채운 베지테리안 버거"));
        burger.add(new Products("Cheeseburger  ", 6.9, "포테이토 번과 비프패티, 치즈가 토핑된 치즈버거"));
        burger.add(new Products("Hamburger", 5.4, "비프패티를 기반으로 야채가 들어간 기본버거"));

        frozenCustard.add(new Products("Shake", 5.9, "바닐라, 초콜릿, 솔티드, 카라멜, 블랙&화이트, 스트로베리, 피넛버터, 커피"));
        frozenCustard.add(new Products("Shake of the Week", 6.5, "특별한 커스터드 플레이버"));
        frozenCustard.add(new Products("Red Bean Shake", 6.5, "신선한 커스터드와 함께 우유와 레드빈이 플레이된 시즈널 쉐이크"));
        frozenCustard.add(new Products("Floats", 5.9, "루트 비어, 퍼플 카우, 크림시클"));

        drink.add(new Products("Shake-mode Lemonade", 3.9, "매장에서 직접 만드는 상큼한 레몬에이드"));
        drink.add(new Products("Fresh Brewed Iced Tea", 3.4, "직접 유기농 홍차를 우려낸 아이스티"));
        drink.add(new Products("Fifty/Fifty", 3.5, "레몬에이드와 아이스티의 만남"));
        drink.add(new Products("Fountain Soda", 2.7, "코카콜라, 코카콜라 제로, 스프라이트, 환타 오렌지, 환타 그레이프"));

        beer.add(new Products("ShackMeister Ale", 9.8, "쉐이크쉑 버거를 위해 뉴욕 브루클린 브루어리에서 특별히 양조한 에일 맥주"));
        beer.add(new Products("Magpie Brewing Co.", 6.8, "Pale Ale, Draft"));

    }


    public void showBurger() {
        System.out.println();
        System.out.println("[ Burgers Menu ]");
        for (int i = 0; i < burger.size(); i++) {
            Products menu = burger.get(i);
            System.out.println((i + 1) + ". " + menu.getName() + "   | " + menu.getPrice() + " | " + menu.getDescription());
        }

        System.out.print("상품선택 : ");
        int burgerChoice = sc.nextInt();
        if(burgerChoice<=burger.size()) {


            Products select = burger.get(burgerChoice-1);
            System.out.println("\n" + "\"" + select.getName() + "      | W" + select.getPrice()
                    + " | " + select.getDescription() + "\""+"\n");
            addOrder(select);
        }
        else{
            System.out.println("잘못된 입력 입니다.");
        }


    }


    public void showFrozenCustard() {
        System.out.println();
        System.out.println("[ FrozenCustards Menu ]");
        for (int i = 0; i < frozenCustard.size(); i++) {
            Products menu = frozenCustard.get(i);
            System.out.println((i + 1) + ". " + menu.getName() + "   | " + menu.getPrice() + " | " + menu.getDescription());
        }

        System.out.print("상품선택 : ");
        int frozenCustardChoice = sc.nextInt();
        if(frozenCustardChoice<=frozenCustard.size()) {


            Products select = frozenCustard.get(frozenCustardChoice-1);
            System.out.println();
            System.out.println("\"" + select.getName() + "      | W" + select.getPrice()
                    + " | " + select.getDescription() + "\"");
            System.out.println();
            addOrder(select);
        }
        else{
            System.out.println("잘못된 입력 입니다.");
        }

    }
    public void showDrink() {
        System.out.println();
        System.out.println("[ Drinks Menu ]");
        for (int i = 0; i < drink.size(); i++) {
            Products menu = drink.get(i);
            System.out.println((i + 1) + ". " + menu.getName() + "   | " + menu.getPrice() + " | " + menu.getDescription());
        }

        System.out.print("상품선택 : ");
        int drinkChoice = sc.nextInt();
        if(drinkChoice<=drink.size()) {


            Products select = drink.get(drinkChoice-1);
            System.out.println("\n" + "\"" + select.getName() + "      | W" + select.getPrice()
                    + " | " + select.getDescription() + "\""+"\n");
            addOrder(select);
        }
        else{
            System.out.println("잘못된 입력 입니다.");
        }


    }
    public void showBeer() {
        System.out.println();
        System.out.println("[ Beers Menu ]");
        for (int i = 0; i < beer.size(); i++) {
            Products menu = beer.get(i);
            System.out.println((i + 1) + ". " + menu.getName() + "   | " + menu.getPrice() + " | " + menu.getDescription());
        }


        System.out.print("상품선택 : ");

        int beerChoice = sc.nextInt();
        if(beerChoice<=beer.size()) {

            Products select = beer.get(beerChoice - 1);
            System.out.println("\n" + "\"" + select.getName() + "      | W" + select.getPrice()
                    + " | " + select.getDescription() + "\""+"\n");
            addOrder(select);
        }
        else{
            System.out.println("잘못된 입력 입니다.");
        }

    }

    public void addOrder(Products add){
        System.out.println("위 메뉴를 장바구니에 추가하시겠습니까?");
        System.out.println("1. 확인       2. 취소");

        int check = sc.nextInt();
        sc.nextLine();

        if (check == 1) {
            order.addBasket(add);
            System.out.println(add.getName() + " 가 장바구니에 추가되었습니다.");
            System.out.println();
        } else if (check == 2) {
            System.out.println("장바구니 추가가 취소되었습니다.");
            System.out.println();
        } else System.out.println("숫자를 잘못 입력하였습니다.");
    }

    public void orderComplete(){

        System.out.println("아래와 같이 주문 하시겠습니까?");
        System.out.println();
        System.out.println("[ Orders ]");
        for (int i = 0; i < order.getbasket().size(); i++) {
            Products menu = order.getbasket().get(i);
            System.out.println((i + 1) + ". " + menu.getName() + "   | " + menu.getPrice() + " | " + menu.getDescription());
        }
        System.out.println();
        System.out.println("[ Total ]");
        System.out.println("W "+order.totalPrice());
        System.out.println();
        System.out.println("1. 주문     2. 메뉴판");
        int orderCheck = sc.nextInt();

        if(orderCheck==1){
            int orderNumber = order.getOrderNumber();

            System.out.println("주문이 완료되었습니다!");
            System.out.println();
            System.out.println("대기번호는 [ " + orderNumber + " ] 번 입니다."); // 대기번호 출력
            System.out.println("(3초 후 메뉴판으로 돌아갑니다.)");
            System.out.println();

            order.ClearBasket();
            order.PlusOrderNumber(orderNumber);
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                System.out.println(e);
            }
        }
        else {
            System.out.println("메뉴판으로 돌아갑니다");
        }


    }

    public void Cancel(){
        System.out.println();
        System.out.println("진행하던 주문을 취소하시겠습니까?");
        System.out.println("1. 확인       2. 취소       ");

        int cancelNum = sc.nextInt();
        sc.nextLine();


        if (cancelNum == 1) {
            order.ClearBasket();
            System.out.println("진행하던 주문이 취소되었습니다.");
            System.out.println();
        } else if (cancelNum == 2) {
            System.out.println("메뉴판으로 돌아갑니다.");

        }
    }

}