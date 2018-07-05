import java.util.ArrayList;
import java.util.List;

/**
 * Created by YLT on 2018/6/13.
 */
public class T17 {
    List<String> result = new ArrayList<>();
    String[] dicts = {"abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};

    public List<String> letterCombinations(String digits) {
        if (digits == null || digits.length() < 1) {
            return result;
        }
        int length = digits.length();
        trans(digits, 0, length, "");
        return result;
    }

    public void trans(String digits, int index, int length, String nowPath) {
        if (index == length) {
            result.add(String.valueOf(nowPath));

            return;
        }
        String candi = dicts[digits.charAt(index) - '2'];
        for (Character ch : candi.toCharArray()) {
            nowPath = nowPath + ch;
            trans(digits, index + 1, length, nowPath);
            nowPath = nowPath.substring(0, nowPath.length() - 1);
        }
    }
}
