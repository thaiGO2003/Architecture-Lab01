package iuh.fit.se.abstract_factory_pattern.factory.abstract_factory;

import iuh.fit.se.abstract_factory_pattern.factory.model.ComputerAbstractFactory;
import iuh.fit.se.factory_pattern.model.Computer;

/**
 * Lớp `ComputerFactory` là một factory class (lớp xưởng) được sử dụng để tạo ra các thể hiện
 * của lớp `Computer` (máy tính) thông qua một Abstract Factory được cung cấp.
 *
 * <p>Lớp này triển khai một phần của mẫu thiết kế Abstract Factory Pattern, giúp tách biệt
 * việc tạo ra các đối tượng `Computer` khỏi logic sử dụng chúng. Nó cho phép client code
 * tạo ra các đối tượng `Computer` mà không cần biết cụ thể lớp con nào được tạo ra,
 * chỉ cần biết Abstract Factory nào được sử dụng.</p>
 *
 * <p>Phương thức `getComputer()` là một phương thức tĩnh, cho phép truy cập trực tiếp
 * mà không cần tạo thể hiện của lớp `ComputerFactory`. Phương thức này nhận vào một
 * đối tượng `ComputerAbstractFactory` và gọi phương thức `createComputer()` của nó
 * để tạo ra một thể hiện của lớp `Computer`.</p>
 *
 * <p>Cách sử dụng:</p>
 * <pre>{@code
 * Computer pc = ComputerFactory.getComputer(new PCFactory("8GB", "500GB", "3.2GHz"));
 * Computer server = ComputerFactory.getComputer(new ServerFactory("32GB", "1TB", "4.0GHz"));
 * }</pre>
 */
public class ComputerFactory {
    /**
     * Phương thức tĩnh để tạo ra một thể hiện của lớp `Computer` thông qua Abstract Factory.
     *
     * @param factory Abstract Factory được sử dụng để tạo ra đối tượng `Computer`.
     * @return Thể hiện của lớp `Computer`.
     */
    public static Computer getComputer(ComputerAbstractFactory factory) {
        return factory.createComputer();
    }
}