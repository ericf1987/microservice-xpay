package az.xpay.xweb.impl.mapper.device;

import az.xpay.xweb.api.domain.device.DeviceDM;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author Eric F
 * @version 1.0
 * @date 2020/5/18 10:45
 */
@Mapper
public interface DeviceMapper {


    /**
     * 获取设备信息列表
     *
     * @return
     */
    List<DeviceDM> getDeviceList();

}
