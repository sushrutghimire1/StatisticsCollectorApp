public class StringStatistic implements Statistic {

    private String key;
    private Integer value;

    @Override
    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    @Override
    public Object getValue() {
        return value;
    }

    public void setValue(Integer value) {
        this.value = value;
    }
}
