package com.netcracker;

public class MassSorter {

	public static Integer[] sort(Integer[] mass) {
		Integer[] temp; 
		// Distance between elements that we put in one group (amount of groups) 
		Integer lvl;
		
		// i - amount of elements in one group
		for(int i = 2; i <= mass.length / 2; i = i * 2) {
			lvl = mass.length / i;
			
			SortThread[] threads = new SortThread[lvl];
			
			// spliting mass into groups
			// j - number of current group
			for(int j = 0; j < lvl; j++) {
				temp = new Integer[i];
				// k - iteration variable in group
				for(int k = 0; k < i; k++) {
					temp[k] = mass[j + k * lvl];
				}
				threads[j] = new SortThread(temp);
				threads[j].start();
			}
			
			for(int j = 0; j < lvl; j++) {
				try {
					threads[j].join();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			
			// bringing together groups into mass
			// j - number of current group
			for(int j = 0; j < lvl; j++) {
				temp = threads[j].getMass();
					
				// k - iteration variable in group
				for(int k = 0; k < i; k++) {
					mass[j + k * lvl] = temp[k]; 
				}
			}
			
			System.out.print( "\nПромежуточный массив = ");
	    	for(int l = 0; l < mass.length; l++)
	    		System.out.print( " " + mass[l]);
		}
		
		
		
		SortThread lastThread = new SortThread(mass);
		lastThread.start();
		try {
			lastThread.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	
		return lastThread.getMass();
	}
	
}
