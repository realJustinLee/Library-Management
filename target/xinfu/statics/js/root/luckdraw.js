var nametxt = $('.slot');
var userName = $('.name');
var pcount;  // 参加抽奖人数
var gcount;  // 参加抽奖的组数
var userImg = new Array();  // 存储用户图片路径
var user = new Array();	// 存储用户名称

var groupImg = new Array(); // 存储组的图片
var groupName = new Array(); // 存储组的名字
var start = false;  // 是否已经点击开始轮播
var luckyUserName;  // 中奖人姓名
var luckyUserImg;  // 中奖人图片

$(function () {

    // 播放烟花
    $('.demo').fireworks({
        sound: false, // sound effect
        opacity: 0.3,
        width: '100%',
        height: '100%'
    });


    // 获取组的信息
    getGroupInfo();
    // 请求待选人信息
    $.ajax({
        url: "/MainServlet/selectAllUser",
        dataType: "json",
        success: function (data) {
            // 判断返回的数据是否为空
            if (JSON.stringify(data) === '[]') {
                console.log("返回的待选人数据为空");
                return 0;
            }
            //将图片路径和用户名称分别装入userImg和user数组
            for (var i in data[0].list) {
                userImg[i] = data[0].list[i].picture;
                user[i] = data[0].list[i].name;
            }

            //请求成功后设置各参数
            pcount = userImg.length - 1;
            nametxt.css('background-image', 'url(' + userImg[0] + ')');
            userName.html(user[0]);

        },
        error: function (data) {
            console.log("待选人信息请求失败！");
        }
    });
});


// 获取组的信息
function getGroupInfo() {
    $.ajax({
        url: "/MainServlet/selectAllGroup",
        dataType: "json",
        success: function (data) {
            // 判断返回的数据是否为空
            if (JSON.stringify(data) === '[]') {
                console.log("返回的分组数据为空");
                return 0;
            }
            //将图片路径和用户名称分别装入userImg和user数组
            for (var i in data[0].list) {
                groupImg[i] = data[0].list[i].picture;
                groupName[i] = data[0].list[i].name;
            }
            // //请求成功后设置各参数
            gcount = groupImg.length - 1;
        },
        error: function () {
            console.log("分组信息请求失败！");
        }
    });
}


/* 随机轮播待选人 */
function showPerson() {
    var num;
    // 如果抽的是小组形式
    if($('input:radio[name="selectType"]:checked').val() == "personal"){
        num = Math.floor(Math.random() * pcount);
        nametxt.css('background-image', 'url(' + userImg[num] + ')');
        userName.html(user[num]);
    }else if($('input:radio[name="selectType"]:checked').val() == "group"){
        num = Math.floor(Math.random() * gcount);
        nametxt.css('background-image', 'url(' + groupImg[num] + ')');
        userName.html(groupName[num]);
    }
    t = setTimeout(showPerson, 50);
}

/* 打印中奖者名单 */
function print() {
    // 请求的路径
    var luckUrl;
    //向后台请求中奖者信息
    var put = $('input:radio[name="put"]:checked').val();
    var type = $('input:radio[name="selectType"]:checked').val();
    // 判断抽奖的形式，根据不同的方式请求不同的路径
    if(type == "group"){
        luckUrl = "MainServlet/selectGroup";
    }else {
        luckUrl = "MainServlet/extract";
    }
    $.ajax({
        url: luckUrl,
        type: 'post',
        data: {"put": put},
        dataType: 'json',
        success: function (data) {
            // 判断返回的数据是否为空
            if (JSON.stringify(data) === '[]') {
                console.log("返回的中奖人数据为空");
                return 0;
            }

            //统计中奖人
            luckyUserImg = data[0].picture;
            luckyUserName = data[0].name;

            // 将中奖者信息打印出来
            nametxt.css('background-image', 'url(' + luckyUserImg + ')');
            userName.html(luckyUserName);

            // 播放音乐
            // $("#music")[0].play();
            // document.getElementById("music").play();
            $('.luck-user-list').prepend("<li><div class='portrait' style='background-image:url(" + luckyUserImg + ")'></div><div class='luckuserName'>" + luckyUserName + "</div></li>");
        },
        error: function (data) {
            console.log("中奖人信息请求失败！");
        }
    });
}

/* 点击开始按钮 */
$("#start").click(function () {
    if (!start) {
        showPerson();
        // 暂停音乐
        // $("#music")[0].pause();
        $("#start").html("抽取");
        start = true;
    } else {
        // 清除定时器，停止图片跳动
        clearTimeout(t);
        print();
        $("#start").html("开始");
        start = false;
    }
})

/* 点击选择抽奖方式： 抽人还是抽组 */
$('input:radio[name="selectType"]').change(function () {
    if($('input:radio[name="selectType"]:checked').val() == "group"){
        nametxt.css('background-image', 'url(' + groupImg[0] + ')');
        userName.html(groupName[0]);
    }else {
        nametxt.css('background-image', 'url(' + userImg[0] + ')');
        userName.html(user[0]);
    }
})
