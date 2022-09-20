package org.example;

import com.googlecode.lanterna.terminal.DefaultTerminalFactory;
import com.googlecode.lanterna.terminal.Terminal;

import java.io.IOException;

public class Main {

    public static void main(String[] args) {

        DefaultTerminalFactory defaultTerminalFactory = new DefaultTerminalFactory();
        Terminal terminal = null;

        try {
            terminal = defaultTerminalFactory.createTerminal();
            Game game = new Game(terminal);
            game.start();

            terminal.readInput();
        }
        catch(IOException e) {
            e.printStackTrace();
        }
        finally {
            if(terminal != null) {
                try {
                    terminal.close();
                }
                catch(IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
