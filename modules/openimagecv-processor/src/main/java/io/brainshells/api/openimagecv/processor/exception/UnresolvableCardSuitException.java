package io.brainshells.api.openimagecv.processor.exception;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public class UnresolvableCardSuitException extends RuntimeException {

    /**
     * Default explicit serialVersionUID for interoperability
     */
    private static final long serialVersionUID = 177576363646781218L;

    /**
     * Default error message templates
     */
    private static final String DEFAULT_UNSUPPORTED_PROCESSOR_PROVIDER_TYPE_MESSAGE_TEMPLATE = "error.issue.type.incorrect";

    /**
     * {@link UnresolvableCardSuitException} constructor with initial input message
     *
     * @param message - initial input message {@link String}
     */
    public UnresolvableCardSuitException(final String message) {
        super(message);
    }

    /**
     * {@link UnresolvableCardSuitException} constructor with initial input {@link Throwable}
     *
     * @param cause - initial input {@link Throwable}
     */
    public UnresolvableCardSuitException(final Throwable cause) {
        super(cause);
    }

    /**
     * {@link UnresolvableCardSuitException} constructor with initial input message and {@link Throwable}
     *
     * @param message - initial input message {@link String}
     * @param cause   - initial input {@link Throwable}
     */
    public UnresolvableCardSuitException(final String message, final Throwable cause) {
        super(message, cause);
    }

    /**
     * Returns {@link UnresolvableCardSuitException} by input parameters
     *
     * @param message - initial input message {@link String}
     * @return {@link UnresolvableCardSuitException}
     */
    public static UnresolvableCardSuitException throwError(final String message) {
        throw new UnresolvableCardSuitException(message);
    }
}
