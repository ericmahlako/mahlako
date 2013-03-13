package za.multichoice.astar.tests;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import za.multichoice.astar.map.FileMap;


public class FileMapTest
{
	public static void main(String[] args) {

		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		System.out.print("Please enter absolute path (e.g /home/files/test_map.txt) : ");
		String filepath = null;

		try {
			filepath = reader.readLine();
		} catch (IOException e) {
			e.printStackTrace();
		}

		new FileMap(filepath).findPath(0, 0, 49, 49);
	}
}
