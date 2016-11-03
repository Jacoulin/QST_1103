package No4;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * Created by Jacoulin on 2016/11/3.
 * 
 * 测试命令
 * cat access.log | java -cp java5.jar com.jacoulin.MapperOfIPFilter "2015-12-31 18:00:00" "2015-12-31 19:00:00" | java -cp java5.jar com.jacoulin.ReducerFilter
 * 
 */
public class ReducerOfIPFilter {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        //使用set集合存放ip，保证没有重复ip地址，方便统计
        Set<String> s = new HashSet<String>();
        while (scanner.hasNext()){
            String[] line = scanner.nextLine().split("\\t");
            //将ip添加进Set集合
            s.add(line[0]);
        }
        //直接输出集合ip的个数
        System.out.println(s.size());
    }
}
