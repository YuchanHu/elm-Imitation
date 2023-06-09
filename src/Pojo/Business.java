package Pojo;

/**
 * 商家类
 */

public class Business {
    private int businessId;
    private String password;
    private String businessName;
    private String businessAddress;
    private String businessExplain;
    private Double starPrice;

    public Double getStarPrice() {
        return starPrice;
    }

    public void setStarPrice(Double starPrice) {
        this.starPrice = starPrice;
    }

    public Double getDeliveryPrice() {
        return deliveryPrice;
    }

    public void setDeliveryPrice(Double deliveryPrice) {
        this.deliveryPrice = deliveryPrice;
    }

    private Double deliveryPrice;

//    @Override
//    public String toString() {
//        return "Business{" +
//                "businessId=" + businessId +
//                ", password='" + password + '\'' +
//                ", businessName='" + businessName + '\'' +
//                ", businessAddress='" + businessAddress + '\'' +
//                ", businessExplain='" + businessExplain + '\'' +
//                ", starPrice=" + starPrice +
//                ", deliveryPrice=" + deliveryPrice +
//                '}';
//    }

    /**
     * 使用规范化表格
     *
     * @return 输出选择后的表格结果内容
     */
    public String toString() {
        String format = "| %-10s | %-10s | %-20s | %-20s | %-20s | %-10s | %-10s |%n";

        // 表格头部

        String sb = "\n" +
                String.format(format, "ID", "Password", "BusinessName", "BusinessAddress", "BusinessExplain", "SatrtPrice", "DeliveryPrice") +
                String.format(format, "-----------", "-----------", "--------------------", "--------------------", "--------------------", "----------", "----------") +

                // 表格内容
                String.format(format, businessId, password, businessName, businessAddress, businessExplain, starPrice, deliveryPrice) +

                // 表格底部
                String.format(format, "-----------", "-----------", "--------------------", "--------------------", "--------------------", "----------", "----------");
        return sb;
    }

    public Business() {

    }

    public Business(int businessId, String password, String businessName, String businessAddress, String businessExplain, double starPrice, double deliveryPrice) {
        this.businessId = businessId;
        this.password = password;
        this.businessName = businessName;
        this.businessAddress = businessAddress;
        this.businessExplain = businessExplain;
        this.starPrice = starPrice;
        this.deliveryPrice = deliveryPrice;
    }

    public int getBusinessId() {
        return businessId;
    }

    public void setBusinessId(int businessId) {
        this.businessId = businessId;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getBusinessName() {
        return businessName;
    }

    public void setBusinessName(String businessName) {
        this.businessName = businessName;
    }

    public String getBusinessAddress() {
        return businessAddress;
    }

    public void setBusinessAddress(String businessAddress) {
        this.businessAddress = businessAddress;
    }

    public String getBusinessExplain() {
        return businessExplain;
    }

    public void setBusinessExplain(String businessExplain) {
        this.businessExplain = businessExplain;
    }

}
