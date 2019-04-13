import java.util.Comparator;
import java.util.PriorityQueue;

// leetcode 973, ����int[][] 
//��������� List<List<Integer>>
//��װ���˿����˻����⡣���Ǹ�һ�ѻ�������꣬���ҵ�����ԭ�㣨������λ�ã�����ļ������
//��PriorityQueue���С�����input�����return�Ķ���List<List<String>>,����дcomparator��΢�鷳�㣬ע���д��
public class K_ClosestPointToOrigin {
    public static int[][] kClosest(int[][] points, int K) {
    	//reverse to be max heap
        PriorityQueue<int[]> pq = new PriorityQueue<int[]>(new Comparator<int[]>(){
        	public int compare(int[] a, int[] b){return b[0]*b[0]+b[1]*b[1]-a[0]*a[0]-a[1]*a[1];}});  
        // if input is List<List<String>>, such as   {{"1", "2"}, {"2","3"}}, �ַ���תint�Ƚ��鷳��
//        PriorityQueue<int[]> pq1 = new  PriorityQueue<List>(new Comparator<List>() {
//        	public int compare(List a, List b) {
//        		return Integer.parseInt(b.get(0))*Integer.parseInt(b.get(0))+Integer.parseInt(b.get(1))*Integer.parseInt(b.get(1)) 
//        				-Integer.parseInt(a.get(0))*Integer.parseInt(a.get(0))-Integer.parseInt(a.get(1))*Integer.parseInt(a.get(1))��
//        				}
//        });
        for (int[] p : points){
            pq.offer(p);
            if (pq.size() > K) // poll out farthest point;
                pq.poll();
        }
        int[][] res = new int[K][2];
        int i = 0;
        while (!pq.isEmpty())
            res[i++] = pq.poll();
        return res;
    }
	public static void main(String[] args) {
		int K =1;
		int[][] points = {{1,3},{-2,2}};
		int[][] res = kClosest(points, K);
		for (int[] p : res)
			System.out.println(p[0]+","+p[1]);
	}
}
