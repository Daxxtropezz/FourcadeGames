/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package four_in_one_games;

import java.awt.Color;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import static javax.swing.JOptionPane.INFORMATION_MESSAGE;

/**
 *
 * @author ACER
 */
public class TicTacToe extends javax.swing.JFrame {

    private String startGame = "X";
    private int xCounter = 0;
    private int oCounter = 0;
    
    /**
     * Creates new form TicTacToe
     */
    public TicTacToe() {
        initComponents();
        gameScore();
    }
    
    private void gameScore(){
        xPoints.setText(String.valueOf(xCounter));
        oPoints.setText(String.valueOf(oCounter));
        
        if(xCounter == 5){
            if(JOptionPane.showConfirmDialog(null,"Do You Want To Play Again?","Player 1 Wins!",JOptionPane.YES_OPTION)
                    == JOptionPane.YES_NO_OPTION){
                GameReset();
                xCounter = 0;
                oCounter = 0;
                
                xPoints.setText(String.valueOf(xCounter));
                oPoints.setText(String.valueOf(oCounter));
            }
        }
        else if(oCounter == 5){
            if(JOptionPane.showConfirmDialog(null,"Do You Want To Play Again?","Player 2 Wins!",JOptionPane.YES_OPTION)
                    == JOptionPane.YES_NO_OPTION){
                GameReset();
                xCounter = 0;
                oCounter = 0;
                
                xPoints.setText(String.valueOf(xCounter));
                oPoints.setText(String.valueOf(oCounter));
            }
        }
    }
    
    private void Player(){
        if(startGame.equalsIgnoreCase("X")){
            startGame = "O";
        }
        else{
            startGame = "X";
        }
    }
    
    private void GameReset(){
        square1.setText("");
        square2.setText("");
        square3.setText("");
        square4.setText("");
        square5.setText("");
        square6.setText("");
        square7.setText("");
        square8.setText("");
        square9.setText("");
        
        square1.setBackground(Color.BLACK);
        square2.setBackground(Color.BLACK);
        square3.setBackground(Color.BLACK);
        square4.setBackground(Color.BLACK);
        square5.setBackground(Color.BLACK);
        square6.setBackground(Color.BLACK);
        square7.setBackground(Color.BLACK);
        square8.setBackground(Color.BLACK);
        square9.setBackground(Color.BLACK);
    }
    
