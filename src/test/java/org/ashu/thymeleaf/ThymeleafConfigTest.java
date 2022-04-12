package org.ashu.thymeleaf;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

import org.junit.jupiter.api.Test;

import lombok.extern.slf4j.Slf4j;

@Slf4j
class ThymeleafConfigTest {

	@Test
	void test() {
//		fail("Not yet implemented");
	}

	class Interval {
		int start;
		int end;

		public Interval(int start, int end) {
			this.start = start;
			this.end = end;
		}
	};

	@Test
	void testSumPair() {
		SinglyLinkedList<Integer> sll1 = new SinglyLinkedList<>();
		sll1.insertAtEnd(2);
		sll1.insertAtEnd(6);
		sll1.insertAtEnd(6);
		
		SinglyLinkedList<Integer> sll2 = new SinglyLinkedList<>();
		sll2.insertAtEnd(3);
		sll2.insertAtEnd(6);
		sll2.insertAtEnd(7);
		
		SinglyLinkedList<Integer> sll3 = new SinglyLinkedList<>();
		sll3.insertAtEnd(1);
		sll3.insertAtEnd(3);
		sll3.insertAtEnd(4);
		
		
		List<SinglyLinkedList<Integer>.Node> lists = new ArrayList<>();
		lists.add(sll1.headNode);
		lists.add(sll2.headNode);
		lists.add(sll3.headNode);
		
		SinglyLinkedList<Integer> result = mergeSortedList(lists);
		result.printLinkedList();
	}

	public <T> SinglyLinkedList<T>.Node reverse(SinglyLinkedList<T> sll, int p, int q) {
		SinglyLinkedList<T>.Node head = sll.headNode;
		SinglyLinkedList<T>.Node current = head;
		SinglyLinkedList<T>.Node lastNodeOfFirstPart = null;
		SinglyLinkedList<T>.Node lastNodeOfSubList = null;
		SinglyLinkedList<T>.Node previous = null;
		current = head;

		for (int i = 0; i < p - 1 && current != null; i++) {
			previous = current;
			current = current.nextNode;
		}
		lastNodeOfFirstPart = previous;
		lastNodeOfSubList = current;

		SinglyLinkedList<T>.Node next = null;
		for (int i = 0; i < q - p + 1 && current != null; i++) {
			next = current.nextNode;
			current.nextNode = previous;
			previous = current;
			current = next;
		}

		if (lastNodeOfFirstPart != null) {
			lastNodeOfFirstPart.nextNode = previous;
		} else {
			lastNodeOfFirstPart = head;
		}
		lastNodeOfSubList.nextNode = current;

		return head;

	}

	public SinglyLinkedList<Integer> mergeSortedList(List<SinglyLinkedList<Integer>.Node> lists) {
		SinglyLinkedList<Integer> result = new SinglyLinkedList<Integer>();
		Queue<SinglyLinkedList<Integer>.Node> minHeap = new PriorityQueue<>((a, b) -> a.data - b.data);
		
		for (SinglyLinkedList<Integer>.Node roots : lists) {
			minHeap.add(roots);
		}
		int previous = 0;
		while(!minHeap.isEmpty()) {
			SinglyLinkedList<Integer>.Node node = minHeap.poll();
			if(previous !=  node.data) {
				result.insertAtEnd(node.data);				
			}
			previous = node.data;
			if(node.nextNode !=null) {
				minHeap.add(node.nextNode);
			}
		}
		
		return result;

	}

	public <T> SinglyLinkedList<Integer> findSum(SinglyLinkedList<T> sll1, SinglyLinkedList<T> sll2) {
		SinglyLinkedList<Integer> result = new SinglyLinkedList<Integer>();

		sll1.reverse();
		sll2.reverse();
		SinglyLinkedList<T>.Node head1 = sll1.headNode;
		SinglyLinkedList<T>.Node head2 = sll2.headNode;
		int carry = 0;
		while (head1 != null || head2 != null || carry > 0) {
			int first = head1 == null ? 0 : (int) head1.data;
			int second = head2 == null ? 0 : (int) head2.data;

			int sum = first + second + carry;
			carry = sum / 10;
			sum = sum % 10;
			result.insertAtEnd(sum);

			if (head1 != null) {
				head1 = head1.nextNode;
			}
			if (head2 != null) {
				head2 = head2.nextNode;
			}

		}
		result.reverse();
		return result;

	}
}