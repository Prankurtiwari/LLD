package problems.custom_immutable_class;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class CustomImmutable {
    private final int id;
    private final String name;
    private final Map<String, String> map;

    public CustomImmutable(int id, String name, Map<String, String> map) {
        this.id = id;
        this.name = name;
        this.map = new HashMap<>(map);
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Map<String, String> getMap() {
        return new HashMap<>(this.map);
    }

    public static void main(String[] args) {
        Map<String, String> map = new HashMap<>();
        map.put("1", "first");
        map.put("2", "second");

        // create an immutable Student object
        CustomImmutable customImmutable = new CustomImmutable(1, "prankur", map);

        // accessing data
        System.out.println(customImmutable.getName());
        System.out.println(customImmutable.getId());
        System.out.println(customImmutable.getMap());

        // try to modify the original map
        map.put("3", "third");
        System.out.println(customImmutable.getMap());

        // try to modify the map returned by getMetadata()
        customImmutable.getMap().put("4", "fourth");
        System.out.println(customImmutable.getMap());
    }
}
