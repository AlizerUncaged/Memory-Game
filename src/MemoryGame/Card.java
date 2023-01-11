/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package MemoryGame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
/**
 *
 * @author Flandre
 */
public class Card extends JLabel {
      private final int value;
    private boolean faceUp;
    private ImageIcon backImage;
    private ImageIcon frontImage;
     boolean isDisabled;

    public Card(int value) {
        this.value = value;
        this.faceUp = false;

        // Load the back image
        // this.backImage = new ImageIcon("back.png");
        // this.frontImage = new ImageIcon(value + ".png");
        this.setText("" + value);
        
        // Set the size of the card
        setPreferredSize(new Dimension(100, 100));
        
        var image = new javax.swing.ImageIcon(getClass().getResource("/MemoryGame/Hidden.png"));
        
        this.setIcon(image);
        
        this.setHorizontalAlignment(JLabel.CENTER);
        this.setVerticalAlignment(JLabel.CENTER);
        this.setFont(new Font("Impact", Font.PLAIN, 30));
        
    }

    public int getValue() {
        return value;
    }

    public boolean isFaceUp() {
        return faceUp;
    }

    public void flip() {
        if (faceUp) {
            var image = new javax.swing.ImageIcon(getClass().getResource("/MemoryGame/Hidden.png"));

            this.setIcon(image);
        } else {
            setIcon(frontImage);
        }
        faceUp = !faceUp;
    }
    
    public void disable() {
        isDisabled = true;
    }

    public void enable() {
        isDisabled = false;
    }
}
