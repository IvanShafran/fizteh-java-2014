package ru.fizteh.fivt.students.IvanShafran.multifilehashmap.commands;

import ru.fizteh.fivt.students.IvanShafran.multifilehashmap.DBFile;
import ru.fizteh.fivt.students.IvanShafran.multifilehashmap.abstractShell.AbstractShell;
import ru.fizteh.fivt.students.IvanShafran.multifilehashmap.abstractShell.Command;

import java.util.ArrayList;


public class CommandPut extends Command {
    private DBFile dataBaseFile;

    @Override
    public void checkArgs(ArrayList<String> args) throws Exception {
        if (args.size() == 0) {
            throw new Exception("missing operand");
        }

        if (args.size() == 1) {
            throw new Exception("missing value");
        }
    }

    private void putValue(String key, String value) {
        dataBaseFile.getHashMap().put(key, value);
    }

    public void execute(ArrayList<String> args) throws Exception {
        checkArgs(args);

        String key = args.get(0);
        String value = args.get(1);

        if (dataBaseFile.getHashMap().containsKey(key)) {
            AbstractShell.printInformation("overwrite old value");
        } else {
            AbstractShell.printInformation("new");
        }

        putValue(key, value);
        dataBaseFile.writeHashMapToFile();
    }

    public CommandPut(DBFile file) {
        dataBaseFile = file;
    }
}
