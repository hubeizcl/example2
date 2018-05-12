package company.querybypage;

public class PageContext {
    private static PageContext pageContext = new PageContext();

    private Pager pager;

    public static PageContext getInstance() {
        return pageContext;
    }

    public Pager get() {
        return pager;
    }

    public void set(Pager pager) {
        this.pager = pager;
    }
}
