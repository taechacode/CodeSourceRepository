package TestCode00;

import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		ArrayList<Integer> list = new ArrayList<>();
		list.add(3);
		list.add(5);
		list.add(2);
		list.add(7);
		System.out.println(list);
		
		list.add(0, 9);
		list.add(0, 6);
		System.out.println(list);
	}
}
