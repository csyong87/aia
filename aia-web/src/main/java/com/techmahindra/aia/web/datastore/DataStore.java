package com.techmahindra.aia.web.datastore;

import com.techmahindra.aia.service.model.UserContext;

import java.io.Serializable;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * A container for data that are meant to be maintained in the {@code HttpSession}.
 *
 * @author Christian
 */
public class DataStore implements Serializable {

    /**
     *
     */
    private static final long serialVersionUID = -5265852261965191245L;

    /**
     * The internal identifier to the {@link UserContext} object in the {@link DataStore} cache
     */
    private static final String INTERNAL_USER_CONTEXT_DATA = "user.context.data";

    /**
     * The cache's internal storage mechanism
     */
    private Map<String, Object> cache = new ConcurrentHashMap<String, Object>();

    /**
     * The default constructor
     */
    public DataStore() {
    }

    /**
     * Store an object into the cache and map to <tt>key</tt>.
     * <p/>
     *
     * @param key   The key to the object in the cache
     * @param value The value to be stored in the cache.
     */
    public final void put(final String key, final Object value) {
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
    public final Object get(final String key) {
        return cache.get(key);
    }

    /**
     * Remove an object identified by the parameter <tt>key</tt> from the cache
     * <p/>
     *
     * @param key 
     */
    public final void remove(final String key) {
        if (cache.containsKey(key)) {
            cache.remove(key);
        }
    }

    /**
     * A type-safe way of getting the {@link UserContext}.
     *
     * @return The logged in user's {@link UserContext}
     */
    public final UserContext getUserContextData() {
        return (UserContext) cache.get(INTERNAL_USER_CONTEXT_DATA);
    }

    /**
     * <p>
     * A type-safe way of setting the {@link UserContext}.
     * </p>
     *
     * @param userContextData The logged in user's context data
     * @see UserContext
     */
    public final void setUserContextData(final UserContext userContextData) {
        cache.put(INTERNAL_USER_CONTEXT_DATA, userContextData);
    }
}
