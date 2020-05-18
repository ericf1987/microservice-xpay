package az.xpay.xweb.api.service.organization;

import az.xpay.xweb.api.domain.organization.OrganizationDM;

import java.util.List;

/**
 * @author Eric F
 * @version 1.0
 * @date 2020/5/18 10:29
 */
public interface IOrgService {

    List<OrganizationDM> getOrgnazitionList();

}
