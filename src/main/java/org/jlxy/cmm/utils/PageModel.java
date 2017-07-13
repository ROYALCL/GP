package org.jlxy.cmm.utils;

/**
 * Created by ORCHID on 2017/4/1.
 */

import static org.jlxy.cmm.utils.CmConstants.PAGE_DEFAULT_SIZE;

/**
 * 分页实体
 */
public class PageModel {
    /**
     * 分页总数据条数
     */
    private int RecordCount;
    /**
     * 当前页面
     */
    private int PageIndex;
    /**
     * 每页分多少条数据
     */
    private int PageSize = PAGE_DEFAULT_SIZE ;


    /**
     * 总页数
     */
    private int totalSize;

    public int getRecordCount() {
        this.RecordCount = this.RecordCount <= 0 ? 0 : this.RecordCount;
        return RecordCount;
    }

    public void setRecordCount(int recordCount) {
        this.RecordCount = recordCount;
    }

    public int getPageIndex() {
        this.PageIndex = this.PageIndex <= 0 ? 1 : this.PageIndex;
        /** 判断当前页面是否超过了总页数:如果超过了默认给最后一页作为当前页  */
        this.PageIndex = this.PageIndex >= this.getTotalSize() ? this.getTotalSize() : this.PageIndex;

        return PageIndex;
    }

    public void setPageIndex(int pageIndex) {
        this.PageIndex = pageIndex;
    }

    public int getPageSize() {
        this.PageSize = this.PageSize <= PAGE_DEFAULT_SIZE ? PAGE_DEFAULT_SIZE : this.PageSize;
        return PageSize;
    }

    public void setPageSize(int pageSize) {
        this.PageSize = pageSize;
    }

    public int getTotalSize() {
        if (this.getRecordCount() <= 0) {
            totalSize = 0;
        } else {
            totalSize = (this.getRecordCount() - 1) / this.getPageSize() + 1;
        }
        return totalSize;
    }

    public void setTotalSize(int totalSize) {
        this.totalSize = totalSize;
    }

    public int getFirstLimitParam() {
        return (this.getPageIndex() - 1) * this.getPageSize();
    }
}
