package Structural_Design_Pattern.CompositePattern.Problem;

public class Main {
    public static void main(String[] args) {
        File oneMovie = new File("Border");
        File twoMovie = new File("Hulchal");
        Directory directory = new Directory("Comedy_Movie");

        directory.add(twoMovie);

        Directory movie = new Directory("Movie");
        movie.add(oneMovie);
        movie.add(directory);

        movie.ls();
    }
}
