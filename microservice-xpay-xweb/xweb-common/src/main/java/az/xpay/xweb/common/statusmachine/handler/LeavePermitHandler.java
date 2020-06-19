package az.xpay.xweb.common.statusmachine.handler;

import az.xpay.xweb.common.statusmachine.LeavePermit;
import az.xpay.xweb.common.statusmachine.StatusHandlerRegistry;
import com.google.common.eventbus.AllowConcurrentEvents;
import com.google.common.eventbus.Subscribe;

/**
 * @author Eric F
 * @version 1.0
 * @date 2020/6/18 15:58
 */
public class LeavePermitHandler {

    @Subscribe
    @AllowConcurrentEvents
    public void handler(LeavePermit leavePermit) {
        getStatusHandler(leavePermit).handler(leavePermit);
    }

    /**
     * 根据请假单获取 StatusHandler
     *
     * @param leavePermit 请假业务
     * @return
     */
    public static StatusHandler getStatusHandler(LeavePermit leavePermit) {
        return StatusHandlerRegistry.acquireStatusHandler(leavePermit.getLeaveItem(), leavePermit.getApprovalNode());
    }

}
