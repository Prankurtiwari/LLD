package problems.file_sharing.controller;

import problems.file_sharing.model.File;
import problems.file_sharing.model.User;
import problems.file_sharing.repository.FileRepository;

import java.util.*;

public class FileController {
    private static volatile FileController instance;
    private final FileRepository fileRepository = FileRepository.getInstance();

    private FileController() {}

    public static FileController getInstance() {
        if (instance == null) {
            synchronized (FileController.class) {
                if (instance == null) {
                    instance = new FileController();
                }
            }
        }
        return instance;
    }

    public void shareFile(User owner, List<User> recipients, String fileName, byte[] content) {
        File file = new File(fileName, content, owner);
        owner.addFile(file);

        for (User recipient : recipients) {
            file.addRecipient(recipient);
            recipient.addFile(file);
        }

        fileRepository.saveFile(file);
    }
}
