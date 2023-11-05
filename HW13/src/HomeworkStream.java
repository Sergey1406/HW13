import java.util.ArrayList;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

public class HomeworkStream {
    public static List<Product> listOfProducts = new ArrayList<Product>();


    public static List<Product> getAllProducts() {

        return listOfProducts.stream()
                .filter(i -> i.getPrice() > 10 && i.getType().equals("Book"))
                .collect(Collectors.toList());

    }

    public static List<Product> getAllDiscount() {
        List<Product> discounted = listOfProducts.stream()
                .filter(i -> i.getType().equals("Book") && i.getDiscount() == true)
                .map(x -> new Product(x.getType(), x.getPrice() - x.getPrice() / 10, true))
                .collect(Collectors.toList());
        return discounted;

    }

    public static Product lowestPrice() {

        List<Product> sorted = listOfProducts.stream()
                .filter(x -> x.getType().equals("Book"))
                .map(item -> {
                    if (item.getType() != "Book") {
                        throw new RuntimeException("продукт book не знайдено");
                    } else {
                        return item;
                    }

                })
                .sorted(Comparator.comparingDouble(Product::getPrice))
                .collect(Collectors.toList());

        return sorted.get(0);
    }


    public static List<Product> lastAdded() {
        List<Product> sorted = listOfProducts.stream()
                .filter(x -> x.getType().equals("Book"))
                .sorted(Comparator.comparing(Product::getDate, Comparator.nullsLast(Comparator.reverseOrder())))
                .limit(3)
                .collect(Collectors.toList());

        return sorted;
    }

    public static double sum() {
        double sum = listOfProducts.stream()
                .filter(x -> x.getType().equals("Book") && x.getDate().getYear() == 122 && x.getPrice() < 75)
                .mapToDouble(Product::getPrice)
                .reduce(0, Double::sum);

        return sum;
    }


    public static void main(String[] args) {

        Product p = new Product("Book", 11.20, true);
        Product k = new Product("Book", 14, true);
        Product d = new Product("Table", 22.30, false);
        Product t = new Product("Car", 22.30);

        Product e = new Product("Book", 45, false, new Date(120, 11, 18));
        Product s = new Product("Book", 40, false, new Date(120, 12, 14));
        Product b = new Product("Book", 41, false, new Date(120, 10, 10));
        Product m = new Product("Book", 49, false, new Date(122, 10, 10));
        Product n = new Product("Book", 48, false, new Date(122, 11, 10));
        Product x = new Product("Book", 47, false, new Date(122, 07, 10));

        listOfProducts.add(e);
        listOfProducts.add(s);
        listOfProducts.add(b);
        listOfProducts.add(m);
        listOfProducts.add(n);
        listOfProducts.add(x);
        

        System.out.println(lowestPrice().getPrice());
        lastAdded();
        System.out.println(sum());

    }
}
