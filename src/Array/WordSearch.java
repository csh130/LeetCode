package Array;

import java.awt.Point;
import java.util.ArrayList;

import javax.swing.text.AbstractDocument.LeafElement;

/**
 * 
 * Given a 2D board and a word, find if the word exists in the grid.
 * 
 * The word can be constructed from letters of sequentially adjacent cell, where
 * "adjacent" cells are those horizontally or vertically neighboring. The same
 * letter cell may not be used more than once.
 * 
 * For example, Given board =
 * 
 * [ ['A','B','C','E'], ['S','F','C','S'], ['A','D','E','E'] ] word = "ABCCED",
 * -> returns true, word = "SEE", -> returns true, word = "ABCB", -> returns
 * false.
 * */
public class WordSearch {

	public static void main(String[] args) {
		char[][] board = { { 'C', 'A', 'A' }, { 'A', 'A', 'A' },
				{ 'B', 'C', 'D' } };
		String word = "AAB";
		WordSearch w = new WordSearch();
		System.out.println(w.exist(board, word));
	}

	public static boolean[][] visited;

	public boolean exist(char[][] board, String word) {
		visited = new boolean[board.length][board[0].length];
		// int[][] visited = new int[board.length][board[0].length];
		char[] ch = word.toCharArray();

		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[i].length; j++) {
				if (check(board, i, j, ch, 0))
					return true;
			}
		}
		return false;
	}

	public boolean check(char[][] board, int row, int col, char[] c, int i) {
		// 如果要找的 word 到 length 长度的 char 了 说明已经找完了
		if (i == c.length)
			return true;

		//如果超出范围 就返回 false 或者当前字符不等于 char[i]
		if (row < 0 || col < 0 || row >= board.length || col >= board[0].length
				|| visited[row][col] || c[i] != board[row][col])
			return false;

		visited[row][col] = true;
		//此处用递归 检查下一个 char 
		if (check(board, row + 1, col, c, i + 1)
				|| check(board, row, col + 1, c, i + 1)
				|| check(board, row - 1, col, c, i + 1)
				|| check(board, row, col - 1, c, i + 1))
			return true;

		visited[row][col] = false;
		return false;

	}
}
