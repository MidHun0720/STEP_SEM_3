package WEEK7_Assessment;

class Cart {
    private int[] prices;
    private int count;
    final String id;

    Cart(String id, int n) {
        this.id = id;
        prices = new int[n];
        count = 0;
    }

    void addItem(int p) {
        if (count < prices.length) {
            prices[count] = p;
            count = count + 1;
        }
    }

    int getTotal() {
        int t = 0;
        for (int i = 0; i < count; i++) {
            t = t + prices[i];
        }
        return t;
    }

    int getItemCount() {
        return count;
    }
}

public class M5 {
    public static void main(String[] args) {
        Cart cart = new Cart("CART-5", 20);
        cart.addItem(250);
        cart.addItem(99);
        cart.addItem(151);
        System.out.println(cart.getTotal());
        System.out.println(cart.getItemCount());
    }
}
