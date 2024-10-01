class Solution {
    public boolean checkValid(int[][] matrix) {
        int n = matrix.length;
        boolean result = true;

        // check every row
        for (int i=0; i<n; i++) {
            boolean[] existed = new boolean[n+1];
            for (int j=0; j<n; j++) {
                int num = matrix[i][j];
                if (!existed[num]) {
                    existed[num] = true;
                } else {
                    return false;
                }
            }
        }

        // check every column
        if (result) {
            for (int j=0; j<n; j++) {
                boolean[] existed = new boolean[n+1];
                for (int i=0; i<n; i++) {
                    int num = matrix[i][j];
                    if (!existed[num]) {
                        existed[num] = true;
                    } else {
                        return false;
                    }
                }
            }
        }

        return true;
    }
}