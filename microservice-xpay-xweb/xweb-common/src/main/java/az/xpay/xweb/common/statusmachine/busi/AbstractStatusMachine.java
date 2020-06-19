package az.xpay.xweb.common.statusmachine.busi;
import az.xpay.xweb.common.statusmachine.base.ApprovalNode;
import az.xpay.xweb.common.statusmachine.base.ApprovalPosition;
import az.xpay.xweb.common.statusmachine.base.ApprovalResult;

import static az.xpay.xweb.common.statusmachine.base.ApprovalNode.*;
import static az.xpay.xweb.common.statusmachine.base.ApprovalPosition.HR;
import static az.xpay.xweb.common.statusmachine.base.ApprovalPosition.LEADER;

/**
 * 状态机抽象类
 *
 * @author Eric F
 * @version 1.0
 * @date 2020/6/12 18:06
 */
public abstract class AbstractStatusMachine implements ApprovalStatusMachine {

    @Override
    public abstract ApprovalNode getNextNode(ApprovalNode node, ApprovalResult approvalResult);

    /**
     * @param result 不同岗位的审批结果 跳转至不同的审批节点
     * @return 返回结果
     */
    public ApprovalNode getNode(ApprovalResult result, ApprovalPosition position) {
        switch (result) {
            case AGREE:
                return LEADER.equals(position) ? LEADER_PERMIT_AGREE :
                        HR.equals(position) ? HR_PERMIT_AGREE : CEO_PERMIT_AGREE;
            case DISAGREE:
                return LEADER.equals(position) ? LEADER_PERMIT_DISAGREE :
                        HR.equals(position) ? HR_PERMIT_DISAGREE : CEO_PERMIT_DISAGREE;
            case MODIFY:
                return LEADER.equals(position) ? LEADER_PERMIT_MODIFY :
                        HR.equals(position) ? HR_PERMIT_MODIFY : CEO_PERMIT_MODIFY;
            default:
                throw new RuntimeException("不支持该审批结果类型");
        }
    }

    /**
     * 递归调用 实现状态机全流程的测试
     *
     * @param node   当前审批节点
     * @param result 审批结果
     * @return
     */
    public ApprovalNode testFullApprovalProcess(ApprovalNode node, ApprovalResult result) {
        //跳转至下一个节点
        ApprovalNode nextNode = getNextNode(node, result);
        System.out.println(nextNode);
        if (!APPROVAL_PASS.equals(nextNode)) {
            nextNode = testFullApprovalProcess(nextNode, result);
        } else {
            System.out.println("执行结束!");
        }
        return nextNode;
    }

}
