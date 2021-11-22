import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BMICalculatorTest
{
    //Creating person variable
    BMICalculator person1;
    BMICalculator person2;
    BMICalculator person3;
    BMICalculator person4;
    BMICalculator person5;
    BMICalculator person6;
    BMICalculator person7;
    BMICalculator person8;

    @BeforeEach
    void setUp()
    {
        //Creating new Object of BMICalculator type. new BMICalculator(...) <-- Constructor: These are the initial values
        person1 = new BMICalculator("Mario", "Zweidick", 178, 80, 'm');
        person2 = new BMICalculator("Hildegard", "Test", 161, 54, 'w');
        person3 = new BMICalculator("Divers", "Test", 191, 68, 'd');
        person4 = new BMICalculator("Martin", "Koch", 194, 110, 'm');
        person5 = new BMICalculator("Karla", "König", 170, 78, 'w');
        person6 = new BMICalculator("Testperson", "Eins", 180, 80, 'm');
        person7 = new BMICalculator("Testperson", "Zwei", 174, 52, 'w');
        person8 = new BMICalculator("Testperson", "Drei", 202, 114, 'm');
    }

    @Test
    void testBMICalculation()
    {
        /*Assertion is the test class that contains methods like "assertEquals", which e.g. requires an expected result
        as a first parameter of the parameter list and a result delivered by the method that is tested in that step
        as a second parameter of the param.list*/
        Assertions.assertEquals(25.25,person1.calculateBMI());
        Assertions.assertEquals(20.83,person2.calculateBMI());
        //Cases from pdf
        Assertions.assertEquals(24.69,person6.calculateBMI());
        Assertions.assertEquals(17.18,person7.calculateBMI());
        Assertions.assertEquals(27.94,person8.calculateBMI());

    }

    @Test
    void testBMICategory()
    {
        Assertions.assertEquals(1, person1.calculateBMICategory());
        Assertions.assertEquals(0, person2.calculateBMICategory());
        Assertions.assertEquals(100, person3.calculateBMICategory());
        Assertions.assertEquals(0, person6.calculateBMICategory());
        Assertions.assertEquals(-1, person7.calculateBMICategory());
        Assertions.assertEquals(1, person8.calculateBMICategory());
    }

    @Test
    void testBMICategoryName()
    {
        Assertions.assertEquals("Übergewicht", person1.getBMICategoryName());
        Assertions.assertEquals("Normalgewicht", person2.getBMICategoryName());
        /*Invalid, because, it is neither male nor female.
          Refer to getBMICategoryName() implementation for more details...*/
        Assertions.assertEquals("Invalid weight class!", person3.getBMICategoryName());
        Assertions.assertEquals("Normalgewicht", person6.getBMICategoryName());
        Assertions.assertEquals("Untergewicht", person7.getBMICategoryName());
        Assertions.assertEquals("Übergewicht", person8.getBMICategoryName());

    }
}