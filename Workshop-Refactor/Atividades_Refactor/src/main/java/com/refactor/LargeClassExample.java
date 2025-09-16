
package com.refactor;

import java.util.ArrayList;
import java.util.List;

/**
 * EXERCÍCIO: Code Smell - Large Class
 * Objetivo:
 *  - Quebrar responsabilidades de ReportManager usando Extract Class
 *  - Sugerido: criar DataLoader, ReportFilter e ReportRenderer
 * Critério de aceite:
 *  - ReportManager deve orquestrar classes menores
 */
public class LargeClassExample {

    public static class Record {
        public final String category;
        public final double value;
        public Record(String category, double value) { this.category = category; this.value = value; }
    }

    // TODO: Esta classe faz "tudo". Extraia classes especializadas.
    public static class ReportManager {
        private final List<Record> data = new ArrayList<>();

        // carrega dados
        public void load() {
            data.add(new Record("A", 10));
            data.add(new Record("B", 30));
            data.add(new Record("A", 25));
            data.add(new Record("C", 7));
        }

        // filtra por categoria
        public List<Record> filterByCategory(String cat) {
            List<Record> out = new ArrayList<>();
            for (Record r : data) if (r.category.equals(cat)) out.add(r);
            return out;
        }

        // renderiza relatório simples
        public String render(List<Record> records) {
            StringBuilder sb = new StringBuilder("REPORT\n");
            double sum = 0;
            for (Record r : records) {
                sb.append(r.category).append(": ").append(r.value).append('\n');
                sum += r.value;
            }
            sb.append("TOTAL: ").append(sum);
            return sb.toString();
        }
    }
}
