package iuh.fit.se.abstract_factory_pattern.factory.model;

import iuh.fit.se.factory_pattern.model.Computer;

/**
 * Interface `ComputerAbstractFactory` định nghĩa một abstract factory (xưởng trừu tượng)
 * cho việc tạo ra các đối tượng `Computer`.
 *
 * <p>Interface này là một phần của mẫu thiết kế Abstract Factory Pattern, giúp định nghĩa
 * một interface cho việc tạo ra các họ đối tượng liên quan mà không cần chỉ định các
 * lớp cụ thể. Các Concrete Factory (lớp xưởng cụ thể) sẽ triển khai interface này
 * để tạo ra các loại `Computer` khác nhau (ví dụ: `PC` hoặc `Server`).</p>
 *
 * <p>Phương thức `createComputer()` được định nghĩa trong interface này, cho phép các
 * Concrete Factory tạo ra các thể hiện của lớp `Computer`.</p>
 */
public interface ComputerAbstractFactory {
    /**
     * Tạo ra một thể hiện của lớp `Computer`.
     *
     * @return Thể hiện của lớp `Computer`.
     */
    public Computer createComputer();
}