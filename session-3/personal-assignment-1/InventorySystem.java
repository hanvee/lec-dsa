import java.util.Scanner;

/**
 * SISTEM INVENTARIS TOKO
 *
 * Program ini adalah sistem manajemen inventaris sederhana untuk toko yang memungkinkan:
 * - Menampilkan daftar barang
 * - Mencari barang berdasarkan nama
 * - Menambah barang baru
 * - Mengupdate stok barang
 * 
 * Struktur Data:
 * - Menggunakan array untuk menyimpan produk (maksimal 10 barang)
 * - Setiap produk memiliki nama, stok, dan harga
 * 
 */

/**
 * Kelas Product - Merepresentasikan sebuah barang dalam inventaris
 * 
 * Kelas ini menggunakan konsep encapsulation (enkapsulasi) dimana:
 * - Atribut dibuat private untuk keamanan data
 * - Akses ke atribut dilakukan melalui getter dan setter
 */
class Product {
    private String name;
    private int stockQuantity;
    private double price;

    /**
     * Constructor untuk membuat objek Product baru
     * 
     * @param name - Nama barang yang akan disimpan
     * @param stockQuantity - Jumlah stok awal barang
     * @param price - Harga per unit barang
     */
    public Product(String name, int stockQuantity, double price) {
        this.name = name;
        this.stockQuantity = stockQuantity;
        this.price = price;
    }

    // Getter methods - Metode untuk mengambil nilai atribut
    
    /**
     * Mengambil nama barang
     * @return nama barang dalam bentuk String
     */
    public String getName() {
        return name;
    }

    /**
     * Mengambil jumlah stok barang
     * @return jumlah stok dalam bentuk integer
     */
    public int getStockQuantity() {
        return stockQuantity;
    }

    /**
     * Mengambil harga barang
     * @return harga barang dalam bentuk double
     */
    public double getPrice() {
        return price;
    }

    // Setter methods - Metode untuk mengubah nilai atribut
    
    /**
     * Mengubah jumlah stok barang
     * @param stockQuantity - jumlah stok baru yang akan diset
     */
    public void setStockQuantity(int stockQuantity) {
        this.stockQuantity = stockQuantity;
    }

    /**
     * Method untuk menampilkan detail barang dalam format yang mudah dibaca
     * Override dari method toString() bawaan Java
     * 
     * @return String yang berisi informasi lengkap barang (nama, stok, harga)
     */
    @Override
    public String toString() {
        return String.format("Name: %s, Jumlah Stock: %d, Harga: %.0f",
                name, stockQuantity, price);
    }
}

/**
 * Kelas InventorySystem - Kelas utama untuk menjalankan sistem inventaris
 * 
 * Kelas ini berisi:
 * - Array untuk menyimpan data produk (maksimal 10 barang)
 * - Menu interaktif untuk user
 * - Method-method untuk operasi CRUD (Create, Read, Update, Delete)
 */
public class InventorySystem {
    // Array untuk menyimpan barang-barang dalam inventaris (maksimal 10 barang)
    private static Product[] inventory = new Product[10];
    
    // Counter untuk melacak jumlah barang yang sudah tersimpan
    private static int totalItems = 0;
    
    // Scanner untuk membaca input dari user
    private static Scanner scanner = new Scanner(System.in);

    /**
     * Method utama (main) - Entry point program
     * 
     * Operasi yang dilakukan:
     * 1. Inisialisasi inventaris dengan 3 barang contoh
     * 2. Menampilkan menu dan memproses pilihan user
     * 3. Loop terus-menerus sampai user memilih exit
     * 
     * @param args - arguments dari command line (tidak digunakan)
     */
    public static void main(String[] args) {
        // Inisialisasi inventaris dengan 3 barang
        initialize();

        // Menu utama - Loop sampai user memilih exit (pilihan 5)
        boolean isRunning = true;
        while (isRunning) {
            showMenu();
            int pilihan = scanner.nextInt();
            scanner.nextLine();

            // Switch statement untuk memproses pilihan menu
            switch (pilihan) {
                case 1:
                    showInventory();
                    break;
                case 2:
                    updateStock();
                    break;
                case 3:
                    searchItem();
                    break;
                case 4:
                    addItem();
                    break;
                case 5:
                    isRunning = false;
                    System.out.println("Anda telah keluar dari program!");
                    break;
                default:
                    System.out.println("Pilihan tidak valid!");
            }

            // Jeda sebelum kembali ke menu utama (kecuali jika exit)
            if (isRunning) {
                System.out.println("\nTekan Enter untuk melanjutkan");
                scanner.nextLine();
                System.out.println();
            }
        }
    }

    /**
     * Method untuk inisialisasi inventaris dengan 3 barang contoh
     * Metode ini dipanggil pada awal program untuk memberikan data awal
     */
    private static void initialize() {
        inventory[0] = new Product("Pensil", 50, 4000);
        inventory[1] = new Product("Buku", 40, 10000);
        inventory[2] = new Product("Penghapus", 25, 2000);
        totalItems = 3;
    }

    /**
     * Method untuk menampilkan menu pilihan kepada user
     * Menampilkan 5 opsi: tampilkan inventaris, update stok, cari barang, tambah barang, dan exit
     */
    private static void showMenu() {
        System.out.println("=== SISTEM INVENTARIS TOKO ===");
        System.out.println("1. Tampilkan Inventaris");
        System.out.println("2. Update Stok Barang");
        System.out.println("3. Cari Barang");
        System.out.println("4. Tambah Barang Baru");
        System.out.println("5. Exit");
        System.out.print("Pilih menu (1-5): ");
    }

