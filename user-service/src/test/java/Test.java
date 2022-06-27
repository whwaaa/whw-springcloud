import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Test  {

    public static void main(String[] args) {
        System.out.println(deleteRepeatChar("abccCdefFgFhF"));

    }


    public static String deleteRepeatChar(String str) {
        int len = str.length();
        if (len <= 1)
            return str;
        String lowerStr = str.toLowerCase();
        List<Integer> keep = new ArrayList<>();

        for (int i=1; i<len; i++) {
            // 相邻不相等, 索引存入保留集合keep
            if (lowerStr.charAt(i) != lowerStr.charAt(i-1)) {
                keep.add(i-1);
            }
        }
        keep.add(len-1);

        // 遍历原字符串根据keep集合选择保留字符
        StringBuilder resStr = new StringBuilder();
        for (Integer i : keep)
            resStr.append(str.charAt(i));

        return resStr.toString();
    }


    /**
     *
     * @param count 字符串的数目
     * @param strLength 字符串的长度
     * @return
     */
    public static String[] generateRandomString(int count, int strLength) {
        char[] dic = generateDictionary();
        String[] res = new String[count];
        StringBuilder sb = new StringBuilder();
        Map<String, String> tempMap = new HashMap<>();

        int j=0;
        while (j < count) {
            // 生成一个随机字符串
            for (int i=0; i<strLength; i++) {
                int index = (int) Math.floor(Math.random() * 64);
                sb.append(dic[index]);
            }
            // 校验非重复
            if (tempMap.put(sb.toString(), sb.toString()) == null) {
                res[j] = sb.toString();
                j++;
            }
        }
        return res;
    }


    public static char[] generateDictionary() {
        char[] dic = new char[62];
        for (int i=0; i<10; i++) {
            dic[i] = (char)(i+48);
        }
        for (int i=10; i<36; i++) {
            dic[i] = (char)(i-10+65);
        }
        for (int i=36; i<62; i++) {
            dic[i] = (char)(i-36+97);
        }
        return dic;
    }
}
