public class TwoDimensionalArray {
    public static char symbol = 'X';

    public static char[][] getTwoDimensionalArray(int size) {

        //TODO: Написать метод, который создаст двумерный массив char заданного размера.
        // массив должен содержать символ symbol по диагоналям, пример для size = 3
        // [X,  , X]
        // [ , X,  ]
        // [X,  , X]

        char[][] result = new char[size][size];
        int a = 0;
        int b = 0;
        int x = 0;
        int y = size - 1;

        for (int i = 0; i < size; i++){

            for (int j = 0; j < size; j++){

                result[i][j] = ' ';

                if(i == a && j == b){

                    result[i][j] = symbol;
                    b++;
                    a++;
                }

                if(i == x && j == y){

                    result[i][j] = symbol;
                    x++;
                    y--;
                }
            }
        }

        return result;
    }
}
