import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class B {
    public static void main(String args[]){

        HashMap map;
       A a = new A();
       a.setAa(1);
       A a1 = new A();
       a1.setAa(1);
       A a2 = a;
       System.out.println(a.equals(a1));
       System.out.println(a==a1);
       System.out.println(a.hashCode()==a1.hashCode());

        Set<A> set = new HashSet<A>();
        set.add(a);
        set.add(a1);
        System.out.println(a.hashCode() == a1.hashCode());
        System.out.println(a.equals(a1));
        System.out.println(set);
    }
}
