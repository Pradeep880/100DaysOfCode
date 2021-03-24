import java.util.Arrays;
import java.util.Comparator;

public class FractionKnapsack {
    static class Item {
        int value;
        int weight;

        Item(int v, int w) {
            this.value = v;
            this.weight = w;
        }
    }

    double fractionalKnapsack(int W, Item arr[], int n) {
        // Your code here
        for (Item i : arr) {
            System.out.println("Value:" + i.value + " Weight:" + i.weight);
        }
        Arrays.sort(arr, new Comparator<Item>() {
            @Override
            public int compare(Item o1, Item o2) {
                double cost1 = ((double) o1.value / (double) o1.weight);
                // System.out.println("cost1:" + cost1);
                double cost2 = ((double) o2.value / (double) o2.weight);
                // System.out.println("cost2:" + cost2);

                if (cost1 < cost2)
                    return 1;
                return -1;
            }
        });
        System.out.println("After Sorting");
        for (Item i : arr) {
            System.out.println("Value:" + i.value + " Weight:" + i.weight);
        }
        double total = 0d;
        for (Item i : arr) {
            int v = (int) i.value;
            int w = (int) i.weight;
            if (W - w >= 0) {
                W = W - w;
                total += (double) v;
            } else {
                double f = (double) W / (double) w;
                total += (double) v * f;
                W = W - w;
                break;
            }
        }
        return total;
    }

    public static void main(String[] args) {
        int n = 4;
        int weight[] = { 10, 40, 20, 30 };
        int value[] = { 60, 40, 100, 120 };
        Item arr[] = new Item[n];
        for (int i = 0; i < n; i++) {
            arr[i] = new Item(value[i], weight[i]);
        }

        FractionKnapsack s1 = new FractionKnapsack();
        int W = 50;
        System.out.println("Maximum profit is:" + s1.fractionalKnapsack(W, arr, n));
    }
}
