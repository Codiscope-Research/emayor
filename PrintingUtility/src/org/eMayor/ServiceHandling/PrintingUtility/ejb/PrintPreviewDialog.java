package org.eMayor.ServiceHandling.PrintingUtility.ejb;

/*
 * PrintPreviewDialog.java
 *
 * Created on 2 ������� 2005, 12:45 ��
 */

import java.awt.Dimension;
import java.awt.Insets;
import java.awt.Point;
import java.awt.event.ActionListener;
import javax.swing.JEditorPane;
import javax.swing.JScrollPane;

/**
 * Creates a Print Preview window allowing the user to accept or cancel the printing
 *
 * @author  imavr
 */

public class PrintPreviewDialog extends javax.swing.JFrame implements ActionListener {
    public JEditorPane jep;
    public int x;
    public int y;
    boolean printConfirmed = false;
    
    /** Creates new form PrintPreviewDialog <br/>
     *  The PrintPreviewDialog allows printing to be cancelled either by clicking on the "Cancel" button or by closing the "Print Preview" window <br/>
     *  For printing to be carried out normally, the user must click on the "Print" button. <br/>
     *  The PrintPreviewDialog's size is restricted by the screen resolution so that the contents of the displayed JEditorPane do not extend beyond the screen's borders. <br/>
     *  If the JEditorPane is larger than the screen in any axis, then a scrollbar allows for full preview of its contents
     *  @param jEP The JEditorPane to be previewed
     *  @param w The width of the PrintPreviewDialog (usually set as the JEditorPane's "getPreferredSize().width")
     *  @param h The height of the PrintPreviewDialog (usually set as the JEditorPane's "getPreferredSize().height")
     */
    public PrintPreviewDialog(JEditorPane jEP, int w, int h) {
        jep = jEP;
        x = w;
        y = h;
        initComponents();
    }
    
    /** Displays this PrintPreviewDialog
     */    
    public void show() {
        printPreviewDialog.setLocationRelativeTo(null);
        int screenX = java.awt.Toolkit.getDefaultToolkit().getScreenSize().width;
        int screenY = java.awt.Toolkit.getDefaultToolkit().getScreenSize().height;
        if (x<screenX) screenX = x;
        if (y<screenY) screenY = y;
        printPreviewDialog.setSize(new Dimension(screenX, screenY));
        Point p = printPreviewDialog.getLocation();
        printPreviewDialog.setLocation(p.x-screenX/2, p.y-screenY/2);
        printPreviewDialog.setVisible(true);
    }
    
    /** Displays a PrintPreviewDialog
     * @param previewDialog the PrintPreviewDialog to display
     */    
    public void show(PrintPreviewDialog previewDialog) {
        previewDialog.setLocationRelativeTo(null);
        int screenX = java.awt.Toolkit.getDefaultToolkit().getScreenSize().width;
        int screenY = java.awt.Toolkit.getDefaultToolkit().getScreenSize().height;
        if (x<screenX) screenX = x;
        if (y<screenY) screenY = y;
        previewDialog.setSize(new Dimension(screenX, screenY));
        Point p = previewDialog.getLocation();
        previewDialog.setLocation(p.x-screenX/2, p.y-screenY/2);
        previewDialog.setVisible(true);
    }
    
    
    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    private void initComponents() {//GEN-BEGIN:initComponents
        ownerFrame = new javax.swing.JFrame();
        printPreviewDialog = new javax.swing.JDialog();
        printPreviewPanel = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jEditorPane1 = jep;
        buttonsPanel = new javax.swing.JPanel();
        printButton = new javax.swing.JButton();
        cancelButton = new javax.swing.JButton();

        ownerFrame.getContentPane().setLayout(null);

        printPreviewDialog.getContentPane().setLayout(new javax.swing.BoxLayout(printPreviewDialog.getContentPane(), javax.swing.BoxLayout.Y_AXIS));

        printPreviewDialog.setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        printPreviewDialog.setTitle("Print Preview");
        printPreviewDialog.setModal(true);
        printPreviewDialog.getAccessibleContext().setAccessibleParent(ownerFrame);
        printPreviewPanel.setLayout(new java.awt.BorderLayout());

        jScrollPane1.setPreferredSize(new Dimension(x, y));
        jScrollPane1.setViewportView(jEditorPane1);

        printPreviewPanel.add(jScrollPane1, java.awt.BorderLayout.CENTER);

        printPreviewDialog.getContentPane().add(printPreviewPanel);

        buttonsPanel.setLayout(new java.awt.GridLayout(1, 0));

        printButton.setText("Print");
        printButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                printButtonActionPerformed(evt);
            }
        });

        buttonsPanel.add(printButton);

        cancelButton.setText("Cancel");
        cancelButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelButtonActionPerformed(evt);
            }
        });

        buttonsPanel.add(cancelButton);

        printPreviewDialog.getContentPane().add(buttonsPanel);

        getContentPane().setLayout(null);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Print Preview");
        setLocationByPlatform(true);
        setResizable(false);
        pack();
    }//GEN-END:initComponents
    /** Cancels printing
     *  @param evt An java.awt.event.ActionEvent
     */    
    private void cancelButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelButtonActionPerformed
        // TODO add your handling code here:
        actionPerformed(evt);
        printConfirmed = false;
    }//GEN-LAST:event_cancelButtonActionPerformed
    /** Confirms printing
     *  @param evt An java.awt.event.ActionEvent
     */        
    private void printButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_printButtonActionPerformed
        // TODO add your handling code here:
        actionPerformed(evt);
        printConfirmed = true;
    }//GEN-LAST:event_printButtonActionPerformed
    
    
    /** Gets the result of the PringPreviewDialog (true for printing or false for cancelling)
     * @return true for printing or false for cancelling
     */    
    public boolean isPrintConfirmed() {
        return printConfirmed;
    }
    
    /** Gets the PringPreviewDialog object
     * @return this PrintPreviewDialog object
     */    
    public PrintPreviewDialog getPrintPreviewDialog() {
        return this;
    }
    
    /** Closes the PringPreviewDialog (DefaultCloseOperation is set to: javax.swing.WindowConstants.EXIT_ON_CLOSE)
     * @param e An java.awt.event.ActionEvent
     */    
    public void actionPerformed(java.awt.event.ActionEvent e) {
        printPreviewDialog.setVisible(false) ;
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel buttonsPanel;
    private javax.swing.JButton cancelButton;
    private javax.swing.JEditorPane jEditorPane1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JFrame ownerFrame;
    private javax.swing.JButton printButton;
    private javax.swing.JDialog printPreviewDialog;
    private javax.swing.JPanel printPreviewPanel;
    // End of variables declaration//GEN-END:variables
    
}