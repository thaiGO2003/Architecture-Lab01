package iuh.fit.se.creational_design_patterns.singleton.lazy_initialization;

/**
 * Lớp `LazyInitializedSingleton` triển khai mẫu thiết kế Singleton sử dụng khởi tạo trễ (lazy initialization).
 *
 * <p>Khởi tạo trễ nghĩa là thể hiện của lớp Singleton chỉ được tạo ra khi phương thức `getInstance()`
 * được gọi lần đầu tiên. Điều này giúp tiết kiệm tài nguyên hệ thống nếu thể hiện Singleton không
 * thực sự cần thiết trong suốt quá trình chạy của ứng dụng.</p>
 *
 * <p>Lớp này sử dụng một biến tĩnh `instance` để lưu trữ thể hiện duy nhất của Singleton.
 * Constructor của lớp được đặt là private để ngăn chặn việc tạo ra các thể hiện mới từ bên ngoài.
 * Phương thức `getInstance()` kiểm tra xem `instance` đã được khởi tạo hay chưa. Nếu chưa,
 * nó sẽ tạo ra một thể hiện mới và gán cho `instance`. Nếu `instance` đã tồn tại, nó sẽ
 * trả về thể hiện hiện có.</p>
 *
 * <p><b>Lưu ý:</b> Cách triển khai này không an toàn trong môi trường đa luồng nếu không có thêm
 * cơ chế đồng bộ hóa. Trong môi trường đa luồng, nhiều luồng có thể cùng lúc kiểm tra
 * `instance == null` và tạo ra nhiều thể hiện của Singleton, vi phạm nguyên tắc Singleton.
 * Để khắc phục vấn đề này, cần sử dụng các cơ chế đồng bộ hóa như `synchronized` hoặc
 * `volatile` (được cải thiện trong các phiên bản java 5+).</p>
 *
 * <p>Cách sử dụng:</p>
 * <pre>{@code
 * LazyInitializedSingleton instance = LazyInitializedSingleton.getInstance();
 * // Sử dụng thể hiện Singleton
 * }</pre>
 */
public class LazyInitializedSingleton {
    /**
     * Thể hiện duy nhất của lớp `LazyInitializedSingleton`.
     */
    private static LazyInitializedSingleton instance;

    /**
     * Constructor private để ngăn chặn việc tạo ra thể hiện từ bên ngoài.
     */
    private LazyInitializedSingleton(){}

    /**
     * Phương thức tĩnh để lấy thể hiện duy nhất của lớp `LazyInitializedSingleton`.
     *
     * @return Thể hiện duy nhất của lớp `LazyInitializedSingleton`.
     */
    public static LazyInitializedSingleton getInstance(){
        if(instance == null){
            instance = new LazyInitializedSingleton();
        }
        return instance;
    }
}