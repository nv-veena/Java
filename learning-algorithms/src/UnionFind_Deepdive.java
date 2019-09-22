/* https://www.hackerearth.com/practice/notes/disjoint-set-union-union-find/
 * 
 */
public class UnionFind_Deepdive {
	public static void main(String[] args) {
		
		int[] arr = new int[] {0,1,2,3,4,5,6,7,8,9};
		UnionFind_Deepdive tst = new UnionFind_Deepdive();
		tst.understandUnionFind(arr);
		

	}
	public void understandUnionFind(int[] arr) {
		UnionFind uf=new UnionFind(arr);
		uf.union(arr[0], arr[1]);
		uf.union(arr[0],arr[2]);
		uf.find(arr[0],arr[3]);
		System.out.println("test");
	}
	class UnionFind{
		int count;
		int[] parent;
		int[] rank;
		public UnionFind(int[] grid) {
			count=0;
			parent=new int[grid.length];
			rank=new int[grid.length];
			for(int i=0;i<grid.length;i++) {
				parent[i]=grid[i];
				rank[i]=0;
				count++;
			}
		}
		public void union(int x,int y) {
			int rootx=findRoot(x);
			int rooty=findRoot(y);
			if(rootx!=rooty) {
				if(rank[rootx]>rank[rooty]) {
					parent[rooty]=rootx;
				}else if(rank[rooty]>rank[rootx]) {
					parent[rootx]=rooty;
				}else {
					parent[rooty]=rootx;
					rank[rootx]++;
				}
				count--;
			}
		}
		public int findRoot(int x) {
			if(parent[x]!=x) {
				parent[x]=findRoot(parent[x]);
			}
			return parent[x];
		}
		public boolean find(int x,int y) {
			return parent[x]==parent[y];
		}
		public int getCount() {
			return count;
		}
	}
	
	
}
