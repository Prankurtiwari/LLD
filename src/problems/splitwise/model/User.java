package problems.splitwise.model;

public class User {
    private final String id;
    private final String name;
    private final UserExpenseBalanceSheet userExpenseBalanceSheet;

    public User(String id, String name) {
        this.id = id;
        this.name = name;
        userExpenseBalanceSheet = new UserExpenseBalanceSheet();
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public UserExpenseBalanceSheet getUserExpenseBalanceSheet() {
        return userExpenseBalanceSheet;
    }
}
