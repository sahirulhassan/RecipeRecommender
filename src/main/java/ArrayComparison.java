import java.util.Arrays;

public class ArrayComparison {
    public static boolean areArraysExactMatch(String[] arr1, String[] arr2) {
        // Check if both arrays have the same length
        if (arr1.length != arr2.length) {
            return false;
        }

        // Sort both arrays
        Arrays.sort(arr1);
        Arrays.sort(arr2);

        // Check if both arrays are equal after sorting
        return Arrays.equals(arr1, arr2);
    }

    public static boolean areArraysPartiallyMatched(String[] arr1, String[] arr2) {
        // Check if any element of arr1 exists in arr2
        for (String element1 : arr1) {
            for (String element2 : arr2) {
                if (element1.equals(element2)) {
                    return true;  // Partial match found
                }
            }
        }
        return false;  // No partial match found
    }

    public static boolean isArraySubset(String[] larger, String[] smaller) {
        // For each element in smaller array, check if it exists in the larger array
        for (String elementSmaller : smaller) {
            boolean found = false;
            for (String elementLarger : larger) {
                if (elementSmaller.equals(elementLarger)) {
                    found = true;
                    break;  // Element found in larger array
                }
            }
            if (!found) {
                return false;  // If any element is not found, return false
            }
        }
        return true;  // All elements in smaller are found in larger
    }
}
