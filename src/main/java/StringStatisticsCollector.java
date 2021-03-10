import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class StringStatisticsCollector implements StatisticsCollector<String, StringStatistic> {

    @Override
    public String getName() {
        return "STRING STATISTICS";
    }

    @Override
    public Iterable<StringStatistic> collectStatistics(Iterable<String> objects) {

        HashMap<String, Integer> counters = new HashMap<>();
        counters.put("LOWERCASE", 0);
        counters.put("UPPERCASE", 0);
        counters.put("SPECIAL_CHARACTERS", 0);
        counters.put("WORDS", 0);
        counters.put("NUMBERS", 0);

        for (String element : objects) {
            for (int i = 0; i < element.length(); i++) {
                char ch = element.charAt(i);
                if (ch >= 'A' && ch <= 'Z')
                    counters.put("UPPERCASE", counters.get("UPPERCASE") + 1);
                else if (ch >= 'a' && ch <= 'z')
                    counters.put("LOWERCASE", counters.get("LOWERCASE") + 1);
                else if (ch >= '0' && ch <= '9')
                    counters.put("NUMBERS", counters.get("NUMBERS") + 1);
                else counters.put("SPECIAL_CHARACTERS", counters.get("SPECIAL_CHARACTERS") + 1);
                if (i > 0 && ch == ' ')
                    counters.put("WORDS", counters.get("WORDS") + 1);
            }
            counters.put("WORDS", counters.get("WORDS") + 1);
        }

        ArrayList<StringStatistic> statistics = new ArrayList<>();
        StringStatistic stringStatistic;
        for (Map.Entry<String, Integer> entry : counters.entrySet()) {
            stringStatistic = new StringStatistic();
            stringStatistic.setKey(entry.getKey());
            stringStatistic.setValue(entry.getValue());
            statistics.add(stringStatistic);
        }
        return statistics;
    }
}
