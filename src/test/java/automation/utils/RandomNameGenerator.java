package automation.utils;

public class RandomNameGenerator {

    public static String generateRandomText(int n) {
        return getAlphaNumericString(n);
    }

    private static String getAlphaNumericString(int n) {
        String AlphacString = "ABCDEFGHIJKLMNOPQRSTUVWXYZ" + "abcdefghijklmnopqrstuvxyz";
        StringBuilder sb = new StringBuilder(n);
        for (int i = 0; i < n; i++) {
            int index = (int) (AlphacString.length() * Math.random());
            sb.append(AlphacString.charAt(index));
        }
        return sb.toString();
    }

    public static String getRandomNumber(int n) {
        return getInteger(n);
    }

    private static String getInteger(int n) {
        String NumericString = "0123456789";
        StringBuilder sb = new StringBuilder(n);
        for (int i = 0; i < n; i++) {
            int index = (int) (NumericString.length() * Math.random());
            sb.append(NumericString.charAt(index));
        }
        return sb.toString();
    }
}
