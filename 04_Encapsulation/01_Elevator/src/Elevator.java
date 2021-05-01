public class Elevator {

    private int currentFloor = 1;
    private int minF;
    private int maxF;

    public Elevator(int minFloor, int maxFloor){
        minF += minFloor;
        maxF += maxFloor;
    }

    public void move(int floor){
        if(maxF >= floor && minF <= floor) {
            if (floor >= currentFloor) {
                for (int i = currentFloor; i <= floor; i++) {
                    System.out.println(i);
                    currentFloor = i;
                }
            } else {
                for (int i = currentFloor; i >= floor; i--) {
                    System.out.println(i);
                    currentFloor = i;
                }
            }
        }else {
            System.out.println("Ошибка");
        }
    }
}
