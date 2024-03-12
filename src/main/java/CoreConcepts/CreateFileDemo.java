package CoreConcepts;

import java.io.File;


public class CreateFileDemo {

    public boolean createFileIfNotExists(String fileName){
        File inputFile = new File(fileName);
        boolean isFileCreated = false;
        if (!inputFile.exists()){
            try {
                // first create the missing dirs
                File parent = inputFile.getParentFile();
                if (parent != null && !parent.exists() && !parent.mkdirs()) {
                    throw new IllegalStateException("Couldn't create dir: " + parent);
                }
                // here the dir would have been created so create the file >>>>
                isFileCreated  = inputFile.createNewFile();
            }catch (Exception e) {
                //log.error("file not created , error: {}",e.getMessage());
            }
        }else{
            // file already exists
        }
        return isFileCreated;
    }

    public boolean createFileIfNotExists(File inputFile){
        boolean isFileCreated = false;
        if (!inputFile.exists()){
            try {
                // first create the missing dirs
                File parent = inputFile.getParentFile();
                if (parent != null && !parent.exists() && !parent.mkdirs()) {
                    throw new IllegalStateException("Couldn't create dir: " + parent);
                }
                // here the dir would have been created so create the file >>>>
                isFileCreated  = inputFile.createNewFile();
            }catch (Exception e) {
                //log.error("file not created , error: {}",e.getMessage());
            }
        }else{
            // file already exists
        }
        return isFileCreated;
    }

    public static void main(String[] args) {
        String filename = "/Users/raushkumar/Desktop/a/b/c/d/e/current_active_dmp.json";
        CreateFileDemo createFileDemo = new CreateFileDemo();
        boolean status = createFileDemo.createFileIfNotExists(filename);
        System.out.println("status >>>> " + status);
        if (status) System.out.println("file created >>>>" + status);
    }
}
