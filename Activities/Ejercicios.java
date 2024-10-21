public class Ejercicios {

    public int fibonacciRec(int n) {
        if (n <= 1) {
            return n;
        }
        return fibonacciRec(n - 1) + fibonacciRec(n - 2);
    }

    public int fibonacciIter(int n) {
        if (n <= 1) {
            return n;
        }
        int prev1 = 0, prev2 = 1;
        int result = 0;
        for (int i = 2; i <= n; i++) {
            result = prev1 + prev2;
            prev1 = prev2;
            prev2 = result;
        }
        return result;
    }
    
    public int factorialRec(int n) {
        if (n == 0 || n == 1) {
            return 1;
        }
        return n * factorialRec(n - 1);
    }
    
    public int factorialIter(int n) {
        int result = 1;
        for (int i = 2; i <= n; i++) {
            result *= i;
        }
        return result;
    }
    
    public int binarySearchRec(int[] arr, int target, int low, int high) {
        if (low > high) {
            return -1;
        }
        int mid = (low + high) / 2;
        if (arr[mid] == target) {
            return mid;
        } else if (arr[mid] > target) {
            return binarySearchRec(arr, target, low, mid - 1);
        } else {
            return binarySearchRec(arr, target, mid + 1, high);
        }
    }

    public int binarySearchIter(int[] arr, int target) {
        int low = 0, high = arr.length - 1;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (arr[mid] == target) {
                return mid;
            } else if (arr[mid] > target) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return -1;
    }
    
    public static void main(String[] args) {
        
    }
}
