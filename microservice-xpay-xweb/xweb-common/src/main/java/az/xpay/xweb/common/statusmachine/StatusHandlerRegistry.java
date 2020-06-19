package az.xpay.xweb.common.statusmachine;

import az.xpay.xweb.common.statusmachine.base.ApprovalNode;
import az.xpay.xweb.common.statusmachine.base.LeaveItem;
import az.xpay.xweb.common.statusmachine.handler.StatusHandler;

import java.text.MessageFormat;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author Eric F
 * @version 1.0
 * @date 2020/6/18 15:32
 */
public class StatusHandlerRegistry {

    private static Map<String, StatusHandler> statusHandlerMap;

    static {
        statusHandlerMap = new ConcurrentHashMap<>();
    }

    private StatusHandlerRegistry() {

    }

    /**
     * 注册状态处理类
     *
     * @param leaveItem    请假事项
     * @param approvalNode 审批节点
     * @return
     */
    private static String getKey(LeaveItem leaveItem, ApprovalNode approvalNode) {
        return MessageFormat.format("请假事项：{0}, 审批节点：{1}", leaveItem.getType(), approvalNode.getStatus());
    }

    public static void registryStatusHandler(LeaveItem leaveItem, ApprovalNode approvalNode, StatusHandler statusHandler) {
        statusHandlerMap.put(getKey(leaveItem, approvalNode), statusHandler);
    }

    public static StatusHandler acquireStatusHandler(LeaveItem leaveItem, ApprovalNode approvalNode) {
        return statusHandlerMap.get(getKey(leaveItem, approvalNode));
    }

    public static void main(String[] args) {
        String key = getKey(LeaveItem.ANNUAL_LEAVE, ApprovalNode.APPROVAL_PASS);
        System.out.println(key);
    }
}
