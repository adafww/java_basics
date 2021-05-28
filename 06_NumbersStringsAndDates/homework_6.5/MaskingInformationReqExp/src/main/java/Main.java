public class Main {

    public static void main(String[] args) {

    }

    public static String searchAndReplaceDiamonds(String text, String placeholder) {

        int[] brackets = new int[text.length()];
        int count = 0;
        boolean countSwitch = false;
        String result = "";

        for (int i = 0; i < text.length(); i++) {

            if (!countSwitch && Character.toString(text.charAt(i)).matches("<")) {

                brackets[count] = i;
                count++;
                countSwitch = true;
            }

            if (countSwitch && Character.toString(text.charAt(i)).matches(">")) {

                brackets[count] = i;
                count++;
                countSwitch = false;
            }
        }

        for (int i = 0; i < text.length(); i++){

            result += text.substring(brackets[i]) + placeholder + text.substring(brackets[++i]);
        }

        return result;
    }
}