package com.lucadev.coinmarketcap.model;

import java.util.Map;

/**
 * Default CMC response format
 *
 * @author <a href="mailto:Luca.Camphuisen@hva.nl">Luca Camphuisen</a>
 * @since 6-5-18
 */
public class ApiResponse<T> {

    protected final Map<String, Object> metadata;
    protected final T data;
    public static final String PROPERTY_DATA = "data";
    public static final String PROPERTY_METADATA = "metadata";
    public static final String KEY_METADATA_ERROR = "error";
    public static final String KEY_METADATA_TIMESTAMP = "timestamp";

    /**
     * Constructs the response model.
     * @param data the response data.
     * @param metadata the metadata object in the response. Inside a map.
     */
    public ApiResponse(T data, Map<String,Object> metadata) {
        this.data = data;
        this.metadata = metadata;
    }

    public T getData() {
        return data;
    }

    public Map<String, Object> getMetadata() {
        return metadata;
    }

    /**
     * Get the erro
     * @return
     */
    public String getError() {
        return String.valueOf(metadata.get(KEY_METADATA_ERROR));
    }

    public long getTimestamp() {
        return Long.parseLong((String)metadata.get(KEY_METADATA_TIMESTAMP));
    }

}
