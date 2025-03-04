package iuh.fit.se.creational_design_patterns.singleton.static_block_initialization;

/**
 * Lớp `StaticBlockSingleton` triển khai mẫu thiết kế Singleton sử dụng khởi tạo khối tĩnh (static block initialization).
 *
 * <p>Khởi tạo khối tĩnh cho phép chúng ta xử lý ngoại lệ trong quá trình khởi tạo thể hiện Singleton.
 * Điều này rất hữu ích khi việc khởi tạo thể hiện Singleton có thể gặp lỗi, ví dụ như khi đọc
 * dữ liệu từ tệp tin hoặc kết nối đến cơ sở dữ liệu.</p>
 *
 * <p>Lớp này sử dụng một khối tĩnh `static{...}` để khởi tạo thể hiện Singleton. Khối tĩnh
 * được thực thi một lần duy nhất khi lớp được tải vào bộ nhớ. Trong khối tĩnh, chúng ta
 * cố gắng tạo một thể hiện của `StaticBlockSingleton`. Nếu xảy ra ngoại lệ, chúng ta
 * sẽ ném một `RuntimeException` để thông báo lỗi khởi tạo.</p>
 *
 * <p>Constructor của lớp được đặt là private để ngăn chặn việc tạo ra các thể hiện mới
 * từ bên ngoài. Phương thức `getInstance()` trả về thể hiện duy nhất của Singleton.</p>
 *
 * <p><b>Lưu ý:</b> Cách triển khai này đảm bảo rằng thể hiện Singleton được tạo ra ngay
 * khi lớp được tải, không phải khi phương thức `getInstance()` được gọi lần đầu tiên.
 * Điều này có thể gây ra vấn đề về hiệu suất nếu việc khởi tạo Singleton tốn nhiều thời
 * gian và thể hiện không được sử dụng ngay lập tức.</p>
 *
 * <p>Cách sử dụng:</p>
 * <pre>{@code
 * StaticBlockSingleton instance = StaticBlockSingleton.getInstance();
 * // Sử dụng thể hiện Singleton
 * }</pre>
 */
public class StaticBlockSingleton {
    /**
     * Thể hiện duy nhất của lớp `StaticBlockSingleton`.
     */
    private static StaticBlockSingleton instance;

    /**
     * Constructor private để ngăn chặn việc tạo ra thể hiện từ bên ngoài.
     */
    private StaticBlockSingleton(){}

    // Khối tĩnh khởi tạo để xử lý ngoại lệ
    static{
        try{
            instance = new StaticBlockSingleton();
        }catch(Exception e){
            throw new RuntimeException("Exception occured in creating singleton instance");
        }
    }

    /**
     * Phương thức tĩnh để lấy thể hiện duy nhất của lớp `StaticBlockSingleton`.
     *
     * @return Thể hiện duy nhất của lớp `StaticBlockSingleton`.
     */
    public static StaticBlockSingleton getInstance(){
        return instance;
    }
}