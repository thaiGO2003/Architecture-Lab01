package iuh.fit.se.abstract_factory_pattern.factory.abstract_factory;

import iuh.fit.se.abstract_factory_pattern.factory.model.ComputerAbstractFactory;
import iuh.fit.se.factory_pattern.model.Computer;
import iuh.fit.se.factory_pattern.model.Server;

/**
 * Lớp `ServerFactory` là một Concrete Factory (lớp xưởng cụ thể) trong mẫu thiết kế Abstract Factory Pattern,
 * được sử dụng để tạo ra các thể hiện của lớp `Server` (máy chủ).
 *
 * <p>Lớp này triển khai interface `ComputerAbstractFactory`, cho phép nó được sử dụng
 * để tạo ra các đối tượng `Computer` thông qua lớp `ComputerFactory`. Nó chịu trách nhiệm
 * tạo ra các đối tượng `Server` với cấu hình cụ thể được cung cấp thông qua constructor.</p>
 *
 * <p>Lớp này có các thuộc tính riêng tư `ram`, `hdd` và `cpu` để lưu trữ thông tin cấu hình.
 * Constructor của lớp nhận các tham số tương ứng để khởi tạo các thuộc tính này.</p>
 *
 * <p>Phương thức `createComputer()` được triển khai từ interface `ComputerAbstractFactory`
 * và trả về một thể hiện của lớp `Server` với các thông số cấu hình đã được lưu trữ.</p>
 *
 * <p>Cách sử dụng:</p>
 * <pre>{@code
 * Computer server = ComputerFactory.getComputer(new ServerFactory("32GB", "1TB", "4.0GHz"));
 * }</pre>
 */
public class ServerFactory implements ComputerAbstractFactory {
    private String ram;
    private String hdd;
    private String cpu;

    /**
     * Constructor để khởi tạo một đối tượng `ServerFactory` với các thông số cấu hình.
     *
     * @param ram Dung lượng RAM.
     * @param hdd Dung lượng HDD.
     * @param cpu Tốc độ CPU.
     */
    public ServerFactory(String ram, String hdd, String cpu) {
        this.ram = ram;
        this.hdd = hdd;
        this.cpu = cpu;
    }

    /**
     * Tạo ra một thể hiện của lớp `Server` với các thông số cấu hình đã được lưu trữ.
     *
     * @return Thể hiện của lớp `Server`.
     */
    @Override
    public Computer createComputer() {
        return new Server(ram, hdd, cpu);
    }
}