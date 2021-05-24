public class Main {

    public static void main(String[] args) {

    }

    public static String searchAndReplaceDiamonds(String text, String placeholder) {

        int firstBracketLeft = 0;
        int secondBracketLeft = 0;
        int firstBracketRight = 0;
        int secondBracketRight = 0;
        int firstCount = 0;
        int secondCount = 0;

        for (int i = 0; i < text.length(); i++) {

            if (Character.toString(text.charAt(i)).equals("<")) {

                firstCount++;
                if (firstCount == 2){

                    secondBracketLeft = i;
                }
                if (firstCount == 1){

                    firstBracketLeft = i;
                }
            }

            if (Character.toString(text.charAt(i)).equals(">")) {

                secondCount++;
                if (secondCount == 2){

                    secondBracketRight = i;
                }
                if (secondCount == 1){

                    firstBracketRight = i;
                }
            }
        }

        if (firstCount == 1 && secondCount == 1){

            text = text.substring(0, firstBracketLeft) + placeholder +
                    text.substring(++firstBracketRight);
        }

        if (firstCount == 2 && secondCount == 2){

            text = text.substring(0, firstBracketLeft) + placeholder +
                    text.substring(++firstBracketRight, secondBracketLeft) + placeholder +
                    text.substring(++secondBracketRight);
        }
        return text;
    }
}