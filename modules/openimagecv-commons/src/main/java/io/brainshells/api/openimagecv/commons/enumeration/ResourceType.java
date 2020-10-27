package io.brainshells.api.openimagecv.commons.enumeration;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public enum ResourceType {
    PROPERTIES(".properties"),
    YAML(".yml", ".yaml");

    private final Set<String> fileExtensions;

    ResourceType(final String... fileExtensions) {
        this.fileExtensions = new HashSet<>();
        Collections.addAll(this.fileExtensions, fileExtensions);
    }

    public static Set<String> allFileExtensions(final ResourceType... resourceTypes) {
        final Set<String> extensions = new HashSet<String>();
        for (final ResourceType resourceType : resourceTypes) {
            extensions.addAll(resourceType.fileExtensions());
        }
        return extensions;
    }

    public static ResourceType getByFileName(final String fileName) {
        for (final ResourceType resourceType : ResourceType.values()) {
            for (final String extension : resourceType.fileExtensions()) {
                if (fileName.endsWith(extension)) {
                    return resourceType;
                }
            }
        }
        return null;
    }

    public Set<String> fileExtensions() {
        return new HashSet<>(this.fileExtensions);
    }
}
