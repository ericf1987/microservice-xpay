package az.xpay.xweb.impl.impl.device;

import az.xpay.xweb.api.domain.device.DeviceDM;
import az.xpay.xweb.api.service.device.IDeviceService;
import az.xpay.xweb.impl.mapper.device.DeviceMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Eric F
 * @version 1.0
 * @date 2020/5/18 10:43
 */
@Service
public class DeviceService implements IDeviceService {

    @Autowired
    DeviceMapper deviceMapper;

    @Override
    public List<DeviceDM> getDeviceList() {
        return deviceMapper.getDeviceList();
    }
}
