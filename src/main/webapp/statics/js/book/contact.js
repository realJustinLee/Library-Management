$(function () {
    //调整导航条样式
    $("#menu ul li:nth-child(5)").addClass("selected");
});

// 联系我们点击事件
$("#send_contact").click(function () {
    //发送ajax请求
    $.ajax({
        url: "/book/api/contact",
        data: {
            name: $("#contact_name").val(),
            email: $("#contact_email").val(),
            phone: $("#contact_phone").val(),
            message: $("#contact_message").val()
        },
        type: 'GET',
        success: function () {
            layer.msg('谢谢您的留言！', {icon: 1, time: 1000});
            console.log("联系我们信息增加成功。");
        },
        error: function () {
            console.log("联系我们信息请求失败。");
        }
    })
});