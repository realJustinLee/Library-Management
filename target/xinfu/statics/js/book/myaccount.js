$(function () {
    //个人信息是否可以修改
    infomationIsAbleChange = false;
    //调整导航条样式
    $("#menu ul li:nth-child(4)").addClass("selected");
    getUserInfo();
});

//获取个人信息
function getUserInfo() {
    $.ajax({
        url: "/book/api/getUserInfo",
        dataType: "json",
        type: 'GET',
        data: {
            id:$.cookie('userId')
        },
        success: function (data) {
            $("#my_info_name").val(data.name);
            $("#my_info_nickname").val(data.nickname);
            $("#my_info_phone").val(data.phone);
            $("#my_info_email").val(data.email);
        },
        error: function () {
            console.log("获取用户信息请求失败！");
        }
    })
}

//修改个人信息
$("#change_info_btn").click(function () {
    //让个人信息输入框可选
    $("#my_infomation .form_row input").removeAttr('disabled');
    $("#password_div").show();
    infomationIsAbleChange = true;
});

//确认修改个人信息
$("#my_info_btn").click(function () {
    //判断信息修改没有
    if (infomationIsAbleChange === false) {
        layer.msg('还没修改信息！', {icon: 2, time: 1000});
        return 0;
    } else {
        //提交请求
        $.ajax({
            url: "/book/api/updateUserInfo",
            dataType: "json",
            type: 'GET',
            data: {
                id:$.cookie('userId'),
                name: $("#my_info_name").val(),
                nickname: $('#my_info_nickname').val(),
                email: $("#my_info_email").val(),
                number: $("#my_info_phone").val(),
                password: $("#my_info_password").val()
            },
            success: function (data) {
                if (data.isSuccess === "true") {
                    layer.msg('修改成功！', {icon: 1, time: 1000});
                } else {
                    layer.msg('修改失败，请稍后再试！', {icon: 2, time: 1000});
                }
            },
            error: function () {
                layer.msg('修改失败，请稍后再试！', {icon: 2, time: 1000});
                console.log("修改用户信息请求失败！");
            }
        })
    }
});