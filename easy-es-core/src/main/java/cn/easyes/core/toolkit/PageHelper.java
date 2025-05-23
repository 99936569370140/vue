package cn.easyes.core.toolkit;

import cn.easyes.core.biz.EsPageInfo;
import cn.easyes.core.biz.SAPageInfo;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * 分页工具
 * <p>
 * Copyright © 2022 xpc1024 All Rights Reserved
 **/
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class PageHelper {
    /**
     * 获取分页信息
     *
     * @param list     数据列表
     * @param total    总数
     * @param pageNum  当前页
     * @param pageSize 总页数
     * @param <T>      数据类型
     * @return 分页信息
     */
    public static <T> EsPageInfo<T> getPageInfo(List<T> list, Long total, Integer pageNum, Integer pageSize) {
        EsPageInfo<T> pageInfo = new EsPageInfo<>(list);
        pageInfo.setTotal(total);
        pageInfo.setPageNum(pageNum);
        pageInfo.setPageSize(pageSize);
        pageInfo.setPages((int) (total % pageSize > 0 ? total / pageSize + 1 : total / pageSize));
        // 计算导航页
        pageInfo.calcNavigatePageNums();
        // 计算前后页,第一页,最后一页
        pageInfo.calcPage();
        // 判断页面边界
        pageInfo.judgePageBoundary();
        return pageInfo;
    }

    /**
     * 获取SearchAfter分页信息
     *
     * @param list            数据列表
     * @param total           总数
     * @param searchAfter     当前页
     * @param nextSearchAfter 下一页
     * @param pageSize        总页数
     * @param <T>             数据类型
     * @return 分页信息
     */
    public static <T> SAPageInfo<T> getSAPageInfo(List<T> list, Long total, List<Object> searchAfter
            , List<Object> nextSearchAfter, Integer pageSize) {
        SAPageInfo<T> saPageInfo = new SAPageInfo<>();
        saPageInfo.setSearchAfter(searchAfter);
        saPageInfo.setNextSearchAfter(nextSearchAfter);
        saPageInfo.setList(list);
        saPageInfo.setTotal(total);
        saPageInfo.setPageSize(pageSize);
        saPageInfo.setPages((int) (total % pageSize > 0 ? total / pageSize + 1 : total / pageSize));
        return saPageInfo;
    }
}
