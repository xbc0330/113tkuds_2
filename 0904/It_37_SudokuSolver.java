public class It_37_SudokuSolver {
    public void solveSudoku(char[][] board) {
        int[] rows = new int[9], cols = new int[9], boxes = new int[9];
        int emptyCount = 0;
        for (int r = 0; r < 9; r++) {
            for (int c = 0; c < 9; c++) {
                char ch = board[r][c];
                if (ch == '.') {
                    emptyCount++;
                } else {
                    int d = ch - '1';
                    int mask = 1 << d;
                    rows[r] |= mask;
                    cols[c] |= mask;
                    boxes[(r / 3) * 3 + (c / 3)] |= mask;
                }
            }
        }
        dfs(board, rows, cols, boxes, 0, 0);
    }

    private boolean dfs(char[][] b, int[] rows, int[] cols, int[] boxes, int r, int c) {
        if (r == 9) return true;
        int nr = c == 8 ? r + 1 : r;
        int nc = c == 8 ? 0 : c + 1;
        if (b[r][c] != '.') return dfs(b, rows, cols, boxes, nr, nc);
        int used = rows[r] | cols[c] | boxes[(r / 3) * 3 + (c / 3)];
        for (int d = 0; d < 9; d++) {
            int mask = 1 << d;
            if ((used & mask) != 0) continue;
            b[r][c] = (char) ('1' + d);
            rows[r] |= mask;
            cols[c] |= mask;
            boxes[(r / 3) * 3 + (c / 3)] |= mask;
            if (dfs(b, rows, cols, boxes, nr, nc)) return true;
            rows[r] ^= mask;
            cols[c] ^= mask;
            boxes[(r / 3) * 3 + (c / 3)] ^= mask;
            b[r][c] = '.';
        }
        return false;
    }
}