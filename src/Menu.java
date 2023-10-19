import java.util.ArrayList;
import java.util.Scanner;

public class Menu {

    ArrayList<Products> burger = new ArrayList<>();//  버거 리스트 생성
    ArrayList<Products> frozenCustard = new ArrayList<>(); // 아이스크림 리스트 생성
    ArrayList<Products> drink = new ArrayList<>(); // 음료 리스트 생성
    ArrayList<Products> beer = new ArrayList<>(); // 맥주 리스트 생성


    Scanner sc = new Scanner(System.in);
    public Menu() { // 각각의 리스트에 이름, 가격, 설명 추가
        burger.add(new Products("ShackBurger", 6.9, "토마토, 양상추, 쉑소스가 토핑된 치즈버거"));
        burger.add(new Products("SmokeShack", 8.9, "베이컨, 체리 페퍼에 쉑소스가 토핑된 치즈버거"));
        burger.add(new Products("Shroom Burger", 9.4, "몬스터 치즈와 체다 치즈로 속을 채운 베지테리안 버거"));

        frozenCustard.add(new Products("Shake of the Week", 6.5, "특별한 커스터드 플레이버"));
        frozenCustard.add(new Products("Red Bean Shake", 6.5, "신선한 커스터드와 함께 우유와 레드빈이 플레이된 시즈널 쉐이크"));
        frozenCustard.add(new Products("Floats", 5.9, "루트 비어, 퍼플 카우, 크림시클"));

        drink.add(new Products("Fresh Brewed Iced Tea", 3.4, "직접 유기농 홍차를 우려낸 아이스티"));
        drink.add(new Products("Fifty/Fifty", 3.5, "레몬에이드와 아이스티의 만남"));
        drink.add(new Products("Fountain Soda", 2.7, "코카콜라, 코카콜라 제로, 스프라이트, 환타 오렌지, 환타 그레이프"));

        beer.add(new Products("ShackMeister Ale", 9.8, "쉐이크쉑 버거를 위해 뉴욕 브루클린 브루어리에서 특별히 양조한 에일 맥주"));
        beer.add(new Products("Magpie Brewing Co.", 6.8, "Pale Ale, Draft"));
        beer.add(new Products("The Hand and Malt", 6.8, "IPA, Can"));

    }


    public void showBurger() { // 버거
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

        }
        else{
            System.out.println("잘못된 입력 입니다.");
        }


    }


    public void showFrozenCustard() { //아이스크림
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
            System.out.println("\n" + "\"" + select.getName() + "      | W" + select.getPrice()
                    + " | " + select.getDescription() + "\""+"\n");

        }
        else{
            System.out.println("잘못된 입력 입니다.");
        }

    }
    public void showDrink() { // 드링크
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

        }
        else{
            System.out.println("잘못된 입력 입니다.");
        }


    }
    public void showBeer() { // 맥주
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
        }
        else{
            System.out.println("잘못된 입력 입니다.");
        }

    }



}