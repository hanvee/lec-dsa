import java.util.ArrayList;
import java.util.Collections;

public class ArrayListOperations {
    private ArrayList<Integer> arrayList;
    
    /**
     * Constructor untuk inisialisasi ArrayList kosong
     */
    public ArrayListOperations() {
        this.arrayList = new ArrayList<>();
    }
    
    /**
     * Constructor untuk inisialisasi ArrayList dengan data yang diberikan
     * @param data Initial data untuk ArrayList
     */
    public ArrayListOperations(int[] data) {
        this.arrayList = new ArrayList<>();
        for (int value : data) {
            arrayList.add(value);
        }
    }
    
    /**
     * Operasi traversal, untuk menampilkan semua elemen dalam ArrayList
     * Time Complexity: O(n)
     * Space Complexity: O(1)
     */
    public void traversal() {
        System.out.println("ArrayList Traversal: " + arrayList);
    }
    
    /**
     * Menambahkan elemen di akhir ArrayList
     * Time Complexity: O(1) amortized
     * Space Complexity: O(1)
     * @param value Value to add
     */
    public void add(int value) {
        arrayList.add(value);
    }
    
    /**
     * Insert element pada posisi tertentu
     * Time Complexity: O(n)
     * Space Complexity: O(1)
     * @param index Posisi untuk menyisipkan
     * @param value Nilai yang akan disisipkan
     */
    public void insert(int index, int value) {
        if (index >= 0 && index <= arrayList.size()) {
            arrayList.add(index, value);
        }
    }
    
    /**
     * Hapus element pada posisi tertentu
     * Time Complexity: O(n)
     * Space Complexity: O(1)
     * @param index Posisi untuk menghapus
     * @return true jika penghapusan berhasil, false jika indeks tidak valid
     */
    public boolean remove(int index) {
        if (index >= 0 && index < arrayList.size()) {
            arrayList.remove(index);
            return true;
        }
        return false;
    }
    
    /**
     * Cari elemen dalam ArrayList
     * Time Complexity: O(n)
     * Space Complexity: O(1)
     * @param target Value untuk dicari 
     * @return Index dari target value, -1 jika tidak ditemukan
     */
    public int search(int target) {
        return arrayList.indexOf(target);
    }
    
    /**
     * Sort ArrayList menggunakan Collections.sort()
     * Time Complexity: O(n log n)
     * Space Complexity: O(1)
     */
    public void sort() {
        Collections.sort(arrayList);
    }
    
    /**
     * Dapatkan referensi ke ArrayList
     * @return Referensi ke ArrayList
     */
    public ArrayList<Integer> getArrayList() {
        return arrayList;
    }
    
    /**
     * Dapatkan ukuran saat ini dari ArrayList
     * @return Jumlah elemen saat ini
     */
    public int getSize() {
        return arrayList.size();
    }
}