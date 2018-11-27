import java.util.*;

public class ObservedPin {
    public static void main(String[] args) {
        System.out.println(getPINs("12"));
    }

    public static List<String> getPINs(String observed) {
        String[][] varriantsOfDigits = initializeArray();

        char[] observedArray = observed.toCharArray();

        String[][] observedVarriantsOfDigits = new String[observedArray.length][];

        for (int i = 0; i < observedVarriantsOfDigits.length; i++) {
            observedVarriantsOfDigits[i] = Arrays.copyOf(varriantsOfDigits[observedArray[i] - 48], varriantsOfDigits[observedArray[i] - 48].length);
        }
//        for (int i = 0; i < 2; i++) {
//            System.out.println(Arrays.toString(observedVarriantsOfDigits[i]));
//        }






        ArrayList<String> result = new ArrayList<>();
        result.add(varriantsOfDigits[0][0]);
        result.add(varriantsOfDigits[0][1]);
        return result;
    }

    public static String[][] initializeArray() {
        String[][] varriantsOfDigits = new String[10][];
        varriantsOfDigits[0] = new String[] {"0", "9"};
        varriantsOfDigits[1] = new String[] {"1", "2", "4"};
        varriantsOfDigits[2] = new String[] {"1", "2", "3", "5"};
        varriantsOfDigits[3] = new String[] {"2", "3", "6"};
        varriantsOfDigits[4] = new String[] {"1", "4", "5", "7"};
        varriantsOfDigits[5] = new String[] {"2", "4", "5", "6", "8"};
        varriantsOfDigits[6] = new String[] {"3", "5", "6", "9"};
        varriantsOfDigits[7] = new String[] {"4", "7", "8"};
        varriantsOfDigits[8] = new String[] {"0", "5", "7", "8", "9"};
        varriantsOfDigits[9] = new String[] {"6", "8", "9"};
        return varriantsOfDigits;
    }

}
