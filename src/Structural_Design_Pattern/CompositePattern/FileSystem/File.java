package Structural_Design_Pattern.CompositePattern.FileSystem;

public class File implements IFileSystem{
    private String name;

    public File(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public void ls() {
        System.out.println("File Name : " + name);
    }
}
