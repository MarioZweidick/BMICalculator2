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

    public BMICalculator(String firstname, String lastname, int bodyHeight, double bodyWeight, char gender)
    {
        this.firstname = firstname;
        this.lastname = lastname;
        this.bodyHeight = bodyHeight;
        this.bodyWeight = bodyWeight;
        this.gender = gender;
    }

    public double calculateBMI()
    {
        return Math.round(bodyWeight / ((double)(bodyHeight / 100) * ((double)bodyHeight / 100)));
    }

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
        //Error-Case. If the program has reached that point, a wrong gender was entered.
        return 100;
    }

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

    public void setBodyHeight(int bodyHeight)
    {
        this.bodyHeight = bodyHeight;
    }

    public void setBodyWeight(double bodyWeight)
    {
        this.bodyWeight = bodyWeight;
    }

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
