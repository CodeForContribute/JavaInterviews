public class FindTargetInRotatedSortedArr {
    public static void main(String[] args) {
        int[] arr = {35, 46, 57, 68, 79, 85, 12, 21, 33};
        FindTargetInRotatedSortedArr obj = new FindTargetInRotatedSortedArr();
        int pos = obj.getTargetIndex(arr, 99);
        System.out.println("index pos found :" + pos);
        arr = new int[]{35, 46, 57, 68, 79, 85, 12, 21, 33};
        pos = obj.getTargetIndex(arr, 68);
        System.out.println("index pos found :" + pos);
        arr = new int[]{4, 5, 6, 7, 0, 1, 2};
        pos = obj.getTargetIndex(arr, 0);
        System.out.println("index pos found :" + pos);
        arr = new int[]{4, 5, 6, 7, 0, 1, 2};
        pos = obj.getTargetIndex(arr, 3);
        System.out.println("index pos found :" + pos);
        arr = new int[]{1};
        pos = obj.getTargetIndex(arr, 0);
        System.out.println("index pos found :" + pos);
    }

    public int getTargetIndex(int[] arr, int target) {
        if (arr == null || arr.length == 0) return -1;
        int n = arr.length;
        int left = 0, right = n - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (arr[mid] == target) {
                return mid;
            } else if (arr[mid] >= arr[left]) {
                if (target >= arr[left] && target < arr[mid]) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            } else {
                if (target > arr[mid] && target <= right) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
        }
        return -1;
    }
}
