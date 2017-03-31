package edu.nccu.beatGoogle;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map.Entry;
import java.util.Scanner;

public class Main {
public static void main(String[] args) throws IOException{
	Scanner sc = new Scanner(System.in);
	while(sc.hasNextLine()){
		String queryStr = sc.nextLine();
		GoogleSearch gSearch = new GoogleSearch(queryStr);
		HashMap<String, String> results = gSearch.getResults();
		for(Entry<String,String> entry : results.entrySet()){
			
			String title = entry.getKey();
			String url = entry.getValue();
			
			System.out.println(title+""+url);
			
		}
	}
}
}