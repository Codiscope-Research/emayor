package org.emayor.webtier.struts.FormTest;

import java.io.*;
import java.nio.charset.Charset;
import java.util.*;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import org.emayor.client.parser.XMLParser;
import org.emayor.client.parser.xml.*;
import org.emayor.webtier.shared.Utilities;


/** 
 *   A singleton object of this class picks up
 *   all xml e-documents and eMayorForms in
 *   the formtest directory and stores them
 *   so that they are available for the
 *   Struts FormTestForm.
 *
 */


public class FormTestRepository
{
  
   //According to rules: The directory (in jboss/conf/MunicipalityInformation is "formtest".
   // It must have the prefix "Name." and works like a "municipality" in the webtier:
   public static final String MunicipalityNameKey = "Name.FormTest";


   // appletProperties, eDocuments and eMayorForm templates are hold here
   // as properties:
   private Properties appletProperties;
   private Properties eMayorFormTemplates;
   private Properties eDocuments;
   private Properties eDocumentFileNames;
   
   private static FormTestRepository Instance = null;

   // Use UTF-8 for file read operations
   private static final Charset charset = Charset.forName("UTF-8");
   
   
   private FormTestRepository()
   {
    System.out.println("-------------- FormTestRepository.constructor: Reading files...");
    // Collect the formtest directory pathname:
    try 
    {
      // MunicipalityNameKey has the form Name.theName -> wee need theName,
      // which in this case is FormTest:
      StringTokenizer tok = new StringTokenizer(MunicipalityNameKey,".");  
      tok.nextToken();
      String directoryName = tok.nextToken();
       
      StringBuffer formTestDirPath = new StringBuffer();  
      formTestDirPath.append( System.getProperty("jboss.server.home.dir") );
      formTestDirPath.append( File.separator );
      formTestDirPath.append( "conf" );
      formTestDirPath.append( File.separator );
      formTestDirPath.append( "MunicipalityInformation" );
      formTestDirPath.append( File.separator );
      formTestDirPath.append( directoryName );
      formTestDirPath.append( File.separator );
      File formTestDirectory = new File( formTestDirPath.toString() );
      System.out.println("FormTest cirectory is: " + formTestDirectory.getPath() );
      if( formTestDirectory.exists() )
      {
        this.collectFiles( formTestDirectory );
      }
      else
      {
        String msg = "The FormTest folder is missing in the JBoss conf directory.";
        String title = "The WebTier configuration is not complete";
        this.errorFeedBack(msg,title);
        System.out.println( "***Error: " + msg );
      }
    }
    catch( Exception e )
    {
      e.printStackTrace();
    }            
   } // private constructor
   
   
      
   public Properties getEDocumentFileNames(){ return this.eDocumentFileNames; }
   public Properties getAppletProperties(){ return this.appletProperties; }
   public Properties getEMayorFormTemplates(){ return this.eMayorFormTemplates; }
   public Properties getEDocuments(){ return this.eDocuments; }
  

   
   private void collectFiles( File formTestDirectory )
   {
     // list its files:
     File[] formTestFiles = formTestDirectory.listFiles();
     System.out.println("-------------- Number of elements in " + formTestDirectory.getPath() +
                        " = " + formTestFiles.length );
     // Three directories must exist:
     // AppletProperties
     // eDocuments
     // eMayorFormTemplates
     // check and load:
     boolean does_AppletProperties_exist = false;
     boolean does_eDocuments_exist = false;
     boolean does_eMayorFormTemplates_exist = false;     
     File directory;
     for( int i=0; i < formTestFiles.length; i++ )
     { 
       directory = formTestFiles[i];
       if( directory.exists() && directory.isDirectory() )
       {
         if( directory.getName().equals("AppletProperties") )
         {
           this.collectAppletProperties( directory );
           does_AppletProperties_exist = true;
         }
         else
         if( directory.getName().equals("eDocuments") )
         {
            this.collect_eDocuments( directory );
            does_eDocuments_exist = true;
         }
         else
         if( directory.getName().equals("eMayorFormTemplates") )
         {
            this.collecteMayorFormTemplates( directory );
            does_eMayorFormTemplates_exist = true;
         }       
       } // if
     } // for
     StringBuffer errorMessage = new StringBuffer("");
     if( !does_AppletProperties_exist    ) errorMessage.append("  AppletProperties");
     if( !does_eDocuments_exist          ) errorMessage.append("  eDocuments");
     if( !does_eMayorFormTemplates_exist ) errorMessage.append("  eMayorFormTemplates");
     if( errorMessage.length() > 0 )
     {
       errorMessage.insert(0,"The following required directories do not exist: ");
       System.out.println("*** ");
       System.out.println("*** Uncomplete FormTest directory");
       System.out.println("*** " + errorMessage.toString() );
       this.errorFeedBack(errorMessage.toString(),"Uncomplete FormTest directory.");
     }     
   } // collectFiles


   
   
   
   
