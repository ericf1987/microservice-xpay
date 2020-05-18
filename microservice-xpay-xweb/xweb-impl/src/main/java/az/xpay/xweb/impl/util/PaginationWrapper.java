package az.xpay.xweb.impl.util;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import java.util.List;

/**
 * @author Eric F
 * @version 1.0
 * @date 2020/5/18 9:49
 */
@FunctionalInterface
public interface PaginationWrapper<T> {

    /**
     * 执行分页查询
     *
     * @param pageNum  当前页
     * @param pageSize 每页记录数
     * @return 查询结果
     */
    default List<T> doPagination(int pageNum, int pageSize) {
        PageHelper.startPage(pageNum, pageSize);

        List<T> result = queryList();

        return new PageInfo<T>(result).getList();
    }

    /**
     * 需要定义的mybatis查询
     *
     * @return 查询结果
     */
    List<T> queryList();

}
