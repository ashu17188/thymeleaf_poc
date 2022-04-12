package org.ashu.thymeleaf;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class DoublyLinkedList<T> {
	Node<T> headNode;
	Node<T> tailNode;
	int size;

	class Node<T> {
		T data;
		Node<T> nextNode;
		Node<T> prevNode;
	}

	public void insertAtHead(T data) {
		Node<T> newNode = new Node<T>();
		newNode.data = data;
		newNode.nextNode = headNode;

		if (headNode != null) {
			headNode.prevNode = newNode;
		} else {
			tailNode = newNode;
		}
		headNode = newNode;
		size++;

	}

	public void insertAtEnd(T data) {
		if(isEmpty()) {
			insertAtHead(data);
			return;
		}
		Node newNode = new Node();
		newNode.data = data;
		
		tailNode.nextNode = newNode;
		newNode.prevNode = tailNode;
		tailNode = newNode;
		size++;
	}
	
	public boolean isEmpty() {
		return size == 0;
	}
	public void printFromHead() {
		Node<T> current = headNode;
		while (current != null) {
			log.info("Current: {}", current.data);
			current = current.nextNode;
		}
	}

	public void printFromTail() {
		Node<T> current = tailNode;
		while (current != null) {
			log.info("Current: {}", current.data);
			current = current.prevNode;
		}
	}

}
