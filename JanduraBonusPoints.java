// Charlie Jandura
// 11/9/2023
// Computer Science Lab 12 JavaFX

/** Class used to determine bonus points and return them
 * Child class of JanduraPointsEarnedD
 */

 public class JanduraBonusPoints extends JanduraPointsEarnedD implements JanduraWednesdayPoints {

    // variables
    double bonusPointsEarned;
    
    // no arg constructor
    public JanduraBonusPoints() {
        super();
    }

    // overloaded constructor to set the points to a double
    // @param x
    public JanduraBonusPoints(double x) {
        bonusPointsEarned += x;
    }

    /**
     * check if user has input at least 3 months of data, and if the average points is greater than 5.0
     * and then add 9 points is both are true
     * @param cups
     */
    public void volumeBonus(double[] cups)
    {

        //variables
        double monthsBought = 0; //amount of months with data greater than 0
        double pointsTotal = 0 ; //total points in cups array
        double averagePoints = 0; //pointsTotal / monthsBought


        //check each index value for a number greater than 0
        for (int i = 0; i < cups.length; i++)
        {
            if (cups[i] > 0)
            {
                monthsBought += 1; //add 1 to months bought if true
                pointsTotal += cups[i]; //add total points if true
            }            

        }

        averagePoints = pointsTotal / monthsBought; //get the average points

        if (monthsBought > 2 && averagePoints > 5.0) //check if both arguments are true
        {
            System.out.println("Thank you for being a loyal customer! You have been awarded 9 extra points."); //output message
            bonusPointsEarned += 9; //add 9 points to pointsEarned

        }

    }

    /** getter method to get bonus points
     * @return bonusPointsEarned
     */
    public double getBonusPoints() {
        return bonusPointsEarned;
    }

    /** setter method used to set bonus and total points
     * no @param or @return
     */
    public void setBonusPoints() {
        pointsEarned += bonusPointsEarned;
    }

    /**interface override method used to calculate bonus wednesday points
     * @param double x
     * no @return
     */
    @Override //override the abstract method
    public void wednesdayBonusPoints(double x){
        double wednesdayPoints = 0; //wednesdayPoints variable
        wednesdayPoints = x * 0.5; //calculate points
        bonusPointsEarned += wednesdayPoints; //set bonus points
        //if (wednesdayPoints > 0) //give output if points>0
            //System.out.println("Thanks for taking part in our special! Bonus points earned: " + wednesdayPoints + "\n");
        setPoints(bonusPointsEarned); //set points in JanduraPointsEarnedD
    }

}