import com.skillbox.airport.Aircraft;
import com.skillbox.airport.Airport;
import com.skillbox.airport.Flight;
import net.sf.saxon.pattern.LocalNameTest;

import javax.swing.plaf.basic.BasicDesktopIconUI;
import java.sql.Time;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {

        Airport airport = Airport.getInstance();
        LocalDate localDate = LocalDate.now();
        LocalTime localTime = LocalTime.now().minusHours(2);
        Date date = new Date(localDate.getYear()
                ,localDate.getMonthValue()
                ,localDate.getDayOfMonth()
                ,localTime.getHour()
                ,localTime.getMinute()
                ,localTime.getSecond()
        );
        airport.getTerminals().stream()
                .map(a -> a.getFlights().stream().map(b -> b.getDate().getTime()).filter(c -> c >= date.getTime()))
                .forEach(System.out::println);
    }

    public static List<Flight> findPlanesLeavingInTheNextTwoHours(Airport airport) {

        /*
        LocalDate localDate = LocalDate.now();
        LocalTime localTime = LocalTime.now().minusHours(2);
        Date date = new Date(localDate.getYear()
                ,localDate.getMonthValue()
                ,localDate.getDayOfMonth()
                ,localTime.getHour()
                ,localTime.getMinute()
                ,localTime.getSecond()
        );
        airport.getTerminals().stream()
                .map(a -> a.getFlights().stream()
                .filter(g -> g.getDate().getTime() >= date.getTime()))
                .collect(Collectors.toList());

         */
        return new ArrayList<>();
    }

}