package iuh.fit.se.creational_design_patterns.singleton.enum_singleton;

/**
 * Lớp `EnumSingleton` triển khai mẫu thiết kế Singleton bằng cách sử dụng enum (liệt kê).
 *
 * <p>Mẫu thiết kế Singleton đảm bảo rằng một lớp chỉ có một thể hiện duy nhất và cung cấp
 * một điểm truy cập toàn cục đến thể hiện đó. Việc sử dụng enum là một cách tiếp cận
 * an toàn và hiệu quả để triển khai Singleton trong Java, vì nó tự động xử lý các vấn đề
 * về serialization, reflection và thread safety.</p>
 *
 * <p>Lợi ích của việc sử dụng enum cho Singleton:</p>
 * <ul>
 * <li><b>An toàn về serialization:</b> Enum được xử lý đặc biệt bởi JVM trong quá trình
 * serialization và deserialization, đảm bảo rằng không có thể hiện mới nào được tạo ra.</li>
 * <li><b>An toàn về reflection:</b> Enum ngăn chặn việc tạo ra các thể hiện mới thông qua
 * reflection, giúp bảo vệ tính duy nhất của Singleton.</li>
 * <li><b>An toàn về thread:</b> Enum được khởi tạo một lần duy nhất bởi JVM, đảm bảo
 * tính an toàn trong môi trường đa luồng.</li>
 * <li><b>Ngắn gọn và dễ hiểu:</b> Việc sử dụng enum giúp triển khai Singleton một cách
 * ngắn gọn và dễ hiểu hơn so với các phương pháp khác.</li>
 * </ul>
 *
 * <p>Cách sử dụng:</p>
 * <pre>{@code
 * EnumSingleton instance = EnumSingleton.INSTANCE;
 * EnumSingleton.doSomething();
 * }</pre>
 *
 * <p>Trong ví dụ trên, `EnumSingleton.INSTANCE` là thể hiện duy nhất của lớp `EnumSingleton`.
 * Phương thức `doSomething()` là một phương thức tĩnh có thể được gọi trực tiếp thông qua
 * tên lớp.</p>
 */
public enum EnumSingleton {
    /**
     * Thể hiện duy nhất của lớp `EnumSingleton`.
     */
    INSTANCE;

    /**
     * Phương thức tĩnh để thực hiện một hành động nào đó.
     * <p>Phương thức này có thể được sử dụng để thực hiện các thao tác liên quan đến
     * thể hiện Singleton.</p>
     */
    public static void doSomething() {
        System.out.println("Do something");
    }
}