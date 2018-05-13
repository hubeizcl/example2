package com.zcl.querybypage;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class Controll {
    private final Logger LOG = LoggerFactory.getLogger(Controll.class);

    @Autowired
    private UserService userService;

    /**
     * 分页时获取所有的学生
     *
     * @return
     */
    @RequestMapping("pageStus")
    @ResponseBody
    public List<User> pageAllStudents(HttpServletRequest req) {
        try {
            Query query = new Query();
            Pager pager = new Pager();
            Map<String, Object> queryParams = new HashMap<>();

            // 获取分页参数
            String showCount = req.getParameter("showCount");
            String currentPage = req.getParameter("currentPage");
            if (StringUtils.hasLength(showCount)) {
                pager.setShowCount(Integer.parseInt(showCount));
            }
            if (StringUtils.hasLength(currentPage)) {
                pager.setCurrentPage(Integer.parseInt(currentPage));
            }
            // 高级查询条件：学生真实姓名
            String trueNameForQuery = req.getParameter("trueNameForQuery");
            if (StringUtils.hasLength(trueNameForQuery)) {
                queryParams.put(" u.REAL_NAME like ", "'%" + trueNameForQuery + "%'");
            }

            query.setPager(pager);
            query.setQueryParams(queryParams);
            List<User> users = userService.pageUsersByRole(query);

            // req.setAttribute("pager", PageContext.getInstance().get());

            return users;
        } catch (Exception e) {
            LOG.error("getAllStudents error : " + e.getMessage());
        }
        return null;
    }

    @RequestMapping("getPager")
    @ResponseBody
    public Pager getPager() {
        return PageContext.getInstance().get();
    }
}