$(function () {
    //调整导航条样式
    $("#menu ul li:nth-child(2)").addClass("selected");

    //请求分页数据
    $.ajax({
        url: "/book/api/bookNumber",
        dataType: "json",
        type: 'GET',
        success: function (data) {
            //将分页显示出来
            $("#pagination").show();
            // 计算页数：返回大于等于其最小整数
            var totalPages = Math.ceil(data[0].dataNum * 1.0 / 12);
            $.jqPaginator('#pagination', {
                totalPages: totalPages,
                visiblePages: 3,
                currentPage: 1,
                wrapper: '<ul class="pagination"></ul>',
                first: '<span class="first"><a href="javascript:void(0);">首页</a></span>',
                prev: '<span class="prev"><a href="javascript:void(0);">上一页</a></span>',
                next: '<span class="next"><a href="javascript:void(0);">下一页</a></span>',
                last: '<span class="last"><a href="javascript:void(0);">尾页</a></span>',
                page: '<span class="page"><a href="javascript:void(0);">{{page}}</a></span>',
                onPageChange: function (num) {
                    // 刷新内容
                    newBookPageChange(num);
                }
            });
        },
        error: function () {
            console.log("分页数据json请求失败！");
        }
    });
});

//页号发生改变重新刷新
function newBookPageChange(pageIndex){
    //发送ajax请求
    $.ajax({
        url: "/book/api/booksPageChange",
        dataType: "json",
        type: 'GET',
        data: {
            pageIndex: pageIndex
        },
        success: function (data){
            //清空html
            $("#new_book_list").html("");
            //将数据插入html中
            for(var index in data){
                $("#new_book_list").append(`
                   <div class=\"new_prod_box\">
                    <a href=\"details?bookId=`+data[index].id+`\">`+data[index].name+`</a>
                    <div class=\"new_prod_bg\">
                        <a href=\"details?bookId=`+data[index].id+`\">
                            <img src=\"`+data[index].path+`\" class=\"thumb\" border=\"0\" />
                        </a>
                    </div>
                </div>
                `);
            }
        },
        error: function () {
            console.log(" 所有书籍json请求失败。");
        }
    })
}

//用户模糊查询书籍
$("#select_book_btn").click(function () {
    //隐藏分页
    $("#pagination").hide();
    //发送请求
    $.ajax({
        url: "/book/api/searchBook",
        dataType: "json",
        type: 'GET',
        data: {
            name: $("#select_book_name").val()
        },
        success: function (data){
            //清空html
            $("#new_book_list").html("");
            //将数据插入html中
            for(var index in data){
                $("#new_book_list").append(`
                   <div class=\"new_prod_box\">
                    <a href=\"details?bookId=`+data[index].id+`\">`+data[index].name+`</a>
                    <div class=\"new_prod_bg\">
                        <a href=\"details?bookId=`+data[index].id+`\">
                            <img src=\"`+data[index].path+`\" class=\"thumb\" border=\"0\" />
                        </a>
                    </div>
                </div>
                `);
            }
        },
        error: function () {
            console.log(" 所有书籍json请求失败。");
        }
    })
});
