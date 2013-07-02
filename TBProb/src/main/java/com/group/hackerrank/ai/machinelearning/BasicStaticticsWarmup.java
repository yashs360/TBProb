package com.group.hackerrank.ai.machinelearning;

import java.util.Scanner;
import java.util.TreeMap;

public class BasicStaticticsWarmup {
	
	
	public void solve(){
		
		Scanner sc = new Scanner(System.in);
		int N = Integer.parseInt(sc.nextLine());
		
		String[] data = sc.nextLine().split(" ");
		
		TreeMap<Double, Integer> map = new TreeMap<Double, Integer>();
		double sum=0;
		double number=0;
		for(String num : data){
			number = Double.parseDouble(num);
			sum+=number;
			if(null==map.get(number)){
				map.put(number, 1);
			}
			else{
				map.put(number, map.get(num)+1);
			}
				
		}
		
		double[] mapKeys = new double[map.size()];
		int pos = 0;
		int modeVal=Integer.MIN_VALUE;
		double modeElement = 0;
		double stdDeviation = 0;
		
		
		for (double key : map.keySet()) {
		    mapKeys[pos++] = key;
		    
		    /** Mode calculation **/
		    if(map.get(key)>modeVal){
		    	modeVal = map.get(key);
		    	modeElement = key;
		    }
		    
		    /** Standard Deviation calculation **/
		    stdDeviation += Math.pow((key - (sum/(double)N)), 2);
		    
		}
		
		
		double mean = (sum/(double)N);
		double merdian = 0;
		int mode = (int)modeElement;
		double stdDev = Math.sqrt(stdDeviation/N);
		double lowerBound = mean - 1.96*(stdDev/Math.sqrt(N));
		double upperBound = mean + 1.96*(stdDev/Math.sqrt(N));
		
		if(mapKeys.length%2==0){
			merdian = (mapKeys[mapKeys.length/2] + mapKeys[mapKeys.length/2 -1])/(double)2;
		}
		else{
			merdian = mapKeys[mapKeys.length];
		}
		
		
		System.out.printf("%.1f\n", mean);
		System.out.printf("%.1f\n", merdian);
		System.out.println(mode);
		System.out.printf("%.1f\n", stdDev);
		System.out.printf("%.1f %.1f\n", lowerBound,upperBound);
		
		
	}
	
	
	public static void main(String[] args) {
		new BasicStaticticsWarmup().solve();
	}

}
