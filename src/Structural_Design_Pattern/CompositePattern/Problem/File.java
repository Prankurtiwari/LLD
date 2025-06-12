package Structural_Design_Pattern.CompositePattern.Problem;

public class File {
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

    public void ls() {
        System.out.println("File Name : " + name);
    }
}
