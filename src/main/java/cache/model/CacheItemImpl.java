package cache.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class CacheItemImpl implements CacheItem {
    private String key;
    private Object value;
}
