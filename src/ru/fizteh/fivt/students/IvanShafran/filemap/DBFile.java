package ru.fizteh.fivt.students.IvanShafran.filemap;


import java.io.*;
import java.util.HashMap;

public class DBFile {
    private File workingFile;
    private HashMap<String, String> hashMap;

    public File getWorkingFile() throws Exception {
        return workingFile;
    }

    public void setWorkingFile(File file) {
        workingFile = file;
    }

    public HashMap<String, String> getHashMap() {
            return hashMap;
    }

    DBFile(File file) {
        setWorkingFile(file);
    }

    public void readFile() throws Exception {
        HashMap readingHashMap = new HashMap();

        try (ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(workingFile))) {
            String key = (String) objectInputStream.readObject();
            String value = (String) objectInputStream.readObject();
        }

        hashMap = readingHashMap;
    }

    public void writeHashMapToFile() throws Exception {
        if (hashMap == null) {
            throw new Exception("hashMap doesn't read yet");
        }

        try (ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(workingFile))) {
            for (String key : hashMap.keySet()) {
                objectOutputStream.writeObject(key);
                objectOutputStream.writeObject(hashMap.get(key));
            }
        }
    }

}
