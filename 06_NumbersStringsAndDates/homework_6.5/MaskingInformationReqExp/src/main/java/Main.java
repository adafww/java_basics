public class Main {

    public static void main(String[] args) {

    }

    public static String searchAndReplaceDiamonds(String text, String placeholder) {

        String result = text.replaceAll("<[0-9]+>|<[\\s0-9]+>", placeholder);

        return result;
    }
}