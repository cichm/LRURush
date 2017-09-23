package cache;

import cache.model.CacheItem;
import cache.model.CacheItemImpl;
import cache.view.CacheView;
import cache.view.CacheViewImpl;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor(access = AccessLevel.PRIVATE)
public class CacheImpl implements Cache {
    @NonNull
    private CacheContainer cacheContainer;
    @NonNull
    @Getter
    private CacheView view;

    public static Cache get() {
        CacheContainer cacheContainer = new CacheContainer();
        return new CacheImpl(cacheContainer, new CacheViewImpl(cacheContainer));
    }

    public CacheItem cacheItem(Object item, String key) {
        CacheItem cacheItem = new CacheItemImpl(key, item);
        cacheContainer.add(cacheItem);
        return cacheItem;
    }

    public void invalidateCache() {
        cacheContainer.clear();
    }
}
