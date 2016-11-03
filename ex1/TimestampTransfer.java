package No1;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

/*
 * 题目要求：
 * 0. 在个人仓库下，创建分支yourname_ex1
 * 1. 在个人分支下，修改Answers.md文件，里面填入当输入为'2016-11-11 11:11:11'时，输出的值是多少
 * 2. 对代码进行注释，说明每行代码的作用，把代码提交到个人分支下
 * 3. 创建pull request，与主仓库的master分支对比
 */
public class TimestampTransfer {
    @SuppressWarnings("resource")
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        //设置输入日期格式
        SimpleDateFormat inputFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        //设置输出日期格式
        SimpleDateFormat outputFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        while (scanner.hasNext()){
            String line = scanner.nextLine();
            Date lineDate = null;
            //声明长整型类型的lineTimestamp，以存放日期转换后的时间戳
            long lineTimestamp;
            try {
                //获得形如输入格式的日期
                lineDate = inputFormat.parse(line);
                //返回长整型的毫秒数，即转换后的时间戳
                lineTimestamp = lineDate.getTime();
                //改变日期格式为输出格式，并输出
                System.out.println(outputFormat.format(lineDate) + " to " + lineTimestamp);
            } catch (ParseException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
    }
}
