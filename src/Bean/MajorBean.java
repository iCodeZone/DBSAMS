package Bean;

public class MajorBean{
    private String Mno;
    private String Mname;
    
    public MajorBean(){}
    
    public void setMno(String Mno){
        this.Mno=Mno;
    }
    public String getMno(){
        return Mno;
    }

    public void setMname(String name){
        this.Mname=name;
    }
    public String getMname(){
        return Mname;
    }
}

