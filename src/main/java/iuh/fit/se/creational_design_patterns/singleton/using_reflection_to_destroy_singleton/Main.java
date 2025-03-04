package iuh.fit.se.creational_design_patterns.singleton.using_reflection_to_destroy_singleton;
import java.lang.reflect.Constructor; // Import lớp Constructor để sử dụng Reflection

import iuh.fit.se.creational_design_patterns.singleton.eager_initialization.EagerInitializedSingleton;

/**
 * Lớp kiểm thử để kiểm tra việc phá vỡ Singleton bằng Reflection.
 *
 * Mục đích:
 * - Singleton Pattern đảm bảo một lớp chỉ có một thể hiện duy nhất.
 * - Reflection (phản xạ) cho phép truy cập và thay đổi cấu trúc của lớp tại runtime, bao gồm cả các thành phần private.
 * - Lớp này minh họa cách Reflection có thể được sử dụng để tạo nhiều thể hiện của Singleton, vi phạm nguyên tắc của nó.
 * - Việc này giúp chúng ta hiểu rõ hơn về tính bảo mật và sự toàn vẹn của Singleton.
 *
 * Tại sao phải phá vỡ Singleton?
 * - Kiểm thử: Trong một số trường hợp kiểm thử, chúng ta cần tạo nhiều thể hiện để kiểm tra các hành vi khác nhau.
 * - Hiểu rõ hơn: Phá vỡ Singleton giúp chúng ta hiểu rõ hơn về cơ chế hoạt động và cách bảo vệ nó.
 * - Bảo mật: Kiểm tra xem Singleton có thể bị tấn công bằng Reflection hay không.
 *
 * Cách thức hoạt động:
 * 1. Lấy thể hiện Singleton hợp lệ bằng getInstance().
 * 2. Sử dụng Reflection để truy cập constructor private của Singleton.
 * 3. Tạo một thể hiện mới bằng constructor được truy cập qua Reflection.
 * 4. So sánh mã băm (hashCode) của hai thể hiện để kiểm tra xem chúng có khác nhau không.
 *
 * Nếu mã băm khác nhau, chứng tỏ Singleton đã bị phá vỡ.
 */
public class Main {
    public static void main(String[] args) {
        /**
         * Lấy thể hiện của Singleton theo cách thông thường bằng phương thức getInstance().
         */
        EagerInitializedSingleton instanceOne = EagerInitializedSingleton.getInstance();

        /**
         * Biến để lưu thể hiện thứ hai của Singleton khi tạo bằng Reflection.
         */
        EagerInitializedSingleton instanceTwo = null;

        try {
            /**
             * Lấy danh sách tất cả các constructor được khai báo trong lớp EagerInitializedSingleton.
             * Mặc dù Singleton chỉ có một constructor private, ta vẫn có thể lấy nó bằng Reflection.
             */
            Constructor<?>[] constructors = EagerInitializedSingleton.class.getDeclaredConstructors();

            /**
             * Duyệt qua tất cả constructor của lớp (trong trường hợp có nhiều constructor private).
             */
            for (Constructor<?> constructor : constructors) {
                /**
                 * Đặt constructor ở trạng thái có thể truy cập được.
                 * Điều này bỏ qua modifier private và cho phép khởi tạo thể hiện mới.
                 */
                constructor.setAccessible(true);

                /**
                 * Tạo một thể hiện mới của Singleton bằng cách gọi constructor.
                 * Điều này vi phạm nguyên tắc của Singleton, vì ta đang tạo một thể hiện thứ hai.
                 */
                instanceTwo = (EagerInitializedSingleton) constructor.newInstance();
                
                // Chỉ cần phá vỡ Singleton một lần, nên thoát vòng lặp ngay sau khi tạo xong
                break;
            }
        } catch (Exception e) {
            /**
             * In ra lỗi nếu có ngoại lệ xảy ra trong quá trình sử dụng Reflection.
             */
            e.printStackTrace();
        }

        /**
         * In ra mã băm (hashCode) của cả hai thể hiện để kiểm tra xem chúng có giống nhau không.
         * Nếu hai mã băm khác nhau, chứng tỏ Singleton đã bị phá vỡ.
         */
        System.out.println(instanceOne.hashCode()); // Mã băm của thể hiện đầu tiên (được tạo hợp lệ)
        System.out.println(instanceTwo.hashCode()); // Mã băm của thể hiện thứ hai (được tạo bằng Reflection)
    }
}