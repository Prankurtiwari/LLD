package Structural_Design_Pattern.CompositePattern.FileSystem;



public class Main {
    public static void main(String[] args) {

        Directory movie = new Directory("Movie");
        File oneMovie = new File("Border");
        File twoMovie = new File("Hulchal");
        Directory directory = new Directory("Comedy_Movie");

        directory.add(twoMovie);

        movie.add(oneMovie);
        movie.add(directory);

        movie.ls();
    }
}
