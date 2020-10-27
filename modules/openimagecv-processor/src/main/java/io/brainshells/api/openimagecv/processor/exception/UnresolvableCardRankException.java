package io.brainshells.api.openimagecv.processor.exception;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public class UnresolvableCardRankException extends RuntimeException {

    /**
     * Default explicit serialVersionUID for interoperability
     */
    private static final long serialVersionUID = 8448568329641060033L;

    /**
     * Default error message templates
     */
    private static final String DEFAULT_UNSUPPORTED_PROCESSOR_PROVIDER_TYPE_MESSAGE_TEMPLATE = "error.issue.type.incorrect";

    /**
     * {@link UnresolvableCardRankException} constructor with initial input message
     *
     * @param message - initial input message {@link String}
     */
    public UnresolvableCardRankException(final String message) {
        super(message);
    }

    /**
     * {@link UnresolvableCardRankException} constructor with initial input {@link Throwable}
     *
     * @param cause - initial input {@link Throwable}
     */
    public UnresolvableCardRankException(final Throwable cause) {
        super(cause);
    }

    /**
     * {@link UnresolvableCardRankException} constructor with initial input message and {@link Throwable}
     *
     * @param message - initial input message {@link String}
     * @param cause   - initial input {@link Throwable}
     */
    public UnresolvableCardRankException(final String message, final Throwable cause) {
        super(message, cause);
    }

    /**
     * Returns {@link UnresolvableCardRankException} by input parameters
     *
     * @param message - initial input message {@link String}
     * @return {@link UnresolvableCardRankException}
     */
    public static UnresolvableCardRankException throwError(final String message) {
        throw new UnresolvableCardRankException(message);
    }
}
