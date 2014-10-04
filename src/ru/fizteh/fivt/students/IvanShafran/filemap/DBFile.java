package ru.fizteh.fivt.students.IvanShafran.filemap;


import java.io.File;
import java.util.HashMap;

public class DBFile {
    private File workingFile;
    private HashMap<String, String> hashMap;

    public File getWorkingFile() {
        return workingFile;
    }

    public void setWorkingFile(File file) {
        workingFile = file;
    }

    public HashMap<String, String> getHashMap()
    {
        return hashMap;
    }

    DBFile(File file) {
        setWorkingFile(file);
    }

    public void readFile() throws Exception {
        HashMap readingHashMap = new HashMap();

        /**/

        hashMap = readingHashMap;
    }

    public void writeHashMapToFile() throws Exception {

    }

}
