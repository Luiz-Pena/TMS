
package com.refactor;

import java.time.LocalDate;
import java.util.List;

/**
 * EXERCÍCIO: Code Smell - Feature Envy
 * Objetivo:
 *  - Mover lógica de formatação (ou parte invejosa) para a classe Order
 * Critério de aceite:
 *  - OrderPrinter deve delegar a Order
 */
public class FeatureEnvyExample {

    public static class OrderItem {
        public final String name;
        public final int qty;
        public final double price;
        public OrderItem(String name, int qty, double price) { this.name = name; this.qty = qty; this.price = price; }
        public double total() { return price * qty; }
    }

    public static class Order {
        public final String id;
        public final LocalDate date;
        public final List<OrderItem> items;
        public Order(String id, LocalDate date, List<OrderItem> items) {
            this.id = id; this.date = date; this.items = items;
        }
        public double total() {
            return items.stream().mapToDouble(OrderItem::total).sum();
        }
    }

    public static class OrderPrinter {
        // TODO: muita "inveja" de Order: mover parte desta lógica para Order.
        public String print(Order o) {
            StringBuilder sb = new StringBuilder();
            sb.append("ORDER ").append(o.id).append(" - ").append(o.date).append('\n');
            for (OrderItem it : o.items) {
                sb.append(it.qty).append("x ").append(it.name).append(" = ").append(it.total()).append('\n');
            }
            sb.append("TOTAL: ").append(o.total());
            return sb.toString();
        }
    }
}
