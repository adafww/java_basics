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
                moveUp(floor);
            } else {
                moveDown(floor);
            }
        }else {
            System.out.println("Ошибка");
        }
    }

    public void moveUp(int floor1){
        for (int i = currentFloor; i <= floor1; i++) {
            System.out.println(i);
            currentFloor = i;
        }
    }

    public void moveDown(int floor1){
        for (int i = currentFloor; i >= floor1; i--) {
            System.out.println(i);
            currentFloor = i;
        }
    }
}
