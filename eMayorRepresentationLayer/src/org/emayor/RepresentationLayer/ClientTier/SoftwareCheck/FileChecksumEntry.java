package org.emayor.RepresentationLayer.ClientTier.SoftwareCheck;


/**
 *  A simple readonly container, which holds a filepath and the
 *  MD5 checksum of the file with that filepath.
 */


public class FileChecksumEntry
{
  private String filePath;
  private String md5Checksum;

  public FileChecksumEntry( final String _filePath,
                            final String _md5Checksum )
  {
    this.filePath = _filePath;
    this.md5Checksum = _md5Checksum;
  }

  public String getFilePath()
  {
    return this.filePath;
  }
  
  
  public String getMd5Checksum()
  {
    return this.md5Checksum;
  }

}
