package az.xpay.xweb.common.statusmachine.handler;

import az.xpay.xweb.common.statusmachine.LeavePermit;

/**
 * @author Eric F
 * @version 1.0
 * @date 2020/6/18 15:29
 */
public interface Handler {

    void handler(LeavePermit leavePermit);

}
