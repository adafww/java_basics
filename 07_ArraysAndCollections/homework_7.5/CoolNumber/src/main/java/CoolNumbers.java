import java.util.*;

public class CoolNumbers {

    public static List<String> generateCoolNumbers() {

        ArrayList<String> list = new ArrayList<>();
        String[] letters = new String[]{"А", "В", "Е", "К", "М", "Н", "О", "Р", "С", "Т", "У", "Х"};
        int niceNumber;
        final Random random = new Random();
        for(int i = 0 ; i <= 2000000 ; i++){

            niceNumber = random.nextInt(10);
            list.add(letters[random.nextInt(12)] + niceNumber + niceNumber + niceNumber +
                    letters[random.nextInt(12)] + letters[random.nextInt(12)] + (random.nextInt(199) + 1));
        }
        return list;
    }

    public static boolean bruteForceSearchInList(List<String> list, String number) {

        long nanos = System.nanoTime();

        for(String i : list){

            if(i.equals(number)){

                return true;
            }
        }

        long duration = System.nanoTime() - nanos;
        int seconds = (int) (duration / 1000000000);
        int milliseconds = (int) (duration / 1000000) % 1000;
        int nanoseconds = (int) (duration % 1000000);
        System.out.printf("%d seconds, %d milliseconds en %d nanoseconds\n", seconds, milliseconds, nanoseconds);

        return false;
    }

    public static boolean binarySearchInList(List<String> sortedList, String number) {

        long nanos = System.nanoTime();

        int index = Collections.binarySearch(sortedList, number);

        long duration = System.nanoTime() - nanos;
        int seconds = (int) (duration / 1000000000);
        int milliseconds = (int) (duration / 1000000) % 1000;
        int nanoseconds = (int) (duration % 1000000);
        System.out.printf("%d seconds, %d milliseconds en %d nanoseconds\n", seconds, milliseconds, nanoseconds);

        if (index != -1){

            return true;
        }else {
            return false;
        }
    }

    public static boolean searchInHashSet(HashSet<String> hashSet, String number) {

        boolean isTrue;
        long nanos = System.nanoTime();

        isTrue = hashSet.contains(number);

        long duration = System.nanoTime() - nanos;
        int seconds = (int) (duration / 1000000000);
        int milliseconds = (int) (duration / 1000000) % 1000;
        int nanoseconds = (int) (duration % 1000000);
        System.out.printf("%d seconds, %d milliseconds en %d nanoseconds\n", seconds, milliseconds, nanoseconds);

        return isTrue;
    }

    public static boolean searchInTreeSet(TreeSet<String> treeSet, String number) {

        boolean isTrue;
        long nanos = System.nanoTime();

        isTrue =  treeSet.contains(number);

        long duration = System.nanoTime() - nanos;
        int seconds = (int) (duration / 1000000000);
        int milliseconds = (int) (duration / 1000000) % 1000;
        int nanoseconds = (int) (duration % 1000000);
        System.out.printf("%d seconds, %d milliseconds en %d nanoseconds\n", seconds, milliseconds, nanoseconds);

        return isTrue;
    }

}
