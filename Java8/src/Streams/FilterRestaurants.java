package Streams;
/*
 * Given the array restaurants where  restaurants[i] = [idi, ratingi, veganFriendlyi, pricei, distancei]. 
 * You have to filter the restaurants using three filters. The veganFriendly filter will be either true 
 * (meaning you should only include restaurants with veganFriendlyi set to true) or false 
 * (meaning you can include any restaurant). In addition, you have the filters maxPrice and maxDistance 
 * which are the maximum value for price and distance of restaurants you should consider respectively.
* Return the array of restaurant IDs after filtering, ordered by rating from highest to lowest. 
* For restaurants with the same rating, order them by id from highest to lowest. For simplicity 
* veganFriendlyi and veganFriendly take value 1 when it is true, and 0 when it is false.
*/
 import java.util.*;
import java.util.stream.Collector;
import java.util.stream.Collectors;
public class FilterRestaurants {
	
	public List<Integer> filterRestaurants(int[][] restaurants,int veganFriendly,int maxDistance,int maxPrice){
		return Arrays.stream(restaurants)
				.filter(s -> s[2] >= veganFriendly && s[3]<=maxPrice && s[4]<=maxDistance)
				.sorted((a,b)->{
					if(a[1]==b[1]) {
						return b[0]-a[0];
					}else {
						return b[1]-a[1];
					}
				})
				.map(i -> i[0])
				.collect(Collectors.toList());
	}
}
