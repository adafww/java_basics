public class ReverseArray {

    public static String[] reverse (String[] strings){

        for (int i = 0; i < strings.length / 2; i++){

            String temp = strings[i];
            strings[i] = strings[strings.length - 1 - i];
            strings[strings.length - 1 - i] = temp;
        }

        return strings;
    }
}
