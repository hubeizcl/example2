/**
 *   处理分页
 *
 *   @param   curPage
 *   @param   id
 */
function page(curPage, id) {
    if (curPage <= 0) {
        curPage = 1;
    }

    var trueNameForQuery = $("#findByTrueNameInput").val().trim();

    var url = path + "/studygroup/pageStus.do";
    var thCss = "class='s-th-class'";
    var tdCss = "class='s-td-class'";
    $.ajax({
        type: "POST",
        url: url,
        dataType: "json",
        data: {
            "id": id,
            "currentPage": curPage,
            "trueNameForQuery": trueNameForQuery
        },
        success: function (data) {
            var json = eval(data);
            var res = "<tr><th   " + thCss + ">选择</th>"
                + "<th   " + thCss + ">用户名</th>"
                + "<th   " + thCss + ">真实姓名</th>"
                + "<th   " + thCss + ">性别</th>"
                + "<th   " + thCss + ">学校</th>"
                + "<th   " + thCss + ">年级</th>"
                + "<th   " + thCss + ">班级</th></tr>";
            for (var i = 0; i < json.length; i++) {
                var userId = json[i].id;
                var name = json[i].name;
                var trueName = json[i].trueName;
                var sex = json[i].sex;
                var school = "";
                if (json[i].school) {
                    school = json[i].school.name;
                }
                var grade = "";
                if (json[i].grade) {
                    grade = json[i].grade.name;
                }
                var clazz = "";
                if (json[i].clazz) {
                    clazz = json[i].clazz.name;
                }
                res += "<tr><td   align='center'   " + tdCss + "><input   type='checkbox'   value='" + userId + "'   /></td>"
                    + "<td   align='center'   " + tdCss + ">" + (name || "") + "</td>"
                    + "<td   align='center'   " + tdCss + ">" + (trueName || "") + "</td>"
                    + "<td   align='center'   " + tdCss + ">" + (sex == 1 ? '女' : '男' || "") + "</td>"
                    + "<td   align='center'   " + tdCss + ">" + school + "</td>"
                    + "<td   align='center'   " + tdCss + ">" + grade + "</td>"
                    + "<td   align='center'   " + tdCss + ">" + clazz + "</td>"
                    + "</td></tr>";
            }
            $("#inviteStudentsTbl").html(res);
            //   每次加载完成都要刷新分页栏数据
            freshPager(id);
        }
    });
}

/**
 *   重新获取分页对象，刷新分页工具栏
 */
function freshPager(id) {
    var url = path + "/studygroup/getPager.do";
    var studyGroupId = id;
    $.ajax({
        type: "POST",
        url: url,
        dataType: "json",
        success: function (data) {
            var pager = eval(data);
            var currentPage = pager.currentPage;
            //                              var   currentResult   =   pager.currentResult;
            //                              var   showCount   =   pager.showCount;
            var totalPage = pager.totalPage;
            //                              var   totalResult   =   pager.totalResult;

            var prePage = currentPage - 1;
            var nextPage = currentPage + 1;
            if (prePage <= 0) {
                prePage = 1;
            }
            if (nextPage > totalPage) {
                nextPage = totalPage;
            }

            $("#topPageId").attr("href", "javascript:page(1,   " + studyGroupId + ");");
            $("#prefixPageId").attr("href", "javascript:page(" + prePage + ",   " + studyGroupId + ");");
            $("#nextPageId").attr("href", "javascript:page(" + nextPage + ",   " + studyGroupId + ");");
            $("#endPageId").attr("href", "javascript:page(" + totalPage + ",   " + studyGroupId + ");");
            $("#curPageId").html(currentPage);
            $("#totalPageId").html(totalPage);
        }
    });
}

/**
 *   按真实姓名搜索
 */
function findByTrueName() {
    page(1, studyGroupId);
}