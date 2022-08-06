package szh.bean;


public class Tbluser {

  private long userId;
  private String uAcc;
  private String uPwd;
  private String uName;
  private String phone;
  private String idNumber;
  private String address;


  public long getUserId() {
    return userId;
  }

  public void setUserId(long userId) {
    this.userId = userId;
  }


  public String getUAcc() {
    return uAcc;
  }

  public void setUAcc(String uAcc) {
    this.uAcc = uAcc;
  }


  public String getUPwd() {
    return uPwd;
  }

  public void setUPwd(String uPwd) {
    this.uPwd = uPwd;
  }


  public String getUName() {
    return uName;
  }

  public void setUName(String uName) {
    this.uName = uName;
  }


  public String getPhone() {
    return phone;
  }

  public void setPhone(String phone) {
    this.phone = phone;
  }


  public String getIdNumber() {
    return idNumber;
  }

  public void setIdNumber(String idNumber) {
    this.idNumber = idNumber;
  }


  public String getAddress() {
    return address;
  }

  public void setAddress(String address) {
    this.address = address;
  }

}