   private void collectAppletProperties( File appletPropertiesDirectory )
   {
     this.appletProperties = this.readAvailableAppletPropertyFiles( appletPropertiesDirectory );
     if( this.appletProperties != null )
     {
       System.out.println("FormTestRepository: Loaded applet properties files.");
     }
     else
     {
       String title = "Uncomplete FormTest directory.";
       String message = "The AppletProperties does not contain the required language properties.";
       System.out.println("*** ");
       System.out.println("*** " + title   );
       System.out.println("*** " + message );
       System.out.println("*** ");
       this.errorFeedBack(message,title);
     }
   } // collectAppletProperties
   
   

   
   private void collecteMayorFormTemplates( File eMayorFormTemplatesDirectory )
   {
     this.eMayorFormTemplates = this.readAvailableEMayorFormTemplateFiles( eMayorFormTemplatesDirectory );
     if( this.eMayorFormTemplates != null )
     {
       System.out.println("FormTestRepository: Loaded eMayorForm template files.");
     }
     else
     {
       String title = "Uncomplete FormTest directory.";
       String message = "The directory eMayorFormTemplates does not contain eMayorForm template files.";
       System.out.println("*** ");
       System.out.println("*** " + title   );
       System.out.println("*** " + message );
       System.out.println("*** ");
       this.errorFeedBack(message,title);
     }
   } // collecteMayorFormTemplates
   
   
   
   

   
   
   
   
   private void collect_eDocuments( File eDocumentsDirectory )
   {
     this.eDocuments = this.readAvailable_eDocumentFiles( eDocumentsDirectory );
     if( this.eDocuments != null )
     {
       System.out.println("FormTestRepository: Loaded eDocument files.");
     }
     else
     {
       String title = "Uncomplete FormTest directory.";
       String message = "The directory eDocuments does not contain the eMayorForm template files.";
       System.out.println("*** ");
       System.out.println("*** " + title   );
       System.out.println("*** " + message );
       System.out.println("*** ");
       this.errorFeedBack(message,title);
     }
   } // collecteDocuments
   
   
   

   
   
   
   
