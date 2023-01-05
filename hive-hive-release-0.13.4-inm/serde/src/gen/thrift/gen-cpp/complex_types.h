/**
 * Autogenerated by Thrift Compiler (0.9.0)
 *
 * DO NOT EDIT UNLESS YOU ARE SURE THAT YOU KNOW WHAT YOU ARE DOING
 *  @generated
 */
#ifndef complex_TYPES_H
#define complex_TYPES_H

#include <thrift/Thrift.h>
#include <thrift/TApplicationException.h>
#include <thrift/protocol/TProtocol.h>
#include <thrift/transport/TTransport.h>





typedef struct _PropValueUnion__isset {
  _PropValueUnion__isset() : intValue(false), longValue(false), stringValue(false), doubleValue(false), flag(false), lString(false), unionMStringString(false) {}
  bool intValue;
  bool longValue;
  bool stringValue;
  bool doubleValue;
  bool flag;
  bool lString;
  bool unionMStringString;
} _PropValueUnion__isset;

class PropValueUnion {
 public:

  static const char* ascii_fingerprint; // = "123CD9D82D5B5054B5054EFD63FC8590";
  static const uint8_t binary_fingerprint[16]; // = {0x12,0x3C,0xD9,0xD8,0x2D,0x5B,0x50,0x54,0xB5,0x05,0x4E,0xFD,0x63,0xFC,0x85,0x90};

  PropValueUnion() : intValue(0), longValue(0), stringValue(), doubleValue(0), flag(0) {
  }

  virtual ~PropValueUnion() throw() {}

  int32_t intValue;
  int64_t longValue;
  std::string stringValue;
  double doubleValue;
  bool flag;
  std::vector<std::string>  lString;
  std::map<std::string, std::string>  unionMStringString;

  _PropValueUnion__isset __isset;

  void __set_intValue(const int32_t val) {
    intValue = val;
    __isset.intValue = true;
  }

  void __set_longValue(const int64_t val) {
    longValue = val;
    __isset.longValue = true;
  }

  void __set_stringValue(const std::string& val) {
    stringValue = val;
    __isset.stringValue = true;
  }

  void __set_doubleValue(const double val) {
    doubleValue = val;
    __isset.doubleValue = true;
  }

  void __set_flag(const bool val) {
    flag = val;
    __isset.flag = true;
  }

  void __set_lString(const std::vector<std::string> & val) {
    lString = val;
  }

  void __set_unionMStringString(const std::map<std::string, std::string> & val) {
    unionMStringString = val;
  }

  bool operator == (const PropValueUnion & rhs) const
  {
    if (__isset.intValue != rhs.__isset.intValue)
      return false;
    else if (__isset.intValue && !(intValue == rhs.intValue))
      return false;
    if (__isset.longValue != rhs.__isset.longValue)
      return false;
    else if (__isset.longValue && !(longValue == rhs.longValue))
      return false;
    if (__isset.stringValue != rhs.__isset.stringValue)
      return false;
    else if (__isset.stringValue && !(stringValue == rhs.stringValue))
      return false;
    if (__isset.doubleValue != rhs.__isset.doubleValue)
      return false;
    else if (__isset.doubleValue && !(doubleValue == rhs.doubleValue))
      return false;
    if (__isset.flag != rhs.__isset.flag)
      return false;
    else if (__isset.flag && !(flag == rhs.flag))
      return false;
    if (!(lString == rhs.lString))
      return false;
    if (!(unionMStringString == rhs.unionMStringString))
      return false;
    return true;
  }
  bool operator != (const PropValueUnion &rhs) const {
    return !(*this == rhs);
  }

  bool operator < (const PropValueUnion & ) const;

  uint32_t read(::apache::thrift::protocol::TProtocol* iprot);
  uint32_t write(::apache::thrift::protocol::TProtocol* oprot) const;

};

void swap(PropValueUnion &a, PropValueUnion &b);

typedef struct _IntString__isset {
  _IntString__isset() : myint(false), myString(false), underscore_int(false) {}
  bool myint;
  bool myString;
  bool underscore_int;
} _IntString__isset;

class IntString {
 public:

  static const char* ascii_fingerprint; // = "52C6DAB6CF51AF617111F6D3964C6503";
  static const uint8_t binary_fingerprint[16]; // = {0x52,0xC6,0xDA,0xB6,0xCF,0x51,0xAF,0x61,0x71,0x11,0xF6,0xD3,0x96,0x4C,0x65,0x03};

