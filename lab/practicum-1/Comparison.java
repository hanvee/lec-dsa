public class Comparison {
    /**
     * Mengukur waktu eksekusi dari operasi traversal pada Array
     * @param arrayOps ArrayOperations object
     * @return Waktu eksekusi dalam nanodetik
     */
    public static long measureArrayTraversal(ArrayOperations arrayOps) {
        long startTime = System.nanoTime();
        arrayOps.traversal();
        long endTime = System.nanoTime();
        return endTime - startTime;
    }
    
    /**
     * Mengukur waktu eksekusi dari operasi traversal pada ArrayList
     * @param arrayListOps ArrayListOperations object
     * @return Waktu eksekusi dalam nanodetik
     */
    public static long measureArrayListTraversal(ArrayListOperations arrayListOps) {
        long startTime = System.nanoTime();
        arrayListOps.traversal();
        long endTime = System.nanoTime();
        return endTime - startTime;
    }
    
    /**
     * Mengukur waktu eksekusi dari operasi pencarian pada Array
     * @param arrayOps ArrayOperations object
     * @param target Nilai yang akan dicari
     * @return Waktu eksekusi dalam nanodetik
     */
    public static long measureArraySearch(ArrayOperations arrayOps, int target) {
        long startTime = System.nanoTime();
        arrayOps.linearSearch(target);
        long endTime = System.nanoTime();
        return endTime - startTime;
    }
    
    /**
     * Mengukur waktu eksekusi dari operasi pencarian pada ArrayList
     * @param arrayListOps ArrayListOperations object
     * @param target Nilai yang akan dicari
     * @return Waktu eksekusi dalam nanodetik   
     */
    public static long measureArrayListSearch(ArrayListOperations arrayListOps, int target) {
        long startTime = System.nanoTime();
        arrayListOps.search(target);
        long endTime = System.nanoTime();
        return endTime - startTime;
    }
    
    /**
     * Mengukur waktu eksekusi dari operasi penyisipan pada Array
     * @param arrayOps ArrayOperations object
     * @param index Index untuk menyisipkan
     * @param value Nilai yang akan disisipkan
     * @return Waktu eksekusi dalam nanodetik
     */
    public static long measureArrayInsertion(ArrayOperations arrayOps, int index, int value) {
        long startTime = System.nanoTime();
        arrayOps.insert(index, value);
        long endTime = System.nanoTime();
        return endTime - startTime;
    }
    
    /**
     * Mengukur waktu eksekusi dari operasi penyisipan pada ArrayList
     * @param arrayListOps ArrayListOperations object
     * @param index Index untuk menyisipkan
     * @param value Nilai yang akan disisipkan
     * @return Waktu eksekusi dalam nanodetik
     */
    public static long measureArrayListInsertion(ArrayListOperations arrayListOps, int index, int value) {
        long startTime = System.nanoTime();
        arrayListOps.insert(index, value);
        long endTime = System.nanoTime();
        return endTime - startTime;
    }
    
    /**
     * Mengukur waktu eksekusi dari operasi penghapusan pada Array
     * @param arrayOps ArrayOperations object
     * @param index Index untuk menghapus
     * @return Waktu eksekusi dalam nanodetik
     */
    public static long measureArrayDeletion(ArrayOperations arrayOps, int index) {
        long startTime = System.nanoTime();
        arrayOps.delete(index);
        long endTime = System.nanoTime();
        return endTime - startTime;
    }
    
    /**
     * Mengukur waktu eksekusi dari operasi penghapusan pada ArrayList
     * @param arrayListOps ArrayListOperations object
     * @param index Index untuk menghapus
     * @return Waktu eksekusi dalam nanodetik
     */
    public static long measureArrayListDeletion(ArrayListOperations arrayListOps, int index) {
        long startTime = System.nanoTime();
        arrayListOps.remove(index);
        long endTime = System.nanoTime();
        return endTime - startTime;
    }
    
    /**
     * Convert nanoseconds ke milliseconds dengan presisi
     * @param nanoTime Waktu dalam nanodetik
     * @return Waktu dalam milidetik sebagai double
     */
    public static double nanosToMillis(long nanoTime) {
        return nanoTime / 1_000_000.0;
    }
}