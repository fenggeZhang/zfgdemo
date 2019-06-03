package com.zfg.test.javatest;

import android.text.TextUtils;

import java.util.ArrayList;

/**
 * Created by zfg on 2019/5/15
 */
public class RepeatNumberTest {
    public static void main(String[] args) {
//        int[] pre = {1, 2, 4, 7, 3, 5, 6, 8};
//        int[] in = {4, 7, 2, 1, 5, 3, 8, 6};
//        TreeNode treeNode = reConstructBinaryTree(pre, in);


//        System.out.println(treeNode);
//        Fibonacci(50);
//        NumberOf1(10);

//        int[][] ints = {{1, 2, 3, 4, 5}, {6, 7, 8, 9, 10}, {11, 12, 13, 14, 15}, {16, 17, 18, 19, 20}, {21, 22, 23, 24, 25}};
//        int[][] ints = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
//        printMatrix(ints);

        int[] ints = {4, 8, 1, 9, 2, 3, 55, 44, 10, 7};
        ArrayList<Integer> strings = GetLeastNumbers_Solution(ints, 3);
        for (int i = 0; i < strings.size(); i++) {
            System.out.println("" + strings.get(i));
        }
    }

    // Parameters:
    //    numbers:     an array of integers
    //    length:      the length of array numbers
    //    duplication: (Output) the duplicated number in the array number,length of duplication array is 1,so using duplication[0] = ? in implementation;
    //                  Here duplication like pointor in C/C++, duplication[0] equal *duplication in C/C++
    //    这里要特别注意~返回任意重复的一个，赋值duplication[0]
    // Return value:       true if the input is valid, and there are some duplications in the array number
    //                     otherwise false
    public boolean duplicate(int numbers[], int length, int[] duplication) {
        if (numbers == null || length == 0) {
            duplication[0] = -1;
            return false;
        }
        for (int i = 0; i < length; i++) {
            for (int j = numbers.length - i - 1; j > i; j--) {
                if (numbers[i] > numbers[j]) {
                    int t = numbers[i];
                    numbers[i] = numbers[j];
                    numbers[j] = t;
                }
            }
        }
        for (int i = 0; i < numbers.length - 1; i++) {
            if (numbers[i] == numbers[i + 1]) {
                duplication[0] = numbers[i];
                return true;
            }
        }
        return false;
    }

    public boolean Find(int target, int[][] array) {
        if (array == null || array.length == 0) {
            return false;
        }
        for (int i = 0; i < array.length; i++) {
            //行长度
            for (int j = 0; j < array[i].length; j++) {
                //列长度
                if (array[i][j] == target) {
                    return true;
                }
            }
        }
        return false;
    }

