import java.util.Scanner;

public class Main {
	static Scanner scn = new Scanner(System.in);

	/*
	 * Given a board of 0's & 1's print : 1.all paths from (0,0) to
	 * (nrows-1,ncols-1) 2.longest path & its length 3.shortest path & its length
	 * 4.count of all paths
	 */
	public static void floodFill() {
		int nr = scn.nextInt(), nc = scn.nextInt();
		int board[][] = new int[nr][nc];
		for (int i = 0; i < nr; i++) {
			for (int j = 0; j < nc; j++) {
				board[i][j] = scn.nextInt();
			}
		}

		int dir[][] = { { -1, 0 }, { -1, +1 }, { 0, +1 }, { +1, +1 }, { +1, 0 }, { +1, -1 }, { 0, -1 }, { -1, -1 } };
		String dirCh[] = { "N", "DUR", "E", "DLR", "S", "DLL", "W", "DUL" };
		int count[] = { 0 };
//		floodFillWithoutRetType(board, 0, 0, "", dir, dirCh, count);
		ffSolver res = floodFill(board, 0, 0);
		System.out.println("Count : " + res.count);
		System.out.println(res.sPath);
		System.out.println(res.lPath);
//		System.out.println("in");
	}

	public static void floodFillWithoutRetType(int[][] board, int r, int c, String psf, int dir[][], String[] dirCh,
			int count[]) {
		if (r == board.length - 1 && c == board[0].length - 1) {
			// destination Reached
			System.out.println(psf + ".");
			count[0] = count[0] + 1;
			return;
		}

		board[r][c] = -1; // visited
		for (int i = 0; i < dir.length; i++) {
			int upRow = r + dir[i][0], upCol = c + dir[i][1];
			if (upRow < 0 || upCol < 0 || upRow == board.length || upCol == board[0].length
					|| board[upRow][upCol] != 0) {
				continue;
				// either the next location is out of the board or next
				// location is already visited or may contain wall
			}
			floodFillWithoutRetType(board, upRow, upCol, psf + "->" + dirCh[i], dir, dirCh, count);
		}
		board[r][c] = 0;// unvisited
	}

	static class ffSolver {
		int count, lenOfSPath, lenOfLPath;
		String sPath, lPath;

		ffSolver(int count, int lenOfSPath, int lenOfLPath, String sPath, String lPath) {
			this.lenOfLPath = lenOfLPath; 
		    this.lenOfSPath = lenOfSPath;
		    this.count = count;
			this.lPath = lPath;
			this.sPath = sPath;
		}
	}

	static int direction[][] = { { -1, 0 }, { -1, +1 }, { 0, +1 }, { +1, +1 }, { +1, 0 }, { +1, -1 }, { 0, -1 },
			{ -1, -1 } };
	static String label[] = { "N", "DUR", "E", "DLR", "S", "DLL", "W", "DUL" };

	public static ffSolver floodFill(int[][] board, int sr, int sc) {
		if (sr == board.length - 1 && sc == board[0].length - 1) {
			return new ffSolver(1, 0, 0, "", "");
		}

		board[sr][sc] = -1;
		int count = 0 , lenOfSPath = Integer.MAX_VALUE , lenOfLPath = Integer.MIN_VALUE;
		String sPath = "" , lPath = "";
		
		for (int i = 0; i < 8; i++) {
			int ur = sr + direction[i][0], uc = sc + direction[i][1];
			if (ur < 0 || uc < 0 || ur == board.length || uc == board[0].length || board[ur][uc] != 0) {
				continue;
			}
			ffSolver rres = floodFill(board, ur, uc);
			count += rres.count;
			if(rres.lenOfSPath < lenOfSPath) {
				lenOfSPath = rres.lenOfSPath;
				sPath = label[i]+" "+rres.sPath;
			}
			if(rres.lenOfLPath > lenOfLPath) {
				lenOfLPath = rres.lenOfLPath;
				lPath = label[i]+" "+rres.lPath;
			}
		}
		if(lenOfLPath != Integer.MIN_VALUE) {			
			lenOfLPath += lenOfLPath+1;
		}
		if(lenOfSPath != Integer.MAX_VALUE) {			
			lenOfSPath += lenOfSPath+1;
		}
		board[sr][sc] = 0;
		
		return new ffSolver(count,lenOfSPath,lenOfLPath,sPath,lPath);
	}

	public static void solver() {
		floodFill();
	}

	public static void main(String args[]) {
		solver();
	}
}
