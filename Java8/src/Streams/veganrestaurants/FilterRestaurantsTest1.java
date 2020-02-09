package streams.veganrestaurants;
/*Input: restaurants = [[1,4,1,40,10],[2,8,0,50,5],[3,8,1,30,4],[4,10,0,10,3],[5,1,1,15,1]], 
 * veganFriendly = 1, maxPrice = 50, maxDistance = 10
Output: [3,1,5] 
Explanation: 
The restaurants are:
Restaurant 1 [id=1, rating=4, veganFriendly=1, price=40, distance=10]
Restaurant 2 [id=2, rating=8, veganFriendly=0, price=50, distance=5]
Restaurant 3 [id=3, rating=8, veganFriendly=1, price=30, distance=4]
Restaurant 4 [id=4, rating=10, veganFriendly=0, price=10, distance=3]
Restaurant 5 [id=5, rating=1, veganFriendly=1, price=15, distance=1] 
After filter restaurants with veganFriendly = 1, maxPrice = 50 and maxDistance = 10 we
 have restaurant 3, restaurant 1 and restaurant 5 (ordered by rating from highest to lowest). 
*/
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.Assert.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.*;

import javax.swing.SpringLayout.Constraints;
class FilterRestaurantsTest1 {
	int[][] restaurants;
	int veganFriendly;
	int maxPrice;
	int maxDistance;
	
	@BeforeEach
	void setUp() throws Exception {
		restaurants = new int[][] {
			{1,4,1,40,10},
			{2,8,0,50,5},
			{3,8,1,30,4},
			{4,10,0,10,3},
			{5,1,1,15,1}
		};
		veganFriendly=1;
		maxPrice=50;
		maxDistance=10;
	}

	@Test
	void testFilterRestaurants() {
		FilterRestaurants test=new FilterRestaurants();
		List<Integer> lst = test.filterRestaurants(restaurants, veganFriendly, maxDistance, maxPrice);
		List<Integer> lst1= Arrays.asList(3,1,5);
		assertTrue(lst.equals(lst1));
	}

}
