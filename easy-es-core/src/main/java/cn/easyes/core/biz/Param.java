package cn.easyes.core.biz;

import cn.easyes.common.enums.EsQueryTypeEnum;
import cn.easyes.core.toolkit.Tree;
import lombok.Data;

/**
 * 查询参数树
 * <p>
 * Copyright © 2022 xpc1024 All Rights Reserved
 **/
@Data
public class Param extends Tree {
    /**
     * 上一节点类型
     */
    private EsQueryTypeEnum prevQueryType;
    /**
     * 节点类型
     */
    private EsQueryTypeEnum queryTypeEnum;
    /**
     * 是否nested嵌套查询类型
     */
    private boolean nested;
    /**
     * 字段名称
     */
    private String column;
    /**
     * 字段值
     */
    private Object val;
    /**
     * 权重
     */
    private Float boost;

    /**
     * 多用途拓展字段1
     */
    private Object ext1;

    /**
     * 多用途拓展字段2
     */
    private Object ext2;
    /**
     * 多用途拓展字段3
     */
    private Object ext3;
    /**
     * 多用途拓展字段4
     */
    private Object ext4;

    /**
     * 多字段名称
     */
    private String[] columns;

    /**
     * 字段是否需要拼接.keyword后缀 默认不需要
     */
    private boolean needAddKeywordSuffix;
}