    /**
     * Method untuk menampilkan semua barang dalam inventaris
     * 
     * Operasi yang dilakukan:
     * 1. Mengecek apakah inventaris kosong
     * 2. Jika tidak kosong, menampilkan semua barang dengan nomor urut
     * 3. Menggunakan loop for untuk iterasi array inventory
     */
    private static void showInventory() {
        System.out.println("\nInventaris Toko:");

        // Cek apakah inventaris kosong
        if (totalItems == 0) {
            System.out.println("Inventaris kosong.");
            return;
        }

        // Loop untuk menampilkan setiap barang dengan nomor urut
        for (int i = 0; i < totalItems; i++) {
            System.out.printf("%d. %s%n", (i + 1), inventory[i].toString());
        }
    }

    /**
     * Method untuk mengupdate stok barang berdasarkan nama
     * 
     * Operasi yang dilakukan:
     * 1. Meminta input nama barang dari user
     * 2. Mencari barang dalam inventaris menggunakan findItemIndex()
     * 3. Jika barang ditemukan, meminta input stok baru
     * 4. Validasi stok tidak boleh negatif
     * 5. Update stok dan tampilkan inventaris terbaru
     */
    private static void updateStock() {
        System.out.print("\nMasukkan nama barang yang ingin diupdate: ");
        String productName = scanner.nextLine();

        // Mencari barang berdasarkan nama menggunakan helper method
        int index = findItemIndex(productName);

        if (index != -1) {
            System.out.print("Masukkan jumlah stok baru: ");
            int newStock = scanner.nextInt();

            // Validasi: stok tidak boleh negatif
            if (newStock >= 0) {
                inventory[index].setStockQuantity(newStock);
                System.out.println("Stok berhasil diupdate!");

                // Tampilkan inventaris setelah diupdate
                System.out.println("\nInventaris setelah diupdate:");
                showInventory();
            } else {
                System.out.println("Jumlah stok tidak boleh negatif!");
            }
        } else {
            System.out.println("Barang dengan nama '" + productName + "' tidak ditemukan!");
        }
    }

    /**
     * Method untuk mencari barang berdasarkan nama
     * 
     * Operasi yang dilakukan:
     * 1. Meminta input nama barang dari user
     * 2. Mencari barang menggunakan findItemIndex()
     * 3. Jika ditemukan, tampilkan detail barang
     * 4. Jika tidak ditemukan, tampilkan pesan error
     */
    private static void searchItem() {
        System.out.print("\nMasukkan nama barang yang dicari: ");
        String itemName = scanner.nextLine();

        int index = findItemIndex(itemName);

        if (index != -1) {
            System.out.println("\nHasil pencarian:");
            System.out.println(inventory[index].toString());
        } else {
            System.out.println("Barang dengan nama '" + itemName + "' tidak ditemukan!");
        }
    }

    /**
     * Method helper untuk mencari index barang berdasarkan nama
     * 
     * Operasi yang dilakukan:
     * 1. Loop melalui semua barang dalam inventaris
     * 2. Bandingkan nama barang dengan nama yang dicari (case-insensitive)
     * 3. Return index jika ditemukan, atau -1 jika tidak ditemukan
     * 
     * @param name - nama barang yang dicari
     * @return index barang dalam array, atau -1 jika tidak ditemukan
     */
    private static int findItemIndex(String name) {
        for (int i = 0; i < totalItems; i++) {
            // equalsIgnoreCase() digunakan agar pencarian tidak case-sensitive
            if (inventory[i].getName().equalsIgnoreCase(name)) {
                return i;
            }
        }
        // Return -1 jika barang tidak ditemukan
        return -1;
    }

    /**
     * Method untuk menambah barang baru ke inventaris
     * 
     * Operasi yang dilakukan:
     * 1. Mengecek apakah inventaris sudah penuh (maksimal 10 barang)
     * 2. Meminta input nama barang dari user
     * 3. Mengecek apakah barang dengan nama tersebut sudah ada
     * 4. Meminta input stok dan harga
     * 5. Validasi stok dan harga tidak boleh negatif
     * 6. Menambahkan barang baru ke array dan increment totalItems
     */
    private static void addItem() {
        // Cek apakah inventaris sudah penuh
        if (totalItems >= 10) {
            System.out.println("\nInventaris sudah penuh! Maksimal 10 barang.");
            return;
        }

        System.out.print("\nMasukkan nama barang: ");
        String name = scanner.nextLine();

        // Cek apakah barang sudah ada menggunakan helper method
        if (findItemIndex(name) != -1) {
            System.out.println("Barang dengan nama '" + name + "' sudah ada!");
            return;
        }

        System.out.print("Masukkan jumlah stok: ");
        int stock = scanner.nextInt();

        System.out.print("Masukkan harga: ");
        double price = scanner.nextDouble();

        // Validasi: stok dan harga tidak boleh negatif
        if (stock >= 0 && price >= 0) {
            // Buat objek Product baru dan tambahkan ke array
            inventory[totalItems] = new Product(name, stock, price);
            totalItems++; // Increment counter
            System.out.println("Barang berhasil ditambahkan!");
        } else {
            System.out.println("Stok dan harga tidak boleh negatif!");
        }
    }
}
