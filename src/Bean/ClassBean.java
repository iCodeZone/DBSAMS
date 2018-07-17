package Bean;

public class ClassBean{
    private String Gno;
    private String Gname;
    private String Mno;
    
    public ClassBean(){}
    
    public void setGno(String Gno){
        this.Gno=Gno;
    }
    public String getGno(){
        return Gno;
    }

    public void setGname(String name){
        this.Gname=name;
    }
    public String getGname(){
        return Gname;
    }

    public void setMno(String Mno){
        this.Mno=Mno;
    }
    public String getMno(){
        return Mno;
    }
}

