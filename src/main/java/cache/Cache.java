package cache;

import cache.model.CacheItem;
import cache.view.CacheView;

public interface Cache {
    CacheItem cacheItem(Object item, String key);
    void invalidateCache();
    CacheView getView();
}
