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
        final long time = System.currentTimeMillis();

        return airport.getTerminals().stream()
                .flatMap(a -> a.getFlights().stream())
                .filter(g -> g.getDate().getTime() < (time + TWOHOURS)
                        && g.getDate().getTime() >= time
                        && g.getType().equals(Flight.Type.DEPARTURE))
                .collect(Collectors.toList());
    }
}