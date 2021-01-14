package io.brainshells.api.openimagecv.commons.resource;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

public class FileResource extends Resource {

    private final File file;

    public FileResource(final File file) {
        super(file.getName());
        this.file = file;
    }

    @Override
    public boolean canBeOpened() {
        return this.file.exists();
    }

    @Override
    protected InputStream openStream() throws IOException {
        return new BufferedInputStream(new FileInputStream(this.file));
    }

    @Override
    public String toString() {
        return "File: " + this.file;
    }
}
