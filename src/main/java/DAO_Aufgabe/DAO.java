package DAO_Aufgabe;

import java.util.*;

public class DAO<T> {
    private Map<String, T> map = new HashMap<>();

    public void save(String id, T entity) {
        map.put(id, entity);
    }

    public T get(String id) {
        return map.get(id);
    }

    public void update(String id, T entity) {
        if (map.containsKey(id)) {
            map.put(id, entity);
        }
    }

    public List<T> list() {
        Collection<T> values = map.values();
        List<T> valueList = new ArrayList<>();
        Iterator<T> iterator = values.iterator();
        while (iterator.hasNext()) {
            valueList.add(iterator.next());
        }
        return valueList;
    }

    public void delete(String id) {
        map.remove(id);
    }
}
