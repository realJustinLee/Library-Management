$(function () {
    //调整导航条样式
    $("#menu ul li:nth-child(3)").addClass("selected");

    //分页
    $.jqPaginator('#pagination', {
        totalPages: 3,
        visiblePages: 3,
        currentPage: 1,
        wrapper: '<ul class="pagination"></ul>',
        first: '<span class="first"><a href="javascript:void(0);">首页</a></span>',
        prev: '<span class="prev"><a href="javascript:void(0);">上一页</a></span>',
        next: '<span class="next"><a href="javascript:void(0);">下一页</a></span>',
        last: '<span class="last"><a href="javascript:void(0);">尾页</a></span>',
        page: '<span class="page"><a href="javascript:void(0);">{{page}}</a></span>',
        onPageChange: function (num) {
            changePage(num);
        }
    });
});

//页面改变书信书籍
function changePage(num){
    //发送ajax请求
    $.ajax({
        url: "/book/api/hotBook",
        dataType: "json",
        type: 'GET',
        data: {
            pageIndex:num
        },
        success: function (data){
            //清空html
            $("#hot_book_list").html("");
            //将数据插入html中
            for(var index in data){
                $("#hot_book_list").append(`
                   <div class=\"feat_prod_box\">
                    <div class=\"prod_img\"><a href=\"details?bookId=`+data[index].id+`\"><img src=\"/statics/images/book/prod1.gif\" alt=\"\" title=\"\" border=\"0\" /></a>
                    </div>
                    <div class=\"prod_det_box\">
                        <span class=\"special_icon\"><img src=\"/statics/images/book/special_icon.gif\" alt=\"\" title=\"\" /></span>
                        <div class=\"box_top\"></div>
                        <div class=\"box_center\">
                            <div class=\"prod_title\">`+data[index].name+`</div>
                            <p class=\"details\">Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod
                                tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis
                                nostrud
                                exercitation.</p>
                            <a href=\"details?bookId=`+data[index].id+`\" class=\"more\">- 更多详情 -</a>
                            <div class=\"clear\"></div>
                        </div>
                        <div class=\"box_bottom\"></div>
                    </div>
                    <div class=\"clear\"></div>
                </div>
                `);
            }
        },
        error: function () {
            console.log(" 热门书籍json请求失败。");
        }
    })
}

