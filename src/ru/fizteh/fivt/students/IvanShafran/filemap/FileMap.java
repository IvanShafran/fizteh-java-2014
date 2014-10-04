package ru.fizteh.fivt.students.IvanShafran.filemap;

import ru.fizteh.fivt.students.IvanShafran.filemap.commands.*;
import ru.fizteh.fivt.students.IvanShafran.shell.AbstractShell;

import java.io.File;
import java.nio.file.Paths;
import java.util.HashMap;

public class FileMap extends AbstractShell {
    private DBFile dataBaseFile;

    private void checkWorkingFile() throws Exception {
        //String path = System.getProperty("db.file");
        String testPath = "C:/test/1.bin";
        String path = testPath;

        File workingFile = new File(Paths.get(path).toAbsolutePath().toString());

        if (!workingFile.exists() || workingFile.isDirectory()) {
            throw new Exception("wrong path to db file");
        }
    }

    private void initCommands() {
        command = new HashMap<>();

        command.put("put", new CommandPut(dataBaseFile));
        command.put("exit", new CommandExit(dataBaseFile));
        command.put("get", new CommandGet(dataBaseFile));
        command.put("list", new CommandList(dataBaseFile));
        command.put("remove", new CommandRemove(dataBaseFile));
    }

    private void initDBFile() {
        //String path = System.getProperty("db.file");
        String testPath = "C://test//1.bin";
        String path = testPath;

        dataBaseFile = new DBFile(new File(Paths.get(path).toAbsolutePath().toString()));

        try {
            dataBaseFile.readFile();
        }
        catch (Exception e) {
            printException(e.getMessage());
        }
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
