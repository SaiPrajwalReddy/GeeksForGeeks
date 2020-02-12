package Graphs;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class MinimumSwapsToSortArray {
	
	class Pair{
		
		int value;
		int index;
		
		Pair(int val,int i)
		{
			value = val;
			index = i;
		}
	}
	
	class PairComparator implements Comparator<Pair>{

		@Override
		public int compare(Pair o1, Pair o2) {
			// TODO Auto-generated method stub
			if(o1.value > o2.value)
				return -1;
			if(o1.value < o2.value)
				return 1;
			return 0;
		}
		
	}
	public static void main(String[] args) {
		int[] a = { 1, 0, 4, 3, 2 };
		MinimumSwapsToSortArray g = new MinimumSwapsToSortArray();
		System.out.println(g.minSwaps(a));
	}

	private int minSwaps(int[] a) {
		// TODO Auto-generated method stub
		boolean visited [] = new boolean[a.length];
		int res = 0;
		List<Pair> list = new ArrayList<Pair>();
		for(int i =0;i<a.length;i++)
		{
			Pair p = new Pair(a[i],i);
			list.add(p);
			
		}
		Collections.sort(list, new PairComparator());
		for(Pair temp : list)
		{	int i = temp.index;
			int val = temp.value;
			
			int cycleSize = 0;
			if(visited[i] == false && i!=val)
			{
				int j =i;
				
				while(!visited[j])
				{
					visited[j] = true;
					j = a[j];
					cycleSize++;
				}
			}
			
			if(cycleSize > 0)
				res = res + cycleSize;
		}
		return res;
	}
}
