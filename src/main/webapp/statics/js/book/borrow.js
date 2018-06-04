$(function () {
    getUserBorrowBooks();
});

//获取用户已借书籍
function getUserBorrowBooks() {
    //提交请求
    $.ajax({
        url: "/book/api/getUserBorrowBooks",
        dataType: "json",
        type: 'GET',
        data: {
            id: $.cookie("userId")
        },
        success: function (data) {
            //重置html
            $("#my_borrow_book_list").html(`
                <tr class=\"cart_title\">
                   <td>书名</td>
                    <td>借阅时间</td>
                    <td>还书时间</td>
                    <td>还书</td>
                </tr>
            `);
            for (var index in data) {
                $("#my_borrow_book_list").append(`
                        <tr>
                        <td>` + data[index].name + `</td>
                        <td>` + data[index].borrow_start_time + `</td>
                        <td>` + data[index].borrow_end_time + `</td>
                        <td><a href=\"javascript:void(0)\" class=\"checkout\" data-id=\"` + data[index].book_id + `\">还书</a></td>
                    </tr>
                `)
            }
            //点击还书
            $(".checkout").bind('click',function () {
                var bookId = $(this).attr('data-id');
                returnBook(bookId);
            });
        },
        error: function () {
            console.log("获取用户借阅书籍失败。")
        }
    })
}

//还书
function returnBook(bookId) {
    //提交请求
    $.ajax({
        url: "/book/api/returnBook",
        dataType: "json",
        type: 'GET',
        data: {
            userId: $.cookie("userId"),
            bookId: bookId
        },
        success: function (data) {
            console.log("还书成功。");
            if(data.returnBookSuccess === "true"){
                layer.msg('还书成功！', {icon: 1, time: 1000});
            }
            //刷新还书的信息
            getUserBorrowBooks();
        },
        error: function () {
            console.log("还书请求失败。");
        }
    });
}

