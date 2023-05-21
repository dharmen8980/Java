package sql_operations;

public class Students extends OperationOptions{
    private int cwid;
    private String name;
    private String major;

    public Students(){};
    public Students(int id, String n, String m){
        cwid = id;
        name = n;
        major = m;
    }
    public Students(int id) {
        cwid = id;
    }

    public Students (int id, String major){
        cwid = id;
        this.major = major;
    }

    public void setName(String name){
        this.name = name;
    }
    public void setMajor(String major){
        this.major = major;
    }
    public int getCwid(){
        return cwid;
    }

    public String getName(){
        return name;
    }

    public String getMajor(){
        return major;
    }
}
