package problems.file_sharing.service;

import problems.file_sharing.controller.FileController;
import problems.file_sharing.model.User;

import java.util.*;

public class FileManager {
    private static volatile FileManager instance;
    private final FileController fileController = FileController.getInstance();

    private FileManager() {}

    public static FileManager getInstance() {
        if (instance == null) {
            synchronized (FileManager.class) {
                if (instance == null) {
                    instance = new FileManager();
                }
            }
        }
        return instance;
    }

    public void shareFile(User owner, List<User> recipients, String fileName, byte[] content) {
        fileController.shareFile(owner, recipients, fileName, content);
    }
}
