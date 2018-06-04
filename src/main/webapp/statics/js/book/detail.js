//定义获取url参数方法
(function ($) {
    $.getUrlParam = function (name) {
        var reg = new RegExp("(^|&)" + name + "=([^&]*)(&|$)");
        var r = window.location.search.substr(1).match(reg);
        if (r != null) return unescape(r[2]);
        return null;
    }
})(jQuery);

$(function () {
    getBookInfo();
    getRelevantBook();
});

//获取书本详情
function getBookInfo() {
    $.ajax({
        url: "/book/api/bookDetail",
        dataType: "json",
        type: 'GET',
        data: {
            bookId: $.getUrlParam('bookId')
        },
        success: function (data) {
            //显示相关信息
            $("#book-detail").html(data[0].description);
            $("#book-name").html(data[0].name);
            $("#book-author").html(data[0].author);
            $("#book-classes").html(data[0].classes);
            $("#book-pub").html(data[0].pub);
            $("#book-num").html(data[0].remain_num);
            $("#borrow-book-btn").attr('data-bookid', data[0].id);
            $("#detail-book-img").attr("src",data[0].path);
            $("#detail-book-icon").attr("href",data[0].path);
        },
        error: function () {
            console.log("获取书本信息失败");
        }
    })
}

//借书功能
function borrowBook(bookId) {
    $.ajax({
        url: "/book/api/borrowBook",
        dataType: "json",
        type: 'GET',
        data: {
            bookId: bookId,
            userId: $.cookie("userId")
        },
        success: function (data) {
            if (data.borrowBookSuccess === "true") {
                layer.msg('借书成功！', {icon: 1, time: 1000});
            }
        },
        error: function () {
            console.log("借书请求失败。");
        }
    })
}

//点击借书按钮绑定事件
$("#borrow-book-btn").click(function () {
    borrowBook($(this).attr('data-bookid'));
});

//获取相关书籍
function getRelevantBook() {
    $.ajax({
        url: "/book/api/relevantBook",
        dataType: "json",
        type: 'GET',
        data: {
            bookId: $.getUrlParam('bookId')
        },
        success: function (data) {
            // 先清空
            $("#tab2").html("");
            //将内容显示出来
            for (var index in data) {
                $("#tab2").append(`
              <div class=\"new_prod_box\">
              <a href=\"details?bookId=` + data[index].id + `\">` + data[index].name + `</a>
              <div class=\"new_prod_bg\">
              <a href=\"details?bookId=` + data[index].id + `\">
                  <img src=\"`+data[index].path+`\" class="thumb" border="0" />
              </a>
              </div>
              </div>
            `);
            }
        },
        error: function () {
            console.log("获取相关书籍请求失败。");
        }
    })
}