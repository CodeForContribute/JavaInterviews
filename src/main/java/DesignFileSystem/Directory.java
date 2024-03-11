package DesignFileSystem;
import java.util.ArrayList;
import java.util.List;
public class Directory implements FileSystem{
    private final String dirName;
    private final List<FileSystem>fileSystemList;

    public Directory(String dirName){
        this.dirName = dirName;
        this.fileSystemList = new ArrayList<>();
    }

    public void add(FileSystem fileSystem){
        this.fileSystemList.add(fileSystem);
    }
    @Override
    public void ls(){
        System.out.println("dir name: " + dirName);
        for (FileSystem fileSystem: fileSystemList){
            fileSystem.ls();
        }
    }
}
