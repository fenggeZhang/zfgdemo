package com.zfg.test.javatest;

/**
 * Created by zfg on 2019/5/22
 * 给定Hlelo和Hello。Hlelo可以通过重新排列变成Hello，
 * 对于给定得Hleeo和Hello，Hleeo则无法通过重新排列；
 */
public class ContrastStr {
    public static void main(String[] strings) {
        String stra = "hello";
        String strb = "hlloe";
        boolean b = contrastStr(stra, strb);
        System.out.println("结果" + b);
        b = contrastStr(stra, stra);
        System.out.println("结果" + b);
    }

    private static boolean contrastStr(String stra, String strb) {
        if (stra.equals(strb)) {
            return true;
        }
        if (stra.length() == 0) {
            return false;
        }
        if (strb.length() == 0) {
            return false;
        }
        if (stra.length() != strb.length()) {
            return false;
        }
        char[] chars1 = sortStr(stra.toCharArray());
        char[] chars2 = sortStr(strb.toCharArray());
        if (chars1 == chars2) {
            return true;
        } else {
            return false;
        }

    }

    private static char[] sortStr(char[] stra) {
        for (int i = 0; i < stra.length; i++) {
            for (int j = i + 1; j < stra.length; j++) {
                if (stra[i] > stra[j]) {
                    char a = stra[i];
                    stra[i] = stra[j];
                    stra[j] = a;
                }
            }
        }
        return stra;
    }
}