    private void winningGame(){
        String b1 = square1.getText();
        String b2 = square2.getText();
        String b3 = square3.getText();
        String b4 = square4.getText();
        String b5 = square5.getText();
        String b6 = square6.getText();
        String b7 = square7.getText();
        String b8 = square8.getText();
        String b9 = square9.getText();
        
        //PLAYER 1
        if(b1 == ("X") && b2 == ("X") && b3 == ("X")){
            JOptionPane.showMessageDialog(null, "Player 1 Wins!", "Tic Tac Toe Game!",INFORMATION_MESSAGE);
            xCounter++;
            gameScore();
            square1.setBackground(Color.RED);
            square2.setBackground(Color.YELLOW);
            square3.setBackground(Color.GREEN);
        }else if(b4 == ("X") && b5 == ("X") && b6 == ("X")){
            JOptionPane.showMessageDialog(null, "Player 1 Wins!", "Tic Tac Toe Game!",INFORMATION_MESSAGE);
            xCounter++;
            gameScore();
            square4.setBackground(Color.RED);
            square5.setBackground(Color.YELLOW);
            square6.setBackground(Color.GREEN);
        }else if(b7 == ("X") && b8 == ("X") && b9 == ("X")){
            JOptionPane.showMessageDialog(null, "Player 1 Wins!", "Tic Tac Toe Game!",INFORMATION_MESSAGE);
            xCounter++;
            gameScore();
            square7.setBackground(Color.RED);
            square8.setBackground(Color.YELLOW);
            square9.setBackground(Color.GREEN);
        }else if(b1 == ("X") && b5 == ("X") && b9 == ("X")){
            JOptionPane.showMessageDialog(null, "Player 1 Wins!", "Tic Tac Toe Game!",INFORMATION_MESSAGE);
            xCounter++;
            gameScore();
            square1.setBackground(Color.RED);
            square5.setBackground(Color.YELLOW);
            square9.setBackground(Color.GREEN);
        }else if(b1 == ("X") && b4 == ("X") && b7 == ("X")){
            JOptionPane.showMessageDialog(null, "Player 1 Wins!", "Tic Tac Toe Game!",INFORMATION_MESSAGE);
            xCounter++;
            gameScore();
            square1.setBackground(Color.RED);
            square4.setBackground(Color.YELLOW);
            square7.setBackground(Color.GREEN);
        }else if(b2 == ("X") && b5 == ("X") && b8 == ("X")){
            JOptionPane.showMessageDialog(null, "Player 1 Wins!", "Tic Tac Toe Game!",INFORMATION_MESSAGE);
            xCounter++;
            gameScore();
            square2.setBackground(Color.RED);
            square5.setBackground(Color.YELLOW);
            square8.setBackground(Color.GREEN);
        }else if(b3 == ("X") && b6 == ("X") && b9 == ("X")){
            JOptionPane.showMessageDialog(null, "Player 1 Wins!", "Tic Tac Toe Game!",INFORMATION_MESSAGE);
            xCounter++;
            gameScore();
            square3.setBackground(Color.RED);
            square6.setBackground(Color.YELLOW);
            square9.setBackground(Color.GREEN);
        }else if(b3 == ("X") && b5 == ("X") && b7 == ("X")){
            JOptionPane.showMessageDialog(null, "Player 1 Wins!", "Tic Tac Toe Game!",INFORMATION_MESSAGE);
            xCounter++;
            gameScore();
            square3.setBackground(Color.RED);
            square5.setBackground(Color.YELLOW);
            square7.setBackground(Color.GREEN);
        }
        
        //PLAYER 2
        else if(b1 == ("O") && b2 == ("O") && b3 == ("O")){
            JOptionPane.showMessageDialog(null, "Player 2 Wins!", "Tic Tac Toe Game!",INFORMATION_MESSAGE);
            oCounter++;
            gameScore();
            square1.setBackground(Color.BLUE);
            square2.setBackground(Color.WHITE);
            square3.setBackground(Color.RED);
        }else if(b4 == ("O") && b5 == ("O") && b6 == ("O")){
            JOptionPane.showMessageDialog(null, "Player 2 Wins!", "Tic Tac Toe Game!",INFORMATION_MESSAGE);
            oCounter++;
            gameScore();
            square4.setBackground(Color.BLUE);
            square5.setBackground(Color.WHITE);
            square6.setBackground(Color.RED);
        }else if(b7 == ("O") && b8 == ("O") && b9 == ("O")){
            JOptionPane.showMessageDialog(null, "Player 2 Wins!", "Tic Tac Toe Game!",INFORMATION_MESSAGE);
            oCounter++;
            gameScore();
            square7.setBackground(Color.BLUE);
            square8.setBackground(Color.WHITE);
            square9.setBackground(Color.RED);
        }
        else if(b1 == ("O") && b5 == ("O") && b9 == ("O")){
            JOptionPane.showMessageDialog(null, "Player 2 Wins!", "Tic Tac Toe Game!",INFORMATION_MESSAGE);
            oCounter++;
            gameScore();
            square1.setBackground(Color.BLUE);
            square5.setBackground(Color.WHITE);
            square9.setBackground(Color.RED);
        }
        else if(b1 == ("O") && b4 == ("O") && b7 == ("O")){
            JOptionPane.showMessageDialog(null, "Player 2 Wins!", "Tic Tac Toe Game!",INFORMATION_MESSAGE);
            oCounter++;
            gameScore();
            square1.setBackground(Color.BLUE);
            square4.setBackground(Color.WHITE);
            square7.setBackground(Color.RED);
        }else if(b2 == ("O") && b5 == ("O") && b8 == ("O")){
            JOptionPane.showMessageDialog(null, "Player 2 Wins!", "Tic Tac Toe Game!",INFORMATION_MESSAGE);
            oCounter++;
            gameScore();
            square2.setBackground(Color.BLUE);
            square5.setBackground(Color.WHITE);
            square8.setBackground(Color.RED);
        }else if(b3 == ("O") && b6 == ("O") && b9 == ("O")){
            JOptionPane.showMessageDialog(null, "Player 2 Wins!", "Tic Tac Toe Game!",INFORMATION_MESSAGE);
            oCounter++;
            gameScore();
            square3.setBackground(Color.BLUE);
            square6.setBackground(Color.WHITE);
            square9.setBackground(Color.RED);
        }else if(b3 == ("O") && b5 == ("O") && b7 == ("O")){
            JOptionPane.showMessageDialog(null, "Player 2 Wins!", "Tic Tac Toe Game!",INFORMATION_MESSAGE);
            oCounter++;
            gameScore();
            square3.setBackground(Color.BLUE);
            square5.setBackground(Color.WHITE);
            square7.setBackground(Color.RED);
        }
        
        else if(b1 != "" && b2 != "" && b3 != "" && 
                b4 != "" && b5 != "" && b6 != "" && 
                b7 != "" && b8 != "" && b9 != "" &&
                b1 != "" && b2 != "" && b3 != "" && 
                b4 != "" && b5 != "" && b6 != "" && 
                b7 != "" && b8 != "" && b9 != ""){
            JOptionPane.showMessageDialog(null, "Draw!");
            GameReset();
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        square3 = new javax.swing.JButton();
        square1 = new javax.swing.JButton();
        square2 = new javax.swing.JButton();
        square6 = new javax.swing.JButton();
        square4 = new javax.swing.JButton();
        square5 = new javax.swing.JButton();
        square9 = new javax.swing.JButton();
        square7 = new javax.swing.JButton();
        square8 = new javax.swing.JButton();
        p1 = new javax.swing.JLabel();
        xPoints = new javax.swing.JLabel();
        p2 = new javax.swing.JLabel();
        oPoints = new javax.swing.JLabel();
        exit = new javax.swing.JButton();
        rset = new javax.swing.JButton();
        background = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        square3.setBackground(new java.awt.Color(0, 0, 0));
        square3.setFont(new java.awt.Font("Lucida Fax", 0, 48)); // NOI18N
        square3.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED, new java.awt.Color(0, 255, 255), new java.awt.Color(0, 204, 204)));
        square3.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        square3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                square3ActionPerformed(evt);
            }
        });
        getContentPane().add(square3, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 50, 140, 130));

        square1.setBackground(new java.awt.Color(0, 0, 0));
        square1.setFont(new java.awt.Font("Lucida Fax", 0, 48)); // NOI18N
        square1.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED, new java.awt.Color(0, 255, 255), new java.awt.Color(0, 204, 204)));
        square1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        square1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                square1ActionPerformed(evt);
            }
        });
        getContentPane().add(square1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 50, 140, 130));

        square2.setBackground(new java.awt.Color(0, 0, 0));
        square2.setFont(new java.awt.Font("Lucida Fax", 0, 48)); // NOI18N
        square2.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED, new java.awt.Color(0, 255, 255), new java.awt.Color(0, 204, 204)));
        square2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        square2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                square2ActionPerformed(evt);
            }
        });
        getContentPane().add(square2, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 50, 140, 130));

        square6.setBackground(new java.awt.Color(0, 0, 0));
        square6.setFont(new java.awt.Font("Lucida Fax", 0, 48)); // NOI18N
        square6.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED, new java.awt.Color(0, 255, 255), new java.awt.Color(0, 204, 204)));
        square6.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        square6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                square6ActionPerformed(evt);
            }
        });
        getContentPane().add(square6, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 200, 140, 130));

        square4.setBackground(new java.awt.Color(0, 0, 0));
        square4.setFont(new java.awt.Font("Lucida Fax", 0, 48)); // NOI18N
        square4.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED, new java.awt.Color(0, 255, 255), new java.awt.Color(0, 204, 204)));
        square4.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        square4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                square4ActionPerformed(evt);
            }
        });
        getContentPane().add(square4, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 200, 140, 130));

        square5.setBackground(new java.awt.Color(0, 0, 0));
        square5.setFont(new java.awt.Font("Lucida Fax", 0, 48)); // NOI18N
        square5.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED, new java.awt.Color(0, 255, 255), new java.awt.Color(0, 204, 204)));
        square5.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        square5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                square5ActionPerformed(evt);
            }
        });
        getContentPane().add(square5, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 200, 140, 130));

        square9.setBackground(new java.awt.Color(0, 0, 0));
        square9.setFont(new java.awt.Font("Lucida Fax", 0, 48)); // NOI18N
        square9.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED, new java.awt.Color(0, 255, 255), new java.awt.Color(0, 204, 204)));
        square9.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        square9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                square9ActionPerformed(evt);
            }
        });
        getContentPane().add(square9, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 350, 140, 130));

        square7.setBackground(new java.awt.Color(0, 0, 0));
        square7.setFont(new java.awt.Font("Lucida Fax", 0, 48)); // NOI18N
        square7.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED, new java.awt.Color(0, 255, 255), new java.awt.Color(0, 204, 204)));
        square7.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        square7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                square7ActionPerformed(evt);
            }
        });
        getContentPane().add(square7, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 350, 140, 130));

        square8.setBackground(new java.awt.Color(0, 0, 0));
        square8.setFont(new java.awt.Font("Lucida Fax", 0, 48)); // NOI18N
        square8.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED, new java.awt.Color(0, 255, 255), new java.awt.Color(0, 204, 204)));
        square8.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        square8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                square8ActionPerformed(evt);
            }
        });
        getContentPane().add(square8, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 350, 140, 130));

        p1.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        p1.setForeground(new java.awt.Color(255, 255, 255));
        p1.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        p1.setText("Player 1: ");
        getContentPane().add(p1, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 10, -1, -1));

        xPoints.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        xPoints.setForeground(new java.awt.Color(255, 255, 255));
        xPoints.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        xPoints.setText("0");
        getContentPane().add(xPoints, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 10, -1, -1));

        p2.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        p2.setForeground(new java.awt.Color(255, 255, 255));
        p2.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        p2.setText(":Player 2");
        getContentPane().add(p2, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 10, -1, -1));

        oPoints.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        oPoints.setForeground(new java.awt.Color(255, 255, 255));
        oPoints.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        oPoints.setText("0");
        getContentPane().add(oPoints, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 10, -1, -1));

        exit.setBackground(new java.awt.Color(51, 51, 51));
        exit.setForeground(new java.awt.Color(255, 255, 255));
        exit.setText("EXIT");
        exit.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        exit.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        exit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exitActionPerformed(evt);
            }
        });
        getContentPane().add(exit, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 500, 70, -1));

        rset.setBackground(new java.awt.Color(51, 51, 51));
        rset.setForeground(new java.awt.Color(255, 255, 255));
        rset.setText("RESET");
        rset.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        rset.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        rset.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rsetActionPerformed(evt);
            }
        });
        getContentPane().add(rset, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 500, 70, -1));

        background.setIcon(new javax.swing.ImageIcon("C:\\Users\\ACER\\Downloads\\BINARYCIRC.gif")); // NOI18N
        background.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED, new java.awt.Color(0, 255, 255), new java.awt.Color(0, 255, 255)));
        getContentPane().add(background, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 540, 550));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void square1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_square1ActionPerformed
        square1.setText(startGame);
        if(startGame.equalsIgnoreCase("X")){
            square1.setForeground(Color.WHITE);
        }else{
            square1.setForeground(Color.BLACK);
        }
        Player();
        winningGame();
    }//GEN-LAST:event_square1ActionPerformed

    private void square2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_square2ActionPerformed
        square2.setText(startGame);
        if(startGame.equalsIgnoreCase("X")){
            square2.setForeground(Color.WHITE);
        }else{
            square2.setForeground(Color.BLACK);
        }
        Player();
        winningGame();
    }//GEN-LAST:event_square2ActionPerformed

    private void square3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_square3ActionPerformed
        square3.setText(startGame);
        if(startGame.equalsIgnoreCase("X")){
            square3.setForeground(Color.WHITE);
        }else{
            square3.setForeground(Color.BLACK);
        }
        Player();
        winningGame();
    }//GEN-LAST:event_square3ActionPerformed

    private void square4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_square4ActionPerformed
        square4.setText(startGame);
        if(startGame.equalsIgnoreCase("X")){
            square4.setForeground(Color.WHITE);
        }else{
            square4.setForeground(Color.BLACK);
        }
        Player();
        winningGame();
    }//GEN-LAST:event_square4ActionPerformed

    private void square5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_square5ActionPerformed
        square5.setText(startGame);
        if(startGame.equalsIgnoreCase("X")){
            square5.setForeground(Color.WHITE);
        }else{
            square5.setForeground(Color.BLACK);
        }
        Player();
        winningGame();
    }//GEN-LAST:event_square5ActionPerformed

    private void square6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_square6ActionPerformed
        square6.setText(startGame);
        if(startGame.equalsIgnoreCase("X")){
            square6.setForeground(Color.WHITE);
        }else{
            square6.setForeground(Color.BLACK);
        }
        Player();
        winningGame();
    }//GEN-LAST:event_square6ActionPerformed

    private void square7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_square7ActionPerformed
        square7.setText(startGame);
        if(startGame.equalsIgnoreCase("X")){
            square7.setForeground(Color.WHITE);
        }else{
            square7.setForeground(Color.BLACK);
        }
        Player();
        winningGame();
    }//GEN-LAST:event_square7ActionPerformed

    private void square8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_square8ActionPerformed
        square8.setText(startGame);
        if(startGame.equalsIgnoreCase("X")){
            square8.setForeground(Color.WHITE);
        }else{
            square8.setForeground(Color.BLACK);
        }
        Player();
        winningGame();
    }//GEN-LAST:event_square8ActionPerformed

    private void square9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_square9ActionPerformed
        square9.setText(startGame);
        if(startGame.equalsIgnoreCase("X")){
            square9.setForeground(Color.WHITE);
        }else{
            square9.setForeground(Color.BLACK);
        }
        Player();
        winningGame();
    }//GEN-LAST:event_square9ActionPerformed

    private void rsetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rsetActionPerformed
        GameReset();
    }//GEN-LAST:event_rsetActionPerformed
