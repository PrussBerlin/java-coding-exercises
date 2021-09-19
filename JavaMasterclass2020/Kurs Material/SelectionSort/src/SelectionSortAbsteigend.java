public class SelectionSortAbsteigend {

    public static int[] selectionSortAbsteigend(int[] arrayToSort) {

        for(int i = 0; i < arrayToSort.length -1; i++) {

            for(int j = i + 1; j < arrayToSort.length; j ++) {

                if (arrayToSort[j] > arrayToSort[i]) {

                    int tmp = arrayToSort[i];
                    arrayToSort[i] = arrayToSort[j];
                    arrayToSort[j] = tmp;
                }
            }
        }
        return arrayToSort;
    }
}
