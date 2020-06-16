package tests;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class tests {

    @DataProvider(name = "Module1")
    public Object[][] createData1()
    {

        int a = -20;
        int b = 10;
        int c = a + b;
        return new Object[][]
                {
                        {c}
                };
    }

    @DataProvider(name = "Module2.1")
    public Object[][] createData2()
    {

        int a = -20;
        int b = 10;
        return new Object[][]
                {
                        {a, b}
                };
    }

    @DataProvider(name = "Module2.2")
    public Object[][] createData3()
    {
        double max = Integer.MAX_VALUE - 1;
        int a = 1 + (int)(Math.random() * max) + 1;
        return new Object[][]
                {
                        {a}
                };
    }

    @DataProvider(name = "Module2.3")
    public Object[][] createData4()
    {
        double min = Integer.MIN_VALUE + 1;
        int a =(int)(Math.random() * min) - 1;
        return new Object[][]
                {
                        {a}
                };
    }

    @DataProvider(name = "Module3")
    public Object[][] createData5()
    {

        int a = 20;
        int b =  10;
        int c = a/b;
        return new Object[][]
                {
                        {a, b, c}
                };
    }

    @DataProvider(name = "Module4")
    public Object[][] createData6()
    {

        double a = 5;

        return new Object[][]
                {
                        {a}
                };
    }


    @Test(dataProvider = "Module1")
    public void FirstModule(int a)
    {
        System.out.println("Тест 1. Позитивная Проверка функции модуля Math.abs(int a)c корректными значениями");
        int b = Math.abs(a);
        System.out.println("a = " + a);
        System.out.println("|a| = " + b);
        if (a < 0) Assert.assertEquals(b,a * -1);
        else Assert.assertEquals(b, a);
        System.out.println();
    }

    @Test(dataProvider = "Module2.1")
    public void SecondModule1(int a, int b)
    {
        System.out.println("Тест 3 - Позитивная проверка функции Math.addExact корректными значениями");
        //Позитивная проверка
        // модуля Math.addExact(int x, int y)
        int c = Math.addExact(a,b);
        Assert.assertEquals(c,a + b);
        System.out.println("Значение с помощью addExact = " + c);
        System.out.println("Проверочное значение = " + (a + b));
        System.out.println();
    }

    @Test(dataProvider = "Module2.2")
    public void SecondModule2(int b)
    {
        System.out.println("Тест 4 - Негативная проверка функции Math.addExact переполнением с положительными числами");

        //Проверка модуля Math.addExact(int x, int y)
        // на переполнение типа int с положительными числами
        int n = Integer.MAX_VALUE;
        try {
            int sum = Math.addExact(n,b);
        }
        catch (RuntimeException e)
        {
            System.out.println("Ожидаемое исключения: java.lang.ArithmeticException: integer overflow");
            System.out.println("Полученное исключение: " + e);
            Assert.assertEquals(e.toString(),"java.lang.ArithmeticException: integer overflow");
        }
        System.out.println();
    }

    @Test(dataProvider = "Module2.3")
    public void SecondModule3(int b)
    {
        System.out.println("Тест 5 - негативная проверка функции Math.addExact переполнением с отрицательными числами");

        //Проверка модуля Math.addExact(int x, int y)
        // на переполнение типа int с отрицательными числами
        int n = Integer.MIN_VALUE;
        try {
            int sum = Math.addExact(n,b);
        }
        catch (RuntimeException e)
        {
            System.out.println("Ожидаемое исключения: java.lang.ArithmeticException: integer overflow");
            System.out.println("Полученное исключение: " + e);
            Assert.assertEquals(e.toString(),"java.lang.ArithmeticException: integer overflow");
        }
        System.out.println();
    }

    @Test(dataProvider = "Module3")
    public void ThirdModule1(int a, int b, int c)
    {
        System.out.println("Тест 6 - Позитивная проверка Math.floorDiv c корректными значениями");

        int res = Math.floorDiv(a, b);
        System.out.println("Первое число = " + a + "; Второе число = " + b);
        System.out.println("Результат floorDiv: " + res);
        System.out.println("Проверка: " + c);
        Assert.assertEquals(res, c);
        System.out.println();
    }

    @Test(dataProvider = "Module1")
    public void ThirdModule2(int a)
    {
        System.out.println("Тест 7 - Негативная проверка Math.floorDiv делением на ноль");

        int b = 0;
        try {
            Math.floorDiv(a,b);
        }
        catch (Throwable e)
        {
            System.out.println("Ожидаемое исключение: java.lang.ArithmeticException: / by zero");
            System.out.println("Полученное исключение: " + e);
            Assert.assertEquals(e.toString(),"java.lang.ArithmeticException: / by zero");
        }
        System.out.println();

    }

    @Test(dataProvider = "Module4")
    public void FourthModule1(double a) {
        System.out.println("Тест 2 - Позитивная проверка Math.exp() ");
        double b = Math.exp(a);
        System.out.println("Число " + a);
        System.out.print("Math.exp() = ");
        System.out.printf("%.3f\n", b);
        System.out.println();
    }
}