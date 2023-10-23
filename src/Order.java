import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Scanner;

public class Order {
    private ArrayList<Products> basket;//Product 리스트 형식으로 사용할 basket 생성
    private int orderNumber;//대기번호
    Scanner sc = new Scanner(System.in);
    public Order() {
        basket = new ArrayList<>();//장바구니 어레이 리스트생성
        orderNumber = 1;//초기값
    }


    public ArrayList<Products> getbasket() {
        return basket;
    }
    // Product 리스트 형식으로 basket 리턴
    public int getOrderNumber() { return orderNumber;    }
    //orderNumber를 리턴해준다

    public void PlusOrderNumber(int orderNumber) {
        this.orderNumber = orderNumber+1;
    }
    //orderNumber에 +1을 해준다.
    public void addBasket(Products menu) {
        basket.add(menu);
    }
    //Products형식의 menu를 basket에 더해줌

    public void ClearBasket() {
        basket.clear();
    }
    //basket 초기화

    public double totalPrice() {//총가격
        double total = 0.0;//초기값
        for (Products menu : basket) {//basket 리스트에 담긴만큼 Products menu에 대입해줌
            total += menu.getPrice();//menu에서 가격만 추출해서 더해줌.

        }
        return total;//총값을 리턴해줌
    }

    public void addOrder(Products add){//바구니에 메뉴추가
        System.out.println("위 메뉴를 장바구니에 추가하시겠습니까?");
        System.out.println("1. 확인       2. 취소");

        int check = sc.nextInt();
        sc.nextLine();

        if (check == 1) {
            addBasket(add);
            System.out.println(add.getName() + " 가 장바구니에 추가되었습니다.");
            System.out.println();
        } else if (check == 2) {
            System.out.println("장바구니 추가가 취소되었습니다.");
            System.out.println();
        } else System.out.println("숫자를 잘못 입력하였습니다.");
    }

    public void orderComplete(){//주문

        System.out.println("아래와 같이 주문 하시겠습니까?");
        System.out.println();
        System.out.println("[ Orders ]");
        for (int i = 0; i <getbasket().size(); i++) {//바구니 사이즈만큼 순서대로 출력
            Products menu = getbasket().get(i);
            System.out.println((i + 1) + ". " + menu.getName() + "   | " + menu.getPrice() + " | " + menu.getDescription());
        }
        System.out.println();
        System.out.println("[ Total ]");
        System.out.println("W "+totalPrice());
        System.out.println();
        System.out.println("1. 주문     2. 메뉴판");
        int orderCheck = sc.nextInt();
        sc.nextLine();

        if(orderCheck==1){
            int orderNumber = getOrderNumber();

            System.out.println("주문이 완료되었습니다!");
            System.out.println();
            System.out.println("대기번호는 [ " + orderNumber + " ] 번 입니다."); // 대기번호 출력
            System.out.println("(3초 후 메뉴판으로 돌아갑니다.)");
            System.out.println();

            ClearBasket();
            PlusOrderNumber(orderNumber);
            try {
                Thread.sleep(3000);//millis 3000= 3초
            } catch (InterruptedException e) {// InterruptedException 예외상황 발생시
                System.out.println(e); // 경고문
            }
        }
        else {
            System.out.println("메뉴판으로 돌아갑니다");
        }


    }

    public void Cancel(){//주문
        System.out.println();
        System.out.println("진행하던 주문을 취소하시겠습니까?");
        System.out.println("1. 확인       2. 취소       ");

        int cancelNum = sc.nextInt();
        sc.nextLine();


        if (cancelNum == 1) {
            ClearBasket();
            System.out.println("진행하던 주문이 취소되었습니다.");
            System.out.println();
        } else if (cancelNum == 2) {
            System.out.println("메뉴판으로 돌아갑니다.");

        }
    }
}