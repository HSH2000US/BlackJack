import java.util.Random;

public class TwoAgainstComputerSingleMode extends AgainstComputerSingle

{
    private int yourValueOne;
    private int yourValueTwo;
    private int firstCompCard;
    private int secondCompCard;
    private int compValue = 0;
    TwoAgainstCompInt playerOne = new TwoAgainstCompInt();
    TwoAgainstCompInt playerTwo = new TwoAgainstCompInt();

    public int setCompValue()
    {
        // first comp card
        Random rn = new Random();
        firstCompCard = rn.nextInt(11) + 1;
        if (firstCompCard == 1 || firstCompCard == 11)
            System.out.println("The computer's first card is an Ace");
        else if (firstCompCard == 10)
            System.out.println("The computer's first card is a face card and is equal to " + firstCompCard);
        else if ( firstCompCard != 1 && firstCompCard != 11)
            System.out.println("The computer's first card is " + firstCompCard);
        // second comp card
        secondCompCard = rn.nextInt(11) + 1;
        if (secondCompCard == 10)
            System.out.println();

        // Check for Computer Ace Values
        if ((firstCompCard == 1 || firstCompCard == 11) && (secondCompCard != 1 || secondCompCard != 11))
        {
            int setToEleven = 11;
            firstCompCard += setToEleven;
            if (firstCompCard + secondCompCard <= 21)
                firstCompCard = 11;
            else if (firstCompCard + secondCompCard > 21)
                firstCompCard = 1;

        }
        else if (secondCompCard == 1 || secondCompCard == 11 && firstCompCard != 1 || firstCompCard != 11) {
            int setToEleven = 11;
            secondCompCard += setToEleven;
            if (secondCompCard + firstCompCard <= 21)
                secondCompCard = 11;
            else if (secondCompCard + firstCompCard > 21)
                secondCompCard = 1;
        }
        else if (secondCompCard == 1 || secondCompCard == 11 && firstCompCard == 1 || firstCompCard == 11)
        {
            firstCompCard = 11;
            secondCompCard = 1;

        }
        compValue = firstCompCard + secondCompCard;
        return compValue;
    }
    public void testWinner()
    {
        // Check for dealer value
        // 16 dealer has 15
        playerOne.setYourValues();
        playerTwo.setYourValues();
        playerOne.addingValues();
        playerTwo.addingValues();
        yourValueOne = playerOne.addingValues();
        yourValueTwo = playerTwo.addingValues();
        System.out.println();
        System.out.println("The computer Value = " + compValue);
        System.out.println("Player One Value = " + yourValueOne);
        System.out.println("Player Two Value = " + yourValueTwo);
        while (compValue <= yourValueOne && yourValueOne <= 21 && compValue < 21 || (compValue <= yourValueTwo && yourValueTwo <= 21 && compValue < 21 ))
        {
            // adding to computer value after checking value to your value
            Random rn = new Random();
            int addingCompValue = rn.nextInt(11) + 1;
            if (addingCompValue == 11 || addingCompValue == 1)
            {

                int eleven = 11;
                if (compValue + eleven <= 21)
                    addingCompValue = 11;
                else
                    addingCompValue = 1;
            }
            else if (addingCompValue == 10)
                System.out.println("The Computer is adding a new value to its total to match your value since cards are over turned. The value added to the computer value is a face card and = 10");
            else
                System.out.println("The Computer is adding a new value to its total to match your value since cards are over turned. The value added to the computer value is = " + addingCompValue);
            compValue += addingCompValue;
            System.out.println("The new computer Value = " + compValue);
        }

    }
    public void printWinner()
    {
        if (yourValueOne == 21 && compValue != 21 && yourValueTwo != 21)
            System.out.println("BlackJack, Player One wins the round. Player one value = "+ yourValueOne + " Comp Value = " + compValue +
                    " \nThe computer's first card " + firstCompCard + " \nThe Computer's second card " + secondCompCard  +
            "\nPlayer Two value = " + yourValueTwo);
        else if (compValue == 21 && yourValueOne != 21 && yourValueTwo != 21)
            System.out.println("BlackJack Comp wins the round. Your value = "+ yourValueOne + " Comp Value = " +
                    compValue + " \nThe computer's first card " + firstCompCard + " \nThe Computer's second card " + secondCompCard +
                    "\nPlayer Two value = " + yourValueTwo);
        else if (compValue > 21 && yourValueOne <= 21 && yourValueTwo > 21)
            System.out.println("Player One wins the round. Player One Value = "+ yourValueOne + " Comp Value = " + compValue +
                    " \nThe computer's first card " + firstCompCard + " \nThe Computer's second card " + secondCompCard+
                    "\n Player Two value = " + yourValueTwo);
        else if (compValue <= 21 && yourValueOne > 21 && yourValueTwo > 21)
            System.out.println("Comp wins the round. Player One Value = "+ yourValueOne + " Comp Value = "
                    + compValue + " \nThe computer's first card " + firstCompCard + " \nThe Computer's second card " + secondCompCard +
                    "\nPlayer Two value = " + yourValueTwo);
        else if (yourValueOne > 21 && compValue > 21 && yourValueTwo > 21 || (yourValueOne == compValue && compValue == yourValueTwo))
            System.out.println("Break... Player One Value = " + yourValueOne + " Comp Value = "
                    + compValue + " \nThe computer's first card " + firstCompCard + " \nThe Computer's second card " + secondCompCard );
        else if (compValue < 21 && yourValueOne < 21 &&  yourValueTwo < 21 && (yourValueOne > compValue && yourValueOne > yourValueTwo))
            System.out.println("You win the round. Your value = "+ yourValueOne + " Comp Value = " + compValue +
                    " \nThe computer's first card " + firstCompCard + " \nThe Computer's second card " + secondCompCard+
                    "\nPlayer Two value = " + yourValueTwo);
        else if (compValue < 21 && yourValueOne < 21 && yourValueTwo < 21 && (yourValueOne < compValue && yourValueTwo < compValue))
            System.out.println("Comp wins the round. Your value = "+ yourValueOne + " Comp Value = "
                    + compValue + " \nThe computer's first card " + firstCompCard + " \nThe Computer's second card " + secondCompCard +
                    "\nPlayer Two value = " + yourValueTwo);
        else if (yourValueTwo == 21 && compValue != 21 && yourValueOne != 21)
            System.out.println("BlackJack, Player Two win the round. Your value = "+ yourValueOne + " Comp Value = " + compValue +
                    " \nThe computer's first card " + firstCompCard + " \nThe Computer's second card " + secondCompCard  +
                    "\nPlayer Two value = " + yourValueTwo);
        else if (yourValueTwo <= 21 && compValue > 21 && yourValueOne > 21)
            System.out.println("Player Two wins the round. Your value = "+ yourValueOne + " Comp Value = " + compValue +
                    " \nThe computer's first card " + firstCompCard + " \nThe Computer's second card " + secondCompCard  +
                    "Player Two value = " + yourValueTwo);
        else if (yourValueTwo < 21 && yourValueOne < 21 && compValue < 21 && (yourValueOne < yourValueTwo && compValue < yourValueTwo))
            System.out.println("Player Two wins the round. Your value = "+ yourValueOne + " Comp Value = " + compValue +
                    " \nThe computer's first card " + firstCompCard + " \nThe Computer's second card " + secondCompCard  +
                    "Player Two value = " + yourValueTwo);

    }
}
