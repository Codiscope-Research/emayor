package org.emayor.RepresentationLayer.ClientTier.Controlers;


/**
 *  Another action controler for buttons.
 *  It prints the eMayorForm xml model to an available printer,
 *  presenting a printer dialog for the user.
 */

import java.awt.event.*;

import org.emayor.RepresentationLayer.ClientTier.EMayorFormsClientApplet;


public class PrintFormToPrinterSubmitter implements ActionListener
{

  private EMayorFormsClientApplet mainApplet;
  private String buttonParameter = null;

  
  public PrintFormToPrinterSubmitter( final EMayorFormsClientApplet _mainApplet,
                                      final String _buttonParameter )
  {
    this.mainApplet = _mainApplet;
    this.buttonParameter = _buttonParameter;
    // Note: The modelNode and the contained tree will be changed
    //       as long as the user is entering or modifying data.
    //       Therefore do not do anything here. Any action only
    //       start in the actionPerformed() method.
  } // Constructor

  
  
  /**
   *  The only method from the ActionListener interface.
   *  It is called as soon as a user clicks a button,
   *  which this object is listening to.
   */
   public void actionPerformed(ActionEvent e)
   {
    this.mainApplet.print_EMayorForm_InteractionPanel();
   } // actionPerformed





} // PrintModelToDiskSubmitter




