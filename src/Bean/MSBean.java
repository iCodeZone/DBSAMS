package Bean;

public class MSBean extends StudentBean{
    private String Mno;
    private String Mname;
    
    public MSBean(){}
    
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

