package com.general.stack;

import java.util.Scanner;

public class BasicStack {

	private static int CAPACITY;
	private static int[] stackElements;
	private static int top=-1;

	public BasicStack(int capacity) {
		CAPACITY = capacity;
		stackElements = new int[CAPACITY];
	}

	public int getCAPACITY() {
		return CAPACITY;
	}

	public static void main(String[] args) {
		BasicStack stack = new BasicStack(5);
		Scanner scanner = new Scanner(System.in);
		System.out.println("Select one of the options from below:");
		System.out.println("1 - push\n" + "2 - pop\n" + "3 - top element\n" + "4 - capacity\n"
				+ "5 - stack full check\n" + "6 - stack empty check\n" + "7 - number of elements in the stack\n"
				+ "8 - print the elements in the stack\n"+"Press any other key to exit ");
		boolean run = true;
		while (run) {
			System.out.println("enter one of the options");
			int argument = scanner.nextInt();
			switch (argument) {
			case 1:
				System.out.println("enter the element to be pushed : ");
				push(scanner.nextInt());
				break;
			case 2:
				pop();
				break;
			case 3:
				top();
				break;
			case 4:
				System.out.println("capacity of the stack is : " + stack.getCAPACITY());
				break;
			case 5:
				System.out.println(stackFull()?"stack is full.":"stack is not full");
				break;
			case 6:
				System.out.println(stackEmpty()?"stack is empty.":"stack is not empty");
				break;
			case 7:
				System.out.println("Size : " + (top+1));
				break;
			case 8:
				System.out.print("stack elements : ");
				for (int i = 0; i <= top; i++) {
					System.out.print(stackElements[i] + " ");
				}
				System.out.println();
				break;
			default:
				run = false;
				break;
			}
		}
		scanner.close();
	}

	// function to add the elements
	public static void push(int num) {
		if ((top+1) != CAPACITY) {
			stackElements[++top] = num;
		} else {
			System.out.println("stack is full. Can't push the element");
		}
	}

	// function to remove the element
	public static void pop() {
		if (top != -1) {
			System.out.println("pop element : " + stackElements[top--]);
		} else {
			System.out.println("no elements to pop.Stack is empty");
		}

	}

	// function to return the top element
	public static void top() {
		if (top != -1) {
			System.out.println("top element : " + stackElements[top]);
		} else {
			System.out.println("no elements.Stack is empty");
		}
	}

	// function to check stack empty condition
	public static boolean stackEmpty() {
		return (top == -1);
	}

	// function to check stack full condition
	public static boolean stackFull() {
		return ((top+1) == CAPACITY);
	}
}
