package ru.fizteh.fivt.students.IvanShafran.filemap;

import ru.fizteh.fivt.students.IvanShafran.shell.AbstractShell;

import java.io.File;
import java.util.HashMap;

public class FileMap extends AbstractShell {
    private DBFile dataBaseFile;

    public DBFile getDataBaseFile() {
        return dataBaseFile;
    }

    private void checkWorkingFile() throws Exception {
        String path = System.getProperty("db.file");

        File workingFile = new File(path);

        if (!workingFile.exists() || workingFile.isDirectory()) {
            throw new Exception("wrong path to db file");
        }
    }

    private void initCommands() {
        command = new HashMap<>();

    }

    private void initDBFile() {
        dataBaseFile = new DBFile(new File(System.getProperty("db.file")));
    }

    FileMap() {
        try {
            checkWorkingFile();
            initDBFile();
            initCommands();
        }
        catch (Exception e) {
            printException(e.getMessage());
        }
    }
}
