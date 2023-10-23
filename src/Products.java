public class Products{
    private String name;//이름
    private double price;//가격
    private String description;//설명

    public Products(String name, double price, String description) {//이름 , 가격, 설명을 받아서 변수들에 대입
        this.name = name;
        this.price = price;
        this.description = description;
    }

    public String getName() {
        return name;
    }//이름 리턴

    public double getPrice() {
        return price;
    }//가격 리턴

    public String getDescription() {
        return description;
    }//설명 리턴
}