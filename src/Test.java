class Base{
    public Base(String s){
        System.out.println("B");
    }
    public static void hello(){
        System.out.println("Hello");
    }
}

public class Test extends Base{
    // 调用父类构造 需要Super（）；
    public Test(String s ){
        super(s);
        System.out.println("C");
    }
    public static boolean isAdmin(String userle){
        //比较的是两个字符串的引用 不是两个字符串的内容，比较内容使用equals
        return userle.toLowerCase() == "admin";
    }
    public static void main(String[] args) {
        new Test("C");
        System.out.println(isAdmin("Admin"));
        //直接使用引用而不去创建对象进行调用方法
        Test test = null;
        test.hello();
        long c = Math.round(11.5);// == 12 是向上取整
    }

}
