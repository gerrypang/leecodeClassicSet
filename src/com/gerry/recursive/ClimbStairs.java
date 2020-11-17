package com.gerry.recursive;

/**
 * 70. 爬楼梯<br>
 * https://leetcode-cn.com/problems/climbing-stairs/
 * 
 * @author pangguowei
 * @since 2020年11月17日
 */
public class ClimbStairs {

	public static void main(String[] args) {
		/**
		 * 假设你正在爬楼梯。需要 n 阶你才能到达楼顶。 
		 * 每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？
		 */
		System.out.println(climbStairs(5));
		System.out.println(climbStairs(45));
	}
	
	/**
	 * 简单递归
	 *
	 * @param n
	 * @return
	 
    public static int climbStairs(int n) {
    	// 1节台阶，有1种走法
    	if (n <= 0) {
    		return 1; 
    	}
    	if (n == 1) {
    		return 1; 
    	}
    	// 2节台阶，有两种走法
    	if (n == 2) {
    		return 2; 
    	}
		return climbStairs(n - 1) + climbStairs(n - 2);
	}*/

	/**
	 * 缓存节点+递归
	 *
	 * @param n
	 * @return
	 */
    public static int climbStairs(int n) {
		int[] chache = new int[n + 1];
    	return climbStairsCache(n, chache);
	}
    
    public static int climbStairsCache(int n, int[] chache) {
    	if (chache[n] > 0) {
    		return chache[n];
    	}
		if (n <= 1) { // 0 / 1 节台阶，有1种走法
			chache[n] = 1;
		} else if (n == 2) { // 2节台阶，有两种走法
			chache[n] = 2;
		} else {
			chache[n] = climbStairsCache(n - 1, chache) + climbStairsCache(n - 2, chache);
		}
		return chache[n];
	}

}
