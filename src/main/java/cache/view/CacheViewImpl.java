package cache.view;

import cache.CacheContainer;
import cache.exceptions.NoCacheEntryException;
import cache.model.CacheItem;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class CacheViewImpl implements CacheView {
    @NonNull
    private CacheContainer cacheContainer;

    public int size() {
        return cacheContainer.size();
    }

    public CacheItem getItem(int index) {
        try {
            return cacheContainer.get(index);
        } catch (NoCacheEntryException e) {
            e.printStackTrace();
            return null;
        }
    }

    public CacheItem getItem(String key) {
        try {
            return cacheContainer.getCacheItem(key);
        } catch (NoCacheEntryException e) {
            e.printStackTrace();
            return null;
        }
    }
}