  /**
   *  Returns the e-document associated with the passed
   *  eMayorForm template name.
   *  templateName comes without the ending .eMayorForm
   */ 
   public String getEDocumentForTemplate( String templateName )
   {
     if( templateName == null )
     {
        System.out.println("*** ");
        System.out.println("*** FormTestRepository.getEDocumentForTemplate(t)");
        System.out.println("*** with t = null called");
        System.out.println("*** ");     
     }
     if( this.eDocuments == null )
     {
        System.out.println("*** ");
        System.out.println("*** FormTestRepository.getEDocumentForTemplate(t)");
        System.out.println("*** but this.eDocuments is null.");
        System.out.println("*** ");     
     }
     String edoc = null;
     try
     {
       edoc = this.eDocuments.get(templateName).toString();
     }
     catch( Exception e )
     {
       // We have enough messages in this method telling more detailed
       // reasons for (nullpointer) or whatever happened here, so the
       // message is enough:
       System.out.println("*** exception message= " + e.getMessage() );
     }
     if( edoc == null ) // say why it didnt work
     {
        System.out.println("*** ");
        System.out.println("*** ");
        System.out.println("*** FormTestRepository.getEDocumentForTemplate(t) for template t= ");
        System.out.println("*** " + templateName );
        System.out.println("*** returns null.");
        System.out.println("*** ");
        System.out.println("*** Valid templateNames would have been:");
        Enumeration keys = this.eDocuments.keys();
        while( keys.hasMoreElements() )
        {
          System.out.println("*** >" + keys.nextElement().toString());
        }
        System.out.println("*** ");
        System.out.println("*** ");
        System.out.println("*** ");     
     }
     return edoc;
   }
   

   
   
   
   
   
  /**
   *  This method works like the method of MunicipalitiesManager with
   *  the same name, but it works on the "virtual" formtest municipality.
   */ 
   public String getAppletPropertyFileForLanguage( String language )
   {
     String propertyFile = this.appletProperties.getProperty(language);
     if( propertyFile == null ) // try english:
     {
       propertyFile = this.appletProperties.getProperty("en");
     }
     if( propertyFile == null )
     {
       System.out.println("*** ");
       System.out.println("*** FormTestRepository.getAppletPropertyFileForLanguage():");
       System.out.println("*** Failed to return a propertyfile for the calling eMayorForms applet.");
       System.out.println("*** ");
     }
     return propertyFile;
   } // getAppletPropertyFileForLanguage
 
   
   
   
   
   
   
   private void errorFeedBack( String message, String title )
   {    
     JFrame errorFrame = new JFrame();
     errorFrame.setSize(600,300);
     errorFrame.setLocation(200,140);
     errorFrame.setTitle("eMayor Developer Feedback");
     errorFrame.setVisible(true);
     errorFrame.toFront();
     JOptionPane.showMessageDialog(errorFrame,message,title,JOptionPane.ERROR_MESSAGE );
     errorFrame.setVisible(false);
     errorFrame.dispose();
   }

      
   
      

   
   
   /**
    *   Read the eDocument files.
    */ 
    private Properties readAvailable_eDocumentFiles( final File eDocumentsDirectory )
    {
      Properties eDocProperties = new Properties();
      
      // eDocumentFileNames is set below, so instanciate here (...)
      this.eDocumentFileNames = new Properties();
      
      // Collect them:
      File[] files = eDocumentsDirectory.listFiles();
      XMLParser xmlParser = new XMLParser();
      for( int i=0; i < files.length; i++ )
      {
        String fileName = files[i].getName();
        if( ( files[i].isFile() ) && 
            ( fileName.endsWith(".xml") )     )
        {
          String fileContent = this.readUTF8TextFileAsString( files[i] );
          // remove the ending .eMayorForm for the property key:
          String templateName = fileName.substring(0,fileName.length()- 11);
          // Create the associated tree structure and use the e-document tag name as
          // key for the returned properties object:
          try
          {
            XML_Node rootNode = xmlParser.transformDocumentToTree( new StringBuffer(fileContent) );
            String rootTagName = rootNode.getTagName(); // This is the "RootNode" node
            String eDocTagName = rootNode.getChildAt(0).getTagName(); // The e-document name

            // Note: The associated template names have been restricted to
            //       contain only characters allowed for filesystems, so
            //       make the same restrictions for the key too:
            String eDocTagNameForFileSystem = Utilities.MakeNameValidForFileSystem(eDocTagName);

            eDocProperties.put(eDocTagNameForFileSystem,fileContent);
            // and add the associated filename to the eDocumentFileNames with the
            // eDocTagName as key:
            eDocumentFileNames.put(eDocTagNameForFileSystem,files[i].getName());
            
            System.out.println(">> ");
            System.out.println(">> FormTestRepository.readAvailable_eDocumentFiles");
            System.out.println(">> added entry with edocument key " + eDocTagNameForFileSystem );
            System.out.println(">> to eDocuments and eDocumentFileNames");
            System.out.println(">> ");
            
          }
          catch( Exception e )
          {
            System.out.println("*** ");
            System.out.println("*** FormTestRepository.readAvailable_eDocumentFiles():");
            System.out.println("*** Exception while creating xml treestructure for e-Document");
            System.out.println("*** with file name= " + fileName );
            System.out.println("*** This file was skipped.");
            System.out.println("*** ");
            e.printStackTrace();
          }
        }  
      } // for  
      return eDocProperties;
    } // readAvailableAppletPropertyFiles
   
   
   
   
   
   
   
