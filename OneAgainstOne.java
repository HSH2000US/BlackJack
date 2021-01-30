import java.util.Scanner;
import java.util.Random;
public class OneAgainstOne extends TwoAgainstComputerSingleMode
{

    TwoAgainstCompInt playerOne = new TwoAgainstCompInt();
    TwoAgainstCompInt playerTwo = new TwoAgainstCompInt();
    private int yourValueOne;
    private int yourValueTwo;

    public void testWinner()
    {
        playerOne.setYourValues();
        playerTwo.setYourValues();
        playerOne.addingValues();
        playerTwo.addingValues();

        yourValueOne = playerOne.addingValues();
        yourValueTwo = playerTwo.addingValues();
    }

    public void printWinner()
    {
        if (yourValueOne == 21 && yourValueTwo != 21)
        {
            System.out.println("BlackJack, player one wins");
        }
        else if(yourValueOne != 21 && yourValueTwo == 21)
        {
            System.out.println("BlackJack, Player two wins");
        }
        else if (yourValueOne > yourValueTwo && yourValueOne < 21 && yourValueTwo < 21)
        {
            System.out.println("Player One Wins");
        }
        else if (yourValueTwo > yourValueOne && yourValueTwo < 21 && yourValueOne < 21)
        {
            System.out.println("Player Two wins.");
        }
        else if (yourValueOne < 21 && yourValueTwo > 21)
        {
            System.out.println("Player One is the winner");
        }
        else if (yourValueTwo < 21 && yourValueOne > 21)
        {
            System.out.println("Player Two is the Winner");
        }
        else if (yourValueOne == yourValueTwo)
        {
            System.out.println("Draw");
        }
        else if (yourValueOne > 21 && yourValueTwo > 21)
        {
            System.out.println("Both Players Bust");
        }

    }


}
