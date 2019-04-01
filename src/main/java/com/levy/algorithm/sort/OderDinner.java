package com.levy.sort;

import java.util.Arrays;

public class OderDinner {
	
	
	private  static int[] list;
	
	public static void main(String[] args){
		
		int[] menu = {1, 2, 3 ,4,5,6, 7, 8, 9};
		int cash = 10;
		int number = 3;
		list = new int[number];
		//order(menu, cash, number, 0, list);
		
		//hardCode();
		hardCode2(0, menu, number);
		
	}
	
	
	
	
	public static void order(int[] menu, int cash, int number, int begin, String list){
		String tmp = list;
		for(int i = begin ; i < menu.length; i++){
			tmp = list + menu[i];
			if (cash < 0){
				break;
			}
			
			if (number > 1){
				number--;
				list = list + menu[i];
				cash = cash - menu[i];
				order(menu, cash, number, i+1, list);
			}else{
				if (cash >=  menu[i] ){
					System.out.println(list + menu[i]);
				}
			}
		}
	}
	
	
	public static void hardCode2(int i, int[] menu, int number){
				
		for(; i < menu.length; i ++){
			if (number == 1){
				output(i, menu);
				number++;
			}else{
				list[number -1] = i;
				hardCode2(i+1,menu, --number);	
				number++;
			}
			
		}
	}
	
	
	public static void output(int j, int[] menu){
		int cash = 0;
		for(int k = j ; k < menu.length; k++){
			cash = 10;
			list[0] = k;
			for(int m : list){
				cash = cash - menu[m];
			}
			if(cash >= 0){
				for(int m : list){
					System.out.print(menu[m]);
				}
				System.out.println("");
			}
		}
	}
	
	public static void hardCode(){
		int[] menu = {1, 2, 3 ,4  ,5, 6, 7, 8, 9};
		int cash = 0;	
		
		//µãÈı¸ö²Ë
		for(int i = 0 ; i < menu.length; i ++){
			for(int j = i+1 ; j < menu.length; j++){
				for(int k = j+1 ; k < menu.length; k++){
					cash = 10;
					cash = cash - menu[i] - menu[j] - menu[k];
					if(cash >= 0){
						System.out.println(menu[i] +""+ menu[j]+""+menu[k]);
					}
				}
			}
		}
	}
}
