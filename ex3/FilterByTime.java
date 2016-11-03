package No3;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Jacoulin on 2016/11/3.
 */
public class FilterByTime {

    public static void main(String[] args) throws ParseException, FileNotFoundException {
        SimpleDateFormat regularFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        //设置美式日期格式
        SimpleDateFormat USTimeFormat = new SimpleDateFormat("dd/MMM/yyyy:HH:mm:ss", Locale.US);
        Date beginDate = regularFormat.parse("2015-12-31 18:00:00");
        Date endDate = regularFormat.parse("2015-12-31 19:00:00");
        long beginTimeStamp = beginDate.getTime();
        long endTimeStamp = endDate.getTime();
        String filePath = "./access.log";
        FileInputStream inputStream = new FileInputStream(filePath);
        Scanner scanner = new Scanner(inputStream, "UTF-8");

        String mp = "(\\d+\\.\\d+\\.\\d+\\.\\d+) [^ ]* [^ ]* \\[([^ ]*) [^ ]*\\] \"[^ ]+ [^ ]+ .*";
        Pattern pattern = Pattern.compile(mp);

        while (scanner.hasNext()){
            // 对每行进行处理
            String line = scanner.nextLine();
            // 切分获取IP，Time
            String strIp = null;
            String strTime = null;

            //匹配数据
            Matcher m = pattern.matcher(line);

            if(m.find()){
                strIp = m.group(1);
                strTime = m.group(2);
                //获取日期毫秒数，判断是否在时间区间[beginTime, endTime]内
                long ts = USTimeFormat.parse(strTime).getTime();
                if(beginTimeStamp <= ts && ts <= endTimeStamp){
                    // 对在时间区间内的数据进行输出
                    System.out.println(strIp + "\t" + strTime);
                }
            }
        }
    }
}
