package dijkstra;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class CityWithSmallestNumberofNeighborsAtThresholdDistTest {

	@Test
	void test() {
		int n=4;int[][] edges = {{0,1,3},{1,2,1},{1,3,4},{2,3,1}};int distanceThreshold = 4;
		CityWithSmallestNumberofNeighborsAtThresholdDist test = new CityWithSmallestNumberofNeighborsAtThresholdDist();
		int expected=3;
		assertEquals(expected,test.findTheCity(edges, distanceThreshold,n));
	}

	@Test
	void test1() {
		 int n = 5;int[][] edges = {{0,1,2},{0,4,8},{1,2,3},{1,4,2},{2,3,1},{3,4,1}};int distanceThreshold = 2;
		 CityWithSmallestNumberofNeighborsAtThresholdDist test = new CityWithSmallestNumberofNeighborsAtThresholdDist();
		 assertEquals(0,test.findTheCity(edges,distanceThreshold,n));
	}
}
