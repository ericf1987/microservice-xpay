package az.xpay.xweb.impl.impl.organization;

import az.xpay.XwebImplBaseTest;
import az.xpay.xweb.api.domain.organization.OrganizationDM;
import az.xpay.xweb.api.service.organization.IOrgService;
import az.xpay.xweb.impl.mapper.organization.OrganizationMapper;
import az.xpay.xweb.impl.util.PaginationWrapper;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author Eric F
 * @version 1.0
 * @date 2020/5/18 14:19
 */
@Slf4j
class OrganizationServiceTest extends XwebImplBaseTest {

    @Autowired
    IOrgService orgService;


    @Test
    void getOrgnazitionList() {

        PaginationWrapper<OrganizationDM> p = () -> orgService.getOrgnazitionList();

        List<OrganizationDM> organizationDMList = p.doPagination(1, 20);

        log.info("查询学校列表: {}", organizationDMList.toString());

    }
}