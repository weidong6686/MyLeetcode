import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
// Amazon OA2 High Five;
class Result{
	int id;
	int value;
	public Result(int id, int value){
		this.id = id;
		this.value = value;
		}
}

public class HighFive {
	public static Map<Integer, Double> highFive(Result[] results) {
		Map<Integer, Double> map = new HashMap<>();
		Map <Integer, List<Integer>> scores = new HashMap<>();
		for (Result res : results) {
			if (scores.containsKey(res.id)) {
				scores.get(res.id).add(res.value);
				}
			else {
				List<Integer> list = new ArrayList<>();
				list.add(res.value);
				scores.put(res.id, list);
				}
			}
		for (Integer id : scores.keySet()) {
			List<Integer> list = scores.get(id);
//			Collections.sort(list);
//			Collections.reverse(list);
			list.sort(new Comparator<Integer>(){public int compare(Integer a, Integer b) {return b-a;}});
			double sum = 0;
			for (int i = 0; i < 5; i++) sum += list.get(i);
			double a = sum/5;
			map.put(id, a);
		}
		return map;
	}
	public static void main(String[] args) {
		Result r1 = new Result(1, 95);
		Result r2 = new Result(1, 95);
		Result r3 = new Result(1, 91);
		Result r4 = new Result(1, 91);
		Result r5 = new Result(1, 93);
		Result r6 = new Result(1, 105);
		Result r7 = new Result(2, 6);
		Result r8 = new Result(2, 6);
		Result r9 = new Result(2, 7);
		Result r10 = new Result(2, 6);
		Result r11 = new Result(2, 6);
		Result[] arr = {r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11};
		Map<Integer, Double> res = highFive(arr);
		System.out.println(res.get(1) + " " +res.get(2));
	}
}
