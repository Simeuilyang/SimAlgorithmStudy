class Solution {
     // 1 1 0 -1
    public int captureForts(int[] forts) {
        int maxCnt = 0;
        int idx = -1;
        for (int i=0; i<forts.length; i++) {
            if (forts[i] == 1) {
                idx = i;
            } else if (forts[i] == -1 && idx >= 0) {
                maxCnt = Math.max(maxCnt, Math.abs(idx - i) - 1);
                idx = -1;
            }
        }

        idx = -1;
        for (int i=forts.length-1; i>=0; i--) {
            if (forts[i] == 1) {
                idx = i;
            } else if (forts[i] == -1 && idx >= 0) {
                maxCnt = Math.max(maxCnt, Math.abs(idx - i) - 1);
                idx = -1;
            }
        }

        // int maxCnt = 0;
        // int cnt = 0;
        // boolean isCheck = false;
        // for (int i=0; i<forts.length; i++) {
        //     if (forts[i] == 1) {
        //         cnt = 0;
        //         isCheck = true;
        //     } else if (forts[i] == 0 && isCheck) {
        //         cnt++;
        //     } else if (forts[i] == -1 && isCheck) {
        //         maxCnt = Math.max(maxCnt, cnt);
        //         isCheck = false;
        //         cnt = 0;
        //     }
        // }

        // cnt = 0;
        // isCheck = false;
        // for (int i=forts.length-1; i>=0; i--) {
        //     if (forts[i] == 1) {
        //         cnt = 0;
        //         isCheck = true;
        //     } else if (forts[i] == 0 && isCheck) {
        //         cnt++;
        //     } else if (forts[i] == -1 && isCheck) {
        //         maxCnt = Math.max(maxCnt, cnt);
        //         isCheck = false;
        //         cnt = 0;
        //     }
        // }

        return maxCnt;
    }
}