  IntString() : myint(0), myString(), underscore_int(0) {
  }

  virtual ~IntString() throw() {}

  int32_t myint;
  std::string myString;
  int32_t underscore_int;

  _IntString__isset __isset;

  void __set_myint(const int32_t val) {
    myint = val;
  }

  void __set_myString(const std::string& val) {
    myString = val;
  }

  void __set_underscore_int(const int32_t val) {
    underscore_int = val;
  }

  bool operator == (const IntString & rhs) const
  {
    if (!(myint == rhs.myint))
      return false;
    if (!(myString == rhs.myString))
      return false;
    if (!(underscore_int == rhs.underscore_int))
      return false;
    return true;
  }
  bool operator != (const IntString &rhs) const {
    return !(*this == rhs);
  }

  bool operator < (const IntString & ) const;

  uint32_t read(::apache::thrift::protocol::TProtocol* iprot);
  uint32_t write(::apache::thrift::protocol::TProtocol* oprot) const;

};

void swap(IntString &a, IntString &b);

typedef struct _Complex__isset {
  _Complex__isset() : aint(false), aString(false), lint(false), lString(false), lintString(false), mStringString(false), attributes(false), unionField1(false), unionField2(false), unionField3(false) {}
  bool aint;
  bool aString;
  bool lint;
  bool lString;
  bool lintString;
  bool mStringString;
  bool attributes;
  bool unionField1;
  bool unionField2;
  bool unionField3;
} _Complex__isset;

class Complex {
 public:

  static const char* ascii_fingerprint; // = "FFA84FEA7037F5858F2BFEDA73AD679A";
  static const uint8_t binary_fingerprint[16]; // = {0xFF,0xA8,0x4F,0xEA,0x70,0x37,0xF5,0x85,0x8F,0x2B,0xFE,0xDA,0x73,0xAD,0x67,0x9A};

  Complex() : aint(0), aString() {
  }

  virtual ~Complex() throw() {}

  int32_t aint;
  std::string aString;
  std::vector<int32_t>  lint;
  std::vector<std::string>  lString;
  std::vector<IntString>  lintString;
  std::map<std::string, std::string>  mStringString;
  std::map<std::string, std::map<std::string, std::map<std::string, PropValueUnion> > >  attributes;
  PropValueUnion unionField1;
  PropValueUnion unionField2;
  PropValueUnion unionField3;

  _Complex__isset __isset;

  void __set_aint(const int32_t val) {
    aint = val;
  }

  void __set_aString(const std::string& val) {
    aString = val;
  }

  void __set_lint(const std::vector<int32_t> & val) {
    lint = val;
  }

  void __set_lString(const std::vector<std::string> & val) {
    lString = val;
  }

  void __set_lintString(const std::vector<IntString> & val) {
    lintString = val;
  }

  void __set_mStringString(const std::map<std::string, std::string> & val) {
    mStringString = val;
  }

  void __set_attributes(const std::map<std::string, std::map<std::string, std::map<std::string, PropValueUnion> > > & val) {
    attributes = val;
  }

  void __set_unionField1(const PropValueUnion& val) {
    unionField1 = val;
  }

  void __set_unionField2(const PropValueUnion& val) {
    unionField2 = val;
  }

  void __set_unionField3(const PropValueUnion& val) {
    unionField3 = val;
  }

  bool operator == (const Complex & rhs) const
  {
    if (!(aint == rhs.aint))
      return false;
    if (!(aString == rhs.aString))
      return false;
    if (!(lint == rhs.lint))
      return false;
    if (!(lString == rhs.lString))
      return false;
    if (!(lintString == rhs.lintString))
      return false;
    if (!(mStringString == rhs.mStringString))
      return false;
    if (!(attributes == rhs.attributes))
      return false;
    if (!(unionField1 == rhs.unionField1))
      return false;
    if (!(unionField2 == rhs.unionField2))
      return false;
    if (!(unionField3 == rhs.unionField3))
      return false;
    return true;
  }
  bool operator != (const Complex &rhs) const {
    return !(*this == rhs);
  }

  bool operator < (const Complex & ) const;

  uint32_t read(::apache::thrift::protocol::TProtocol* iprot);
  uint32_t write(::apache::thrift::protocol::TProtocol* oprot) const;

};

void swap(Complex &a, Complex &b);



#endif