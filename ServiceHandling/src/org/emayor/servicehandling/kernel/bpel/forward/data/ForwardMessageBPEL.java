/**
 * ForwardMessageBPEL.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis WSDL2Java emitter.
 */

package org.emayor.servicehandling.kernel.bpel.forward.data;

public class ForwardMessageBPEL  implements java.io.Serializable {
    private static String THIS_NAMESPACE = "http://eMayor.org/sh/bpel/forward/data";
    
    private java.lang.String document;
    private java.lang.String document1;
    private java.lang.String document2;
    private java.lang.String document3;
    private java.lang.String document4;
    private java.lang.String ssid;
    private java.lang.String uid;

    public ForwardMessageBPEL() {
    }

    public java.lang.String getDocument() {
        return document;
    }

    public void setDocument(java.lang.String document) {
        this.document = document;
    }

    public java.lang.String getDocument1() {
        return document1;
    }

    public void setDocument1(java.lang.String document1) {
        this.document1 = document1;
    }

    public java.lang.String getDocument2() {
        return document2;
    }

    public void setDocument2(java.lang.String document2) {
        this.document2 = document2;
    }

    public java.lang.String getDocument3() {
        return document3;
    }

    public void setDocument3(java.lang.String document3) {
        this.document3 = document3;
    }

    public java.lang.String getDocument4() {
        return document4;
    }

    public void setDocument4(java.lang.String document4) {
        this.document4 = document4;
    }

    public java.lang.String getSsid() {
        return ssid;
    }

    public void setSsid(java.lang.String ssid) {
        this.ssid = ssid;
    }

    public java.lang.String getUid() {
        return uid;
    }

    public void setUid(java.lang.String uid) {
        this.uid = uid;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof ForwardMessageBPEL)) return false;
        ForwardMessageBPEL other = (ForwardMessageBPEL) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.document==null && other.getDocument()==null) || 
             (this.document!=null &&
              this.document.equals(other.getDocument()))) &&
            ((this.document1==null && other.getDocument1()==null) || 
             (this.document1!=null &&
              this.document1.equals(other.getDocument1()))) &&
            ((this.document2==null && other.getDocument2()==null) || 
             (this.document2!=null &&
              this.document2.equals(other.getDocument2()))) &&
            ((this.document3==null && other.getDocument3()==null) || 
             (this.document3!=null &&
              this.document3.equals(other.getDocument3()))) &&
            ((this.document4==null && other.getDocument4()==null) || 
             (this.document4!=null &&
              this.document4.equals(other.getDocument4()))) &&
            ((this.ssid==null && other.getSsid()==null) || 
             (this.ssid!=null &&
              this.ssid.equals(other.getSsid()))) &&
            ((this.uid==null && other.getUid()==null) || 
             (this.uid!=null &&
              this.uid.equals(other.getUid())));
        __equalsCalc = null;
        return _equals;
    }

    private boolean __hashCodeCalc = false;
    public synchronized int hashCode() {
        if (__hashCodeCalc) {
            return 0;
        }
        __hashCodeCalc = true;
        int _hashCode = 1;
        if (getDocument() != null) {
            _hashCode += getDocument().hashCode();
        }
        if (getDocument1() != null) {
            _hashCode += getDocument1().hashCode();
        }
        if (getDocument2() != null) {
            _hashCode += getDocument2().hashCode();
        }
        if (getDocument3() != null) {
            _hashCode += getDocument3().hashCode();
        }
        if (getDocument4() != null) {
            _hashCode += getDocument4().hashCode();
        }
        if (getSsid() != null) {
            _hashCode += getSsid().hashCode();
        }
        if (getUid() != null) {
            _hashCode += getUid().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(ForwardMessageBPEL.class);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://eMayor.org/sh/bpel/forward/data", "ForwardMessageBPEL"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("document");
        elemField.setXmlName(new javax.xml.namespace.QName(THIS_NAMESPACE, "document"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("document1");
        elemField.setXmlName(new javax.xml.namespace.QName(THIS_NAMESPACE, "document1"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("document2");
        elemField.setXmlName(new javax.xml.namespace.QName(THIS_NAMESPACE, "document2"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("document3");
        elemField.setXmlName(new javax.xml.namespace.QName(THIS_NAMESPACE, "document3"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("document4");
        elemField.setXmlName(new javax.xml.namespace.QName(THIS_NAMESPACE, "document4"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ssid");
        elemField.setXmlName(new javax.xml.namespace.QName(THIS_NAMESPACE, "ssid"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("uid");
        elemField.setXmlName(new javax.xml.namespace.QName(THIS_NAMESPACE, "uid"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        typeDesc.addFieldDesc(elemField);
    }

    /**
     * Return type metadata object
     */
    public static org.apache.axis.description.TypeDesc getTypeDesc() {
        return typeDesc;
    }

    /**
     * Get Custom Serializer
     */
    public static org.apache.axis.encoding.Serializer getSerializer(
           java.lang.String mechType, 
           java.lang.Class _javaType,  
           javax.xml.namespace.QName _xmlType) {
        return 
          new  org.apache.axis.encoding.ser.BeanSerializer(
            _javaType, _xmlType, typeDesc);
    }

    /**
     * Get Custom Deserializer
     */
    public static org.apache.axis.encoding.Deserializer getDeserializer(
           java.lang.String mechType, 
           java.lang.Class _javaType,  
           javax.xml.namespace.QName _xmlType) {
        return 
          new  org.apache.axis.encoding.ser.BeanDeserializer(
            _javaType, _xmlType, typeDesc);
    }

}
