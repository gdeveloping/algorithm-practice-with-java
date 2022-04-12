package tech.gdev.algorithmpractice.util;

/**
 * @author gdev
 * @date 2022/4/11 23:07
 */
public class StringFormat {

    public static void main(String[] args) {
        String str = "Longest Substring Without Repeating Characters";
        formatString(str);
    }

    public static void formatString(String str) {
        String[] arr = str.toLowerCase().split(" |-|_");

        StringBuilder sb = new StringBuilder();
        for (String s : arr) {
            sb.append(" ")
                    .append((char) (s.charAt(0)+'A'-'a'))
                    .append(s.substring(1));
        }
        String res = sb.length() > 0 ? sb.substring(1) : sb.toString();
        System.out.println(res);
        System.out.println(res.replace(" ", ""));
    }
}
