package org.ashu.thymeleaf;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class SinglyLinkedList<T> {
	Node headNode;
	int size;

	class Node {
		T data;
		Node nextNode;

		Node(T data) {
			this.data = data;
		}
	}

	public void insertAtHead(T data) {
		Node temp = new Node(data);

		temp.nextNode = headNode;
		headNode = temp;
		size++;
	}

	public void insertAtEnd(T data) {
		if (isEmpty()) {
			insertAtHead(data);
		} else {

			Node newNode = new Node(data);
			Node last = headNode;
			while (last.nextNode != null) {
				last = last.nextNode;
			}
			last.nextNode = newNode;
			size++;
		}
	}

	public Object search(T data) {
		if (isEmpty())
			return -1;
		for (Node p = headNode; p != null; p = p.nextNode) {
			if (p.data.equals(data)) {
				return data;
			}
		}
		return -1;
	}

	public void deleteByValue(T data) {
		Node previous = null;
		Node current = headNode;
		if(current.data.equals(data)) {
			size--;
			return;
		}
		while(current !=null) {
			if(current.data.equals(data)) {
				previous.nextNode = current.nextNode;
				size--;
				return;
			}
			previous =current;
			current = current.nextNode;
		}
	}
	
	public void reverse() {
		Node current = headNode;
		Node previous = null;
		while(current != null) {
			Node next = current.nextNode;
			current.nextNode = previous;
			previous = current;
			current = next;
		}
		this.headNode = previous;
	}
	
	public boolean isEmpty() {
		return size == 0;
	}

	public void printLinkedList() {
		for (Node p = headNode; p != null; p = p.nextNode) {
			log.info("Node: {}", p.data);
		}
	}
	
	
}
