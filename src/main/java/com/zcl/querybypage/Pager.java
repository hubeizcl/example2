package com.zcl.querybypage;


/**
 * 分页描述信息
 *
 * @author dendy
 */
public class Pager {
    // 每一页的显示条数
    private int showCount;
    // 总的页数
    private int totalPage;
    // 查询的数据总条数
    private int totalResult;
    // 当前页
    private int currentPage;
    // 从第几条开始获取数据
    @SuppressWarnings("unused")
    private int currentResult;

    public Pager() {
        this(1);
    }

    public Pager(int currentPage) {
        // 默认每页显示10条记录
        this(currentPage, 10);
    }

    public Pager(int currentPage, int showCount) {
        this.currentPage = currentPage;
        if (showCount > 0) {
            this.showCount = showCount;
        }
        // 错误处理
        if (this.currentPage < 1) {
            this.currentPage = 1;
        }
    }

    //只列出关键的getter和setter……

    public int getTotalPage() {
        // 分页算法，计算总页数
        return this.totalPage;
    }

    public int getCurrentResult() {
        // 计算从第几条获取数据
        return (currentPage - 1) * showCount;
    }

    public int getShowCount() {
        return showCount;
    }

    public void setShowCount(int showCount) {
        this.showCount = showCount;
    }

    public void setTotalPage(int totalPage) {
        this.totalPage = totalPage;
    }

    public int getTotalResult() {
        return totalResult;
    }

    public void setTotalResult(int totalResult) {
        this.totalResult = totalResult;
    }

    public int getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(int currentPage) {
        this.currentPage = currentPage;
    }

    public void setCurrentResult(int currentResult) {
        this.currentResult = currentResult;
    }
}
