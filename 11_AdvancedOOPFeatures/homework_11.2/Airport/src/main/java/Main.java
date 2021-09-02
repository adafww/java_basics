import com.skillbox.airport.Airport;
import com.skillbox.airport.Flight;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {

        findPlanesLeavingInTheNextTwoHours(Airport.getInstance()).stream().forEach(System.out::println);
    }

    public static List<Flight> findPlanesLeavingInTheNextTwoHours(Airport airport) {

        final int TWOHOURS = 7_200_000;
        Date date = new Date();

        return airport.getTerminals().stream()
                .flatMap(a -> a.getFlights().stream())
                .filter(g -> g.getDate().getTime() < (date.getTime() + TWOHOURS)
                        && g.getDate().getTime() >= date.getTime()
                        && g.getType().equals(Flight.Type.DEPARTURE))
                .collect(Collectors.toList());
    }
}