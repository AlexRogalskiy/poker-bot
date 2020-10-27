package io.brainshells.api.openimagecv.processor.enumeration;

/**
 * Card mask interface declaration
 *
 * @param <T> type of configurable card mask
 */
public interface Maskable<T> {
    /**
     * Returns {@link T} view mask
     *
     * @return {@link T} view mask
     */
    T getMask();
}
