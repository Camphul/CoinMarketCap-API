package com.lucadev.coinmarketcap.model;

import com.lucadev.coinmarketcap.api.ApiResponseException;

import java.util.Map;

/**
 * Default CMC response format
 *
 * @author <a href="mailto:Luca.Camphuisen@hva.nl">Luca Camphuisen</a>
 * @since 6-5-18
 */
public abstract class ApiResponse<T> {

    public static final String JSON_DATA_PROPERTY = "data";
    public static final String JSON_METADATA_PROPERTY = "metadata";
    public static final String METADATA_ERROR_KEY = "error";
    public static final String METADATA_TIMESTAMP_KEY = "timestamp";
    protected final Map<String, Object> metadata;
    protected final T data;

    /**
     * Constructs the response model.
     *
     * @param data     the response data.
     * @param metadata the metadata object in the response. Inside a map.
     */
    public ApiResponse(T data, Map<String, Object> metadata) {
        this.data = data;
        this.metadata = metadata;
        if (hasError()) {
            throw new ApiResponseException(this);
        }
    }

    /**
     * Actual data we are probably interested in.
     *
     * @return
     */
    public T getData() {
        return data;
    }

    /**
     * Metadata info map
     *
     * @return
     */
    public Map<String, Object> getMetadata() {
        return metadata;
    }

    /**
     * Get the erro
     *
     * @return
     */
    public String getError() {
        return String.valueOf(metadata.get(METADATA_ERROR_KEY));
    }

    /**
     * Check if the response contains an error
     *
     * @return
     */
    public boolean hasError() {
        return metadata.containsKey(METADATA_ERROR_KEY) && metadata.get(METADATA_ERROR_KEY) != null;
    }

    /**
     * Unix timestamp of request
     *
     * @return
     */
    public long getTimestamp() {
        return ((Integer) metadata.get(METADATA_TIMESTAMP_KEY)).longValue();
    }

}
