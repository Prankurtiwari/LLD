package problems.vending_machine.enums;

public enum ItemType {
    COKE ("coke"),
    PEPSI ("pepsi"),
    JUICE ("juice"),
    SODA("soda");

    final String name;

    ItemType(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
