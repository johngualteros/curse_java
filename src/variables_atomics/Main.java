package variables_atomics;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

public class Main {
    private static Map<String,Double> pricesByAirline;
    public static void main(String[] args){
        init();
        String from = "BCN";
        String to = "JFK";

        Double lowestPrice=getLowestPrice(from,to);
        Double averagePrice=getAveragePrice(from,to);

        System.out.printf("Lowest price: %f\nAverage; %f",lowestPrice,averagePrice);
    }
    private static Double getLowestPrice(String from,String to){
        AtomicReference<Double> lowestPrice=new AtomicReference<>(null);
        pricesByAirline.keySet().stream().parallel().forEach(airline->{
            Double price=getPriceTrip(airline,from,to);
            if(lowestPrice.get() == null || lowestPrice.get()>price){
                lowestPrice.set(price);
            }
        });
        return lowestPrice.get();
    }
    private static Double getAveragePrice(String from,String to){
        AtomicReference<Double> totalPrice=new AtomicReference<>(0.0);
        AtomicInteger counter=new AtomicInteger(0);
        pricesByAirline.keySet().stream().parallel().forEach(airline->{
            Double price=getPriceTrip(airline,from,to);
            Double result=totalPrice.get()+price;
            totalPrice.set(result);
            counter.incrementAndGet();
        });

        return totalPrice.get() / counter.get();
    }

    private static void init(){
        pricesByAirline=new HashMap<>();

        pricesByAirline.put("American Airlines",550.0);
        pricesByAirline.put("Us Airways",620.0);
        pricesByAirline.put("Qatar Airways",750.0);
        pricesByAirline.put("Avianca",320.0);
        pricesByAirline.put("Emirates",770.0);
    }
    private static Double getPriceTrip(String airline,String from,String to){
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        return pricesByAirline.get(airline);
    }
}
