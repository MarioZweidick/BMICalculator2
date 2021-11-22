public class BMICalculator
{
    //Mario Zweidick
    //Weight: 80kg
    //Age: 26

    String firstname;
    String lastname;
    int bodyHeight;
    double bodyWeight;
    char gender;

    /*Constructor...must have the same name as the class! Can be generated using "ALT+EINF" --> Constructor
      If you want to have all variables in the parameterlist, select all of them in the dialog that shows up
      after selecting "constructor"
      parameter list = all elements between () after function name. In our case
      firstname, lastname, bodyheight, bodyweight, gender*/
    public BMICalculator(String firstname, String lastname, int bodyHeight, double bodyWeight, char gender)
    {
        this.firstname = firstname;
        this.lastname = lastname;
        this.bodyHeight = bodyHeight;
        this.bodyWeight = bodyWeight;
        this.gender = gender;
    }

    private double round(double value) {
        return Math.round(value * 100) / 100D;
    }

    public double calculateBMI()
    {
        double bmi = round(bodyWeight / (((double)bodyHeight / 100) * ((double)bodyHeight / 100)));
        return bmi;
    }

    /*Calculates the BMI category based on the calculated bmi.
      Used switch-case, which works similar to if-else. In our case, the "gender" is the condition we wanna check.
      case 'm': means the same as "if(gender = 'm')
      In my case, I am also checking for capital letters....*/
    public int calculateBMICategory()
    {
        double bmi = calculateBMI();

        switch(gender)
        {
            case 'm':
            case 'M':
            {
                if(bmi < 16)
                    return -2;
                else if(bmi >= 16 && bmi < 18.5)
                    return -1;
                else if(bmi >= 18.5 && bmi < 25)
                    return 0;
                else if(bmi >= 25 && bmi < 35)
                    return 1;
                else
                    return 2;
            }
            case 'w':
            case 'W':
            {
                if(bmi < 15)
                    return -2;
                else if(bmi >= 15 && bmi < 17.5)
                    return -1;
                else if(bmi >= 17.5 && bmi < 24)
                    return 0;
                else if(bmi >= 24 && bmi < 34)
                    return 1;
                else
                    return 2;
            }
        }
        /*Error-Case. If the program has reached that point, a gender that is not defined in the calculation
         list was entered. E.g. 'd' for divers (used it for person 3 in my test cases and in BMIDemoApp)
         I want to return 100 in that case to show that something went wrong while calculating the result*/
        return 100;
    }

    //Checking for the category name... In case of person 3 (gender = d), result will be "invalid weight class"
    public String getBMICategoryName()
    {
        int category = calculateBMICategory();

        if(category == -2)
            return "Sehr starkes Untergewicht";
        else if(category == -1)
            return "Untergewicht";
        else if(category == 0)
            return "Normalgewicht";
        else if(category == 1)
            return "Übergewicht";
        else if(category == 2)
            return "Sehr starkes Übergewicht";
        else
            return "Invalid weight class!";

    }

    /*Setter method for bodyweight. You could use it to override an already set value
    (after creating object using constructor)*/
    public void setBodyHeight(int bodyHeight)
    {
        this.bodyHeight = bodyHeight;
    }

    public void setBodyWeight(double bodyWeight)
    {
        this.bodyWeight = bodyWeight;
    }

    //Getter method to access corresponding value, after initialization using the constructor
    public String getFirstname()
    {
        return firstname;
    }

    public String getLastname()
    {
        return lastname;
    }

    public int getBodyHeight()
    {
        return bodyHeight;
    }

    public double getBodyWeight()
    {
        return bodyWeight;
    }

    public char getGender()
    {
        return gender;
    }
}
