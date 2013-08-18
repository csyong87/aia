package com.techmahindra.aia.web.datastore;

import java.io.Serializable;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import com.techmahindra.aia.service.model.UserContext;

/**
 * A container for data that are meant to be maintained in the {@code HttpSession}.
 * 
 * @author Christian
 * 
 */
public class DataStore implements Serializable {

    /**
	 * 
	 */
    private static final long serialVersionUID = -5265852261965191245L;

    private static final String INTERNAL_USER_CONTEXT_DATA = "user.context.data";

    private Map<String, Object> cache = new ConcurrentHashMap<String, Object>();

    public DataStore() {
    }

    /**
     * Store an object into the cache and map to <tt>key</tt>
     */
    public void put(String key, Object value) {
        if (key.equalsIgnoreCase(INTERNAL_USER_CONTEXT_DATA)) {
            throw new RuntimeException(String.format("%s may not be used as it is a reserved internal keyword", key));
        }
        cache.put(key, value);
    }

    /**
     * Retrieve an object identified by the parameter <tt>key</tt> from the cache
     * 
     * @param key
     * @return
     */
    public Object get(String key) {
        return cache.get(key);
    }

    /**
     * Remove an object identified by the parameter <tt>key</tt> from the cache
     * <p>
     * 
     * @param key
     */
    public void remove(String key) {
        if (cache.containsKey(key)) {
            cache.remove(key);
        }
    }

    /**
     * <p>
     * A type-safe way of setting the {@link UserContext}.
     * </p>
     * 
     * @param userContextData
     * @see UserContextData
     */
    public void setUserContextData(UserContext userContextData) {
        cache.put(INTERNAL_USER_CONTEXT_DATA, userContextData);
    }

    /**
     * A type-safe way of getting the {@link UserContext}.
     * 
     * @return
     */
    public UserContext getUserContextData() {
        return (UserContext) cache.get(INTERNAL_USER_CONTEXT_DATA);
    }
}