  /**
   *   Read the eMayorForm template files.
   */ 
   private Properties readAvailableEMayorFormTemplateFiles( final File eMayorFormTemplatesDirectory )
   {
     Properties templateProperties = new Properties();
     // Collect them:
     File[] files = eMayorFormTemplatesDirectory.listFiles();
     for( int i=0; i < files.length; i++ )
     {
       String fileName = files[i].getName();
       if( ( files[i].isFile() ) && 
           ( fileName.endsWith(".eMayorForm") )     )
       {
         String fileContent = this.readUTF8TextFileAsString( files[i] );     
         // remove the ending .eMayorForm for the property key:
         String templateName = fileName.substring(0,fileName.length()- 11);
         System.out.println("readAvailableEMayorFormTemplateFiles: template file read with name: " + templateName );
         templateProperties.put(templateName,fileContent);      
       }  
     } // for  
     return templateProperties;
   } // readAvailableAppletPropertyFiles



   
   
   
   
   
   /** 
    * Finally load all property files required for the eMayorForms applets:
    * They are located in the AppletProperties subdirectory and have the form
    * eMayorForms_xx.properties where xx = en,ger,it,sp denotes the language.
    * properties structure is <key>   == language
    *                         <value> == the file as string
    */
    private Properties readAvailableAppletPropertyFiles( final File appletPropertiesDirectory )
    {
      Properties appProperties = new Properties();
      // Collect them:
      File[] files = appletPropertiesDirectory.listFiles();
      for( int i=0; i < files.length; i++ )
      {
        String fileName = files[i].getName();
        if( ( files[i].isFile() ) && 
              ( fileName.startsWith("eMayorForms_") ) && 
              ( fileName.endsWith(".properties") )     )
        {
          String fileContent = this.readUTF8TextFileAsString( files[i] );     
          // filter out the language identifier:
          int lastPointIndex = fileName.lastIndexOf(".");
          String languageID = fileName.substring(12,lastPointIndex);
          System.out.println("readAvailableAppletPropertyFiles: applet property file read for language: " + languageID );
          appProperties.put(languageID,fileContent);      
        }  
      } // for  
      return appProperties;
    } // readAvailableAppletPropertyFiles
   
   
 
    
    
    private String readUTF8TextFileAsString( final File file )
    {    
      String fileString = null;
      try
      {
        FileInputStream fin = new FileInputStream(file);
        ByteArrayOutputStream bOut = Utilities.ReadByteFileFromInputStream(fin);
        fileString = bOut.toString("UTF-8");
        bOut = null;
      }
      catch( Exception e )
      {
        e.printStackTrace();
      }
      return fileString;    
    } // readUTF8TextFileAsString
    
    
    
    
    
   
  /**
   *  Singleton GetInstance() method.
   *  Returns the static instance for this class,
   *  which it creates before, if it was not created yet.
   */
    public static FormTestRepository GetInstance()
    {
      return GetInstance(false);
    }
    public static FormTestRepository GetInstance( boolean forceNewInstance )
    {
     if( ( Instance == null ) || (forceNewInstance) )
     {
       Instance = new FormTestRepository();     
     }
     return Instance;
   } // GetInstance



} // FormTestRepository




