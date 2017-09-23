package cache;

import cache.exceptions.NoCacheEntryException;
import cache.model.CacheItem;
import cache.model.CacheItemImpl;
import lombok.NoArgsConstructor;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Optional;

@NoArgsConstructor
public class CacheContainer extends LinkedHashMap<String, Object> {
    private static final int MAX_SIZE = 3;

    public CacheItem get(int index) throws NoCacheEntryException {
        return entrySet().stream()
                .skip(index)
                .findAny()
                .map(entry -> new CacheItemImpl(entry.getKey(), entry.getValue()))
                .orElseThrow(NoCacheEntryException::new);
    }

    void add(CacheItem cacheItem) {
        put(cacheItem.getKey(), cacheItem.getValue());
    }

    @Override
    protected boolean removeEldestEntry(Map.Entry<String, Object> eldest) {
        return size() > MAX_SIZE;
    }

    public CacheItem getCacheItem(String key) throws NoCacheEntryException {
        return Optional.ofNullable(get(key))
                .map(value -> new CacheItemImpl(key, value)).orElseThrow(NoCacheEntryException::new);
    }
}
