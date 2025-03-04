package iuh.fit.se.factory_pattern.model;

/**
 * Lớp `PC` đại diện cho một máy tính cá nhân (Personal Computer) và kế thừa từ lớp trừu tượng `Computer`.
 *
 * <p>Lớp này triển khai các phương thức trừu tượng được định nghĩa trong lớp `Computer`
 * để cung cấp thông tin cụ thể về cấu hình của một máy tính cá nhân, bao gồm dung lượng
 * RAM, dung lượng HDD và tốc độ CPU.</p>
 *
 * <p>Lớp này có các thuộc tính riêng tư `ram`, `hdd` và `cpu` để lưu trữ thông tin cấu hình.
 * Constructor của lớp nhận các tham số tương ứng để khởi tạo các thuộc tính này.</p>
 *
 * <p>Các phương thức `getRAM()`, `getHDD()` và `getCPU()` trả về giá trị của các thuộc
 * tính tương ứng.</p>
 */
public class PC extends Computer {

    private String ram;
    private String hdd;
    private String cpu;

    /**
     * Constructor để khởi tạo một đối tượng `PC` với các thông số cấu hình.
     *
     * @param ram Dung lượng RAM.
     * @param hdd Dung lượng HDD.
     * @param cpu Tốc độ CPU.
     */
    public PC(String ram, String hdd, String cpu) {
        this.ram = ram;
        this.hdd = hdd;
        this.cpu = cpu;
    }

    /**
     * Lấy dung lượng RAM của máy tính cá nhân.
     *
     * @return Dung lượng RAM.
     */
    @Override
    public String getRAM() {
        return this.ram;
    }

    /**
     * Lấy dung lượng HDD của máy tính cá nhân.
     *
     * @return Dung lượng HDD.
     */
    @Override
    public String getHDD() {
        return this.hdd;
    }

    /**
     * Lấy tốc độ CPU của máy tính cá nhân.
     *
     * @return Tốc độ CPU.
     */
    @Override
    public String getCPU() {
        return this.cpu;
    }
}