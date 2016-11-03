package No4;

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
public class MapperOfIPFilter {
    public static void main(String[] args) throws ParseException {
        SimpleDateFormat regularFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        //设置美式日期格式
        SimpleDateFormat USTimeFormat = new SimpleDateFormat("dd/MMM/yyyy:HH:mm:ss", Locale.US);
        //从命令行接收参数，arg[0]为beginDate，arg[1]为endDate
        Date beginDate = regularFormat.parse(args[0]);
        Date endDate = regularFormat.parse(args[1]);
        long beginTimeStamp = beginDate.getTime();
        long endTimeStamp = endDate.getTime();

        Scanner scanner = new Scanner(System.in);

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
