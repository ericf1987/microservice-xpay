package az.xpay.xweb.common.statusmachine.base;

/**
 * 审批节点
 *
 * @author Eric F
 * @version 1.0
 * @date 2020/6/12 14:07
 */
public enum ApprovalNode {

    //个人提交申请
    APPLY("apply", "申请"),

    LEADER_PERMITING("leaderPermiting", "直接领导审批中"),

    LEADER_PERMIT_AGREE("leaderPermitAgree", "直接领导同意"),

    LEADER_PERMIT_DISAGREE("leaderPermitDisagree", "直接领导不同意"),

    LEADER_PERMIT_MODIFY("leaderPermitModify", "直接领导驳回"),


    //HR审批
    HR_PERMITING("hrPermiting", "人事主管审批中"),

    HR_PERMIT_AGREE("hrPermitAgree", "人事主管同意"),

    HR_PERMIT_DISAGREE("hrPermitDisagree", "人事主管不同意"),

    HR_PERMIT_MODIFY("hrPermitModify", "人事主管驳回"),


    //CEO审批
    CEO_PERMITING("ceoPermiting", "总裁审批中"),

    CEO_PERMIT_AGREE("ceoPermitAgree", "总裁同意"),

    CEO_PERMIT_DISAGREE("ceoPermitDisagree", "总裁不同意"),

    CEO_PERMIT_MODIFY("ceoPermitModify", "总裁驳回"),

    //审批结果
    APPROVAL_PASS("approvalOK", "审核通过"),

    APPROVAL_REJECT("approvalFailure", "审核不通过");

    private String status;
    private String memo;

    ApprovalNode(String status, String memo) {
        this.status = status;
        this.memo = memo;
    }

    @Override
    public String toString() {
        return "ApprovalNode{" +
                "status='" + status + '\'' +
                ", memo='" + memo + '\'' +
                '}';
    }

    public String getStatus() {
        return status;
    }

    public String getMemo() {
        return memo;
    }

    public boolean equals(ApprovalNode node) {
        return this.status.equals(node.getStatus()) && this.memo.equals(node.getMemo());
    }
}
