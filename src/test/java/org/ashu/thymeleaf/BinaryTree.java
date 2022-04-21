package org.ashu.thymeleaf;

import java.util.List;

import javax.validation.constraints.NotNull;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class BinaryTree {

	class Node {
		Node left;
		Node right;
		int data;
	}

	Node root;
	int size;

	public void createBst(@NotNull List<Integer> list) {
		for(int value: list) {
			insert(value);
		}
	}

	public void insert(int data) {
		if (root == null) {
			root = new Node();
			root.data = data;
		} else {
			while (root != null) {
				if (root.data < data) {
					root = root.right;
				} else {
					root = root.left;
				}
			}
			root = new Node();
			root.data = data;
		}

	}
	public void inOrderTraversal(Node root) {
		if(null ==  root) return;
		
		log.info("{}", root.data);
		
	}
	
	public boolean isIdentical(Node root1, Node root2) {
		if (root1 == null && root2 == null) {
			return true;
		}

		if (root1 == null || root2 == null) {
			return false;
		}

		if (root1.data == root2.data && isIdentical(root1.left, root2.left) && isIdentical(root1.right, root2.right)) {
			return true;
		}

		return false;
	}
}
