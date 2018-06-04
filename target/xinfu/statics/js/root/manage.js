var updateThis; //更新按钮指定的this
var bookChangeId; //修改书籍的id

$(function () {
    //显示所有用户
    showAllUser();
    //显示所有书籍
    showAllBooks();
});

function changeMenu() {
    $("#bookHeader-section").hide();
    $("#bookAddition-section").hide();
    $("#modifyBook-section").hide();
    $("#user-section").hide();

}

/* 左侧菜单选择事件 */
$(".sidebar-menu li").click(function () {
    // 移除所有sidebar li下的active类
    $(".sidebar-menu li").removeClass("active");
    $(this).addClass("active");
    changeMenu();
    //显示相应的模块
    $("#" + $(this).attr("data-section")).show();
});

//显示所有书籍
function showAllBooks() {
    $.ajax({
        url: "/root/api//selectAllBooksInfo",
        dataType: "json",
        type: 'GET',
        data: {
            name: $("#book-search").val()
        },
        success: function (data) {
            if (JSON.stringify(data) === '[]') {
                console.log("返回的书本信息数据为空");
                return 0;
            } else {
                //清空原来的列表
                $("#bookInformation tr:not(:first)").empty("");
                for (var index in data) {
                    $("#bookInformation").append(`
                   <tr>
                        <td class=\"table-book-class\">` + data[index].classes + `</td>
                        <td class=\"table-book-name\">` + data[index].name + `</td>
                        <td class=\"table-book-author\">` + data[index].author + `</td>               
                        <td class=\"table-book-info\">` + data[index].pub + data[index].edition + `</td>
                        <td class=\"table-book-num\">` + data[index].all_num + `</td>
                        <td class=\"table-book-descr\">` + "总共" + data[index].all_num + "本，" + "已借出" + (parseInt(data[index].all_num) - parseInt(data[index].remain_num)) + "本" + `</td> 
                        <td>
                         <button class=\"btn btn-success btn-sm update-book\"  data-book-id=\"` + data[index].id + `\">修改</button>&nbsp;&nbsp;
                         <button class=\"btn btn-danger btn-sm delete-book \" data-book-id=\"` + data[index].id + `\">删除</button>
                           </td>
                           </td>               
                          </tr>
                `);
                }
            }
        },
        error: function () {
            console.log(" 所有书籍json请求失败。");
        }
    });
}


//模糊查询书籍
$("#bookSearch").click(function () {
    $.ajax({
        url: "/root/api/searchBookByKeyWord",
        dataType: "json",
        type: 'GET',
        data: {
            name: $("#book-search").val()
        },
        success: function (data) {
            if (JSON.stringify(data) === '[]') {
                console.log("返回的书本信息数据为空");
                layer.msg('找不到书籍！', {icon: 2, time: 1000});
                return 0;
            } else {
                //清空原来的列表
                $("#bookInformation tr:not(:first)").empty("");
                for (var index in data) {
                    $("#bookInformation").append(`
                   <tr>
                        <td class=\"table-book-class\">` + data[index].classes + `</td>
                        <td class=\"table-book-name\">` + data[index].name + `</td>
                        <td class=\"table-book-author\">` + data[index].author + `</td>               
                        <td class=\"table-book-info\">` + data[index].pub + data[index].edition + `</td>
                        <td class=\"table-book-num\">` + data[index].all_num + `</td>
                        <td class=\"table-book-descr\">` + "总共" + data[index].all_num + "本，" + "已借出" + (parseInt(data[index].all_num) - parseInt(data[index].remain_num)) + "本" + `</td> 
                        <td>
                         <button class=\"btn btn-success btn-sm update-book\"  data-book-id=\"` + data[index].id + `\">修改</button>&nbsp;&nbsp;
                         <button class=\"btn btn-danger btn-sm delete-book \" data-book-id=\"` + data[index].id + `\">删除</button>
                           </td>
                           </td>               
                          </tr>
                `);
                }
            }
        },
        error: function () {
            console.log(" 所有书籍json请求失败。");
        }
    });
});


/*
* 一键导出所有书本*/
$("#report-book").click(function () {
    $.ajax({
        url: "/manage/api/reportBook", /*导出书本API*/
        dataType: 'json',
        type: 'GET',
        success: function (data) {

        },
        error: function () {
            console.log(" 请求失败。");
        }
    });
});

//修改书本信息
//先索引
$("#searchBook").click(function () {
    $.ajax({
        url: "/root/api/searchBookById",
        dataType: "json",
        type: 'GET',
        data: {
            id: $("#modify-book").val()
        },
        success: function (data) {
            if (JSON.stringify(data) === '[]') {
                console.log("返回的书本信息数据为空");
                return 0;
            } else {
                $("#modifyClass").val(data[0].classes);
                $("#modifyBookname").val(data[0].name);
                $("#modifyAuthor").val(data[0].author);
                $("#modifyInfo").val(data[0].pub + ";" + data[0].edition);
                $("#modifyDescr").val(data[0].description);
                $("#modifyNum").val(data[0].all_num);
                $("#myModal").modal('show');
                bookChangeId = data[0].id;
            }
        },
        error: function () {
            console.log(" 请求失败。");
        }
    });
});
//再修改信息
$("#update-book-btn").click(function () {
    var newbook = {
        id: bookChangeId,
        classes: $("#modifyClass").val(),
        name: $("#modifyBookname").val(),
        author: $("#modifyAuthor").val(),
        info: $("#modifyInfo").val(),
        description: $("#modifyDescr").val(),
        all_num: $("#modifyNum").val()
    };

    $.ajax({
        url: "/root/api/updateBook",
        dataType: 'json',
        type: 'get',
        data: newbook,
        success: function (data) {
            if (data.updateSuccess === "true") {
                console.log("修改信息成功");
                $("#myModal").modal('hide');
                layer.msg('修改成功', {icon: 1, time: 1000});
            } else {
                $("#myModal").modal('hide');
            }
        }
    });
});


