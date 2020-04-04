package com.netcracker;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
    	Integer mass[] = {4, 5, 2, 1};
    	
    	System.out.print( "mass = ");
    	for(int i = 0; i < mass.length; i++)
    		System.out.print( " " + mass[i]);
        
        mass = MassSorter.sort(mass);
        
        System.out.print( "\nmass = ");
    	for(int i = 0; i < mass.length; i++)
    		System.out.print( " " + mass[i]);
    	
    	
    	Integer[] mass2 = {3, 12, 65, 3, 9, 10, 4, 5, 2};
    	
    	System.out.print( "\nmass2 = ");
    	for(int i = 0; i < mass2.length; i++)
    		System.out.print( " " + mass2[i]);
        
        mass2 = MassSorter.sort(mass2);
        
        System.out.print( "\nmass2 = ");
    	for(int i = 0; i < mass2.length; i++)
    		System.out.print( " " + mass2[i]);
    	
    }
}
