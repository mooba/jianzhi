package jianzhioffer;

/**
 * 替换空格
 * 请实现一个函数，将一个字符串中的每个空格替换成“%20”。例如，当字符串为We Are Happy.则经过替换之后的字符串为We%20Are%20Happy。
 */
public class Solution2 {
    public String replaceSpace(StringBuffer str) {
        StringBuilder sb = new StringBuilder();
        int strLen = str.length();
        for (int i = 0; i < strLen; i++) {
            if (str.charAt(i) == ' ') {
                sb.append('%');
                sb.append('2');
                sb.append('0');
            } else {
                sb.append(str.charAt(i));
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        StringBuffer sb = new StringBuffer("we are happy");
        Solution2 s  = new Solution2();
        System.out.println(s.replaceSpace(sb));
    }
}