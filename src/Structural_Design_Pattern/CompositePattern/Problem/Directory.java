package Structural_Design_Pattern.CompositePattern.Problem;

import java.util.ArrayList;
import java.util.List;

public class Directory {
    private String directoryName;
    private List<Object> objectsList;

    public Directory(String directoryName) {
        this.directoryName = directoryName;
        this.objectsList = new ArrayList<>();
    }

    public void add (Object object) {
        objectsList.add(object);
    }

    public void ls() {
        System.out.println("Directory name : " + directoryName);

        for (Object object : objectsList) {
            // Problem

            if(object instanceof File) {
                ((File) object).ls();
            } else if (object instanceof Directory) {
                ((Directory) object).ls();
            }
        }
    }
}
