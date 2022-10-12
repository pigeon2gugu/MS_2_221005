package class_221012.Algorithms_221012;

interface Compare{
    boolean doSth(int valueA, int valueB);
}

public class MaxAndMin {

    private int getMaxorMin(int[] arr, Compare compare) { // callback

        int compareValue = arr[0];

        for(int i =0; i< arr.length; i++) {
            boolean isSth = compare.doSth(arr[i], compareValue);
            if (isSth) {
                compareValue = arr[i];

            }
        }

        return compareValue;
    }

    public int max(int[] arr) {
        return getMaxorMin(arr, new Compare() {
            @Override
            public boolean doSth(int valueA, int valueB) {
                return valueA > valueB;
            }
        });
    }

    public int min(int[] arr) {
        return getMaxorMin(arr, new Compare() {
            @Override
            public boolean doSth(int valueA, int valueB) {
                return valueA < valueB;
            }
        });
    }

    public static void main(String[] args) {

        int[] arr = {3,29,38,12,57,74,40,85,61};

        MaxAndMin maxAndMin = new MaxAndMin();
        int maxResult = maxAndMin.max(arr);
        int minResult = maxAndMin.min(arr);

        System.out.println(maxResult);
        System.out.println(minResult);
    }
}
