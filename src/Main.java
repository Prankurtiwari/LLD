import java.util.*;


class IntArrayKey {
    private final int[] array;

    public IntArrayKey(int[] array) {
        this.array = array;
    }

    @Override
    public boolean equals(Object o) {
        return Arrays.equals(this.array, ((IntArrayKey) o).array);
    }

    @Override
    public int hashCode() {
        return Arrays.hashCode(array);
    }
}

public class Main {
    public static void main(String[] args) {
        Main m = new Main();
        ArrayList<ArrayList<String>> anagrams = m.anagrams(new String[]{"no", "on", "is"});
        System.out.println(anagrams);
    }

    public ArrayList<ArrayList<String>> anagrams(String[] arr) {
        // code here
        HashMap<IntArrayKey, ArrayList<String>> mp = new HashMap<>();
        for(String str: arr) {
            int[] freq = new int[26];

            for(int i=0;i<str.length();i++) {
                freq[str.charAt(i)-'a']++;
            }
            IntArrayKey key = new IntArrayKey(freq);

            if(!mp.containsKey(key)) {
                mp.putIfAbsent(key, new ArrayList<>());
            }
            mp.get(key).add(str);

        }


        return new ArrayList<>(mp.values());
    }
}