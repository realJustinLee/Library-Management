$(function () {
    //调整导航条样式
    $("#menu ul li:nth-child(1)").addClass("selected");
    getFeatureBookInfo();
    getNewBooksInfo();
})

//获取特色书籍信息
function getFeatureBookInfo() {
    //清空html
    $("#special_book_list").html("");
    //发送ajax请求
    $.ajax({
        url: "/book/api/specialBook",
        dataType: "json",
        type: 'GET',
        success: function (data) {
            for (var index in data) {
                $("#special_book_list").append(`
                <div class=\"feat_prod_box\">
                    <div class=\"prod_img\">
                        <a href=\"details?bookId=`+ data[index].id +`\">
                            <img src=\"/statics/images/book/prod2.gif\" border=\"0\"/>
                        </a>
                    </div>
                    <div class=\"prod_det_box\">
                        <div class=\"box_top\"></div>
                        <div class=\"box_center\">
                            <div class=\"prod_title\">` + data[index].name + `</div>
                            <p class=\"details\">Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod
                                tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis
                                nostrud
                                exercitation.
                            </p>
                            <a href=\"details?bookId=`+ data[index].id +`\" class=\"more\">- 更多详情 -</a>
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
            console.log("获取特色书籍信息失败");
        }
    })
}

//获取最新书籍信息
function getNewBooksInfo() {
    //清空html
    $("#new_book_list").html("");
    //发送ajax请求
    $.ajax({
        url: "/book/api/newBooks3",
        dataType: "json",
        type: 'GET',
        success: function (data) {
            for (var index in data) {
                $("#new_book_list").append(`
                    <div class=\"new_prod_box\">
                    <a href=\"details?bookId=`+ data[index].id +`\">` + data[index].name + `</a>
                    <div class=\"new_prod_bg\">
                        <span class=\"new_icon\">
                            <img src=\"/statics/images/book/new_icon.gif\"/>
                        </span>
                        <a href=\"details?bookId=`+ data[index].id +`\">
                            <img src=\"`+data[index].path+`\" class=\"thumb\" border=\"0\"/>
                        </a>
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
