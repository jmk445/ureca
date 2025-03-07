package basic.sort;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class CollectionSortTeset {
	public static void main(String[] args) {
		
		//Collection중 대표적인 예시인 arrayList의 정렬
		List<Item> list = new ArrayList<>();
		list.add(new Item(3, "66"));
		list.add(new Item(5, "99"));
		list.add(new Item(4, "77"));
		list.add(new Item(7, "66"));
		
		// #1. Comparable
		Collections.sort(list); //implements Comparable한 객체가 아닐 경우 컴파일 에러
		System.out.println(list);
		
		
		//#2. lambda
		Collections.sort(list,(o1,o2)->o1.ItemId - o2.ItemId);
	}
	
	static class Item implements Comparable<Item>{
		int ItemId;
		String itemNm;
		
		Item(int itemId, String itemNm){
			this.ItemId = itemId;
			this.itemNm = itemNm;
		}

		@Override
		public String toString() {
			return "Item [ItemId=" + ItemId + ", itemNm=" + itemNm + "]";
		}
		

		@Override
		public int compareTo(Item o) {			
			return this.ItemId - o.ItemId; //natural order
		}
	}

}


