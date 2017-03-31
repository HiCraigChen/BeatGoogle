package edu.nccu.beatGoogle;

import java.io.IOException;
import java.util.ArrayList;

public class Run 
{
	public static void main(String[] args) throws IOException
	{
		ArrayList<Keyword> keywords = new ArrayList<>();
		keywords.add(new Keyword("Answer",3));
		keywords.add(new Keyword("Solution",3));
		keywords.add(new Keyword("Manuals",3));
		keywords.add(new Keyword("Scribd",3));
		keywords.add(new Keyword("Yahoo knowledge",3));
		keywords.add(new Keyword("PDF",3));
		
		keywords.add(new Keyword("Chegg",-1));
		keywords.add(new Keyword("courseHero",-1));
		keywords.add(new Keyword("login",-1));
		keywords.add(new Keyword("sign in",-1));
		keywords.add(new Keyword("Amazon",-1));
	
		BeatGoogle beatGoogle = new BeatGoogle(keywords);
		ArrayList<Website> resultWebs = beatGoogle.query("Fallout");
		
		//print result webs...
	}
}
