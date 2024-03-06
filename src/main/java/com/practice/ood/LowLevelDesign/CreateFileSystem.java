package com.practice.ood.LowLevelDesign;

public class CreateFileSystem {
    // in normal implementation we have to check the instance type.
    // solved better with Composite design pattern
    public static void main(String[] args) {
        Directory movieDir = new Directory("Movie");
        FileSystem borderMovie = new File("Border");
        movieDir.add(borderMovie);
        Directory comedyMovieDir = new Directory("ComedyMovies");
        FileSystem hulChul = new File("hulChul");
        comedyMovieDir.add(hulChul);
        movieDir.add(comedyMovieDir);
        movieDir.ls();
    }

}
