import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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
    public static void main(String[] args) {
        T56 t167 = new T56();
        List<Interval> arg = new ArrayList<Interval>();
        arg.add(new Interval(1,3));
        arg.add(new Interval(2,6));
        arg.add(new Interval(8,10));
        arg.add(new Interval(15,18));
        t167.merge(arg);
    }
}
