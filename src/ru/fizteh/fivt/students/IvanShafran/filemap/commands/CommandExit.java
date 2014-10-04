package ru.fizteh.fivt.students.IvanShafran.filemap.commands;


import ru.fizteh.fivt.students.IvanShafran.shell.commands.Command;

import java.util.ArrayList;

public class CommandExit extends Command {
    public void execute(ArrayList<String> args) {
        System.exit(0);
    }
}
