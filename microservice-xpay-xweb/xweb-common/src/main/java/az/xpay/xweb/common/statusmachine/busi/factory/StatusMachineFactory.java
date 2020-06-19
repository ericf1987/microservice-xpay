package az.xpay.xweb.common.statusmachine.busi.factory;


import az.xpay.xweb.common.statusmachine.base.LeaveItem;
import az.xpay.xweb.common.statusmachine.busi.AbstractStatusMachine;
import az.xpay.xweb.common.statusmachine.busi.ApprovalStatusMachine;

import static az.xpay.xweb.common.statusmachine.base.ApprovalNode.APPLY;
import static az.xpay.xweb.common.statusmachine.base.ApprovalResult.AGREE;
import static az.xpay.xweb.common.statusmachine.base.LeaveItem.SICK_LEAVE;

/**
 * 状态机工厂类
 * @author Eric F
 * @version 1.0
 * @date 2020/6/12 18:18
 */
public class StatusMachineFactory {

    private StatusMachineFactory(){}

    public static ApprovalStatusMachine getStatusMachine(LeaveItem leaveItem){
        switch (leaveItem){
            case ANNUAL_LEAVE:
                return new AnnualLeaveStatusMachine();
            case CASUAL_LEAVE:
                return new CasualLeaveStatusMachine();
            case SICK_LEAVE:
                return new SickLeaveStatusMachine();
            case MARRIAGE_LEAVE:
                return new MarriageLeaverStatusMachine();
        }

        return null;
    }

    public static void main(String[] args) {
        AbstractStatusMachine statusMachine = (AbstractStatusMachine) getStatusMachine(SICK_LEAVE);
        statusMachine.testFullApprovalProcess(APPLY, AGREE);
    }

}
