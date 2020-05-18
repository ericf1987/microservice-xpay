package az.xpay.xweb.impl.mapper.organization;

import az.xpay.xweb.api.domain.organization.OrganizationDM;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author Eric F
 * @version 1.0
 * @date 2020/5/18 10:46
 */
@Mapper
public interface OrganizationMapper {

    /**
     * 返回学校 机构列表
     *
     * @return
     */
    List<OrganizationDM> getOrgnazitionList();

}
