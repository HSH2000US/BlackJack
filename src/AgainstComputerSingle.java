import java.util.Scanner;
import java.util.Random;
public class AgainstComputerSingle
{
    private int yourValue = 0;
    private int compValue = 0;
    private int firstCompCard;
    private int secondCompCard;


    public int setYourValue()

    {
        Scanner sc = new Scanner(System.in);
        Random rn = new Random();
        int firstCard = rn.nextInt(11) + 1;
        if (firstCard == 10)
            System.out.println("Your first card is a face card and is equal to " + firstCard);

        else if ( firstCard != 1 && firstCard != 11)
            System.out.println("Your first card is " + firstCard);

        else
        {
            System.out.print("The card you have chosen is an Ace. Do you want the value to be one or eleven >>> ");
            int Ace = sc.nextInt();
            firstCard = Ace;
            // 10 + 10 + 10 or 11, option of choosing 1 or 11 but can't change even tho in real black jack you could
        }

        int secondCard = rn.nextInt(11) + 1;

        if (secondCard == 10)
            System.out.println("Your second card is a face card and is equal to " + secondCard);

        else if (secondCard != 1 && secondCard != 11)
            System.out.println("Your second card is " + secondCard);

        else
        {
            System.out.print("The card you have chosen is an Ace. Do you want the value to be one or eleven >>> ");
            int Ace = sc.nextInt();
            secondCard = Ace;
        }

        yourValue = firstCard + secondCard;
        System.out.println("Your total value is " + yourValue);

        return yourValue;

    }

    public int setCompValue()
    {
        // first comp card
        Random rn = new Random();
        firstCompCard = rn.nextInt(11) + 1;
        if (firstCompCard == 1 || firstCompCard == 11)
        {
            System.out.println("The computer's first card is an Ace");
        }
        else if (firstCompCard == 10)
        {
            System.out.println("The computer's first card is a face card and is equal to " + firstCompCard);
        }
        else if ( firstCompCard != 1 && firstCompCard != 11)
        {
            System.out.println("The computer's first card is " + firstCompCard);
        }

        // second comp card

        secondCompCard = rn.nextInt(11) + 1;
        if (secondCompCard == 10)
        {
            System.out.println();
        }


        // Check for Computer Ace Values
        if ((firstCompCard == 1 || firstCompCard == 11) && (secondCompCard != 1 && secondCompCard != 11))
        {
            int setToEleven = 11;
            firstCompCard += setToEleven;
            if (firstCompCard + secondCompCard <= 21)
                firstCompCard = 11;
            else if (firstCompCard + secondCompCard > 21)
                firstCompCard = 1;

        }
        else if ((secondCompCard == 1 || secondCompCard == 11) && (firstCompCard != 1 && firstCompCard != 11))
        {
            int setToEleven = 11;
            secondCompCard += setToEleven;
            if (secondCompCard + firstCompCard <= 21)
                secondCompCard = 11;
            else if (secondCompCard + firstCompCard > 21)
                secondCompCard = 1;
        }
        else if ((secondCompCard == 1 || secondCompCard == 11) && (firstCompCard == 1 || firstCompCard == 11))
        {
            firstCompCard = 1;
            secondCompCard = 11;

        }

        compValue = firstCompCard + secondCompCard;

        return compValue;
        // Don't add anything after return statement
    }

    public int getCompFirstCard()
    {
        return firstCompCard;
    }
    public int getcompValue()
    {
        return compValue;
    }
    public int getYourValue()
    {
        return yourValue;
    }

    public int addingValues()
    {
        Scanner sc = new Scanner(System.in);
        Random rn = new Random();
        System.out.print("Based on your current " + yourValue + " would you like to hit Answer YES or NO >>> ");
        String hit = sc.nextLine();
        while (hit.toUpperCase().equals("YES") && yourValue < 21)
        {
            int newValue = rn.nextInt(11) + 1;
            if (newValue == 1 || newValue == 11)
            {

                int eleven = 11;
                if (eleven + yourValue <= 21)
                    newValue = 11;
                else
                    newValue = 1;
            }
            else if (newValue == 10)
                System.out.println("The card is a face card end is = 10");
            else
                 System.out.println("The card is = " + newValue);
            yourValue += newValue;
            System.out.println("Your new total is >>> " + yourValue);

            if (yourValue < 21)
            {

                System.out.print("Do you want to stay or hit again. Answer YES to hit and NO to stay >>> ");
                hit = sc.nextLine();
            }

            else
            {
                hit = "NO";
            }
        }

        return yourValue;

    }
    public void testWinner()
    {
        // Check for dealer value
        // 16 dealer has 15
        System.out.println();
        System.out.println("The computer Value = " + compValue);
        System.out.println("Your Value = " + yourValue);
        while (compValue <= yourValue && yourValue <= 21 && compValue < 21)
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
        if (yourValue == 21 && compValue != 21)
            System.out.println("BlackJack, You win the round. Your value = "+ yourValue + " Comp Value = " + compValue +
                    " \nThe computer's first card " + firstCompCard + " \nThe Computer's second card " + secondCompCard );
        else if (compValue == 21 && yourValue != 21)
            System.out.println("BlackJack Comp wins the round. Your value = "+ yourValue + " Comp Value = " +
                    compValue + " \nThe computer's first card " + firstCompCard + " \nThe Computer's second card " + secondCompCard );
        else if (compValue > 21 && yourValue <= 21)
            System.out.println("You win the round. Your value = "+ yourValue + " Comp Value = " + compValue +
                    " \nThe computer's first card " + firstCompCard + " \nThe Computer's second card " + secondCompCard);
        else if (compValue <= 21 && yourValue > 21)
            System.out.println("Comp wins the round. Your value = "+ yourValue + " Comp Value = "
                    + compValue + " \nThe computer's first card " + firstCompCard + " \nThe Computer's second card " + secondCompCard );
        else if (yourValue > 21 && compValue > 21 || yourValue == compValue)
            System.out.println("Break... Your value = " + yourValue + " Comp Value = "
                    + compValue + " \nThe computer's first card " + firstCompCard + " \nThe Computer's second card " + secondCompCard );
        else if (compValue < 21 && yourValue < 21 && (yourValue > compValue))
            System.out.println("You win the round. Your value = "+ yourValue + " Comp Value = " + compValue +
                    " \nThe computer's first card " + firstCompCard + " \nThe Computer's second card " + secondCompCard);
        else if (compValue < 21 && yourValue < 21 && (yourValue < compValue))
            System.out.println("Comp wins the round. Your value = "+ yourValue + " Comp Value = "
                    + compValue + " \nThe computer's first card " + firstCompCard + " \nThe Computer's second card " + secondCompCard );

    }

}
