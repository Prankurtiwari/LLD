package problems.file_sharing.repository;

import problems.file_sharing.model.File;

import java.util.*;

public class FileRepository {
    private static volatile FileRepository instance;
    private final Map<UUID, File> files = new HashMap<>();

    private FileRepository() {}

    public static FileRepository getInstance() {
        if (instance == null) {
            synchronized (FileRepository.class) {
                if (instance == null) {
                    instance = new FileRepository();
                }
            }
        }
        return instance;
    }

    public void saveFile(File file) {
        files.put(file.getId(), file);
    }

    public File getFile(UUID id) {
        return files.get(id);
    }
}
