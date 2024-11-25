import java.util.Scanner;

public class MainMethodsClass
{
    public static void main(String[] args)
    {
        Scanner input = new Scanner(System.in);

        System.out.println("Enter driver's code => ");
        MyMethodsClass.taxi(input.nextInt());

        System.out.println("Enter age => ");
        MyMethodsClass.isAlcoholPermit(input.nextInt());
    }
}