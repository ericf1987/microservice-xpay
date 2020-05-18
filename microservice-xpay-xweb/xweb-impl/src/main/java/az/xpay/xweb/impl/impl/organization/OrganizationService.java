package az.xpay.xweb.impl.impl.organization;

import az.xpay.xweb.api.domain.organization.OrganizationDM;
import az.xpay.xweb.api.service.organization.IOrgService;
import az.xpay.xweb.impl.mapper.organization.OrganizationMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Eric F
 * @version 1.0
 * @date 2020/5/18 10:44
 */
@Service
public class OrganizationService implements IOrgService {

    @Autowired
    OrganizationMapper organizationMapper;

    @Override
    public List<OrganizationDM> getOrgnazitionList() {
        return organizationMapper.getOrgnazitionList();
    }
}
