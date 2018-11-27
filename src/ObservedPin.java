import java.util.*;

public class ObservedPin {
    private static String[][] observedVarriantsOfDigits;
    private static int n;

    public static void main(String[] args) {
        System.out.println(getPINs("11"));
    }

    public static List<String> getPINs(String observed) {
        List<String> result = new LinkedList<>();
        String[][] varriantsOfDigits = initializeArray();

        char[] observedArray = observed.toCharArray();
        n = observedArray.length;
        observedVarriantsOfDigits = new String[n][];

        for (int i = 0; i < n; i++) {
            observedVarriantsOfDigits[i] = Arrays.copyOf(varriantsOfDigits[observedArray[i] - 48], varriantsOfDigits[observedArray[i] - 48].length);
        }

        int[] index = new int[n];
        StringBuilder builder = new StringBuilder();
        while (index[0] < observedVarriantsOfDigits[0].length) {
            builder.delete(0, builder.length());
            for (int i = 0; i < n; i++) {
                builder.append(observedVarriantsOfDigits[i][index[i]]);
            }
            result.add(builder.toString());
            index = generateCombinations(index);
        }
        return result;
    }

    public static String[][] initializeArray() {
        String[][] varriantsOfDigits = new String[10][];
        varriantsOfDigits[0] = new String[] {"0", "8"};
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

    private static int[] generateCombinations(int[] arr) {
        for (int i = n - 1; i >= 0; i--)
            if (arr[i] < observedVarriantsOfDigits[i].length - 1) {
                arr[i]++;
                for (int j = i; j < n - 1; j++)
                    arr[j + 1] = 0;
                return arr;
            }
        arr[0]++;
        return arr;
    }
}
