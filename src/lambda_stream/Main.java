import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args){
        // Streams / Lambda
        List<String>cities=new ArrayList<>();
        cities.add("london");
        cities.add("bogotá");
        cities.add("new york");
        cities.add("barcelona");

        //pattern design pipeline

        cities.stream().forEach(city->System.out.printf("The city is %s \n",city));
        //Other form of print the cities with function
        cities.stream().forEach(Main::printCity);//reference of method
        //or
        cities.forEach(Main::printCity);
        //the code below is parallel it work in parallel for better performance in the processor but not is sequential
        cities.stream().parallel().forEach(Main::printCity);

        //Filter
        cities.stream().filter(city->city.startsWith("n")||city.contains("lo"))
                .forEach(Main::printCity);

        //other form
        cities.stream().filter(Main::filterCity).forEach(Main::printCity);
        //the method filter never can be a terminal method

        //saving the array in a new list
        List<String> filterCities=cities.stream().filter(Main::filterCity).collect(Collectors.toList());
        //or more small
        List<String> filteredCities= cities.stream().filter(Main::filterCity).toList();
        //collect convert the stream with list or set(conjunto)
    }
    public static boolean filterCity(String city){
        return city.startsWith("b")||city.contains("lo");
    }
    public static void printCity(String city){
        System.out.printf("The city is : %s\n",city);
    }
}
