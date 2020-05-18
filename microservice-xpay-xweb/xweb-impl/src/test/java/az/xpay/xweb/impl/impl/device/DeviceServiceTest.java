package az.xpay.xweb.impl.impl.device;

import az.xpay.XwebImplBaseTest;
import az.xpay.xweb.api.domain.device.DeviceDM;
import az.xpay.xweb.api.service.device.IDeviceService;
import az.xpay.xweb.impl.util.PaginationWrapper;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author Eric F
 * @version 1.0
 * @date 2020/5/18 10:49
 */
@Slf4j
class DeviceServiceTest extends XwebImplBaseTest {

    @Autowired
    IDeviceService deviceService;

    @Test
    void getDeviceList() {

        PaginationWrapper<DeviceDM> p = () -> deviceService.getDeviceList();

        List<DeviceDM> deviceDMList = p.doPagination(1, 10);

        log.info("设备列表：{}", deviceDMList.toString());

    }
}