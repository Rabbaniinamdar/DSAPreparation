package Arrays;
// Initialize two variables: maxProfit to keep track of the maximum profit and
// minPrice to keep track of the minimum stock price. Initialize maxProfit with
// the smallest possible integer value and minPrice with the largest possible
// integer value.

// Iterate through the array of stock prices.

// For each day's stock price:
// a. Update the minPrice by taking the minimum of the current stock price and
// the previous minPrice.
// b. Calculate the potential profit on the current day by subtracting the
// minPrice from the current stock price.
// c. Update the maxProfit by taking the maximum of the current maxProfit and
// the calculated potential profit.

// After iterating through all the stock prices, the maxProfit will hold the
// maximum profit that can be obtained by buying and selling the stock once.

// Return the value of maxProfit as the result.

import java.util.Arrays;

class Stock {
    public static int buy_Sell_1(int arr[]) {
        int maxProfit = Integer.MIN_VALUE;
        int minPrice = Integer.MAX_VALUE;
        for (int i = 0; i < arr.length; i++) {
            minPrice = Math.min(minPrice, arr[i]);
            maxProfit = Math.max(maxProfit, arr[i] - minPrice);
        }
        return maxProfit;
    }

    // Initialize the profit variable to 0.

    // Iterate through the array of stock prices starting from the second day.

    // For each day's stock price:
    // a. Compare the current day's stock price with the previous day's stock price.
    // b. If the current day's price is higher than the previous day's price, that
    // means we can make a profit by buying on the previous day and selling on the
    // current day. Add the difference between the two prices to the profit.

    // After iterating through all the stock prices, the profit will hold the
    // maximum profit achievable by performing multiple buy-sell transactions.

    // Return the value of profit as the result.

    public static int buy_Sell_2(int arr[]) {
        int profit = 0;
        for (int i = 1; i < arr.length; i++) {
            if (arr[i - 1] < arr[i]) {
                profit += arr[i] - arr[i - 1];
            }
        }
        return profit;
    }

    // buy1 to store the minimum price for the first buy.
    // buy2 to store the minimum price for the second buy.
    // sell1 to store the maximum profit after the first sell.
    // sell2 to store the maximum profit after the second sell.
    // Iterate through each day's stock price in the array:
    // a. Update buy1 to be the smaller value between the current stock price and
    // buy1.
    // b. Update sell1 to be the larger value between the current profit after the
    // first sell and the difference between the current stock price and buy1.
    // c. Update buy2 to be the smaller value between the difference between the
    // current stock price and sell1 and buy2.
    // d. Update sell2 to be the larger value between the current profit after the
    // second sell and the difference between the current stock price and buy2.

    // After iterating through all the stock prices, the value of sell2 will
    // represent the maximum profit achievable with at most two transactions.

    // Return the value of sell2 as the final result.
    public static int buy_Sell_3(int arr[]) {
        int buy1 = Integer.MAX_VALUE;
        int buy2 = Integer.MAX_VALUE;
        int sell1 = 0;
        int sell2 = 0;

        for (int price : arr) {
            buy1 = Math.min(buy1, price);
            sell1 = Math.max(sell1, price - buy1);
            buy2 = Math.min(buy2, price - sell1);
            sell2 = Math.max(sell2, price - buy2);
        }
        return sell2;
    }

    // Create two arrays, buy and sell, each of size k, to keep track of the maximum
    // profit after each buy and sell for up to k transactions.

    // Initialize all values in the buy array with the maximum possible negative
    // value and all values in the sell array with 0.

    // Iterate through each day's stock price:
    // a. Update the first element in the buy array to be the maximum of its current
    // value and the negation of the current stock price.
    // b. Update the first element in the sell array to be the maximum of its
    // current value and the sum of the current stock price and the first element of
    // the buy array.
    // c. For each additional transaction (starting from the second), update the buy
    // and sell arrays based on previous transaction values.

    // Update buy[j] (j > 0) to be the maximum of its current value and the sum of
    // the current stock price and the sell[j - 1] value.
    // Update sell[j] (j > 0) to be the maximum of its current value and the sum of
    // the current stock price and the buy[j] value.
    // After iterating through all the stock prices, the value in the last position
    // of the sell array (i.e., sell[k - 1]) will represent the maximum profit
    // achievable with at most k transactions.

    // Return the value of sell[k - 1] as the final result.
    public static int buy_Sell_4(int price[], int k) {
        int buy[] = new int[k];
        int sell[] = new int[k];

        Arrays.fill(buy, Integer.MAX_VALUE);
        Arrays.fill(sell, 0);

        for (int i = 0; i < price.length; i++) {
            buy[0] = Math.max(buy[0], price[i] * -1);
            sell[0] = Math.max(sell[0], price[i] + buy[0]);
            for (int j = 1; j < k; j++) {
                buy[j] = Math.max(buy[j], price[i] + sell[j - 1]);
                sell[j] = Math.max(sell[j], price[i] + buy[j]);
            }
        }
        return sell[k - 1];
    }

    public static void main(String[] args) {
        int arr[] = { 1, 2, 3, 4, 5 };
        System.out.println(buy_Sell_4(arr, 2));
    }
}
