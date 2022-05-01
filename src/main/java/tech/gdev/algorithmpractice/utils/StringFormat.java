package tech.gdev.algorithmpractice.utils;

/**
 * @author gdev
 * @date 2022/4/11 23:07
 */
public class StringFormat {

    public static void main(String[] args) {
        formatTitleString();
        System.out.println();
        formatArrayString();
    }

    public static void formatTitleString() {
        String str = "";
        System.out.println(str);
        formatTitleString(str);
    }

    public static void formatArrayString() {
        String str = "";
        System.out.println(str);
        formatArrayString(str);
    }

    public static void formatTitleString(String str) {
        if (str == null || str.isEmpty()) {return;}
        String[] arr = str.trim().toLowerCase().split(" |-|_");

        StringBuilder sb = new StringBuilder();
        for (String s : arr) {
            sb.append(" ")
                    .append((char) (s.charAt(0)+'A'-'a'))
                    .append(s.substring(1));
        }
//        System.out.println(sb);
        String res = sb.length() > 0 ? sb.substring(1) : sb.toString();
        System.out.println(res.replace(" ", ""));
        System.out.println(res.replace(" ", "-").toLowerCase());
        System.out.println(res);
        System.out.println(res.toUpperCase());
    }

    public static void formatArrayString(String str) {
        String res = str
                .replace("[", "{")
                .replace("]", "}");
        System.out.println(res);
        if (res.length() > 1 && res.charAt(1) == '{') {
            System.out.println("new int[][]" + res);
        } else if (res.length() > 0 && res.charAt(0) == '{') {
            System.out.println("new int[]" + res);
        }
    }
}
