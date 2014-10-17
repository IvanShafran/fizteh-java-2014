package ru.fizteh.fivt.students.IvanShafran.multifilehashmap.commands.dbfile;

import ru.fizteh.fivt.students.IvanShafran.multifilehashmap.DBFile;
import ru.fizteh.fivt.students.IvanShafran.multifilehashmap.DBTable;
import ru.fizteh.fivt.students.IvanShafran.multifilehashmap.abstractShell.AbstractShell;
import ru.fizteh.fivt.students.IvanShafran.multifilehashmap.abstractShell.Command;

import java.util.ArrayList;


public class CommandRemove extends Command {
    private DBTable dbTable;

    public void setDBTable(DBTable newDBTable) {
        dbTable = newDBTable;
    }

    @Override
    public void checkArgs(ArrayList<String> args) throws Exception {
        if (args.size() == 0) {
            throw new Exception("missing key");
        }
    }

    public void execute(ArrayList<String> args) throws Exception {
        checkArgs(args);

        String key = args.get(0);

        int hashCode = key.hashCode();
        int nDirectory = hashCode % 16;
        int nFile = (hashCode / 16) % 16;

        DBFile dbFile = dbTable.getMapOfDBFiles().get(nDirectory).get(nFile);

        if (dbFile.getHashMap().containsKey(key)) {
            AbstractShell.printInformation("remove");
        } else {
            AbstractShell.printInformation("not found");
        }

        dbFile.getHashMap().remove(key);
    }

}
