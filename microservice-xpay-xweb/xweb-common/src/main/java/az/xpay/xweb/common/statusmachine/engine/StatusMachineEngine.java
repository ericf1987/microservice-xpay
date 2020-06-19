package az.xpay.xweb.common.statusmachine.engine;

import az.xpay.xweb.common.statusmachine.LeavePermit;
import az.xpay.xweb.common.statusmachine.handler.LeavePermitHandler;
import com.google.common.eventbus.EventBus;

/**
 * @author Eric F
 * @version 1.0
 * @date 2020/6/18 15:51
 */
public class StatusMachineEngine {

    private static EventBus eventBus;

    static {
        eventBus = new EventBus();
    }

    public static void post(LeavePermit leavePermit){
        eventBus.post(leavePermit);
    }

    public static void addListener(LeavePermitHandler leavePermitHandler){
        eventBus.register(leavePermitHandler);
    }

}
