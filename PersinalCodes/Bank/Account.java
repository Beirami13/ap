package PersinalCodes.Bank;

public class Account {
    private int mojoodi;
    private String name;
    public Account(String name,int mojoodi){
        this.name=name;
        this.mojoodi=mojoodi;
    }
    public int getmojoodi(){
        return mojoodi;
    }
    public String getname(){
        return name;
    }
    public void setname(String name){
        this.name=name;
    }
    public void setname(int mojoodi){
        this.mojoodi=mojoodi;
    }

    public Boolean bardasht(int mojoodi,int mablaq){
        if (mojoodi>=mablaq){
            mojoodi-=mablaq;
            return true;
        }else{
            System.out.println("no");
            return false;
        }

    }
    public int variz(int mojoodi,int mablaq){
        mojoodi+=mablaq;
        return mojoodi;
    }
    public String logBalance(){
        return "name : "+name +" mojoodi : "+mojoodi;
    }
}

