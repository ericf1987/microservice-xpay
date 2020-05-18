package az.xpay.xweb.api.domain.device;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 设备领域
 * @author Eric F
 * @version 1.0
 * @date 2020/5/18 10:11
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class DeviceDM {

    private String id;
    private String deviceName;
    private String nickName;
    private String uniqueCode;

}