private JFrame frame;
    private void exitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exitActionPerformed
        frame = new JFrame("EXIT!");
        if(JOptionPane.showConfirmDialog(frame,"Are You Sure You Want To Exit?","Tic Tac Toe Game",JOptionPane.YES_NO_OPTION)
                == JOptionPane.YES_NO_OPTION){
            JOptionPane.showMessageDialog(null, "Navigating to Game Selection!");
            GameSelection gs = new GameSelection();
            gs.setVisible(true);
            dispose();
        }
        
    }//GEN-LAST:event_exitActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(TicTacToe.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TicTacToe.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TicTacToe.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TicTacToe.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TicTacToe().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel background;
    private javax.swing.JButton exit;
    private javax.swing.JLabel oPoints;
    private javax.swing.JLabel p1;
    private javax.swing.JLabel p2;
    private javax.swing.JButton rset;
    private javax.swing.JButton square1;
    private javax.swing.JButton square2;
    private javax.swing.JButton square3;
    private javax.swing.JButton square4;
    private javax.swing.JButton square5;
    private javax.swing.JButton square6;
    private javax.swing.JButton square7;
    private javax.swing.JButton square8;
    private javax.swing.JButton square9;
    private javax.swing.JLabel xPoints;
    // End of variables declaration//GEN-END:variables
}
