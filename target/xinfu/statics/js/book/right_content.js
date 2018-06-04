$(function () {
    isLogin();
    mostHotAuthor();
    mostHotBook();
});

//判断是否已经登录，显示相应信息
function isLogin() {
    $.ajax({
        url: "/book/api/loginedUserInfo",
        dataType: "json",
        type: 'GET',
        data: {
            id: $.cookie("userId")
        },
        success: function (data) {
            $("#logined-name").html(data[0].nickname);
            $("#last-login").html(data[0].recently_login);
            $("#user_borrow_book_num").html(data[1].num);
        },
        error: function () {
            console.log("登录用户信息获取失败。");
        }
    });
}

//最新热门书籍
function mostHotBook() {
    //清空html
    $("#right_new_book_list").html("");
    //发送ajax请求
    $.ajax({
        url: "/book/api/newBooks3",
        dataType: "json",
        type: 'GET',
        success: function (data) {
            for (var index in data) {
                $("#right_new_book_list").append(`
                    <div class=\"new_prod_box\">
                    <a href=\"details?bookId=`+ data[index].id +`\">` + data[index].name + `</a>
                    <div class=\"new_prod_bg\">
                        <span class=\"new_icon\"><img src=\"/statics/images/book/promo_icon.gif\" /></span>
                        <a href=\"details?bookId=`+data[index].id+`\"><img src=\"`+data[index].path+`\"  class=\"thumb\" border=\"0\" /></a>
                    </div>
                </div>
                `)
            }
        },
        error: function () {
            console.log("获取最新书籍信息失败");
        }
    })
}

//热门作家
function mostHotAuthor() {
    //清空html
    $("#top_author_list").html("");
    //发送ajax请求
    $.ajax({
        url: "/book/api/topAuthor",
        dataType: "json",
        type: 'GET',
        success: function (data) {
            for (var index in data) {
                $("#top_author_list").append(`
                   <li><a href=\"https://www.baidu.com/s?wd=`+data[index].author+`\">` + data[index].author + `</a></li>
                `)
            }
        },
        error: function () {
            console.log("获取热门作家信息失败");
        }
    })
}

//退出登录
$("#logout").click(function () {
    //清空cookie
    $.cookie("userId", "", {expires: -1, path: "/"});
    //跳转页面
    location.href = "/";
});