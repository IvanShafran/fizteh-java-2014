package ru.fizteh.fivt.students.IvanShafran.filemap.commands;

import ru.fizteh.fivt.students.IvanShafran.filemap.DBFile;
import ru.fizteh.fivt.students.IvanShafran.shell.AbstractShell;
import ru.fizteh.fivt.students.IvanShafran.shell.commands.Command;

import java.util.ArrayList;


public class CommandList extends Command {
    DBFile dataBaseFile;

    public void execute(ArrayList<String> args) throws Exception {
        StringBuilder list = new StringBuilder();
        int index = 0;
        for (String key : dataBaseFile.getHashMap().keySet()) {
            list.append(key);
            ++index;

            if (index != dataBaseFile.getHashMap().size()) {
                list.append(", ");
            }
        }

        AbstractShell.printInformation(list.toString());
    }

    CommandList(DBFile file) {
        dataBaseFile = file;
    }
}
