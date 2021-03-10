public interface StatisticsCollector<T, S extends Statistic> {

    String getName();

    Iterable<S> collectStatistics(Iterable<T> objects);

}
