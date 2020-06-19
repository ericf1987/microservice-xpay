package az.xpay.xweb.common.statusmachine.base;

/**
 * 审批岗位
 *
 * @author Eric F
 * @version 1.0
 * @date 2020/6/12 14:31
 */
public enum ApprovalPosition {

    LEADER("leader", "直接领导岗位"),

    HR("hr", "人事主管"),

    CEO("ceo", "总裁");

    private String type;

    private String name;

    ApprovalPosition(String type, String name) {
        this.type = type;
        this.name = name;
    }


}
