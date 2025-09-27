public class Main {
    public static void main(String[] args) {
        System.out.println("ARRAY vs ARRAYLIST PERFORMANCE COMPARISON");
        System.out.println("============================================\n");

        // Test data inisialisasi
        int[] testData = { 20, 40, 60, 80, 100 };

        ArrayOperations arrayOps = new ArrayOperations(testData);
        ArrayListOperations arrayListOps = new ArrayListOperations(testData);

        System.out.println("1. Data Awal:");
        arrayOps.traversal();
        arrayListOps.traversal();
        System.out.println();

        // Test operasi search
        System.out.println("2. Operasi Search:");
        int searchTarget = 60;

        int arraySearchResult = arrayOps.linearSearch(searchTarget);
        int arrayListSearchResult = arrayListOps.search(searchTarget);

        System.out.println("Pencarian " + searchTarget + " dalam Array: " +
                (arraySearchResult != -1 ? "Ditemukan di indeks " + arraySearchResult : "Tidak ditemukan"));
        System.out.println("Pencarian " + searchTarget + " dalam ArrayList: " +
                (arrayListSearchResult != -1 ? "Ditemukan di indeks " + arrayListSearchResult : "Tidak ditemukan"));
        System.out.println();

        // Test operasi insert
        System.out.println("3. Operasi Insert:");
        int insertValue = 25;
        int insertIndex = 2;

        arrayOps.insert(insertIndex, insertValue);
        arrayListOps.insert(insertIndex, insertValue);

        System.out.print("Array setelah penyisipan elemen " + insertValue + ": ");
        arrayOps.traversal();
        System.out.print("ArrayList setelah penyisipan elemen " + insertValue + ": ");
        arrayListOps.traversal();
        System.out.println();

        // Perbandingan performa
        System.out.println("4. Perbandingan Performa:");
        performanceTest(testData);

        // Large dataset test
        System.out.println("\n5. Large Dataset Test:");
        largeDatasetTest();
    }

    /**
     * Mengukur waktu eksekusi dari operasi dasar
     * 
     * @param testData Test data array
     */
    private static void performanceTest(int[] testData) {
        ArrayOperations arrayOps = new ArrayOperations(testData);
        ArrayListOperations arrayListOps = new ArrayListOperations(testData);

        // Test search
        long arraySearchTime = Comparison.measureArraySearch(arrayOps, 30);
        long arrayListSearchTime = Comparison.measureArrayListSearch(arrayListOps, 30);

        System.out.printf("Waktu eksekusi pencarian pada Array: %.6f ms%n",
                Comparison.nanosToMillis(arraySearchTime));
        System.out.printf("Waktu eksekusi pencarian pada ArrayList: %.6f ms%n",
                Comparison.nanosToMillis(arrayListSearchTime));

        // Test insert  
        ArrayOperations arrayOpsInsert = new ArrayOperations(testData);
        ArrayListOperations arrayListOpsInsert = new ArrayListOperations(testData);

        long arrayInsertTime = Comparison.measureArrayInsertion(arrayOpsInsert, 2, 25);
        long arrayListInsertTime = Comparison.measureArrayListInsertion(arrayListOpsInsert, 2, 25);

        System.out.printf("Waktu eksekusi penyisipan pada Array: %.6f ms%n",
                Comparison.nanosToMillis(arrayInsertTime));
        System.out.printf("Waktu eksekusi penyisipan pada ArrayList: %.6f ms%n",
                Comparison.nanosToMillis(arrayListInsertTime));

        // Test delete
        long arrayDeleteTime = Comparison.measureArrayDeletion(arrayOpsInsert, 2);
        long arrayListDeleteTime = Comparison.measureArrayListDeletion(arrayListOpsInsert, 2);

        System.out.printf("Waktu eksekusi penghapusan pada Array: %.6f ms%n",
                Comparison.nanosToMillis(arrayDeleteTime));
        System.out.printf("Waktu eksekusi penghapusan pada ArrayList: %.6f ms%n",
                Comparison.nanosToMillis(arrayListDeleteTime));
    }

    /**
     * Test performa dengan dataset besar
     */
    private static void largeDatasetTest() {
        int[] largeData = new int[1000];
        for (int i = 0; i < 1000; i++) {
            largeData[i] = i * 10;
        }

        ArrayOperations largeArrayOps = new ArrayOperations(largeData);
        ArrayListOperations largeArrayListOps = new ArrayListOperations(largeData);

        // Performa search pada dataset besar
        long arraySearchTime = Comparison.measureArraySearch(largeArrayOps, 500);
        long arrayListSearchTime = Comparison.measureArrayListSearch(largeArrayListOps, 500);

        System.out.printf("Search - Array: %.6f ms, ArrayList: %.6f ms%n",
                Comparison.nanosToMillis(arraySearchTime),
                Comparison.nanosToMillis(arrayListSearchTime));

        // Performa insert pada dataset besar
        ArrayOperations largeArrayOpsInsert = new ArrayOperations(largeData);
        ArrayListOperations largeArrayListOpsInsert = new ArrayListOperations(largeData);

        long arrayInsertTime = Comparison.measureArrayInsertion(largeArrayOpsInsert, 500, 9999);
        long arrayListInsertTime = Comparison.measureArrayListInsertion(largeArrayListOpsInsert, 500, 9999);

        System.out.printf("Insertion - Array: %.6f ms, ArrayList: %.6f ms%n",
                Comparison.nanosToMillis(arrayInsertTime),
                Comparison.nanosToMillis(arrayListInsertTime));

        // Performa delete pada dataset besar
        ArrayOperations largeArrayOpsDelete = new ArrayOperations(largeData);
        ArrayListOperations largeArrayListOpsDelete = new ArrayListOperations(largeData);

        long arrayDeleteTime = Comparison.measureArrayDeletion(largeArrayOpsDelete, 500);
        long arrayListDeleteTime = Comparison.measureArrayListDeletion(largeArrayListOpsDelete, 500);

        System.out.printf("Deletion - Array: %.6f ms, ArrayList: %.6f ms%n",
                Comparison.nanosToMillis(arrayDeleteTime),
                Comparison.nanosToMillis(arrayListDeleteTime));
    }
}
