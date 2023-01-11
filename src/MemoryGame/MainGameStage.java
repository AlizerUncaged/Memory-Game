/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package MemoryGame;

import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.net.*;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;
import javax.swing.*;

/**
 *
 * @author Flandre
 */
public class MainGameStage extends javax.swing.JPanel {
    
    int moves = 0;

    /**
     * Creates new form MainGameStage
     */
    public MainGameStage() {
        initComponents();
        moveLabel.setText("Moves: " + moves);
        List<Card> picked = new ArrayList<>();
        
        List<Integer> cardValues = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 1, 2, 3, 4, 5, 6, 7, 8));
        Collections.shuffle(cardValues); // Shuffle the list of card values

        gameArea.setLayout(new GridLayout(4, 4));
        boolean[] disabledClicks = {false};
        List<Card> cards = new ArrayList<>();
        // add cards
        for (int i = 0; i < 16; i++) {
            // Instantiate the Card with random "values"
            int value = cardValues.get(i);
            Card card = new Card(value);
            cards.add(card);
            
            card.addMouseListener(new MouseAdapter() {
                @Override
                public void mousePressed(MouseEvent e) {
                    if (disabledClicks[0] || card.isDisabled) {
                        return;
                    }
                    
                    card.flip();
                    
                    var value = card.getValue();
                    System.out.println(value);
                    picked.add(card);
                    
                    if (picked.size() >= 2) // if there's at least 2 items
                    {
                        moves++;
                        moveLabel.setText("Moves: " + moves);
                        
                        int reference = card.getValue();
                        boolean allSame = true;
                        
                        List<Integer> values = picked.stream()
                                .map(card -> card.getValue())
                                .collect(Collectors.toList());
                        
                        for (int i : values) {
                            if (i != reference) {
                                allSame = false;
                                break;
                            }
                        }
                        
                        if (allSame) {
                            System.out.println("Correct!");
                            for (Card i : picked) {
                                i.disable();
                            }
                            picked.clear();
                            
                            boolean allFlipped = true;
                            for (Card p : cards) {
                                if (!p.isFaceUp()) {
                                    allFlipped = false;
                                    break;
                                }
                            }
                            
                            if (allFlipped) {
                                JFrame frame = new JFrame("Memory Game");
                                
                                var gameoverstage = new GameOverStage(Integer.toString(moves));
                                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                                frame.add(gameoverstage);
                                frame.pack();
                                frame.setIconImage(Toolkit.getDefaultToolkit().getImage(MemoryGame.class.getResource("icon.png")));
                                frame.setResizable(false);
                                frame.setLocationRelativeTo(null);
                                gameoverstage.jButton1.addActionListener(event -> frame.dispose());
                                
                                frame.setVisible(true);
                                
                                
                            }
                        } else {
                            
                            disabledClicks[0] = true;
                            
                            gameArea.setEnabled(false);
                            
                            javax.swing.Timer timer = new javax.swing.Timer(1000, new ActionListener() {
                                @Override
                                public void actionPerformed(ActionEvent e) {
                                    
                                    for (Card i : picked) {
                                        if (i.isFaceUp()) {
                                            i.flip();
                                        }
                                        System.out.println("flipped!");
                                    }
                                    
                                    picked.clear();
                                    disabledClicks[0] = false;
                                    
                                }
                            });
                            
                            timer.setRepeats(false);
                            timer.start();
                            System.out.println("Wrong!");
                            
                        }
                    }
                }
            });
            // Add the card to the cards panel
            gameArea.add(card);
        }
        
    }
    
    public void wait(int milliseconds) {
        SwingWorker worker = new SwingWorker<Void, Void>() {
            @Override
            protected Void doInBackground() throws Exception {
                Thread.sleep(milliseconds); // delay for 1 second
                return null;
            }
            
            @Override
            protected void done() {
                // code to execute when the delay is finished
                // here you can do the action you want to do
            }
        };
        worker.execute();
    }
    
    @Override
    protected void paintComponent(Graphics g) {
        
        System.out.print("Painted \n");
        
        super.paintComponent(g);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        moveLabel = new javax.swing.JLabel();
        gameArea = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();

        setName("backgroundPanel"); // NOI18N
        setPreferredSize(new java.awt.Dimension(400, 458));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        moveLabel.setFont(new java.awt.Font("Impact", 0, 24)); // NOI18N
        moveLabel.setForeground(new java.awt.Color(255, 255, 255));
        moveLabel.setText("Moves: 0");
        add(moveLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 400, -1, -1));

        gameArea.setName("gameArea"); // NOI18N
        gameArea.addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentShown(java.awt.event.ComponentEvent evt) {
                gameAreaShown(evt);
            }
        });

        javax.swing.GroupLayout gameAreaLayout = new javax.swing.GroupLayout(gameArea);
        gameArea.setLayout(gameAreaLayout);
        gameAreaLayout.setHorizontalGroup(
            gameAreaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 360, Short.MAX_VALUE)
        );
        gameAreaLayout.setVerticalGroup(
            gameAreaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 360, Short.MAX_VALUE)
        );

        add(gameArea, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, 360, 360));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/MemoryGame/natalia-rajs-background.jpg"))); // NOI18N
        jLabel1.setText("jLabel1");
        add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));
    }// </editor-fold>//GEN-END:initComponents

    private void gameAreaShown(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_gameAreaShown

    }//GEN-LAST:event_gameAreaShown


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel gameArea;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel moveLabel;
    // End of variables declaration//GEN-END:variables
}
