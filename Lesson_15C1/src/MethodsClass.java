public class MethodsClass
{
    public static double calculateSalary(double hours, double wage, double tax)
    {
        return hours * wage * (1 - tax / 100);
    }
}
