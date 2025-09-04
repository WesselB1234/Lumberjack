package org.example;

import com.googlecode.lanterna.terminal.DefaultTerminalFactory;
import com.googlecode.lanterna.terminal.Terminal;
import com.googlecode.lanterna.terminal.swing.SwingTerminalFrame;

import javax.swing.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.IOException;

public class Main {

    public static void main(String[] args) {

        DefaultTerminalFactory factory = new DefaultTerminalFactory();

        try (Terminal terminal = factory.createTerminal()) {

            // Event handling in case of a Swing terminal frame,
            // so the application closes properly when the user clicks the close button of the window.
            if (terminal instanceof SwingTerminalFrame) {
                SwingTerminalFrame swing = (SwingTerminalFrame) terminal;
                swing.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
                swing.addWindowListener(new WindowAdapter() {
                    @Override public void windowClosing(WindowEvent e) { System.exit(0); // if you want to be extra sure
                    }
                });
            }

            Game game = new Game(terminal);
            game.start();
        }
        catch(IOException e) {
            e.printStackTrace();
        }
    }
}
