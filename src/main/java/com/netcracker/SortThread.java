package com.netcracker;

public class SortThread extends Thread{
	
	private Integer[] mass = null;
	
	
	public SortThread(Integer[] mass) {
		this.mass = mass;
	}
	
	public Integer[] getMass() {
		return mass;
	}
	
	@Override
    public void run() {
	
		Integer cur;
		
		for(int i = 1; i < mass.length; i++) {
			
			cur = mass[i];
			
			int j = i - 1;
			boolean ok = true;
			
			while(j >= 0 && ok) {
				
				if(mass[j] > cur) {
					mass[j + 1] = mass[j];
					j--;
				}
				else {
					mass[j + 1] = cur;
					ok = false;
				}
			}
			
			if(j == -1) {
				mass[0] = cur;
			}
			
		}
		
	}
	
}
