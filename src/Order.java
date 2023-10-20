import java.lang.reflect.Array;
import java.util.ArrayList;

public class Order {
    private ArrayList<Products> basket;
    private int orderNumber;

    public Order() {
        basket = new ArrayList<>();
        orderNumber = 1;
    }


    public ArrayList<Products> getbasket() {
        return basket;
    }

    public int getOrderNumber() {
        return orderNumber;
    }

    public void PlusOrderNumber(int orderNumber) {
        this.orderNumber = orderNumber+1;
    }

    public void addBasket(Products menu) {
        basket.add(menu);
    }


    public void ClearBasket() {
        basket.clear();
    }


    public double totalPrice() {
        double total = 0.0;
        for (Products menu : basket) {
            total += menu.getPrice();

        }
        return total;
    }
}