package training.patterns.decorator.nio;

import org.jetbrains.annotations.NotNull;

import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;

class UpperCaseInputStream extends FilterInputStream {

    UpperCaseInputStream(InputStream in) {
        super(in);
    }

    @Override
    public int read() throws IOException {
        int codePoint = in.read();
        return (codePoint == -1 ? codePoint : Character.toUpperCase((char) codePoint));
    }

    @Override
    public int read(@NotNull byte[] b, int off, int len) throws IOException {
        int codePoint = in.read(b, off, len);
        for (int i = off; i < off + codePoint; i++) {
            b[i] = (byte) Character.toUpperCase((char) b[i]);
        }
        return codePoint;
    }

    @Override
    public int read(@NotNull byte[] b) throws IOException {
        int codePoint = in.read(b);
        for (int i = 0; i < b.length; i++) {
            b[i] = (byte) Character.toUpperCase((char) b[i]);
        }
        return codePoint;
    }
}
