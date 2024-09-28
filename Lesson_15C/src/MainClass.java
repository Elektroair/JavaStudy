public class MainClass
{

    public static void fan_1(int mode)
    {
        if (mode == 0)
        {
            System.out.println("Switched out");
        }
        else if (mode == 1)
        {
            System.out.println("Speed 1");
        }
        else if (mode == 2)
        {
            System.out.println("Speed 2");
        }
        else if (mode == 3)
        {
            System.out.println("Speed 3");
        }
        else
        {
            System.out.println("ERROR: Wrong mode");
        }
    }

    public static void fan_2(int mode)
    {
        switch (mode)
        {
            case 0:
                System.out.println("Switched off");
                break;
            case 1:
                System.out.println("Speed 1");
                break;
            case 2:
                System.out.println("Speed 2");
                break;
            case 3:
                System.out.println("Speed 3");
                break;
            default:
                System.out.println("ERROR: Wrong mode");
        }
    }

    public static double calculator(double num_1, char action, double num_2)
    {
        if ((action != '/') || (num_2 != 0))
        {
            switch (action)
            {
                case '+':
                    System.out.printf("%.2f\n", num_1 + num_2);
                    return num_1 + num_2;
                case '-':
                    System.out.printf("%.2f\n", num_1 - num_2);
                    return num_1 - num_2;
                case '*':
                    System.out.printf("%.2f\n", num_1 * num_2);
                    return num_1 * num_2;
                case '/':
                    System.out.printf("%.2f\n", num_1 / num_2);
                    return num_1 / num_2;
                default:
                    System.out.println("ERROR: Unknown action");
                    return 0;
            }
        }
        else
        {
            System.out.println("ERROR: Division by zero is prohibited");
            return 0;
        }
    }

    public static void main(String[] args)
    {
        double result = MethodsClass.calculateSalary(182, 55, 14);
    }
}