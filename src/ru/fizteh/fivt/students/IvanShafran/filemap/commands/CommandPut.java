package ru.fizteh.fivt.students.IvanShafran.filemap.commands;

import ru.fizteh.fivt.students.IvanShafran.filemap.DBFile;
import ru.fizteh.fivt.students.IvanShafran.shell.commands.Command;

import java.util.ArrayList;


public class CommandPut extends Command {
    DBFile dataBaseFile;

    @Override
    public void checkArgs(ArrayList<String> args) throws Exception {
        if (args.size() == 0) {
            throw new Exception("missing operand");
        }

        if (args.size() == 1) {
            throw new Exception("missing value");
        }
    }

    public void execute(ArrayList<String> args) throws Exception {
        checkArgs(args);



    }

    CommandPut(DBFile file) {
        dataBaseFile = file;
    }
}
