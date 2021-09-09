import core.Line;
import junit.framework.TestCase;
import core.Station;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;

public class RoureCalculatorTest extends TestCase {

    List<Station> routeOneLine, routeTwoLine, routeThreeLine;
    List<Station> stations;
    List<Station> conection1, conection2;
    RouteCalculator routeCalculator;
    StationIndex stationIndex;

    @Override
    protected void setUp() throws Exception {

        stations = new ArrayList<>();
        conection1 = new ArrayList<>();
        conection2 = new ArrayList<>();
        routeOneLine = new ArrayList<>();
        routeTwoLine = new ArrayList<>();
        routeThreeLine = new ArrayList<>();

        stationIndex = new StationIndex();

        Line line1 = new Line(1, "Первая");
        Line line2 = new Line(2, "Вторая");
        Line line3 = new Line(3, "Третья");

        stations.add(new Station("Петровская", line1));
        stations.add(new Station("Арбузная", line1));
        stations.add(new Station("Морковная", line2));
        stations.add(new Station("Яблочная", line2));
        stations.add(new Station("Апельсиновая", line3));
        stations.add(new Station("Ягодная", line3));

        line1.addStation(stations.get(0));
        line1.addStation(stations.get(1));
        line2.addStation(stations.get(2));
        line2.addStation(stations.get(3));
        line3.addStation(stations.get(4));
        line3.addStation(stations.get(5));

        conection1.add(stations.get(1));
        conection1.add(stations.get(2));
        conection2.add(stations.get(3));
        conection2.add(stations.get(4));

        stationIndex.addLine(line1);
        stationIndex.addLine(line2);
        stationIndex.addLine(line3);

        stationIndex.addConnection(conection1);
        stationIndex.addConnection(conection2);

        for (int i = 0; i < stations.size(); i++){

            stationIndex.addStation(stations.get(i));
        }

        for (int i = 0; i < 2; i++){

            routeOneLine.add(stations.get(i));
        }

        for (int i = 0; i < 4; i++){

            routeTwoLine.add(stations.get(i));
        }

        for (int i = 0; i < stations.size(); i++){

            routeThreeLine.add(stations.get(i));
        }

        routeCalculator = new RouteCalculator(stationIndex);
    }

    public void testCalculateDuration(){

        double actual = RouteCalculator.calculateDuration(routeTwoLine);
        double expected = 8.5;
        assertEquals(expected, actual);
    }

    public void testIsConnected(){

        boolean actual = stationIndex.getConnectedStations(routeTwoLine.get(1)).contains(routeTwoLine.get(2));
        boolean expected = true;
        assertEquals(expected, actual);
    }

    public void testGetShortestRouteOneLine(){

        List<Station> actual = routeCalculator.getShortestRoute(stations.get(0), stations.get(1));
        List<Station> expected = routeOneLine;
        assertEquals(expected, actual);
    }

    public void testGetShortestRouteTwoLine(){

        List<Station> actual = routeCalculator.getShortestRoute(stations.get(0), stations.get(3));
        List<Station> expected = routeTwoLine;
        assertEquals(expected, actual);
    }

    public void testGetShortestRouteThreeLine(){

        List<Station> actual = routeCalculator.getShortestRoute(stations.get(0), stations.get(5));
        List<Station> expected = routeThreeLine;
        assertEquals(expected, actual);
    }

    @Override
    protected void tearDown() throws Exception {
        super.tearDown();
    }
}
