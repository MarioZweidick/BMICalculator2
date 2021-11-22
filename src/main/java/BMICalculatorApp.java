import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

public class BMICalculatorApp
{
    public static void main(String[] args)
    {
        /*Creating objects of our BMICalculator. After the "new" Keyword, the constructor is called.
        If there is no constructor implemented in your BMICalculator, the IDE is creating
        a hidden constructor with no values in the parameter list.
        EXAMPLE: BMICalculator personX = new BMICalculator(); <--Let's pretend that there is no constructor in my BMICalculator class*/

        BMICalculator person1 = new BMICalculator("Mario", "Zweidick", 178, 80, 'm');
        BMICalculator person2 = new BMICalculator("Hildegard", "Test", 161, 54, 'w');
        BMICalculator person3 = new BMICalculator("Divers", "Test", 191, 68, 'd');
        BMICalculator person4 = new BMICalculator("Martin", "Koch", 194, 110, 'm');
        BMICalculator person5 = new BMICalculator("Karla", "König", 170, 78, 'w');
        BMICalculator person6 = new BMICalculator("Testperson", "Eins", 180, 80, 'm');
        BMICalculator person7 = new BMICalculator("Testperson", "Zwei", 174, 52, 'w');
        BMICalculator person8 = new BMICalculator("Testperson", "Drei", 202, 114, 'm');

        //Creating arraylist that stores BMICalculator objects...In our case person1 to person8
        ArrayList<BMICalculator> personList = new ArrayList<>();

        //this is how to add a persopn to our arraylist....personList.add(<person you wanna insert>)
        personList.add(person1);
        personList.add(person2);
        personList.add(person3);
        personList.add(person4);
        personList.add(person5);
        personList.add(person6);
        personList.add(person7);
        personList.add(person8);

        //calling our printWeight method that prints all elements stored in the arraylist
        printWeights(personList);

        //Gets the BMICaclulator for the person with highest BMI and stores it in the "fatty" variable (no offense)
        BMICalculator fatty = fatDetector(personList);

        /*Show fattest person, based on the bmi in the console. soutv + TAB
        automatically generates a System.out.println for a variable.*/
        System.out.println("The fattest person is: " + fatty.getFirstname() + " " + fatty.getLastname() + " with a bmi of "
                            + fatty.calculateBMI());

        System.out.println("Number of people with an not unnormal BMI:  " + getUnnormalBMIpersonSet(personList).size());
        printGenderOverview(getNumberByGender(personList));

    }

    /*
    * Task: This method sums up all the weights of all people in the personList
    * Input: personList...ArrayList containing all participating people
    * Output: sum...int-Value, showing the overall weight
    * */
    public static int sumWeight(ArrayList<BMICalculator> personList)
    {
        int sum = 0;

        //Iterate over all elements of personList (Iterate = check all elements...one after the other)
        for (BMICalculator bmiCalculator : personList)
        {
            //bmiCalculator = One BMICalculator Object in the personList
            //sum will be increase by the bodyweight everytime we check a person.
            //sum += is the same as...sum = sum + bmiCalculator.getBodyWeight();
            sum += bmiCalculator.getBodyWeight();
        }
        return sum;
    }

    /*
     * Task: This method calculates the average weight of all people in the personList
     * Input: personList...ArrayList containing all participating people
     * Output: sum...double-Value, showing the average weight
     * */
    public static double averageWeight(ArrayList<BMICalculator> personList)
    {
        //using the sumWeight()-method, we can easily calculate the sum.
        //formula for average: sum/numberOfpeople
        return (sumWeight(personList) / (double)personList.size());
    }

    /*
     * Task: This method prints everyone's name, weight and bmi + sum + average weight at the end
     * Input: personList...ArrayList containing all participating people
     * Output: no output, as it is a void method
     * */
    public static void printWeights(ArrayList<BMICalculator> personList)
    {
        System.out.println("WEIGHT LIST OF THE FOLLOWING PEOPLE\n-------------------------------------");

        //Iterating over personList....getting element by element...stored in variable bmiCalculator
        for (BMICalculator bmiCalculator : personList)
        {
            //Output, formatted with som '\n'--> line break
            System.out.println("\nName: " + bmiCalculator.getFirstname() + " " + bmiCalculator.getLastname() + ":\nWeight: " + bmiCalculator.getBodyWeight()
                    + " \nBMI: "+ bmiCalculator.calculateBMI());
        }

        //total weight using our previously implemented method to calculate the sum

        System.out.println("\nTotal weight: " + sumWeight(personList));

        //average weight using our previously implemented method to calculate the average weight
        System.out.println("Average weight: " + averageWeight(personList));
    }

