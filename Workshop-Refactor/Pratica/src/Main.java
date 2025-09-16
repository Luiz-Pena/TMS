import java.text.DecimalFormat;
import java.util.Arrays;
import java.util.List;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        List<Double> sales = Arrays.asList(1200.0, 50.0, 300.0, 5000.0);
        double total = 0.0;
        for (double s : sales) {
            total += s;
        }

        double discount = 0.0;
        if (total > 5000) {
            discount = total * 0.1;
        } else if (total > 1000) {
            discount = total * 0.05;
        }

        double tax = total * 0.2;
        double finalAmount = total - discount + tax;

        System.out.println("Total: " + total);
        System.out.println("Discount: " + discount);
        System.out.println("Tax: " + tax);
        System.out.println("Final: " + finalAmount);

        DecimalFormat df = new DecimalFormat("#,##0.00");
        System.out.println("Resumo (BRL):");
        System.out.println("Total: R$ " + df.format(total));
        System.out.println("Desconto: R$ " + df.format(discount));
        System.out.println("Imposto: R$ " + df.format(tax));
        System.out.println("A pagar: R$ " + df.format(finalAmount));
    }
}