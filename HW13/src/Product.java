import java.util.Date;

public class Product {

    private String type;
    private double price;
    private boolean discount;
    private Date date;
    private int id = 0;

    public Product(String type, double price) {
        this.type = type;
        this.price = price;
    }


    public Product(String type, double price, boolean discount) {
        this.type = type;
        this.price = price;
        this.discount = true;
    }

    public Product(String type, double price, boolean discount, Date date) {
        this.type = type;
        this.price = price;
        this.discount = true;
        this.date = date;
    }


    public String getType() {
        return type;
    }

    public double getPrice() {
        return price;
    }

    public boolean getDiscount() {
        return discount;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Date getDate() {
        return date;
    }


    public static void main(String[] args) {

    }
}
