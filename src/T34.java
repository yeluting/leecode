public class T34 {
    public int[] searchRange(int[] nums, int target) {
        int[] result = new int[]{-1, -1};
        if (nums == null || nums.length == 0) {
            return result;
        }

        int begin = 0, end = nums.length - 1;
        int index = -1;
        while (begin <= end) {
            int mid = (begin + end) / 2;
            if (nums[mid] == target) {
                index = mid;
                break;
            } else if (nums[mid] < target) {
                begin = mid + 1;
            } else {
                end = mid - 1;
            }
        }

        if (index != -1) {
            int b1 = 0, e1 = index;
            while (b1 < e1) {
                int m1 = (b1 + e1) / 2;
                if (nums[m1] == target) {
                    e1 = m1;
                } else {
                    b1 = m1 + 1;
                }
            }
            result[0] = b1;
            int b2 = index, e2 = nums.length - 1;
            while (b2 < e2) {
                int m2 = (b2 + e2) / 2 + 1;
                if (nums[m2] == target) {
                    b2 = m2;
                } else {
                    e2 = m2 - 1;
                }
            }
            result[1] = e2;
        }
        return result;
    }


    public int[] searchRange1(int[] nums, int target) {
        int[] result = new int[]{-1, -1};
        if (nums == null || nums.length == 0) {
            return result;
        }

        int begin = 0, end = nums.length - 1;
        while (begin < end) {
            int mid = (begin + end) / 2;
            if (nums[mid] >= target) {
                end = mid;
            } else {
                begin = mid + 1;
            }
        }
        if (nums[begin] == target) {
            result[0] = begin;
        }

        int begin1 = 0, end1 = nums.length - 1;
        while (begin1 < end1) {
            int mid = (begin1 + end1) / 2 + 1;
            if (nums[mid] <= target) {
                begin1 = mid;
            } else {
                end1 = mid - 1;
            }
        }
        if (nums[end1] == target) {
            result[1] = end1;
        }
        return result;
    }
}
