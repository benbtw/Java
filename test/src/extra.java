public class extra {
    AnotherClass clas = new AnotherClass();

    public int num = clas.getNumber();
    void print(){
        clas.increase();
        System.out.println(clas.number);
        System.out.println(num);
    }
}
