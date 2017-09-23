package cache.view;

import cache.model.CacheItem;

public interface CacheView {
    int size();
    CacheItem getItem(int index);
    CacheItem getItem(String key);
}
