//==============================================================================
// Copyright (C) 2005 Advanced Encryption Technology Europe B.V.
// Copyright (C) 2005 eMayor Consortium (http://www.emayor.org)
// All rights are reserved. Reproduction in whole or in part is prohibited
// without the written consent of the copyright owner.
//
// Package: org.emayor.xmlsigner
// Class:   Signer
// Version: $Id: Signer.java,v 1.1 2005/11/16 10:51:00 emayor Exp $
// Product: Java XML signing applet
//
// Description:
//		Signer interface (signs using the PKCS #1 with a SHA-1 hash)
//==============================================================================

package org.emayor.client.controlers.xmlsigner;

public interface Signer 
{
    public byte[] sign(Signable signable);
    
    public byte[] digest(Signable signable);
    
    public byte[] getSigningCertificate();
    
    public byte[] getSigningKeyModulus();
    
    public byte[] getSigningKeyExponent();
}