    /*
     * Task: This method searches for the "fattest" person, measured by BMI, not weight!
     * Input: personList...ArrayList containing all participating people
     * Output: BMICalculator object, with the highest BMI
     * */
    public static BMICalculator fatDetector(ArrayList<BMICalculator> personList)
    {
        //Setting the first element as the "fattestPerson"
        BMICalculator fattestPerson = personList.get(0);

        /*Iterating over personList...I could have done a normal for-loop, ignoring the first element in the list,
        because it has been already set above using personList.get(0)
        For such small amount of data, performance is not really a crutial requirement.*/
        for (BMICalculator bmiCalculator : personList)
        {
            //If my person has a higher bmi than the currently "fattestPerson"...
            if(bmiCalculator.calculateBMI() > fattestPerson.calculateBMI())
            {
                //...we set the current bmiCalculator as the "fattestPerson"
                fattestPerson = bmiCalculator;
            }

        }
        //After iterating over all elements....we return the fattest person including all data, such as "bmi", weight, etc.
        return fattestPerson;
    }

    /*
     * Task: This method searches for all people having a BMI-Category that does not equal 0 (Normalgewicht).
     *       All found elements are stored in a HashSet
     * Input: personList...ArrayList containing all participating people
     * Output: HashSet containing all found people
     * */
    public static HashSet<BMICalculator> getUnnormalBMIpersonSet(ArrayList<BMICalculator> personList)
    {
        //Creating new instance of a HashSet that can only store objects of type BMICalculator
        HashSet<BMICalculator> personSet = new HashSet<>();

        //Iterate over ArrayList and check, if category is not 0. If that is the case, we add it to the HashSet.
        for (BMICalculator person : personList)
        {
            if(person.calculateBMICategory() != 0)
                personSet.add(person);
        }

        return personSet;
    }

    /*
     * Task: This method sums up all participants per gender.
     *       All found elements are stored in a HashMap
     * Input: personList...ArrayList containing all participating people
     * Output: HashMap containing all found people
     * */
    public static HashMap<Character, Integer> getNumberByGender(ArrayList<BMICalculator> personList)
    {
        /*HashMaps always consist of a key, value pair
          Every key is unique and refers to the assigned value*/
        HashMap<Character, Integer> genderMap = new HashMap<>();

        //Going through arraylist
        for (BMICalculator person : personList)
        {
            /*If the key is already in the set (e.g. we have already added a 'm' for male) we have to get the current value
              that is linked to the key. Then we add 1 to it and put it back into the HashMap
              EXAMPLE: We have already counted two 'm' person. Now another one is stored in variable 'person'
              As a first step, we assign the current value for that key ('m'), which is 2 in our example...
              As a next step we increase it by one, using value++
              Finally, we put it back into the map, using the put-method.*/
            if(genderMap.containsKey(person.getGender()))
            {
                //If key is already in the list, we get the corresponding value to the currently focused key
                //and add up by 1 before setting the value again
                int value = genderMap.get(person.getGender());
                value++;
                genderMap.put(person.getGender(), value);
            }
            else
            {
                //If nothing is in, we add qty 1 for the key;
                genderMap.put(person.getGender(), 1);
            }
        }

        //After iteration is done, we return our filled HashMap
        return genderMap;
    }

    /*
     * Task: This method prints all elements stored in the HashMap
     * Input: genderMap...HashMap containing key = gender ('m', 'w', 'd') and value = <amount of male, female, divers people>
     * Output: no return value, due to the "void" return type.
     * */
    public static void printGenderOverview(HashMap<Character, Integer> genderMap)
    {
        System.out.println("\nPARTICIPANTS PER GENDER!\n---------------");
        for (Character gender : genderMap.keySet())
        {
            System.out.println(gender + ": " + genderMap.get(gender));
        }
    }
}
