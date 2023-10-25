package stream;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class Product {
    private int id;
    private String name;
    private int price;

    public Product(int id, String name, int price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", price=" + price +
                '}';
    }

    public Product() {

    }

    public void test() {
        List<Product> productList = new ArrayList<>();
        productList.add(new Product(1, "hp", 20000));
        productList.add(new Product(2, "dell", 30000));
        productList.add(new Product(3, "samsung", 32000));
        productList.add(new Product(4, "apple", 40000));
        productList.add(new Product(5, "mi", 10000));

        List<Product> products = productList.stream().filter(e -> e.price >= 30000)
                .toList();
        System.out.println(products);

        productList.stream().filter(e -> e.price < 30000).forEach(e -> System.out.println(e.name));

        //using reduce method
        Integer reduce = productList.stream().map(e -> e.price)
                .reduce(0, (sum, price) -> sum + price);
        System.out.println(reduce);

        //using collector
        Integer sum = productList.stream().collect(Collectors.summingInt(e -> e.price));
        System.out.println(sum);

        //min/max using stream
        Product maxValue = productList.stream().max((product1, product2)
                -> product1.price > product2.price ? 1 : -1).get();
        System.out.println(maxValue);

        Product minValue = productList.stream().min((product1, product2)
                -> product1.price > product2.price ? 1 : -1).get();
        System.out.println(minValue);

        //count
        Long totalProduct = productList.stream().map(e -> e).count();
        System.out.println(totalProduct);
        //convert list to set

        Set<Product> productSet = productList.stream()
                .filter(p->p.price>=30000)
                .collect(Collectors.toSet());
        System.out.println(productSet);

        //convert list into map
        Map<Integer, String> productMap = productList.stream()
                .collect(Collectors.toMap(e->e.id,e->e.name));
        System.out.println(productMap);
    }

}
