package basic.sort;

import java.util.Arrays;
import java.util.Comparator;

public class ArraySortTest {
	public static void main(String[] args) {
		//배열 정렬
		
		
//		//int
//		int[] intArray = { 3, 5, 2, 7, 9, 4};
//		
//		System.out.println(Arrays.toString(intArray));
//		Arrays.sort(intArray);
//		System.out.println(Arrays.toString(intArray));
//		
//		//String
//		String[] strArray = {"Hello", "ABC", "World", "UPlus"};
//		
//		System.out.println(Arrays.toString(strArray));
//		Arrays.sort(strArray);
//		System.out.println(Arrays.toString(strArray));
//		Arrays.sort(strArray, Collections.reverseOrder());
//		
		//사용자 정의 클래스
		Item[] itemArray = {new Item(3, "66"),new Item(2, "77"),new Item(5, "44"),new Item(8, "11")};
		
		//#1. 사용자 정의클래스의 정렬 - 클래스에 정의
		Arrays.sort(itemArray);
		System.out.println(Arrays.toString(itemArray));
		
		//Arrays.sort는 두번째 파라미터로 comparable 객체를 받음 -> 1. 익명 객체, 2. 람다
		//#2 사용자 정의클래스의 정렬 - Comparator 인터페이스 이용 - anonymous 객체
		//정렬 대상 클래스에 Comparable 인터페이스(functional interface) 구현하지 않아도, 정렬 시점에 정렬 기준을 구현한 객체를 전달
		Arrays.sort(itemArray, new Comparator<Item>(){
			@Override
			public int compare(Item o1, Item o2) {
				return o1.ItemId - o2.ItemId;
			}
		});
		System.out.println(Arrays.toString(itemArray));
		
		//#3 사용자 정의클래스의 정렬- Comparator 인터페이스 이용 - 람다
		//정렬 대상 클래스에 Comparable 인터페이스(functional interface) 구현하지 않아도, 정렬 시점에 정렬 기준을 구현한 객체를 전달
		Arrays.sort(itemArray, (o1,o2) -> 
			o1.ItemId - o2.ItemId
		);
		Arrays.sort(itemArray, (o1,o2) -> 
			o1.ItemId == o2.ItemId ? o1.itemNm.compareTo(o2.itemNm) : o1.ItemId - o2.ItemId
		);
			
		System.out.println(Arrays.toString(itemArray));
		
	}
	
	//객체들을 정렬할 때, 기준이 필요, 이 기준은 여러가지 존재 
	//#1. 클래스에 정의 
	//Comparable에 제너릭으로 Item을 넘겨주기 , (Item으로 정렬을 해야하기 때문에)
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
//			return this.ItemId - o.ItemId; //natural order
//			return o.ItemId - this.ItemId; //reverse order
//			return this.itemNm.compareTo(o.itemNm);
			//itemId를 우선 비교하는데 같은 값이면 itemNm으로 비교하도록
			return this.ItemId == o.ItemId ? this.itemNm.compareTo(o.itemNm) : this.ItemId - o.ItemId;
		}
		
		
		
		
	}
}
