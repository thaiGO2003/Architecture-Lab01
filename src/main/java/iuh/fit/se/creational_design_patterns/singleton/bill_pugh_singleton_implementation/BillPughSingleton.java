package iuh.fit.se.creational_design_patterns.singleton.bill_pugh_singleton_implementation;

/**
 * Mô hình Singleton sử dụng Bill Pugh Singleton Design Pattern.
 * Đây là cách tiếp cận hiệu quả và tối ưu trong Java để đảm bảo
 * chỉ có một instance duy nhất của lớp được tạo ra.
 */
public class BillPughSingleton {

    /**
     * Constructor riêng tư để ngăn chặn việc tạo instance từ bên ngoài lớp.
     */
    private BillPughSingleton() {
    }

    /**
     * Lớp lồng tĩnh giúp tạo instance duy nhất của BillPughSingleton.
     * - Khi lớp SingletonHelper được tải, INSTANCE sẽ được khởi tạo một cách thread-safe.
     * - Điều này tận dụng lazy initialization và đảm bảo rằng instance chỉ được tạo khi cần.
     */
    private static class SingletonHelper {
        /**
         * Instance duy nhất của BillPughSingleton, chỉ được khởi tạo một lần.
         */
        private static final BillPughSingleton INSTANCE = new BillPughSingleton();
    }

    /**
     * Phương thức trả về instance duy nhất của BillPughSingleton.
     * - INSTANCE chỉ được tạo khi phương thức này được gọi lần đầu tiên.
     * - Đây là cách tiếp cận thread-safe và không cần sử dụng từ khóa synchronized.
     * 
     * @return instance duy nhất của BillPughSingleton
     */
    public static BillPughSingleton getInstance() {
        return SingletonHelper.INSTANCE;
    }
}
