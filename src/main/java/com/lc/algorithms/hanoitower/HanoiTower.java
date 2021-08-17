package com.lc.algorithms.hanoitower;

/**
 * 汉诺塔移动路径
 *
 * @author houjianpo
 * @version 1.0.0
 * @date 09:15 2020/12/23
 */
public class HanoiTower {

    public static void main(String[] args) {
        move(3, 'A', 'B', 'C' );
    }

    /**
     * 移动盘子，递归方法
     *
     * @param topN   要移动的顶部盘子个数
     * @param from   从哪个底座
     * @param middle 中间底座
     * @param to     目标底座
     * @author houjianpo
     * @date 09:16 2020/12/23
     * @version 1.0.0
     */
    public static void move(int topN, char from, char middle, char to) {
        // 如果topN == 1，那就是移动最后一个盘子，直接从from到to
        if (topN == 1) {
            System.out.println("盘子1，从" + from + "塔座，移动到" + to + "塔座");
        } else {
            move(topN - 1, from, to, middle);
            System.out.println("盘子" + topN + "，从" + from + "塔座，移动到" + to + "塔座");
            move(topN - 1, middle, from, to);
        }
    }
}
