
public class stockSellBuy {

    public static int profit(int arr[]) {
        int maxProfit = 0;
        int profit;
        int min = arr[0];
        for (int i = 0; i < arr.length; i++) {
            profit = arr[i] - min;
            maxProfit = Math.max(maxProfit, profit);
            min = Math.min(min, arr[i]);
        }
        return maxProfit;
    }

    public static void main(String[] args) {
        int arr[] = {1, 3, 6, 2, 9, 10, 3, 2};
        System.out.println(profit(arr));
    }
}
