//点击注册功能
$("#register").click(function () {
    //判断是否已经勾选同意协议
    if (!$("#terms").prop("checked")) {
        layer.msg('请先同意协议！', {icon: 2, time: 1000});
        return 0;
    } else {
        //发送ajax请求
        $.ajax({
            url: "/api/register",
            dataType: "json",
            type: 'GET',
            data: {
                username: $("#register_username").val(),
                nickname: $("#register_nickname").val(),
                password: $("#register_password").val(),
                number: $("#register_phone").val(),
                email: $("#register_email").val()
            },
            success: function (data) {
                //判断是否注册成功
                if (data[0].registerSuccess == "true") {
                    layer.msg('注册成功，将自动跳转到登录页面！', {icon: 1, time: 2000});
                    setTimeout("javascript:location.href='/'", 1000);/*不知道为什么情请求不允许：因为你路径写错了*/
                } else {
                    layer.msg('注册失败，请稍后再试！', {icon: 2, time: 1000});
                }
            },
            error: function () {
                console.log(" 注册请求失败。");
            }
        })
    }
});