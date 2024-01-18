// Charlie Jandura
// 11/9/2023
// Computer Science Lab 12 JavaFX

/**
 * Class used to get, calculate, and return points earned
 * Parent class of JanduraBonusPoints
 */

public class JanduraPointsEarnedD
{

    // variable
    double pointsEarned;

    // no arg constructor to set the points to 0     
    public JanduraPointsEarnedD()
    {
        pointsEarned = 0;

    }

    /** overloaded constructor used to set points to a double
     * @param x
     */
    public JanduraPointsEarnedD(double x)
    {
        pointsEarned = x;

    }

    /** setter method to receive cups earned and calculate points earned
     * @param cups, cups amount
     * @return pointsEarned, points earned
     */
    public double setPoints(double[] cups)
    {
        for (int i = 0; i < cups.length; i++){
            pointsEarned += calculatePoints(cups[i]);

        }
        return pointsEarned;
    }

    /** Overloaded setter method to set points using a double
     * @param double x
     * @return pointsEarned
     */
    public double setPoints(double x) {
        pointsEarned += x;
        return pointsEarned;
    }

    /** calculate users points based off of cups amount
     * @param x, cups amount
     * @return p, points value
     */
    private double calculatePoints(double x)
    {
        //points variable
        double p = 0;

        // calculations based off x with set values when x is 1-4, and when tis 5 or more then p will equal x * 2.895
        if (x == 0)
            p += 0;
        else if (x == 1)
            p += 2;
        else if (x == 2)
            p += 5.15;
        else if (x == 3)
            p += 8.249;
        else if (x == 4)
            p += 11.555;
        else if (x > 4)
            p += x * 2.895;

        
        return p;
            
    }

    /** overloaded method which takes a string, converts it to an integer and calculates points
     * @param c, string
     * @return p, points value
     */
    private double calculatePoints(String c)
    {
        //points variable
        int x = Integer.parseInt(c);
        double p = 0;

        // calculations based off x with set values when x is 1-4, and when tis 5 or more then p will equal x * 2.895
        if (x == 0)
            p += 0;
        else if (x == 1)
            p += 2;
        else if (x == 2)
            p += 5.15;
        else if (x == 3)
            p += 8.249;
        else if (x == 4)
            p += 11.555;
        else if (x > 4)
            p += x * 2.895;

        
        return p;
            
    }

    /** getter method to retrieve points earned and give output based on points
     * @param cupsAmount
     * @return pointsEarned
     */
    public double getPoints()
    {
        // return pointsEarned
        return pointsEarned;

    }

    

}
