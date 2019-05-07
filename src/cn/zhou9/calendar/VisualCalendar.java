package cn.zhou9.calendar;

import java.text.SimpleDateFormat;
import java.util.*;

/**
 * 可视化日历（Date时间类基础）
 * @Auther:CN.Zhou9
 * @Date:2019/5/7
 * @Description:cn.zhou9.calendar
 * @version:1.0
 */
public class VisualCalendar {
    public static void main(String[] args) {
        System.out.println("请输入日期（格式为：2018-1-1）：");
        Scanner scanner = new Scanner(System.in);
        String dateString = scanner.nextLine();
        //将输入的字符串转化成日期类
        System.out.println("输入的日期为：" + dateString);
        String[] str = dateString.split("-");
        int year = Integer.parseInt(str[0]);
        int month = new Integer(str[1]);
        int day = new Integer(str[2]);
        //Month：0 - 11
        Calendar calendar = new GregorianCalendar(year, month - 1, day);
        //另一种方式：将字符串通过SimpleDateFormat转化成Date对象，再转化成日期类。
        /*SimpleDateFormat sdfDatFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date date = sdfDatFormat.parse(dateString);
        Calendar calendar = new GregorianCalendar();
        calendar.setTime(date);
        int day = calendar.get(Calendar.DATE);*/
        calendar.set(Calendar.DATE, 1);
        //week：1 - 7 日一二三四五六
        int dow = calendar.get(Calendar.DAY_OF_WEEK);
        System.out.println("日\t一\t二\t三\t四\t五\t六");
        for (int i = 0; i < (dow - 1); i++) {
            System.out.print("\t");
        }
        int maxDate = calendar.getActualMaximum(Calendar.DATE);
        //System.out.println("maxDate：" + maxDate);
        for (int i = 1; i <= maxDate; i++) {
            StringBuilder strBuilder = new StringBuilder();
            if (calendar.get(Calendar.DATE) == day) {
                strBuilder.append(calendar.get(Calendar.DATE) + "*\t");
            } else {
                strBuilder.append(calendar.get(Calendar.DATE) + "\t");
            }
            System.out.print(strBuilder);
            //System.out.println(calendar.get(Calendar.DATE)+((calendar.get(Calendar.DATE)==day)?"*":"")+"\t");
            if (calendar.get(Calendar.DAY_OF_WEEK) == Calendar.SATURDAY) {
                System.out.print("\n");
            }
            calendar.add(Calendar.DATE, 1);
        }
    }
}
