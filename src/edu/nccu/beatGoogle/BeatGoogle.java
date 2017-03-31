package edu.nccu.beatGoogle;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Map;
import java.util.Map.Entry;

public class BeatGoogle 
{
	private ArrayList<Keyword> keywords;
	public ArrayList<Website> roots;
	public BeatGoogle(ArrayList<Keyword> keywords)
	{
		this.keywords = keywords;
	}
	
	public ArrayList<Website> query(String searchWord) throws IOException
	{
		//call Google
		GoogleSearch gSearch = new GoogleSearch(searchWord);
		Map<String, String> titleUrlMap = gSearch.getResults();
		
		//create website tree based on google search's results
		roots =new ArrayList<>();
		for(Entry<String,String> entry : titleUrlMap.entrySet())
		{
			String title = entry.getKey();
			String urlStr = entry.getValue();
			Website root = new Website(title, urlStr);
			roots.add(root);
			
			root.grows(keywords);
			root.evaluate();
			
		}
		
		Collections.sort(roots, new WebsiteComparator());
		
		return roots;
	}
}
