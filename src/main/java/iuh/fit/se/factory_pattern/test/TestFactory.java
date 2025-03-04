package iuh.fit.se.factory_pattern.test;

import iuh.fit.se.factory_pattern.factory.ComputerFactory;
import iuh.fit.se.factory_pattern.model.Computer;
import iuh.fit.se.factory_pattern.model.PC;
import iuh.fit.se.factory_pattern.model.Server;

/**
 * Lớp `TestFactory` dùng để kiểm tra và minh họa việc sử dụng mẫu thiết kế Factory Pattern
 * thông qua lớp `ComputerFactory`.
 *
 * <p>Lớp này tạo ra các đối tượng `Computer` (cụ thể là `PC` và `Server`) bằng cách sử dụng
 * phương thức `getComputer()` của `ComputerFactory`. Sau đó, nó in ra thông tin cấu hình
 * của các đối tượng đã tạo.</p>
 *
 * <p>Mục đích chính của lớp này là để chứng minh cách Factory Pattern giúp tách biệt việc
 * tạo ra đối tượng khỏi logic sử dụng đối tượng, làm cho code dễ bảo trì và mở rộng hơn.</p>
 */
public class TestFactory {
    /**
     * Phương thức `main` là điểm bắt đầu thực thi của chương trình.
     *
     * @param args Mảng các tham số dòng lệnh (không sử dụng trong ví dụ này).
     */
    public static void main(String[] args) {
        // Tạo đối tượng Computer (thực tế là PC) bằng Factory
        Computer computer = ComputerFactory.getComputer("pc", "2 GB", "500 GB", "2.4 GHz");

        // Tạo đối tượng Server bằng Factory và ép kiểu
        Server server = (Server) ComputerFactory.getComputer("server", "16 GB", "1 TB", "2.9 GHz");

        // Tạo đối tượng PC bằng Factory và ép kiểu
        PC pc = (PC) ComputerFactory.getComputer("pc", "1 GB", "1 TB", "2.9 GHz");

        // In ra thông tin cấu hình của các đối tượng
        System.out.println("Factory Computor Config:" + computer);
        System.out.println("Factory Server Config:" + server);
        System.out.println("Factory PC Config:" + pc);
    }
}