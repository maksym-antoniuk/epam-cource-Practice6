package ua.nure.antoniuk.Practice6.part5;

public class Tree<E extends Comparable<E>> {

	private static final String INDENT = "   ";

	private Node<E> root = null;

	public boolean remove(E element) {
		if (root == null) {
			return false;
		}
		return remove(element, root);
	}

	private boolean remove(E element, Node<E> node) {
		Node<E> parent = node.parent;
		if (node.element.compareTo(element) == 0) {
			if (node.left == null && node.right == null) {
				if (node.parent.left == node) {
					node.parent.left = null;
				} else {
					node.parent.right = null;
				}
				return true;
			}
			if (node.left == null && node.right != null) {
				if (node.parent.left == node) {
					node.parent.left = node.right;
				} else {
					node.parent.right = node.right;
				}
				node.parent = parent;
				return true;
			}
			if (node.left != null && node.right == null) {
				if (node.parent.left == node) {
					node.parent.left = node.left;
				} else {
					node.parent.right = node.left;
				}
				node.parent = parent;
				return true;
			}
			if (node.right.left == null) {
				if (node.parent.left == node) {
					node.parent.left = node.right;
				} else {
					node.parent.right = node.right;
				}
				node.right.left = node.left;
				node.parent = parent;
				return true;
			} else {
				Node<E> temp = node.right;
				while (temp.left.left != null) {
					temp = temp.left;
				}
				node.element = temp.left.element;
				temp.left = null;
				node.parent = parent;
				return true;
			}
		}
		if (node.left != null && node.right != null) {
			if (node.element.compareTo(element) > 0) {
				return remove(element, node.left);
			} else {
				return remove(element, node.right);
			}
		}
		if (node.left == null && node.right != null) {
			if (node.element.compareTo(element) > 0) {
				return false;
			} else {
				return remove(element, node.right);
			}
		}
		if (node.right == null && node.left != null) {
			if (node.element.compareTo(element) < 0) {
				return false;
			} else {
				return remove(element, node.left);
			}
		}
		return false;
	}

	public void add(E[] elements) {
		for (E e : elements) {
			add(e);
		}
	}

	public boolean add(E e) {
		if (root == null) {
			root = new Node<E>();
			root.element = e;
			return true;
		} else {
			Node<E> temp = root;
			while (true) {
				if (temp.element.compareTo(e) == 0 && temp != null) {
					return false;
				}
				if (temp.element.compareTo(e) < 0) {
					if (temp.right == null) {
						Node<E> node = new Node<>();
						node.element = e;
						node.parent = temp;
						temp.right = node;
						return true;
					} else {
						temp = temp.right;
					}
				} else {
					if (temp.left == null) {
						Node<E> node = new Node<>();
						node.element = e;
						node.parent = temp;
						temp.left = node;
						return true;
					} else {
						temp = temp.left;
					}
				}
			}
		}
	}

	public void print() {
		if (root == null) {
			return;
		}
		if (root.right != null) {
			print(root.right, 1);
		}
		if (root != null) {
			System.out.println(root.element);
		}
		if (root.left != null) {
			print(root.left, 1);
		}
	}

	private void print(Node<E> node, int c) {
		if (node.right == null && node.left == null) {
			for (int i = 0; i < c; i++) {
				System.out.print(INDENT);
			}
			System.out.println(node.element);
			return;
		}
		if (node.right != null && node.left != null) {
			print(node.right, c + 1);
			for (int i = 0; i < c; i++) {
				System.out.print(INDENT);
			}
			System.out.println(node.element);
			print(node.left, c + 1);
			return;
		}
		if (node.right != null) {
			print(node.right, c + 1);
			for (int i = 0; i < c; i++) {
				System.out.print(INDENT);
			}
			System.out.println(node.element);
			return;
		}
		if (node.left != null) {
			for (int i = 0; i < c; i++) {
				System.out.print(INDENT);
			}
			System.out.println(node.element);
			print(node.left, c + 1);
		}
	}

	private static class Node<E> {
		E element;
		Node<E> left;
		Node<E> right;
		Node<E> parent;
	}

}
