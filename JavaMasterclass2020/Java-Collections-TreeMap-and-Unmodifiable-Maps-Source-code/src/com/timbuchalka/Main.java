package com.timbuchalka;

import java.util.Map;

public class Main {
    private static StockList stockList = new StockList();

    public static void main(String[] args) {
	    StockItem temp = new StockItem("bread", 0.86, 100);
        stockList.addStock(temp);

        temp = new StockItem("cake", 1.10, 7);
        stockList.addStock(temp);

        temp = new StockItem("car", 12.50, 2);
        stockList.addStock(temp);

        temp = new StockItem("chair", 62.0, 10);
        stockList.addStock(temp);

        temp = new StockItem("cup", 0.50, 200);
        stockList.addStock(temp);
        temp = new StockItem("cup", 0.45, 7);
        stockList.addStock(temp);

        temp = new StockItem("door", 72.95, 4);
        stockList.addStock(temp);

        temp = new StockItem("juice", 2.50, 36);
        stockList.addStock(temp);

        temp = new StockItem("phone", 96.99, 35);
        stockList.addStock(temp);

        temp = new StockItem("towel", 2.40, 80);
        stockList.addStock(temp);

        temp = new StockItem("vase", 8.76, 40);
        stockList.addStock(temp);

        System.out.println(stockList);

        Basket timsBasket = new Basket("Tim");

        addItem(timsBasket, "car", 1);
        System.out.println(timsBasket);

        addItem(timsBasket, "car", 1);
        System.out.println(timsBasket);

        if(addItem(timsBasket, "car", 1) != 1) {
            System.out.println("There are no more cars in stock");
        }

        addItem(timsBasket, "spanner", 5);

        addItem(timsBasket, "juice", 4);
        addItem(timsBasket, "cup", 12);
        addItem(timsBasket, "bread", 1);

        Basket basket = new Basket("customer");
        addItem(basket, "cup", 100);
        addItem(basket, "juice", 5);
        removeItem(basket, "cup", 1);
        System.out.println(basket);

        removeItem(timsBasket, "car", 1);
        removeItem(timsBasket, "cup", 9);
        removeItem(timsBasket, "car", 1);
        System.out.println("cars removed: " + removeItem(timsBasket, "car", 1)); //should not remove any

        System.out.println(timsBasket);

        //remove all items from timsbasket
        removeItem(timsBasket, "bread", 1);
        removeItem(timsBasket, "cup", 3);
        removeItem(timsBasket, "juice", 4);
        removeItem(timsBasket, "cup", 3);
        System.out.println(timsBasket);

        System.out.println("\nDisplay stocklist before and after checkout");
        System.out.println(basket);
        System.out.println(stockList);
        checkOut(basket);
        System.out.println(basket);
        System.out.println(stockList);

        StockItem car = stockList.Items().get("car");
        if(car != null) {
            car.adjustStock(2000);
        }
        if(car != null) {
            stockList.get("car").adjustStock(-1000);
        }
        System.out.println(stockList);

        checkOut(timsBasket);
        System.out.println(timsBasket);

    }

    public static int addItem(Basket basket, String item, int quantity) {
        //retrieve the item from stock list
        StockItem stockItem = stockList.get(item);
        if(stockItem == null) {
            System.out.println("We don't sell " + item);
            return 0;
        }
        if(stockList.reserveStock(item, quantity) != 0) {
            return basket.addToBasket(stockItem, quantity);
        }
        return 0;
    }

    public static int removeItem(Basket basket, String item, int quantity) {
        //retrieve the item from stock list
        StockItem stockItem = stockList.get(item);
        if(stockItem == null) {
            System.out.println("We don't sell " + item);
            return 0;
        }
        if(basket.removeFromBasket(stockItem, quantity) == quantity) {
            return stockList.unreserveStock(item, quantity);
        }
        return 0;
    }
// Meine eigene Methode
//    public int unreserve(Basket basket, String item, int quantity) {
//
//        if(stockList.get(item) == null || !(basket.Items().containsKey(item))) {
//            System.out.println(item + " is not an item in your basket");
//            return 0;
//        }
//        if(!(basket.Items().get(item) >= quantity)) {
//            System.out.println("You can't unreserve more than you have in your basket");
//            return 0;
//        }
//        return stockList.get(item).unreserveStock(quantity);
//    }

    public static boolean checkOut(Basket basket) {
        if(!(basket == null)) {
            for(Map.Entry<StockItem, Integer> entry: basket.Items().entrySet()) {
//                StockItem item = entry.getKey();
                stockList.sellStock(entry.getKey().getName(), entry.getValue());
            }
//            System.out.println(basket);
            basket.clearBasket();
//            System.out.println(stockList);
            return true;
        }
        return false;
    }
}
