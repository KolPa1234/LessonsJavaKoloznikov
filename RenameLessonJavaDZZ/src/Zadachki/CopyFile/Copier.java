package Zadachki.CopyFile;

import java.io.IOException;

public interface Copier {
    boolean copy(String filePath, String destinationFolderPath) throws IOException;
}
