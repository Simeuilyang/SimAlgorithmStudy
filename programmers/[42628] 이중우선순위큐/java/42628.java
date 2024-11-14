import java.util.*;
class Solution {
    public int[] solution(String[] operations) {
        PriorityQueue<Integer> maxPq1 = new PriorityQueue<>(Collections.reverseOrder());
        PriorityQueue<Integer> maxPq2 = new PriorityQueue<>(Collections.reverseOrder());
        int maxFlag = 1;
        PriorityQueue<Integer> minPq1 = new PriorityQueue<>();
        PriorityQueue<Integer> minPq2 = new PriorityQueue<>();
        int minFlag = 1;
        
        String[] operArr = null;
        String nowOper = null;
        int num;
        for (String operation : operations) {
            operArr = operation.split(" ");
            nowOper = operArr[0];
            num = Integer.parseInt(operArr[1]);
            if (nowOper.equals("I")) {
                if (maxFlag == 1)   maxPq1.offer(num);
                else    maxPq2.offer(num);
                
                if (minFlag == 1)   minPq1.offer(num);
                else    minPq2.offer(num);
            } else {    // nowOper == "D"
                if (num > 0) {  // D 1
                    // max pq 처리
                    if (maxFlag == 1)   maxPq1.poll();
                    else    maxPq2.poll();
                    
                    // min pq 처리
                    if (minFlag == 1) {
                        if (minPq1.size() <= 1) minPq1.clear();
                        else {
                            while (minPq1.size() > 1) {
                                minPq2.offer(minPq1.poll());
                            }
                            minPq1.clear();
                        }
                        minFlag = 2;
                    } else {    // minFlag == 2
                        if (minPq2.size() <= 1) minPq2.clear();
                        else {
                            while (minPq2.size() > 1) {
                                minPq1.offer(minPq2.poll());
                            }
                            minPq2.clear();
                        }
                        minFlag = 1;
                    }
                } else {    // D -1
                    // min pq 처리
                    if (minFlag == 1)   minPq1.poll();
                    else    minPq2.poll();
                    
                    // max pq 처리
                    if (maxFlag == 1) {
                        if (maxPq1.size() <= 1) maxPq1.clear();
                        else {
                            while (maxPq1.size() > 1) {
                                maxPq2.offer(maxPq1.poll());
                            }
                            maxPq1.clear();
                        }
                        maxFlag = 2;
                    } else {    // maxFlag == 2
                        if (maxPq2.size() <= 1) maxPq2.clear();
                        else {
                            while (maxPq2.size() > 1) {
                                maxPq1.offer(maxPq2.poll());
                            }
                            maxPq2.clear();
                        }
                        maxFlag = 1;
                    }
                }
            }
        }
        
        Integer min, max;
        if (minFlag == 1)   min = minPq1.poll();
        else    min = minPq2.poll();
        min = min == null ? 0 : min;
        
        if (maxFlag == 1)   max = maxPq1.poll();
        else    max = maxPq2.poll();
        max = max == null ? 0 : max;
        
        return new int[] {max, min};
    }
//     public int[] solution(String[] operations) {
//         int[] ans;
//         MinHeap minpq = new MinHeap(); // 오름차순 (최솟값)
//         MaxHeap maxpq = new MaxHeap(); // 내림차순 (최댓값)
        
//         int N = operations.length;
//         String[] s;
//         for(int i=0; i<N; i++) {
//         	s = operations[i].split(" ");
//         	int optnum = Integer.parseInt(s[1]);
//         	if(s[0].equals("I")) {
//         		minpq.Insert(optnum);
//         		maxpq.Insert(optnum);
//         	}else { // "D"
//         		if(optnum == 1) { // 최댓값 삭제
//         			if(maxpq.data.size() == maxpq.delete.size())	continue; // 빈큐에 대한 연산 -> 무시
//         			else {
//         				int max = maxpq.Top();
        				
//         				minpq.Delete(max);
//         				maxpq.Delete(max);
//         			}
//         		}else { // 최솟값 삭제
//         			if(minpq.data.size() == minpq.delete.size())	continue; // 빈큐에 대한 연산 -> 무시
//         			else {
//         				int min = minpq.Top();
        				
//         				minpq.Delete(min);
//         				maxpq.Delete(min);
//         			}
//         		}
//         	}
//         }
        
//         if(maxpq.data.size() == maxpq.delete.size())	ans = new int[] {0, 0};
//         else {
//         	int max = maxpq.Top();
//         	int min = minpq.Top();
        	
//         	ans = new int[] {max, min};
//         }
//         return ans;
//     }
    
//     private static class MinHeap{ // 오름차순
// 		PriorityQueue<Integer> data;
// 		PriorityQueue<Integer> delete;
		
// 		MinHeap(){
// 			data = new PriorityQueue<>();
// 			delete = new PriorityQueue<>();
// 		}
		
// 		public void Insert(int num) {
// 			data.add(num);
// 		}
		
// 		public void Delete(int num) {
// 			delete.add(num);
// 		}
		
// 		public int Top() { // 호출 전에 data, delete 크기 비교해주기 (같으면 pass)
// 			Adjust();
// 			return data.peek();
// 		}
		
// 		private void Adjust() {
// 			while(!delete.isEmpty() && data.peek().equals(delete.peek())) {
// 				data.remove();
// 				delete.remove();
// 			}
// 		}
// 	}
	
// 	private static class MaxHeap{ // 내림차순
// 		PriorityQueue<Integer> data;
// 		PriorityQueue<Integer> delete;
		
// 		MaxHeap(){
// 			data = new PriorityQueue<>(Collections.reverseOrder());
// 			delete = new PriorityQueue<>(Collections.reverseOrder());
// 		}
		
// 		public void Insert(int num) {
// 			data.add(num);
// 		}
		
// 		public void Delete(int num) {
// 			delete.add(num);
// 		}
		
// 		public int Top() {
// 			Adjust();
// 			return data.peek();
// 		}
		
// 		public void Adjust() {
// 			while(!delete.isEmpty() && data.peek().equals(delete.peek())) {
// 				data.remove();
// 				delete.remove();
// 			}
// 		}
// 	}
}