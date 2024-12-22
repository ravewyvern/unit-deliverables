/********************************************
 *	AUTHORS:	Katelyn Nova Powers
 * COLLABORATORS: <name of peer, tutor, instructor>
 *	LAST MODIFIED:	10/7/2024
 ********************************************/

/********************************************
 *	Sleep Score Calculator
 *********************************************
 *	PROGRAM DESCRIPTION:
 *	This program calculates and outputs a sleep score based on user provided sleep data,
 *  such as REM, light, and deep sleep times. It also compares the user's total sleep
 *  time to the recommended sleep time for their age.
 *********************************************
 *	ALGORITHM:
 *  INPUT age, sleepRemTime, sleepLightTime, sleepDeepTime, sleepDescription
 *  CALC totalSleepTime = rem + light + deep
 *  CALC recommendedMinSleepTime = 12 - subValue * age
 *  CALC recommendedMaxSleepTime = 12 - subValue * age
 *  CALC recommendedSleepTime = (recommendedMinSleepTime + recommendedMaxSleepTime) / 2
 *  CALC recommendedREM, recommendedLight, recommendedDeep
 *  CALC sleep component scores:
 *     remScore = (sleepRemTime / recommendedREM) * 35
 *     lightScore = (sleepLightTime / recommendedLight) * 20
 *     deepScore = (sleepDeepTime / recommendedDeep) * 45
 *  CALC baseScore = remScore + lightScore + deepScore
 *  OUTPUT sleepScore, totalSleepTime, recommendedMinSleepTime, recommendedMaxSleepTime, sleepDescription
 *********************************************
 *	STATIC METHODS:
 *	+ String dividerLine(): Returns a formatted line divider.
 *	+ double calculateTotalSleep(double rem, double light, double deep): Returns the sum of REM, light, and deep sleep.
 *	+ double recommendedSleepTime(int age, double subValue): Calculates the recommended sleep time based on age.
 *	+ int calculateSleepScore(double rem, double light, double deep, double sleepMin, double sleepMax): Calculates the sleep score based on the user’s sleep data and age.
 *********************************************
 *	ALL IMPORTED PACKAGES NEEDED AND PURPOSE:
 *	Not used for UD1
 *********************************************/

// <IMPORTS GO HERE - Not used for UD1>

public class UD1Main
{

  /***** CONSTANT SECTION *****/

  public static void main(String[] args)
  {
    /***** DECLARATION SECTION *****/
    // Input your age here
    int age = 21;
    // Put your different stages of sleep here (you need a sleep tracker for this)
    double sleepRemTime = 1.0;
    double sleepLightTime = 2.5;
    double sleepDeepTime = 4.0;
    // Describe your sleep here
    String sleepDescription = "Perfect sleep";

    /***** INITIALIZATION SECTION *****/

    /***** INTRO SECTION *****/

    /***** INPUT SECTION *****/

    /***** PROCESSING SECTION *****/
    //this code calls different methods to perform calculations 
    double totalSleepTime = UD1Main.calculateTotalSleep(sleepRemTime, sleepLightTime, sleepDeepTime);
    double recommendedMinSleepTime = UD1Main.recommendedSleepTime(age, 0.28);
    double recommendedMaxSleepTime = UD1Main.recommendedSleepTime(age, 0.14);
    int sleepScore = UD1Main.calculateSleepScore(sleepRemTime, sleepLightTime, sleepDeepTime, recommendedMinSleepTime, recommendedMaxSleepTime);

    /***** OUTPUT SECTION *****/
    //This code outputs the UI to display the info
    System.out.printf("%15s    _.._\n", "");
    System.out.printf("%15s .' .-'`\n", "");
    System.out.printf("%15s/  /\n", "");
    System.out.printf("%15s|  |\n", "");
    System.out.printf("%15s\\  \\\n", "");
    System.out.printf("%15s '._'-._\n", "");
    System.out.printf("%15s    ```\n", "");
    System.out.printf("%15sSleep score\n", "");
    System.out.printf("%15s%4s%d\n", "", "", sleepScore);
    System.out.print(UD1Main.dividerLine());
    System.out.printf("%10s90-100 = Perfect sleep\n", "");
    System.out.printf("%10s70-90 = Okay sleep\n", "");
    System.out.printf("%10s40-70 = Poor sleep\n", "");
    System.out.printf("%10s20-40 = Terrible sleep\n", "");
    System.out.printf("%10s0-20 = Go to bed right now\n", "");
    System.out.print(UD1Main.dividerLine());
    System.out.printf("%12sTotal sleep time:\n", "");
    System.out.printf("%16s%.1f hours\n", "", totalSleepTime);
    System.out.print(UD1Main.dividerLine());
    System.out.printf("%-10sBased on your age of %d\n", "", age);
    System.out.printf("%7syour recommended sleep time is\n", "");
    System.out.printf("%14s%.1f - %.1f hours\n", "", recommendedMinSleepTime, recommendedMaxSleepTime);
    System.out.print(UD1Main.dividerLine());
    System.out.printf("%8sYou Describe your sleep as:\n", "");
    System.out.printf("%12s%s\n", "", sleepDescription);
    Main.runner();
  }
  /***** STATIC METHODS *****/

  /**
   * This code is just to output a divider line into the UI
   *
   * @return The formatted line divider.
   */
  public static String dividerLine()
  {
    return String.format("%5s%s\n", "", "─────────────────────────────────");
  }

  /**
   * This code combines the rem sleep, deep sleep, and light sleep into one.
   *
   * @param rem The amount of REM sleep the user got.
   * @param light The amount of light sleep the user got.
   * @param deep The amount of deep sleep the user got.
   * @return The total sleep time.
   */
  public static double calculateTotalSleep(double rem, double light, double deep) {
    return rem + light + deep;
  }

  /**
   * This code calculated the estimated time you need to sleep using a formula I found
   *
   * @param age The user's age.
   * @param subValue The value to subtract from the age.
   * @return The recommended sleep time.
   */
  public static double recommendedSleepTime(int age, double subValue) {
    double sleep = 12 - subValue * age;
    return sleep;
  }

  /**
   * This code Calculates a sleep score using rem sleep, light sleep, deep sleep, and min and max recommended sleep times
   *
   * This method calculates the sleep score based on the user's sleep data and age.
   * @param rem The amount of REM sleep the user got.
   * @param light The amount of light sleep the user got.
   * @param deep The amount of deep sleep the user got.
   * @param sleepMin The minimum recommended sleep time for the user's age.
   * @param sleepMax The maximum recommended sleep time for the user's age.
   * @return The sleep score.
   */
  public static int calculateSleepScore(double rem, double light, double deep, double sleepMin, double sleepMax) {
    // Calculates the average recommended time someone will sleep
    double recommendedSleep = (sleepMin + sleepMax) / 2;
    // Calculates the percentage of sleep is best for each sleep stage
    double recommendedRem = recommendedSleep * 0.35;
    double recommendedLight = recommendedSleep * 0.20;
    double recommendedDeep = recommendedSleep * 0.45;
    // Assigns weights to all the sleep stages
    double remScore = (rem / recommendedRem) * 35;
    double lightScore = (light / recommendedLight) * 20;
    double deepScore = (deep / recommendedDeep) * 45;
    //adds all scores together
    return (int) (remScore + lightScore + deepScore);
    }
}