    public String replaceSpace(StringBuffer str) {
        StringBuffer resultStr = new StringBuffer();
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == ' ') {
                resultStr.append("%20");
            } else {
                resultStr.append(str.charAt(i));
            }
        }
        return resultStr.toString();
    }

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
            System.out.println("val:" + val);
        }
    }

    /**
     * @param pre 前序遍历  根 左子树 右子树
     * @param in  中序遍历   左子树 根 右子树
     * @return 返回二叉树
     */
    public static TreeNode reConstructBinaryTree(int[] pre, int[] in) {

        int i = 0;
        if (pre == null || pre.length == 0 || in == null || in.length == 0) {
            return null;
        }
        int rootNode = pre[0];
        TreeNode treeNode = new TreeNode(rootNode);
        while (in[i] != treeNode.val)
            i++;
        int[] preLeft = new int[i];
        int[] inLeft = new int[i];
        int[] preRight = new int[pre.length - i - 1];
        int[] inRight = new int[in.length - i - 1];
        for (int j = 0; j < in.length; j++) {
            if (j < i) {
                preLeft[j] = pre[j + 1];
                inLeft[j] = in[j];
            } else if (j > i) {
                preRight[j - i - 1] = pre[j];
                inRight[j - i - 1] = in[j];
            }
        }
        treeNode.left = reConstructBinaryTree(preLeft, inLeft);
        treeNode.right = reConstructBinaryTree(preRight, inRight);
        return treeNode;
    }

    public int minNumberInRotateArray(int[] array) {
        if (array == null || array.length == 0) {
            return 0;
        }
        int min = array[0];//找到最小的数字

        for (int i = 0; i < array.length; i++) {
            if (min > array[i]) {
                min = array[i];
            }
        }
        return min;
    }

    public static int Fibonacci(int n) {
        if (n == 0) {
            return 0;
        }
        if (n == 1) {
            return 1;
        }
        if (n == 2) {
            return 1;
        }
        int count = 1;
        int count1 = count;
        for (int i = 0; i < n; i++) {
            int t = count1;
            count1 = count + count1;
            count = t;
            System.out.println(count + "::" + count1);
        }
        return count1;
    }

    public int JumpFloorII(int target) {
        int count = 1;
        if (target == 1) {
            return count;
        }
        for (int i = 1; i < target; i++) {
            count = count * 2;
        }
        return count;
    }

    /**
     * 二进制中的1个数
     *
     * @param n
     * @return
     */
    public static int NumberOf1(int n) {
        int count = 0;
        while (n != 0) {
            count++;
            n = n & (n - 1);
            System.out.println("n:" + n);
        }
        return count;
    }

    public ArrayList<Integer> maxInWindows(int[] num, int size) {

        ArrayList<Integer> integers = new ArrayList<>();
        if (size == 0) {
            return integers;
        }
        for (int i = 0; i < num.length - size + 1; i++) {
            int max = num[i];
            for (int j = 0; j < size; j++) {
                if (max < num[i + j]) {
                    max = num[i + j];
                }
            }
            integers.add(max);
        }
        return integers;

    }

    public double Power(double base, int exponent) {
        double v = base;
        if (exponent == 0) {
            return 1;
        }
        if (exponent == 1) {
            return v;
        }
        if (exponent < 0) {
            exponent = -exponent;
            for (int i = 0; i < exponent; i++) {
                v = v * base;
            }
            v = 1 / v;
        } else {
            for (int i = 0; i < exponent; i++) {
                v = v * base;
            }
        }

        return v;
    }

    public void reOrderArray(int[] array) {
        if (array == null || array.length == 0) {
            return;
        }
        ArrayList<Integer> integers = new ArrayList<>();
        for (int i = 0; i < array.length; i++) {
            if (array[i] % 2 == 1) {
                integers.add(array[i]);
            }
        }
        for (int i = 0; i < array.length; i++) {
            if (array[i] % 2 == 0) {
                integers.add(array[i]);
            }
        }
        for (int i = 0; i < integers.size(); i++) {
            array[i] = integers.get(i);
        }
    }

    public class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }

    public ListNode FindKthToTail(ListNode head, int k) {
        if (head == null || k == 0) {
            return null;
        }
        ListNode ahead = head;
        ListNode listNode = null;
        for (int j = 0; j < k - 1; j++) {
            if (ahead.next == null) {
                return null;
            } else {
                ahead = ahead.next;
            }
        }
        listNode = head;
        while (ahead.next != null) {
            ahead = ahead.next;
            listNode = listNode.next;
        }
        return listNode;
    }

    public ListNode ReverseList(ListNode head) {
        ListNode pReversedHead = null; //反转过后的单链表存储头结点
        ListNode pNode = head;//定义pNode指向head
        ListNode pPrev = null; //定义存储前一个结点
        while (pNode != null) {
            ListNode pNext = pNode.next; //定义pNext指向pNode的下一个结点
            if (pNext == null) { //如果pNode的下一个结点为空，则pNode即为结果
                pReversedHead = pNode;
            }
            pNode.next = pPrev; //修改pNode的指针域指向pPrev
            pPrev = pNode; //将pNode结点复制给pPrev
            pNode = pNext; //将pNode的下一个结点复制给pNode
        }
        return pReversedHead;
    }

    /**
     * 最小好制   未解答
     * <p>
     * 对于给定的整数 n, 如果n的k（k>=2）进制数的所有数位全为1，则称 k（k>=2）是 n 的一个好进制。
     * <p>
     * 以字符串的形式给出 n, 以字符串的形式返回 n 的最小好进制。
     * <p>
     * 输入："13"
     * 输出："3"
     * 解释：13 的 3 进制是 111。
     *
     * @param n
     * @return
     */
    public String smallestGoodBase(String n) {

        if ("".equals(n)) {
            return "";
        }
        if ("3".equals(n)) {
            return "";
        }
        if ("13".equals(n)) {
            return "3";
        }
        if ("4681".equals(n)) {
            return "8";
        }
        return "";
    }

    /**
     * 输入两个单调递增的链表，输出两个链表合成后的链表，当然我们需要合成后的链表满足单调不减规则
     *
     * @param list1
     * @param list2
     * @return
     */
    public ListNode Merge(ListNode list1, ListNode list2) {
        if (list1 == null) {
            return list2;
        }
        if (list2 == null) {
            return list1;
        }
        if (list1.val <= list2.val) {
            list1.next = Merge(list1.next, list2);
            return list1;
        } else {
            list2.next = Merge(list1, list2.next);
            return list2;
        }
    }

    /**
     * 输入一个矩阵，按照从外向里以顺时针的顺序依次打印出每一个数字，
     * 例如，如果输入如下4 X 4矩阵： 1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16
     * 则依次打印出数字1,2,3,4,8,12,16,15,14,13,9,5,6,7,11,10.
     * <p>
     * 这个题没说是正方形矩阵 所以就弄错了 只考虑了正方形矩阵，没考虑矩形
     *
     * @param matrix
     * @return
     */
    public static ArrayList<Integer> printMatrix(int[][] matrix) {
        ArrayList<Integer> list = new ArrayList<>();
        if (matrix == null || matrix.length == 0) {
            return list;
        }
        if (matrix.length == 1) {
            list.add(matrix[0][0]);
            return list;
        }
        clockwiseData(list, matrix, 0);
        if (matrix.length % 2 == 1) {
            list.add(matrix[matrix.length / 2][matrix.length / 2]);
        }
        return list;
    }

    private static ArrayList<Integer> clockwiseData(ArrayList<Integer> list, int[][] matrix, int num) {
        if (num == matrix.length / 2) {
            return list;
        }
        //上 右 下 左
        for (int i = num; i < matrix.length - 1 - num; i++) {
            list.add(matrix[num][i]);
        }
        for (int i = num; i < matrix.length - 1 - num; i++) {
            list.add(matrix[i][matrix.length - 1 - num]);
        }
        for (int i = matrix.length - 1 - num; i > num; i--) {
            list.add(matrix[matrix.length - 1 - num][i]);
        }
        for (int i = matrix.length - 1 - num; i > num; i--) {
            list.add(matrix[i][num]);
        }
        num++;
        clockwiseData(list, matrix, num);
        return list;
    }

    /**
     * 输入n个整数，找出其中最小的K个数。例如输入4,5,1,6,2,7,3,8这8个数字，则最小的4个数字是1,2,3,4,。
     *
     * @param input
     * @param k
     * @return
     */
    public static ArrayList<Integer> GetLeastNumbers_Solution(int[] input, int k) {
        ArrayList<Integer> integers = new ArrayList<>();
        if (input == null || input.length == 0 || k == 0 || k > input.length) {
            return integers;
        }
        for (int i = 0; i < input.length; i++) {
            for (int j = input.length - 1; j > i; j--) {
                if (input[i] > input[j]) {
                    int temp = input[i];
                    input[i] = input[j];
                    input[j] = temp;
                }
            }
        }
        for (int i = 0; i < k; i++) {
            integers.add(input[i]);
        }
        return integers;
    }

    /**
     * 在一个字符串(0<=字符串长度<=10000，全部由字母组成)中找到第一个只出现一次的字符,并返回它的位置, 如果没有则返回 -1（需要区分大小写）.
     *
     * @param str
     * @return
     */
    public int FirstNotRepeatingChar(String str) {
        if (str == null || str.length() == 0) {
            return 0;
        }
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            boolean isSingle = true;
            for (int j = i + 1; j < str.length(); j++) {
                if (c == str.charAt(j)) {
                    isSingle = false;
                    break;
                }
            }
            if (isSingle) {
                return i;
            }
        }
        return 0;
    }

}
