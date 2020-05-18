package az.xpay.xweb.api.domain.organization;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 学校 机构领域
 * @author Eric F
 * @version 1.0
 * @date 2020/5/18 10:12
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class OrganizationDM {
    private String id;
    private String wxOrgid;
    private String schoolName;
}
