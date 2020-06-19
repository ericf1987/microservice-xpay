package az.xpay.xweb.common.statusmachine.base;

/**
 * 公司请假事项
 * @author Eric F
 * @version 1.0
 * @date 2020/6/12 11:47
 */
public enum LeaveItem {

    ANNUAL_LEAVE("annual_leave", "年假"),
    CASUAL_LEAVE("casual_leave", "事假"),
    SICK_LEAVE("medical_leave", "病假"),
    MARRIAGE_LEAVE("marriage_leave", "婚假");

    private String type;
    private String memo;

    LeaveItem(String type, String memo) {
        this.type = type;
        this.memo = memo;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getMemo() {
        return memo;
    }

    public void setMemo(String memo) {
        this.memo = memo;
    }
}
