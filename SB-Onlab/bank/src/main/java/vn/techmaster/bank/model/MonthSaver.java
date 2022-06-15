package vn.techmaster.bank.model;

public enum MonthSaver {
    ONE(1L),THREE(3L),SIX(6L),NINE(9L),TWELVE(12L),UNLIMITED(0L);

    public final long label;
    private MonthSaver(long label) {
        this.label = label;
    }
}
