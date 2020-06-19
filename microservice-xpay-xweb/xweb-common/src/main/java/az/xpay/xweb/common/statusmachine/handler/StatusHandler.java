package az.xpay.xweb.common.statusmachine.handler;

import az.xpay.xweb.common.statusmachine.LeavePermit;
import az.xpay.xweb.common.statusmachine.busi.factory.StatusMachineFactory;
import az.xpay.xweb.common.statusmachine.engine.StatusMachineEngine;

import java.util.Objects;

/**
 * @author Eric F
 * @version 1.0
 * @date 2020/6/18 15:28
 */
public abstract class StatusHandler implements Handler {


    public void before(LeavePermit leavePermit) {

    }

    public void handler(LeavePermit leavePermit) {
        before(leavePermit);
        doHandler(leavePermit);
        after(leavePermit);
    }

    protected abstract void doHandler(LeavePermit leavePermit);

    public void after(LeavePermit leavePermit) {

    }

    public void getNextStatusHandler(LeavePermit leavePermit) {
        leavePermit.setApprovalNode(Objects.requireNonNull(StatusMachineFactory.getStatusMachine(leavePermit.getLeaveItem()))
                .getNextNode(leavePermit.getApprovalNode(), leavePermit.getApprovalResult()));
        //状态机引擎去处理请假业务
        StatusMachineEngine.post(leavePermit);
    }

}
