package org.jlxy.cmm.utils;

import java.util.List;

/**
 * Created by ORCHID on 2017/3/25.
 */
public class Result {
    private Page page;
    private List list;

    public Result(Page page, List list) {
        this.page = page;
        this.list = list;
    }

    public Result() {
    }

    public Page getPage() {
        return page;
    }

    public void setPage(Page page) {
        this.page = page;
    }

    public List getList() {
        return list;
    }

    public void setList(List list) {
        this.list = list;
    }
}
