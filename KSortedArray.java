package prog;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class KSortedArray {
	public static void solver(int[] arr, int k) {
		PriorityQueue<Integer> pq = new PriorityQueue<>();
		for(int i=0;i<=k;i++) {
			pq.add(arr[i]);
		}
		arr[0] = pq.remove();
		int i;
		for(i=1;i<arr.length-k;i++) {
			pq.add(arr[i+k]);
			arr[i] = pq.remove();
		}
		while(pq.size()>0) {
			arr[i] = pq.remove();
			i++;
		}
		for(int val:arr) {
			System.out.println(val);
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[] arr = new int[n];

		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}

		int k = Integer.parseInt(br.readLine());
		solver(arr, k);
	}

}
