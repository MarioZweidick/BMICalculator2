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
