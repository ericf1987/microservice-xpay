package az.xpay.xweb.common.statusmachine.base;

/**
 * 审批结果
 *
 * @author Eric F
 * @version 1.0
 * @date 2020/6/12 11:51
 */
public enum ApprovalResult {

    AGREE("agree", "同意"),
    DISAGREE("disagree", "不同意"),
    MODIFY("modify", "修改");

    private String type;

    private String memo;

    ApprovalResult(String type, String memo) {
        this.type = type;
        this.memo = memo;
    }
}
