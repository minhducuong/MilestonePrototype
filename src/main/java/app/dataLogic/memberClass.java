package app.dataLogic;

public class memberClass {
 private String sID;
 private String full_name;
 private String gender;

public memberClass(String sID, String full_name, String gender) {
    this.sID = sID;
    this.full_name = full_name;
    this.gender = gender;
}

public String getsID() {
    return sID;
}
public String full_name() {
    return full_name;
}
public String gender() {
    return gender;
}
     
}
