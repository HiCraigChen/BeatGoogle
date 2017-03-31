package edu.nccu.beatGoogle;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

public class KeywordCounter 
{
	private String urlStr;
	private String content;
	
	public KeywordCounter(String urlStr)
	{
		this.urlStr = urlStr;
	}
	
	public String getContent()
	{
		return content;
	}
	
	private String fetchContent() throws IOException
	{
		URL url = new URL(this.urlStr);
		URLConnection conn =url.openConnection();
		InputStream in = conn.getInputStream();
		BufferedReader br = new BufferedReader(new InputStreamReader(in));
		String retVal="";
		String line = null;
		while ((line = br.readLine())!=null) 
		{
			retVal = retVal + line + "\n";
		}
		return retVal;
	}
	public int countKeyword(String keyword) throws IOException
	{
		while(content==null)
		{
			content = fetchContent();
		}
		
		int retVal = 0;
		int fromIdx = 0;
		int found = -1;
		while ((found=content.indexOf(keyword, fromIdx))!=-1) 
		{
			retVal++;
			fromIdx = found +keyword.length();
		}
		
		return retVal;
	}
}
