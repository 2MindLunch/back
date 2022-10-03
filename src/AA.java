
public class AA {

    public String find(TestInterface a){
        return a.find("aaa");
    }

    public static void main(String[] args){
       System.out.println(new AA().find(x->x));

    }
}
