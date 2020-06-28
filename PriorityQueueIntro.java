package prog;

import java.util.Collections;
import java.util.PriorityQueue;

public class PriorityQueueIntro {
	public static void main(String args[]) {
		PriorityQueue<Integer> pq = new PriorityQueue<>();

		pq.add(200);
		pq.add(300);
		pq.add(123);
		pq.add(199);
		pq.add(-100);

		System.out.println(pq);
		while (pq.size() > 0) {
			System.out.print(pq.remove() + " ");
		}
		System.out.println();
		
		//
		PriorityQueue<Integer> pq1 = new PriorityQueue<>(Collections.reverseOrder());

		pq1.add(200);
		pq1.add(300);
		pq1.add(123);
		pq1.add(199);
		pq1.add(-100);
		
		System.out.println(pq1);
		while (pq1.size() > 0) {
			System.out.print(pq1.remove() + " ");
		}
		System.out.println();

		PriorityQueue<String> pq2 = new PriorityQueue<>();
		
		pq2.add("India");
		pq2.add("Pakistan");
		pq2.add("US");
		pq2.add("Srilanka");
		pq2.add("China");
		
		System.out.println(pq2);
		while (pq2.size() > 0) {
			System.out.print(pq2.remove() + " ");
		}
		System.out.println();

	}
}