//显示所有用户
function showAllUser() {
    $.ajax({
        url: "/root/api/selectAllUser",
        dataType: "json",
        type: 'GET',
        success: function (data) {
            if (JSON.stringify(data) === '[]') {
                console.log("返回的用户信息数据为空");
                return 0;
            } else {
                //清空原来的列表
                $("#userInformation tr:not(:first)").empty("");
                for (var index in data) {
                    $("#userInformation").append(`
                   <tr>
                        <td class=\"table-user-id\">` + data[index].id + `</td>
                        <td class=\"table-user-name\">` + data[index].name + `</td>
                        <td class=\"table-user-group\">` + data[index].nickname + `</td>              
                         <td class=\"table-user-id\">` + data[index].email + `</td>
                        <td class=\"table-user-name\">` + data[index].number + `</td>
                        <td class=\"table-user-group\">` + data[index].is_borrow + `</td> 
                        </td>
                        <td>
                        <button class="btn btn-danger btn-sm delete-user ">禁用</button>&nbsp;&nbsp;
                         <button class="btn btn-success btn-sm update-user " >解禁</button>
                         </td>
                      </tr>
                `);
                }
            }
        },
        error: function () {
            console.log(" 所有书籍json请求失败。");
        }
    })
}

//查询普通用户
$("#searchUser").click(function () {
    $.ajax({
        url: "/root/api/selectUserById",
        dataType: "json",
        type: 'GET',
        data: {
            id: $("#user-search").val()
        },
        success: function (data) {
            if (JSON.stringify(data) === '[]') {
                console.log("返回的用户信息数据为空");
                return 0;
            } else {
                //清空原来的列表
                $("#userInformation tr:not(:first)").empty("");
                $("#userInformation").append(`
                   <tr>
                        <td class=\"table-user-id\">` + data[0].id + `</td>
                        <td class=\"table-user-name\">` + data[0].name + `</td>
                        <td class=\"table-user-group\">` + data[0].nickname + `</td>              
                         <td class=\"table-user-id\">` + data[0].email + `</td>
                        <td class=\"table-user-name\">` + data[0].number + `</td>
                        <td class=\"table-user-group\">` + data[0].is_borrow + `</td> 
                        </td>
                        <td>
                        <button class="btn btn-danger btn-sm delete-user ">禁用</button>&nbsp;&nbsp;
                         <button class="btn btn-success btn-sm update-user " >解禁</button>
                         </td>
                      </tr>
                `);
            }
        },
        error: function () {
            console.log(" 所有书籍json请求失败。");
        }
    })
});

//导出用户报表
$("#report-user").click(function () {
    $.ajax({
        url: "/manage/api/reportUser",
        dataType: 'json',
        type: 'get',
        success: function (data) {
        },
        error: function () {
            console.log("导出用户失败");
        }
    });
});

//点击修改图书信息
$(document).on("click", ".update-book", function () {
    var that = this;
    updatathis = this;
    $("#modifyClass").val($(that).parent().prevAll(".table-book-class").html());
    $("#modifyBookname").val($(that).parent().prevAll(".table-book-name").html());
    $("#modifyAuthor").val($(that).parent().prevAll(".table-book-author").html());
    $("#modifyInfo").val($(that).parent().prevAll(".table-book-info").html());
    $("#modifyNum").val($(that).parent().prevAll(".table-book-num").html());
    $("#modifyDescr").val($(that).parent().prevAll(".table-book-descr").html());
    $("#modifyBook-section").show();
    $("#myModal").modal('show');
    bookChangeId = $(that).attr('data-book-id');
});

function isShow() {
    if ($("#myModal").status == 0) {
        $("#modifyBook-section").hide();
    }
}

/* 从从信息表中删除书籍 */
$(document).on("click", ".delete-book", function () {
    // 绑定this对象
    var that = this;
    // 存储传输的id
    var myData = {
        id: $(this).attr('data-book-id')
    };
    //询问是否确认删除
    layer.confirm('确认删除书籍？', {
        btn: ['确定', '取消']
    }, function () {
        //向后端传输数据
        $.ajax({
            url: '/root/api/deleteBook',
            dataType: 'json',
            data: myData,
            success: function (data) {
                if (data.deleteSuccess === "true") {
                    // 将书籍从页面删除
                    $(that).parent().parent().remove();
                    layer.msg('删除成功', {icon: 1, time: 1000});
                }
                else {
                    layer.msg('删除失败', {icon: 2, time: 1000});
                }
            },
            error: function () {
                console.log("删除书籍请求发送失败！");
            }
        });
    });
});

//退出功能
$("#logout").click(function () {
    //清空cookie
    $.cookie("userId", "", {expires: -1, path: "/"});
    //跳转页面
    location.href = "/";
});
