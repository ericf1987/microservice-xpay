package az.xpay.xweb.api.service.device;

import az.xpay.xweb.api.domain.device.DeviceDM;

import java.util.List;

/**
 * @author Eric F
 * @version 1.0
 * @date 2020/5/18 10:28
 */
public interface IDeviceService {

    List<DeviceDM> getDeviceList();

}
