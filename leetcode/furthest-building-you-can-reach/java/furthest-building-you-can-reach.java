import java.util.*;

class Solution {
    public int furthestBuilding(int[] heights, int bricks, int ladders) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        int len = heights.length;
        for (int i=0; i<len-1; i++) {
            int diff = heights[i+1] - heights[i];

            if (diff < 0)   continue;   // 사다리, 벽돌 사용하지 않아도 되는 경우

            pq.offer(diff);
            if (pq.size() > ladders) {  // 사다리를 더이상 사용할 수 없는 경우
                int maxDiff = pq.poll();
                if (maxDiff <= bricks) {
                    bricks -= maxDiff;
                } else {
                    return i;
                }
            }

        }

        return len - 1;
    }

    // 시간 초과 
    // public int furthestBuilding(int[] heights, int bricks, int ladders) {
    //     int len = heights.length;
    //     int result = 0;
    //     Queue<Status> q = new LinkedList<>();
    //     q.add(new Status(0, bricks, ladders));

    //     while(q.size() != 0) {
    //         Status nowStatus = q.poll();
    //         int nowIdx = nowStatus.nowIdx;
    //         result = Math.max(result, nowIdx);
    //         int remainBricks = nowStatus.bricks;
    //         int remainLadders = nowStatus.ladders;

    //         if (nowIdx + 1 < len) {
    //             if (heights[nowIdx] >= heights[nowIdx + 1]) {   // bricks나 ladder가 필요없는 경우
    //                 q.add(new Status(nowIdx + 1, remainBricks, remainLadders));
    //             } else {    // 필요한 경우
    //                 int diff = heights[nowIdx + 1] - heights[nowIdx];
    //                 if (remainBricks >= diff) { // bricks 사용
    //                     q.add(new Status(nowIdx + 1, remainBricks - diff, remainLadders));
    //                 }

    //                 if (remainLadders > 0) {    // ladders 사용
    //                     q.add(new Status(nowIdx + 1, remainBricks, remainLadders - 1));
    //                 }
    //             }
    //         }
    //     }

    //     return result;
    // }

    // class Status {
    //     int nowIdx;
    //     int bricks; 
    //     int ladders;

    //     Status(int nowIdx, int bricks, int ladders) {
    //         this.nowIdx = nowIdx;
    //         this.bricks = bricks;
    //         this.ladders = ladders;
    //     }
    // }
}