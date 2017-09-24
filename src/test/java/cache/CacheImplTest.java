package cache;

import cache.model.CacheItem;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class CacheImplTest {
    @Test(groups = "fast")
    public void similarItems() {
        Cache cache = CacheImpl.get();
        cache.cacheItem(1, "1");
        cache.cacheItem(2, "2");

        CacheItem cacheItem = cache.cacheItem(1, "1");

        assertEquals(cache.getView().getItem(0), cacheItem);
    }

    @Test(groups = "fast")
    public void invalidateCacheTest() {
        Cache cache = CacheImpl.get();
        cache.cacheItem(1, "1");

        cache.invalidateCache();
        assertEquals(cache.getView().size(), 0);
    }

    @Test(groups = "fast")
    public void checkIfOnlyThreeValuesAreAvailable() {
        Cache cache = CacheImpl.get();
        cache.cacheItem(1, "1");
        cache.cacheItem(2, "2");
        cache.cacheItem(3, "3");
        cache.cacheItem(4, "4");
        cache.cacheItem(5, "5");

        CacheItem cacheItem = cache.cacheItem(3, "3");
        assertEquals(cache.getView().getItem(0), cacheItem);
    }

    @Test(groups = "fast")
    public void checkIfReturnsNullWhenAskedForNonexistentEntry() {
        Cache cache = CacheImpl.get();
        cache.cacheItem(1, "1");

        assertNull(cache.getView().getItem(4));
    }

    @Test
    public void getObjectByValue() {
        Cache cache = CacheImpl.get();
        cache.cacheItem(1, "1");
        cache.cacheItem(2, "2");
        cache.cacheItem(3, "3");

        CacheItem cacheItem = cache.cacheItem(1, "3");

        assertEquals(cache.getView().getItem("3"), cacheItem);

        cache.cacheItem(4, "4");
    }

    @Test
    public void noCacheEntryExceptionsIfGetOldElement() {
        Cache cache = CacheImpl.get();
        cache.cacheItem(1, "1");
        cache.cacheItem(2, "2");

        CacheItem cacheItem = cache.cacheItem(3, "3");
        cache.cacheItem(4, "4");

        cache.getView().getItem("1");
    }
}