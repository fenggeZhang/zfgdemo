package com.zfg.test.javatest.algorithm;

import static java.lang.Math.pow;

/**
 * author : zfg
 * e-mail : zfg_android@163.com
 * date   : 2019/7/25
 * desc   : 贪心算法
 */
public class TanxinTest {
    int integerBreak(int n) {
        if (n < 2) return 0;
        if (n == 2) return 1;
        if (n == 3) return 2;

        int n3 = n / 3;       // 切成 3 的数量

        if (n % 3 == 1)         // 如果余下的长度为 4
            n3--;

        int n2 = (n - 3 * n3) / 2;  // 切成 2 的数量
        return (int) pow(3, n3) * (int) pow(2, n2);
    }
}
