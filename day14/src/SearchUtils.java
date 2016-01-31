import java.util.List;
import java.util.Map;

/**
 * Binary search using recursion
 */
public abstract class SearchUtils {

    public static boolean search (List<Integer> l, Integer query, Map<Integer, Boolean> cache) {
        if (l == null || l.isEmpty()) {
            return false;
        } else {
            if (cache != null && cache.containsKey(query)) {
                return true;
            }

            boolean found;
            Integer half = l.size() / 2;
            Integer middle = l.get(half);

            if (middle.equals(query)) {
                found = true;
            } else {
                found = (query < middle) ?
                        search(l.subList(0, half), query, cache) :
                        search(l.subList(half, l.size()), query, cache);
            }
            if (cache != null) {
                cache.put(query, found);
            }
            return found;
        }
    }

}
