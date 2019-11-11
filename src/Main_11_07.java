import java.util.Scanner;

public class Main_11_07 {
    //每三个空瓶子换一瓶饮料，可以进行赊账  问有n个空瓶子可以喝多少饮料
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n ;
        while(scanner.hasNext()){
            n = scanner.nextInt();
            System.out.println(drink(n));
        }
    }

    private static int drink(int n) {
        int total = 0;
        while(n>2){
            total = total+n/3;
            n = n/3 +n%3;
        }
        if(n==2){
            total = total+1;
        }
        return total;
    }
}
