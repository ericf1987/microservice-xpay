package az.xpay.xweb.common.statusmachine;

import az.xpay.xweb.common.statusmachine.base.ApprovalNode;
import az.xpay.xweb.common.statusmachine.base.ApprovalResult;
import az.xpay.xweb.common.statusmachine.base.LeaveItem;
import lombok.Data;

/**
 * 请假业务
 * @author Eric F
 * @version 1.0
 * @date 2020/6/18 15:29
 */
@Data
public class LeavePermit {

    /**
     * 审批节点
     */
    private ApprovalNode approvalNode;

    /**
     * 请假事项
     */
    private LeaveItem leaveItem;

    /**
     * 审批结果
     */
    private ApprovalResult approvalResult;

    /**
     * 用户
     */
    private String userId;


}
