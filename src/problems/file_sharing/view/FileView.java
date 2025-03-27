package problems.file_sharing.view;

import problems.file_sharing.model.File;

public class FileView {
    public void displayFileInfo(File file) {
        System.out.println("File: " + file.getFileName());
        System.out.println("Owner: " + file.getOwner().getUsername());
        System.out.println("Recipients: " + file.getRecipients().size());
    }
}
