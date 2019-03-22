package com.zfg.test.javatest;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by zfg on 2019/3/20
 * n 皇后问题
 */
public class NKing {
    public static void main(String[] args) {
        solveNQueens1(5);
    }

    private static List<List<String>> res = new ArrayList<>();

    public static List<List<String>> solveNQueens1(int n) {
        boolean board[][] = new boolean[n][n];
        oneQueen(board, 0, n);
        for (int i = 0; i < res.size(); i++) {
            for (int j = 0; j < res.get(i).size(); j++) {
                System.out.println(res.get(i).get(j));
            }
            System.out.println();
        }
        return res;
    }

    public static void oneQueen(boolean board[][], int i, int n) {
        List<String> re;
        StringBuilder sb;
        //可以放置
        if (i == n) {
            //输出到结果集res
            re = new ArrayList<>();
            for (int p = 0; p < n; p++) {
                sb = new StringBuilder();
                for (int q = 0; q < n; q++) {
                    if (board[p][q]) {
                        sb.append('Q');
                    } else {
                        sb.append('.');
                    }
                }
                re.add(sb.toString());
            }
            res.add(re);
            return;
        }
        for (int j = 0; j < n; j++) {
            if (canPut(i, j, n, board)) {
                board[i][j] = true;
                oneQueen(board, i + 1, n);
                board[i][j] = false;
            }
        }
    }

    public static boolean canPut(int i, int j, int n, boolean board[][]) {
        //判断列
        for (int k = 0; k < i; k++) {
            if (board[k][j]) {
                return false;
            }
        }
        //判断左上
        int q = j, p = i;
        while (p > 0 && q > 0) {
            if (board[--p][--q]) {
                return false;
            }
        }
        //判断右上
        q = j;
        p = i;
        while (p > 0 && q < n - 1) {
            if (board[--p][++q]) {
                return false;
            }
        }
        return true;
    }


    public static List<List<String>> solveNQueens(int n) {
        List<List<String>> lists = new ArrayList<>();
        List<String> strings = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String str = "";
            for (int j = 0; j < n; j++) {
                str += ".";
            }
            strings.add(str);
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                StringBuilder sb = new StringBuilder(strings.get(i));

                if (isQueen(strings, i, j)) {
                    sb.replace(j, j + 1, "Q");
                } else {
                    sb.replace(j, j + 1, ".");
                }
            }
//            strings.add(str);
        }
        for (int i = 0; i < strings.size(); i++) {
            System.out.println(strings.get(i));
        }
        lists.add(strings);
        return lists;
    }

    private static boolean isQueen(List<String> strings, int i, int j) {

      /*  if (strings.get(i).contains("Q"))
            return false;
//        同列
        for (int k = 0; k < strings.size(); k++) {
            if (("" + strings.get(k).charAt(j)).equals("Q"))
                return false;
        }*/
//        同斜线
        for (int k = 0; k < strings.size(); k++) {
            for (int l = 0; l < strings.size(); l++) {
                if (("" + (strings.get(k).charAt(l))).equals("Q")) {
                    if (k != i && l != j) {
                        if (k == i || l == j) {
                            return false;
                        }
                        if (((Math.abs((k - i))) % (Math.abs(l - j))) == 1)
                            return false;
                    }
                }
            }
        }
        return true;
    }
}
