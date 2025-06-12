package problems.design_atm.enums;

public enum TransactionType {

    CASH_WITHDRAW(100, "Cash Withdraw"),
    BALANCE_CHECK(200, "Balance Check");

    private final int value;
    private final String name;

    TransactionType(int value, String name) {
        this.value = value;
        this.name = name;
    }

    public int getValue() {
        return value;
    }

    public String getName() {
        return name;
    }

    public static void showAllTransactionType() {
        for (TransactionType type: TransactionType.values()){
            System.out.println(type.getName());
        }
    }
}
