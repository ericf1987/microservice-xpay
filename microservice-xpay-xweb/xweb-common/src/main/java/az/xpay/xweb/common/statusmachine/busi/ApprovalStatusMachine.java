package az.xpay.xweb.common.statusmachine.busi;


import az.xpay.xweb.common.statusmachine.base.ApprovalNode;
import az.xpay.xweb.common.statusmachine.base.ApprovalResult;

/**
 * 审核状态跳转状态机 负责控制审批节点的跳转
 * @author Eric F
 * @version 1.0
 * @date 2020/6/12 14:21
 */
public interface ApprovalStatusMachine {

    /**
     *
     * @param node     当前审批节点
     * @param approvalResult 审批结果
     * @return
     */
    ApprovalNode getNextNode(ApprovalNode node, ApprovalResult approvalResult);

}


