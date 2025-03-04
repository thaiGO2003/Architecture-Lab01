package iuh.fit.se.abstract_factory_pattern.factory.main;

import iuh.fit.se.abstract_factory_pattern.factory.abstract_factory.ComputerFactory;
import iuh.fit.se.abstract_factory_pattern.factory.abstract_factory.PCFactory;
import iuh.fit.se.abstract_factory_pattern.factory.abstract_factory.ServerFactory;
import iuh.fit.se.factory_pattern.model.Computer;

/**
 * Lớp `Main` dùng để kiểm tra và minh họa việc sử dụng mẫu thiết kế Abstract Factory Pattern
 * thông qua lớp `ComputerFactory`, `PCFactory`, và `ServerFactory`.
 *
 * <p>Lớp này tạo ra các đối tượng `Computer` (cụ thể là `PC` và `Server`) bằng cách sử dụng
 * `ComputerFactory.getComputer()` và truyền vào các Concrete Factory (`PCFactory` và `ServerFactory`).
 * Sau đó, nó in ra thông tin cấu hình của các đối tượng đã tạo.</p>
 *
 * <p>Mục đích chính của lớp này là để chứng minh cách Abstract Factory Pattern giúp tạo ra
 * các họ đối tượng liên quan mà không cần biết cụ thể lớp con nào được tạo ra, làm cho
 * code linh hoạt và dễ mở rộng hơn.</p>
 */
public class Main {
    /**
     * Phương thức `main` là điểm bắt đầu thực thi của chương trình.
     *
     * @param args Mảng các tham số dòng lệnh (không sử dụng trong ví dụ này).
     */
    public static void main(String[] args) {
        testAbstractFactory();
    }

    /**
     * Phương thức `testAbstractFactory` tạo ra và in ra thông tin cấu hình của các đối tượng
     * `Computer` sử dụng Abstract Factory Pattern.
     */
    private static void testAbstractFactory() {
        // Tạo đối tượng PC bằng Abstract Factory
        Computer pc = ComputerFactory.getComputer(new PCFactory("2 GB", "500 GB", "2.4 GHz"));

        // Tạo đối tượng Server bằng Abstract Factory
        Computer server = ComputerFactory.getComputer(new ServerFactory("16 GB", "1 TB", "2.9 GHz"));

        // In ra thông tin cấu hình của các đối tượng
        System.out.println("AbstractFactory PC Config:" + pc);
        System.out.println("AbstractFactory Server Config:" + server);
    }
}