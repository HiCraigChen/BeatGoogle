package edu.nccu.beatGoogle;

import java.util.Comparator;

public class WebsiteComparator implements Comparator<Website>
{
	@Override
	public int compare(Website o1,Website o2)
	{
		return o2.globalScore - o1.globalScore;
	}
}
