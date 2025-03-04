package iuh.fit.se.creational_design_patterns.singleton.thread_safe_singleton;

/**
 * Lớp `ThreadSafeSingleton` triển khai mẫu thiết kế Singleton và đảm bảo tính an toàn
 * trong môi trường đa luồng.
 *
 * <p>Mẫu thiết kế Singleton đảm bảo rằng chỉ có một thể hiện duy nhất của một lớp được tạo ra.
 * Trong môi trường đa luồng, việc tạo ra thể hiện Singleton cần được đồng bộ hóa để tránh
 * việc nhiều luồng cùng lúc tạo ra nhiều thể hiện.</p>
 *
 * <p>Lớp này cung cấp hai phương thức để lấy thể hiện Singleton:</p>
 * <ul>
 * <li>`getInstance()`: Sử dụng từ khóa `synchronized` trên phương thức để đảm bảo
 * đồng bộ hóa. Cách này đơn giản nhưng có thể ảnh hưởng đến hiệu suất vì toàn bộ phương
 * thức được đồng bộ hóa.</li>
 * <li>`getInstanceUsingDoubleLocking()`: Sử dụng kỹ thuật khóa kép (double-checked locking)
 * để giảm thiểu ảnh hưởng đến hiệu suất. Cách này chỉ đồng bộ hóa phần code cần thiết
 * (khởi tạo thể hiện) và chỉ khi thể hiện chưa được tạo.</li>
 * </ul>
 *
 * <p>Constructor của lớp được đặt là private để ngăn chặn việc tạo ra các thể hiện mới
 * từ bên ngoài.</p>
 *
 * <p><b>Lưu ý:</b> Kỹ thuật khóa kép (double-checked locking) có thể gặp vấn đề trong
 * một số phiên bản Java cũ do vấn đề về tối ưu hóa của trình biên dịch. Trong các phiên
 * bản Java 5 trở lên, kỹ thuật này hoạt động chính xác.</p>
 *
 * <p>Cách sử dụng:</p>
 * <pre>{@code
 * ThreadSafeSingleton instance1 = ThreadSafeSingleton.getInstance();
 * ThreadSafeSingleton instance2 = ThreadSafeSingleton.getInstanceUsingDoubleLocking();
 * // Sử dụng thể hiện Singleton
 * }</pre>
 */
public class ThreadSafeSingleton {
    /**
     * Thể hiện duy nhất của lớp `ThreadSafeSingleton`.
     */
    private static ThreadSafeSingleton instance;

    /**
     * Constructor private để ngăn chặn việc tạo ra thể hiện từ bên ngoài.
     */
    private ThreadSafeSingleton() {
    }

    /**
     * Phương thức tĩnh để lấy thể hiện duy nhất của lớp `ThreadSafeSingleton` (đồng bộ hóa toàn bộ phương thức).
     *
     * @return Thể hiện duy nhất của lớp `ThreadSafeSingleton`.
     */
    public static synchronized ThreadSafeSingleton getInstance() {
        if (instance == null) {
            instance = new ThreadSafeSingleton();
        }
        return instance;
    }

    /**
     * Phương thức tĩnh để lấy thể hiện duy nhất của lớp `ThreadSafeSingleton` (sử dụng khóa kép).
     *
     * @return Thể hiện duy nhất của lớp `ThreadSafeSingleton`.
     */
    public static ThreadSafeSingleton getInstanceUsingDoubleLocking() {
        if (instance == null) {
            synchronized (ThreadSafeSingleton.class) {
                if (instance == null) {
                    instance = new ThreadSafeSingleton();
                }
            }
        }
        return instance;
    }
}