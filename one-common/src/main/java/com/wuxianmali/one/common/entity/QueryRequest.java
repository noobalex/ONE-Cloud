package com.wuxianmali.one.common.entity;

import lombok.Data;
import lombok.ToString;
import java.io.Serializable;

@Data
@ToString
public class QueryRequest implements Serializable {

    private static final long serialVersionUID = -5137773629285646L;

    private int pageSize = 10;

    private int pageNum = 1;

    private String field;

    private String order;
}
