package iuh.fit.se.factory_pattern.model;

/**
 * Lớp trừu tượng `Computer` định nghĩa các thuộc tính và hành vi chung của các loại máy tính.
 *
 * <p>Lớp này là lớp cha trong mẫu thiết kế Factory Pattern, được sử dụng để tạo ra các loại
 * máy tính khác nhau như PC và Server. Lớp này định nghĩa các phương thức trừu tượng
 * để lấy thông tin về RAM, HDD và CPU của máy tính. Lớp cũng cung cấp một phương thức
 * `toString()` để in ra thông tin cấu hình của máy tính.</p>
 *
 * <p>Các lớp con như `PC` và `Server` sẽ kế thừa từ lớp này và triển khai các phương thức
 * trừu tượng để cung cấp thông tin cụ thể về cấu hình của từng loại máy tính.</p>
 */
public abstract class Computer {
    /**
     * Phương thức trừu tượng để lấy dung lượng RAM của máy tính.
     *
     * @return Dung lượng RAM của máy tính.
     */
    public abstract String getRAM();

    /**
     * Phương thức trừu tượng để lấy dung lượng HDD của máy tính.
     *
     * @return Dung lượng HDD của máy tính.
     */
    public abstract String getHDD();

    /**
     * Phương thức trừu tượng để lấy tốc độ CPU của máy tính.
     *
     * @return Tốc độ CPU của máy tính.
     */
    public abstract String getCPU();

    /**
     * Phương thức để in ra thông tin cấu hình của máy tính.
     *
     * @return Chuỗi chứa thông tin cấu hình của máy tính.
     */
    @Override
    public String toString() {
        return "RAM= " + this.getRAM() + ", HDD=" + this.getHDD() + ", CPU=" + this.getCPU();
    }
}