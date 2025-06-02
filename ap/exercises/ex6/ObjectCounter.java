package ap.exercises.ex6;

import java.util.*;

public class ObjectCounter {
    private Map<String, Integer> counterMap;

    public ObjectCounter() {
        this.counterMap = new HashMap<>();
    }

    public void add(String item) {
        counterMap.put(item, counterMap.getOrDefault(item, 0) + 1);
    }

    public List<Map.Entry<String, Integer>> getTop(int k) {
        return counterMap.entrySet().stream()
                .sorted((a, b) -> b.getValue().compareTo(a.getValue()))
                .limit(k)
                .toList();
    }
}

