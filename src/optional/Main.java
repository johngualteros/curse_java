package optional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Main {
    public static void main(String[] args) throws Exception {
        List<String> countries = new ArrayList<>();
        countries.add("Colombia");
        countries.add("Peru");
        countries.add("Spain");
        countries.add("Italy");
        countries.add("Mexico");
        countries.add("Andorra");

        Optional<String> country=countries.stream()
                .filter(c->c.contains("ia"))
                .findFirst();

        country.ifPresent(System.out::println);
    }
    public static void exampleOptional(){
        Optional<Double> result=averageScores(7.0,8.0,9.0,10.0);
        if(result.isPresent()) {
            System.out.println(result.get());
        }else{
            System.out.println("Nothing");
        }
    }
    public static Optional<Double> averageScores(Double ...scores){//the optional says if it should return a double or not
        if(scores.length==0){
            return Optional.empty();
        }
        double sum=0;
        for(Double score : scores) sum+=score;
        return Optional.of(sum/scores.length);
    }
}
