import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    static int i = 0;
    static int scale = 2;
    static RoundingMode roundingMode = RoundingMode.HALF_UP;

    public static BigDecimal summation(){
        BigDecimal sum = new BigDecimal(0);
        BigDecimal quantity;
        BigDecimal unit_price;
        BigDecimal amount;
        String s = "";
        int x = 0;
        Scanner scanner = new Scanner(System.in);


        while (true) {

//            try{
//                quantity = scanner.nextDouble();
//                System.out.print("单价：");
//                unit_price = scanner.nextDouble();
//                amount = quantity * unit_price;
//                System.out.println("金额：" + amount);
//                sum += amount;
//            } catch (InputMismatchException e){
//                System.out.println("该账单已结束");
//                break;
//            }

            try {
                System.out.println("* 第" + (++x) + "项数量及单价：");

                System.out.print("数量：");
                s = scanner.nextLine();
                if (s.isEmpty()) s = "1";
                if (s.endsWith(".")) s.substring(0, s.length() - 1);
                quantity = new BigDecimal(s);

                System.out.print("单价：");
                s = scanner.nextLine();
                if (s.endsWith(".")) s.substring(0, s.length() - 1);
                unit_price = new BigDecimal(s);

                amount = Main.bigSum(quantity, unit_price);
                System.out.println("金额：" + amount);
                sum = sum.add(amount).setScale(scale,roundingMode);

            } catch (NumberFormatException e){
                if (s.endsWith("\\")){
                    System.out.println("已撤销上一条数据");
                    x--;
                }else {
                    System.out.println("该账单已结束");
                    break;
                }
            }
        }


        return sum;
    }

    public static BigDecimal bigSum(BigDecimal quantity, BigDecimal unit_price){

        return quantity.multiply(unit_price).setScale(scale,roundingMode);
    }


    public static void main(String[] args) throws InterruptedException {
        System.out.println("欢迎进入账单计算系统");

        while (true) {
            System.out.println("-------------------------------------------------------------");
            System.out.println("第" + (++i) + "张账单");
            System.out.println("总数:" +  Main.summation());
            Thread.sleep(50);
            System.out.println("-------------------------------------------------------------");
        }
    }
}