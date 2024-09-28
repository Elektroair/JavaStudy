public class MyMethodsClass
{
    public static void taxi (int code)
    {
        switch (code)
        {
            case 1:
                System.out.println("Anatoly, GO!");
                break;
            case 2:
                System.out.println("Anna, GO!");
                break;
            case 3:
                System.out.println("Alex, GO!");
                break;
            case 4:
                System.out.println("Alöna, GO!");
                break;
            case 5:
                System.out.println("Anton, GO!");
                break;
            default:
                System.out.println("ERROR: Unknown code");
                break;
        }
    }

    public static void isAlcoholPermit(int age)
    {
        if (age >= 0 && age < 18)
        {
            System.out.println("Alcohol is not permit");
        }
        else if (age >= 18 && age <= 80)
        {
            System.out.println("Alcohol is permit");
        }
        else if (age > 80)
        {
            System.out.println("Alcohol is not recommended");
        }
        else
        {
            System.out.println("ERROR: Wrong enter");
        }
    }
}
