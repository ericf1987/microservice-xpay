package az.xpay.xweb.common.statusmachine.busi.factory;


import az.xpay.xweb.common.statusmachine.base.ApprovalNode;
import az.xpay.xweb.common.statusmachine.base.ApprovalResult;
import az.xpay.xweb.common.statusmachine.busi.AbstractStatusMachine;

import static az.xpay.xweb.common.statusmachine.base.ApprovalNode.*;
import static az.xpay.xweb.common.statusmachine.base.ApprovalPosition.HR;
import static az.xpay.xweb.common.statusmachine.base.ApprovalPosition.LEADER;

/**
 * 事假申请流程状态机
 *
 * @author Eric F
 * @version 1.0
 * @date 2020/6/12 18:05
 */
public class CasualLeaveStatusMachine extends AbstractStatusMachine {

    @Override
    public ApprovalNode getNextNode(ApprovalNode node, ApprovalResult approvalResult) {
        switch (node) {
            //发起申请后 走向直接领导审批中
            case APPLY:
                return LEADER_PERMITING;
            case LEADER_PERMITING:
                //直接领导审批中 根据审批结果条转到  直接领导审批结果
                return getNode(approvalResult, LEADER);
            case LEADER_PERMIT_AGREE:
                // 直接领导审批 根据结果 跳转到 HR审批中
                return HR_PERMITING;
            case LEADER_PERMIT_DISAGREE:
                return LEADER_PERMIT_DISAGREE;

            case HR_PERMITING:
                return getNode(approvalResult, HR);
            case HR_PERMIT_AGREE:
                return APPROVAL_PASS;
            case HR_PERMIT_DISAGREE:
                return HR_PERMIT_DISAGREE;

        }

        return null;
    }
}
