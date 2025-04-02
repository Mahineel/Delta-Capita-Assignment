package com.deltacapita.logic;

import java.util.HashMap;
import java.util.Map;

public class DeltaCapita {

	public DeltaCapita() {
	}

	
	public static void main(String[] args) {
		
		Map<String, Integer> map = new HashMap<>();
        map.put("Apple", 35);
        map.put("Banana", 20);
        map.put("Melon", 50);
        map.put("Lime", 15);	
        
        String[] fruits = new String[]{"Apple","Apple","Banana", "Melon", "Apple","Melon", "Melon","Lime","Lime","Lime","Lime"};
        
        int cost = 0, melon = 0, lime = 0;
        for(String fruit: fruits) {
	            if(fruit.equals("Melon")) {
	                melon++;
	                if(melon==2) {
	                    melon = 0;
	                    continue;
	                }
	            } else if(fruit.equals("Lime")) {
	                lime++;
	                if(lime==3) {
	                    lime = 0;
	                    continue;
	                }
	            }
	            cost += map.get(fruit);
	        }
        System.out.println(cost);
     }
	}
