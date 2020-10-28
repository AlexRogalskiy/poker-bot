package io.brainshells.api.openimagecv.processor;

import io.brainshells.api.openimagecv.processor.management.ApplicationRunner;

public class ApplicationBootstrap {

    public static void main(final String[] args) {
        new ApplicationRunner(args).execute();
    }
}
