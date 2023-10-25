package Practice;

import stream.Product;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

public class StreamPractice {
    private int id;
    private String name;
    private int price;

    public StreamPractice(int id, String name, int price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }

    public StreamPractice() {

    }

    @Override
    public String toString() {
        return "StreamPractice{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", price=" + price +
                '}';
    }

    public void test(){
        List<StreamPractice> streamPracticesList = new ArrayList<>();
        streamPracticesList.add(new StreamPractice(1,"sim",2000));
        streamPracticesList.add(new StreamPractice(2,"phone",70000));
        streamPracticesList.add(new StreamPractice(3,"pen",1500));
        streamPracticesList.add(new StreamPractice(4,"notepad",3000));
        streamPracticesList.add(new StreamPractice(5,"pencil",800));
        streamPracticesList.add(new StreamPractice(6,"laptop",300));

        //filter
        List<StreamPractice> product = streamPracticesList.stream().filter(e -> e.price <= 1000).toList();
        System.out.println(product);

        //reduce method to count
        Integer countTotal = streamPracticesList.stream()
                .map(e -> e.price)
                .filter(e -> e <= 1000)
                .reduce(0, (sum, streamPractice) -> sum + streamPractice);
        System.out.println(countTotal);

        //sum by using collector method
        Integer CountId = streamPracticesList.stream()
                .collect(Collectors.summingInt(e -> e.id));
        System.out.println(CountId);

        //find max price
        Optional<StreamPractice> maxPrice = streamPracticesList.stream()
                .max((p1, p2) -> p1.price > p2.price ? 1 : -1);
        System.out.println(maxPrice.get().price);
        
        //count
        long totalId = streamPracticesList.stream().map(e -> e).count();
        System.out.println(totalId);

        //convert to map
        Map<Integer,StreamPractice> streamPracticeMap = streamPracticesList.stream()
                .filter(e->e.price>=1000)
                .collect(Collectors.toMap(e->e.id,e->e));
        System.out.println(streamPracticeMap);

    }

}
