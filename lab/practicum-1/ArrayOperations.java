import java.util.Arrays;

public class ArrayOperations {
    private int[] array;
    private int size;
    private int capacity;
    
    /**
     * Constructor untuk inisialisasi array dengan kapasitas tertentu
     * @param capacity Kapasitas maksimum dari array
     */
    public ArrayOperations(int capacity) {
        this.capacity = capacity;
        this.array = new int[capacity];
        this.size = 0;
    }
    
    /**
     * Constructor untuk inisialisasi array dengan data yang diberikan
     * @param data Data awal untuk array
     */
    public ArrayOperations(int[] data) {
        this.capacity = data.length * 2;
        this.array = new int[capacity];
        this.size = data.length;
        System.arraycopy(data, 0, this.array, 0, data.length);
    }
    
    /**
     * Opwerasi traversal, untuk menampilkan semua elemen dalam array
     * Time Complexity: O(n)
     * Space Complexity: O(1)
     */
    public void traversal() {
        System.out.print("Array Traversal: [");
        for (int i = 0; i < size; i++) {
            System.out.print(array[i]);
            if (i < size - 1) System.out.print(", ");
        }
        System.out.println("]");
    }
    
    /**
     * Opearasi linear search
     * Time Complexity: O(n)
     * Space Complexity: O(1)
     * @param target Value untuk dicari
     * @return Index dari target value, -1 jika tidak ditemukan
     */
    public int linearSearch(int target) {
        for (int i = 0; i < size; i++) {
            if (array[i] == target) {
                return i;
            }
        }
        return -1;
    }
    
    /**
     * Operasi Binary Search (setelah array di-sort)
     * Time Complexity: O(log n)
     * Space Complexity: O(1)
     * @param target Value untuk dicari
     * @return Index dari target value, -1 jika tidak ditemukan
     */
    public int binarySearch(int target) {
        // Sort array terlebih dahulu
        int[] sortedArray = Arrays.copyOf(array, size);
        Arrays.sort(sortedArray);
        
        int left = 0, right = size - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            
            if (sortedArray[mid] == target) {
                return mid;
            }
            if (sortedArray[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return -1;
    }
    
    /**
     * Insert element pada posisi tertentu
     * Time Complexity: O(n)
     * Space Complexity: O(1)
     * @param index Posisi untuk menyisipkan
     * @param value Nilai yang akan disisipkan
     * @return true jika penyisipan berhasil, false jika tidak
     */
    public boolean insert(int index, int value) {
        if (index < 0 || index > size || size >= capacity) {
            return false;
        }
        
        System.arraycopy(array, index, array, index + 1, size - index);
        array[index] = value;
        size++;
        return true;
    }
    
    /**
     * Menambahkan elemen di akhir array
     * Time Complexity: O(1)
     * Space Complexity: O(1)
     * @param value Nilai yang akan ditambahkan
     * @return true jika penambahan berhasil, false jika tidak
     */
    public boolean add(int value) {
        return insert(size, value);
    }
    
    /**
     * Hapus elemen pada posisi tertentu
     * Time Complexity: O(n) - karena pergeseran elemen
     * Space Complexity: O(1)
     * @param index Posisi untuk menghapus
     * @return true jika penghapusan berhasil, false jika tidak valid
     */
    public boolean delete(int index) {
        if (index < 0 || index >= size) {
            return false;
        }
        
        System.arraycopy(array, index + 1, array, index, size - index - 1);
        size--;
        return true;
    }
    
    /**
     * Dapatkan salinan array saat ini dengan ukuran aktual
     * @return Salinan array dengan ukuran aktual
     */
    public int[] toArray() {
        return Arrays.copyOf(array, size);
    }
    
    /**
     * Dapatkan ukuran saat ini dari array
     * @return Jumlah elemen saat ini
     */
    public int getSize() {
        return size;
    }
    
    /**
     * Sort array menggunakan Arrays.sort()
     * Time Complexity: O(n log n)
     * Space Complexity: O(1)
     */
    public void sort() {
        Arrays.sort(array, 0, size);
    }
}
