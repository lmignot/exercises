package DataStructures;

/**
 * PiJ day 11 - exercise 6.1
 */
public class SimpleMap<K,V> {

    private static final int MAX_ITEMS = 1000;
    private int size = 0;
    private MapItem<K,V>[] storage;

    public SimpleMap () {
        storage = new MapItem[MAX_ITEMS];
    }

    public void put (K k, V v) {
        if (size == MAX_ITEMS) {
            return;
        }
        boolean isNew = true;
        // check if the key exists and if so update the value
        for (int i = 0; i < size; i++) {
            if (storage[i] != null && storage[i].getKey().equals(k)) {
                storage[i].setValue(v);
                isNew = false;
                break;
            }
        }
        // key doesn't exist so add it
        if (isNew) {
            storage[size++] = new MapItem<>(k, v);
        }
    }

    public boolean remove (K key) {
        boolean result = false;
        for (int i = 0; i < size; i++) {
            if (storage[i] != null && storage[i].getKey().equals(key)) {
                storage[i] = null;
                result = true;
                size--;
                shiftEntries(i);
                break;
            }
        }
        return result;
    }

    public V get (K k) {
        V result = null;
        for (int i = 0; i < size; i++) {
            if (storage[i] != null && storage[i].getKey().equals(k)) {
                result = storage[i].getValue();
                break;
            }
        }
        return result;
    }

    public int size () {
        return size;
    }

    private void shiftEntries (int start) {
        for (int i = start; i < size; i++) {
            storage[i] = storage[i + 1];
        }
    }

    private class MapItem<K, V> {
        private final K key;
        private V value;

        public MapItem(K key, V value) {
            this.key = key;
            this.value = value;
        }

        public K getKey() {
            return key;
        }

        public V getValue() {
            return value;
        }

        public void setValue(V value) {
            this.value = value;
        }
    }
}
