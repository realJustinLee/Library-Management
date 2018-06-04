jQuery(document).ready(function () {
    // 背景图轮播,间隔3s
    $.backstretch([
        "statics/images/login/login.jpg"
        , "statics/images/login/bg2.jpg"
    ], {duration: 3000, fade: 750});

    $('.login-form input[type="text"], .login-form input[type="password"], .login-form textarea').on('focus', function () {
        $(this).removeClass('input-error');
    });

    $('.login-form').on('submit', function (e) {

        $(this).find('input[type="text"], input[type="password"], textarea').each(function () {
            if ($(this).val() == "") {
                e.preventDefault();
                $(this).addClass('input-error');
            }
            else {
                $(this).removeClass('input-error');
            }
        });
    });
    // 通过ajax验证登陆请求
    $("#login").click(function () {
        $.ajax({
            url: "/api/login",
            dataType: 'json',
            data:{
                username:$("#form-username").val(),
                password:$("#form-password").val()
            },
            success: function (data) {
                if (data!==null && data[0].role == "root") {
                    //存储用户信息cookie
                    $.cookie("userId",data[0].userId,{expires:1,path:"/"});
                    location.href = "/root/manage";
                } else if (data!==null && data[0].role == "user") {
                    //存储用户信息cookie
                    $.cookie("userId",data[0].userId,{expires:1,path:"/"});
                    location.href = "/book/index";
                }
                else {
                    $("#login-message").css("color", "red").html("账号或密码错误！");
                }
            },
            error: function (data) {
                console.log("登录验证请求失败！");
            }
        })
    })
})
