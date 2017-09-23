package cache;

import cache.model.CacheItem;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class CacheImplTest {
    @Test
    public void assertEqualsIfsimilarItemsTest() {
        Cache cache = CacheImpl.get();
        cache.cacheItem(1, "1");
        cache.cacheItem(2, "2");

        CacheItem cacheItem = cache.cacheItem(1, "1");

        assertEquals(cache.getView().getItem(0), cacheItem);
    }

    @Test
    public void invalidateCacheMustClearCacheTest() {
        Cache cache = CacheImpl.get();

        cache.invalidateCache();
        assertEquals(cache.getView().size(), 0);
    }

    @Test
    public void onlyThreeValuesAreAvailableTest() {
        Cache cache = CacheImpl.get();
        cache.cacheItem(1, "1");
        cache.cacheItem(2, "2");
        cache.cacheItem(3, "3");
        cache.cacheItem(4, "4");
        cache.cacheItem(5, "5");

        CacheItem cacheItem = cache.cacheItem(3, "3");
        assertEquals(cache.getView().getItem(0), cacheItem);
    }

    @Test
    public void noCacheEntryExceptionsIfNumberIndexIsGraderThanThreeTest() {
        Cache cache = CacheImpl.get();
        cache.cacheItem(1, "1");

        cache.getView().getItem(4);
    }

    @Test
    public void clearCacheTest() {
        Cache cache = CacheImpl.get();
        cache.cacheItem(1, "1");

        CacheItem cacheItem = cache.cacheItem(1, "1");

        assertEquals(cache.getView().getItem(0), cacheItem);

        cache.invalidateCache();

        assertNull(cache.getView().getItem(0));
    }

    @Test
    public void getObjectByValueShouldBeReturnTest() {
        Cache cache = CacheImpl.get();
        cache.cacheItem(1, "1");
        cache.cacheItem(2, "2");
        cache.cacheItem(3, "3");

        CacheItem cacheItem = cache.cacheItem(1, "3");

        assertEquals(cache.getView().getItem("3"), cacheItem);

        cache.cacheItem(4, "4");
    }

    @Test
    public void noCacheEntryExceptionsIfGetOldElementTest() {
        Cache cache = CacheImpl.get();
        cache.cacheItem(1, "1");
        cache.cacheItem(2, "2");

        CacheItem cacheItem = cache.cacheItem(3, "3");
        cache.cacheItem(4, "4");

       cache.getView().getItem("1");
    }
}