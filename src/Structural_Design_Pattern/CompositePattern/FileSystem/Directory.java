package Structural_Design_Pattern.CompositePattern.FileSystem;

import Structural_Design_Pattern.CompositePattern.Problem.File;

import java.util.ArrayList;
import java.util.List;

public class Directory implements IFileSystem{
    private final String directoryName;
    private List<IFileSystem> objectsList;

    public Directory(String directoryName) {
        this.directoryName = directoryName;
        this.objectsList = new ArrayList<>();
    }

    public void add (IFileSystem object) {
        objectsList.add(object);
    }

    public void ls() {
        System.out.println("Directory name : " + directoryName);

        for (IFileSystem object : objectsList) {
            object.ls();
        }
    }
}
