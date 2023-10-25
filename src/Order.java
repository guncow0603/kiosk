
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Order {
    boolean finished = false;
    private ArrayList<Products> basket;//장바구니 어레이 리스트생성 Product 리스트 형식으로 사용할 basket 생성
    private int orderNumber;//대기번호
    private String requirements; // 요청사항
    String orderTime; // 주문 시각
    String finishedTime; // 주문 완료 시각
    ArrayList<Order> orderList = new ArrayList<>();    // 주문서 리스트(관리자가 볼 것)

    Scanner sc = new Scanner(System.in);
    public Order() {
        basket = new ArrayList<>(); // 장바구니 어레이리스트 생성
        orderNumber = 0; // 초기 주문넘버
    }
    public Order(int orderNumber, ArrayList<Products> basket, String requirements, String orderTime) {
        this.orderNumber = orderNumber;
        this.basket = basket;
        this.requirements = requirements;
        this.orderTime = orderTime;
    }


    public ArrayList<Products> getBasket() {
        return basket;
    }
    // Product 리스트 형식으로 basket 리턴
    public int getOrderNumber() { return orderNumber;    }
    //orderNumber를 리턴해준다

    public void setOrderNumber(int orderNumber) {
        this.orderNumber = orderNumber;
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
    public static String setDate() {
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy/MM/dd h:mm:ss");
        return dateTimeFormatter.format(LocalDateTime.now());
    }
    public void takeOrder(){//주문

        System.out.println("아래와 같이 주문 하시겠습니까?");
        System.out.println();
        System.out.println("[ Orders ]");
        for (int i = 0; i <getBasket().size(); i++) {//바구니 사이즈만큼 순서대로 출력
            Products menu = getBasket().get(i);
            System.out.println((i + 1) + ". " + menu.getName() + "   | " + menu.getPrice() + " | " + menu.getDescription());
        }
        System.out.println();
        System.out.println("[ Total ]");
        System.out.println("W "+totalPrice());
        System.out.println();
        System.out.println("1. 주문     2. 메뉴판");
        int orderCheck = sc.nextInt();
        sc.nextLine();
        System.out.println("--------------------------------------------------------");
        if (orderCheck == 1) {
            System.out.println("주문 시 요청사항을 입력하시겠습니까?");
            System.out.println("\n1. 네      2. 아니요");
            int checkNum = sc.nextInt();
            sc.nextLine();
            System.out.println("--------------------------------------------------------");
            // 요청 사항 입력
            if (checkNum == 1) {
                System.out.println("요청사항을 입력해주세요 (최대 20자):");
                String getRequirements = sc.nextLine();
                System.out.println("--------------------------------------------------------");
                if (getRequirements.length() <= 20) {
                    System.out.println("요청사항이 정상적으로 전달되었습니다. 감사합니다.");
                    setRequirements(getRequirements); // 요구사항 입력
                } else {
                    while(true) {
                        System.out.println("죄송합니다. 총 20글자 내외로 작성해주시기 바랍니다.");
                        getRequirements = sc.nextLine();
                        setRequirements(getRequirements);//요구사항 입력
                        if(getRequirements.length() <= 20){
                            break;
                        }
                    }
                }
            } else {//요구 사항이 없을경우
                    setRequirements("");//""요구사항 입력
            }



            orderComplete(basket); //OrderComplete()메서드를 불러온다
        } else if (orderCheck == 2) {
            System.out.println("메뉴판으로 돌아갑니다."); // 메뉴판으로 돌아간다.
        }


    }
    public void orderComplete(ArrayList<Products> basket) { // 주문완료, 대기번호 출력
        ArrayList<Products> Arraylist = new ArrayList<>(basket);
        String requirements = getRequirements();
        setOrderNumber(orderNumber+1);//대기번호 1증가

        orderList.add(new Order(orderNumber, Arraylist, requirements, setDate()));


        System.out.println("주문이 완료되었습니다!");
        System.out.println();

        System.out.println("대기번호는 [ " + orderNumber + " ] 번 입니다."); // 대기번호 출력
        System.out.println("(3초 후 메뉴판으로 돌아갑니다.)");

        ClearBasket(); // 바구니를 초기화


        try { // 3초간 지연
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            System.out.println(e);
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

    public String getRequirements() {
        return requirements;
    }

    public void setRequirements(String requirements) {
        this.requirements = requirements;
    }
}