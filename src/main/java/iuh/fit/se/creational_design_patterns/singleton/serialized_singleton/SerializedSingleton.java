package iuh.fit.se.creational_design_patterns.singleton.serialized_singleton;

import java.io.Serializable;

/**
 * Lớp `SerializedSingleton` triển khai mẫu thiết kế Singleton và đảm bảo tính duy nhất
 * của thể hiện ngay cả sau khi serialization và deserialization.
 *
 * <p>Serialization là quá trình chuyển đổi một đối tượng thành một chuỗi byte để lưu trữ
 * hoặc truyền tải. Deserialization là quá trình ngược lại, chuyển đổi chuỗi byte trở lại
 * thành đối tượng. Trong trường hợp Singleton, nếu không có biện pháp bảo vệ, deserialization
 * có thể tạo ra một thể hiện mới, phá vỡ tính duy nhất của Singleton.</p>
 *
 * <p>Lớp này sử dụng một lớp tĩnh bên trong `SingletonHelper` để khởi tạo thể hiện Singleton
 * (lazy initialization). Điều này đảm bảo rằng thể hiện chỉ được tạo khi phương thức
 * `getInstance()` được gọi lần đầu tiên. Constructor của lớp được đặt là private để
 * ngăn chặn việc tạo ra các thể hiện mới từ bên ngoài.</p>
 *
 * <p>Phương thức `readResolve()` được sử dụng để bảo vệ Singleton khỏi bị phá vỡ trong
 * quá trình deserialization. Khi một đối tượng `SerializedSingleton` được deserialized,
 * JVM sẽ gọi phương thức `readResolve()` và thay thế đối tượng deserialized bằng giá trị
 * trả về của phương thức này. Trong trường hợp này, phương thức `readResolve()` trả về
 * thể hiện duy nhất của Singleton, đảm bảo rằng không có thể hiện mới nào được tạo ra.</p>
 *
 * <p><b>Lưu ý:</b> Việc thêm `serialVersionUID` là một thực hành tốt khi triển khai
 * `Serializable`. Nó giúp đảm bảo tính tương thích giữa các phiên bản khác nhau của lớp
 * trong quá trình serialization và deserialization.</p>
 *
 * <p>Cách sử dụng:</p>
 * <pre>{@code
 * SerializedSingleton instance = SerializedSingleton.getInstance();
 * // Serialize instance
 * // Deserialize instance
 * }</pre>
 */
public class SerializedSingleton implements Serializable {
    /**
     * ID phiên bản để đảm bảo tính tương thích serialization.
     */
    private static final long serialVersionUID = -7604766932017737115L;

    /**
     * Constructor private để ngăn chặn việc tạo ra thể hiện từ bên ngoài.
     */
    private SerializedSingleton() {
    }

    /**
     * Lớp tĩnh bên trong để khởi tạo thể hiện Singleton (lazy initialization).
     */
    private static class SingletonHelper {
        /**
         * Thể hiện duy nhất của lớp `SerializedSingleton`.
         */
        private static final SerializedSingleton instance = new SerializedSingleton();
    }

    /**
     * Phương thức tĩnh để lấy thể hiện duy nhất của lớp `SerializedSingleton`.
     *
     * @return Thể hiện duy nhất của lớp `SerializedSingleton`.
     */
    public static SerializedSingleton getInstance() {
        return SingletonHelper.instance;
    }

    /**
     * Phương thức để bảo vệ Singleton khỏi bị phá vỡ trong quá trình deserialization.
     *
     * @return Thể hiện duy nhất của lớp `SerializedSingleton`.
     */
    protected Object readResolve() {
        return getInstance();
    }
}