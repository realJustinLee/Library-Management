package com.library.utils;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * @Author: lixin
 * @Date:   Created in 2018/4/16 19:02
 * @Description:
 * @Email: JustinDellAdam@live.com
 */
public class OrderNumber {
    private StringBuilder stringBuilder = new StringBuilder();

    /**
     * 生成业务流水号
     */
    public String getOrderNum(String workeCode) {
        stringBuilder.append(workeCode);
        long num = 0;
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmSS");
        String format = sdf.format(new Date());
        num = Long.parseLong(format) * 10;
        stringBuilder.append(num);
        return String.valueOf(stringBuilder);
    }

    /**
     * 生成几天后的时间
     */
    public Date getNextDay(Date date,int dayNum) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.DAY_OF_MONTH, dayNum);
        date = calendar.getTime();
        return date;
    }
}
