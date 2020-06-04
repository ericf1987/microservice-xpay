package az.xpay.xweb.api.domain.device;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * 设备领域
 * @author Eric F
 * @version 1.0
 * @date 2020/5/18 10:11
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class DeviceDM implements Serializable {

    private String id;
    private String deviceName;
    private String nickName;
    private String uniqueCode;

    public DeviceDM setId(String id){
        this.id = id;
        return this;
    }

    public DeviceDM setDeviceName(String deviceName) {
        this.deviceName = deviceName;
        return this;
    }

    public DeviceDM setNickName(String nickName) {
        this.nickName = nickName;
        return this;
    }

    public DeviceDM setUniqueCode(String uniqueCode) {
        this.uniqueCode = uniqueCode;
        return this;
    }
}
