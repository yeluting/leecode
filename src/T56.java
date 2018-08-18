import java.util.*;

/**
 * Created by YLT on 2017/9/7.
 */
class Interval {
    int start;
    int end;
    Interval() {
        start = 0;
        end = 0;
    }
    Interval(int s, int e) {
        start = s;
        end = e;
    }
}
public class T56 {
    public List<Interval> merge(List<Interval> intervals) {
        if(intervals.size() <= 1){
            return intervals;
        }
        int n = intervals.size();
        int[] starts = new int[n];
        int[] ends = new int[n];
        for (int i = 0; i < n; i++) {
            starts[i] = intervals.get(i).start;
            ends[i] = intervals.get(i).end;
        }
        Arrays.sort(starts);
        Arrays.sort(ends);
        // loop through
        List<Interval> res = new ArrayList<Interval>();

        for (int i = 0, j = 0; i < n; i++) { // j is start of interval.
            if (i == n - 1 || starts[i + 1] > ends[i]) {
                res.add(new Interval(starts[j], ends[i]));
                j = i + 1;
            }
        }
        return res;
    }

    public List<Interval> merge1(List<Interval> intervals) {
        if(intervals.size() <= 1){
            return intervals;
        }
        List<Interval> res = new ArrayList<>();
        Collections.sort(intervals, new Comparator<Interval>() {
            @Override
            public int compare(Interval o1, Interval o2) {
                return o1.start - o2.start;
            }
        });

        Interval temp = intervals.get(0);
        for (int i = 1; i < intervals.size(); i ++){
            if (temp.end >= intervals.get(i).start){
                temp.end = Math.max(temp.end,intervals.get(i).end);
            }else {
                res.add(temp);
                temp = intervals.get(i);
            }
        }
        res.add(temp);
        return res;
    }
}
