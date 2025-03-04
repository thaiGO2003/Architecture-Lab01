package iuh.fit.se.factory_pattern.factory;

import iuh.fit.se.factory_pattern.model.*;

/**
 * Lớp `ComputerFactory` là một factory class (lớp xưởng) được sử dụng để tạo ra các thể hiện
 * của lớp `Computer` (máy tính) dựa trên kiểu máy tính được yêu cầu (PC hoặc Server).
 *
 * <p>Lớp này triển khai mẫu thiết kế Factory Pattern, giúp tách biệt việc tạo ra đối tượng
 * khỏi logic sử dụng đối tượng. Điều này giúp code trở nên linh hoạt hơn, dễ bảo trì
 * và dễ mở rộng.</p>
 *
 * <p>Phương thức `getComputer()` là một phương thức tĩnh, cho phép truy cập trực tiếp
 * mà không cần tạo thể hiện của lớp `ComputerFactory`. Phương thức này nhận vào các
 * tham số mô tả cấu hình của máy tính (RAM, HDD, CPU) và kiểu máy tính (PC hoặc Server).
 * Dựa trên kiểu máy tính, phương thức sẽ tạo ra và trả về một thể hiện của lớp `PC`
 * hoặc `Server` tương ứng.</p>
 *
 * <p>Nếu kiểu máy tính không được nhận diện (không phải "PC" hoặc "Server"), phương thức
 * sẽ trả về `null`.</p>
 *
 * <p>Cách sử dụng:</p>
 * <pre>{@code
 * Computer pc = ComputerFactory.getComputer("PC", "8GB", "500GB", "3.2GHz");
 * Computer server = ComputerFactory.getComputer("Server", "32GB", "1TB", "4.0GHz");
 * }</pre>
 */
public class ComputerFactory {
    /**
     * Phương thức tĩnh để tạo ra các thể hiện của lớp `Computer` dựa trên kiểu máy tính.
     *
     * @param type Kiểu máy tính ("PC" hoặc "Server").
     * @param ram  Dung lượng RAM.
     * @param hdd  Dung lượng HDD.
     * @param cpu  Tốc độ CPU.
     * @return Thể hiện của lớp `Computer` (PC hoặc Server) hoặc `null` nếu kiểu không hợp lệ.
     */
    public static Computer getComputer(String type, String ram, String hdd, String cpu) {
        if ("PC".equalsIgnoreCase(type))
            return new PC(ram, hdd, cpu);
        else if ("Server".equalsIgnoreCase(type))
            return new Server(ram, hdd, cpu);
        return null;
    }
}