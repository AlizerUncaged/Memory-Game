/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package MemoryGame;

import java.awt.Toolkit;
import javax.swing.*;

/**
 *
 * @author Flandre
 */
public class MemoryGame {

    public static void main(String[] args) {
        // Create the MainGameStage
        JFrame frame = new JFrame("Memory Game");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(new MainGameStage());
        frame.pack();
        frame.setIconImage(Toolkit.getDefaultToolkit().getImage(MemoryGame.class.getResource("icon.png")));
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);

    }
}
