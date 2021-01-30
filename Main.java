import java.util.Scanner;
import java.util.Random;

public class Main
{
    public static void main (String[] args)
    {
        Random rn = new Random();
        Scanner sc = new Scanner (System.in);

        Player askPlayerObj = new Player();
        AgainstComputerSingle OneVComp = new AgainstComputerSingle ();
        TwoAgainstComputerSingleMode objTwo = new TwoAgainstComputerSingleMode();
        OneAgainstOne objOne = new OneAgainstOne();

        int AskPlayer;
        int gameMode;
        System.out.print("Enter gamemode:\nEnter 1 for one player game mode against the computer \nEnter 2 or a two player gamemode and a computer \nEnter 3 for a One v One \n");
        System.out.print("Enter value >>> ");
        AskPlayer = sc.nextInt();
        while (AskPlayer < 1 || AskPlayer > 3)
        {
            System.out.println("Sorry value not available please re-enter ");
            System.out.print("Enter gamemode:\nEnter 1 for one player game mode against the computer \nEnter 2 for a two player gamemode and a computer \nEnter 3 for a One v One \n");
            System.out.print("Enter value >>> ");
            AskPlayer = sc.nextInt();
            System.out.println();
        }
        askPlayerObj.setGameMode(AskPlayer);
        gameMode = askPlayerObj.getPlayerGameMode();


        if (gameMode == 1)
        {
            System.out.println();
            System.out.println("You have chosen the game mode of 1v1 against the computer. Casino rules apply: ");
            System.out.println("You will be given two cards and the computer will be given two cards as well");
            System.out.println("You will know one of the computer's cards since it will be overturned, but not know the other.");
            System.out.println("The winner will be whoever has the higher value equal to 21 or closes to 21 but lower");
            System.out.println("The computer will have a chance to match your value and win once you have chosen to stay. \n");
            System.out.println("The default value for an ace value of the computer's first card will be 1.");
            OneVComp.setYourValue();
            OneVComp.setCompValue();
            OneVComp.getCompFirstCard();
            OneVComp.getcompValue();
            OneVComp.getYourValue();
            OneVComp.addingValues();
            OneVComp.testWinner();
            OneVComp.printWinner();

        }
        else if (gameMode == 2)
        {
            int playerOne = 0;
            int playerTwo = 0;
            int playerOneCompare;
            int playerTwoCompare;
            int number = rn.nextInt(10) + 1;
            System.out.println();
            System.out.println("You have chosen the game mode of 2 players against a computer (dealer)");
            System.out.println("The players who goes first is player one and the player who goes second is player two");
            System.out.println("The way it will work since both players can see the screen \n" +
                    "is that the first player will be asked if he wanted to hit or stay. Then it will move to the second \n" +
                    "player and the players will have a chance to match each other. Then the computer \n" +
                    "will have a chance to match them At the end of the game the number value \n" +
                    "of each card will printed so an Ace will have a number as will a face card ");
            System.out.println("To determine who goes second both players will pick a number between 1 and 10 \n" +
                    "And whoever loses goes first. ");
            System.out.print("Enter a number between 1 and 10 >>> ");
            playerOne = sc.nextInt();
            System.out.print("The next Player, Enter a number between 1 and 10 >>> ");
            playerTwo = sc.nextInt();
            if (number - playerOne >= 0 && (number - playerTwo >= 0))
            {
                playerOneCompare = number - playerOne;
                playerTwoCompare = number - playerTwo;
                if (playerOneCompare < playerTwoCompare)
                    System.out.println("Player who guessed second goes first.");
                else if (playerTwoCompare < playerOneCompare)
                    System.out.println("Player who guessed first goes first");
                System.out.println("The number was " + number);
            }
            else if (number - playerOne < 0 || (number - playerTwo < 0))
            {
                if (number - playerOne < 0 && number - playerTwo >= 0)
                {
                    playerOneCompare = playerOne - number;
                    playerTwoCompare = number - playerTwo;
                    if (playerOneCompare < playerTwoCompare)
                        System.out.println("The number is " + number + "\nPlayer who guessed second goes first.");
                    else if (playerTwoCompare < playerOneCompare)
                        System.out.println("The number is " + number + "\nPlayer who guessed first goes first");

                }
                else if (number - playerOne >= 0 && number - playerTwo < 0)
                {
                    playerOneCompare = number - playerOne;
                    playerTwoCompare = playerTwo - number;
                    if (playerOneCompare < playerTwoCompare)
                        System.out.println("The number is " + number + "\nPlayer who guessed second goes first.");
                    else if (playerTwoCompare < playerOneCompare)
                        System.out.println("The number is " + number + "\nPlayer who guessed first goes first");

                }
                else if (number - playerOne < 0 && number - playerTwo < 0)
                {
                    playerOneCompare = playerOne - number;
                    playerTwoCompare = playerTwo - number;
                    if (playerOneCompare < playerTwoCompare)
                        System.out.println("The number is " + number + "\nPlayer who guessed second goes first.");
                    else if (playerTwoCompare < playerOneCompare)
                        System.out.println("The number is " + number + "\nPlayer who guessed first goes first");
                }
            }

            objTwo.setCompValue();
            objTwo.testWinner();
            objTwo.printWinner();
        }
        else if (gameMode == 3)
        {

            int playerOne = 0;
            int playerTwo = 0;
            int number = rn.nextInt(10) + 1;
            int playerOneCompare;
            int playerTwoCompare;
            System.out.println("The way this black jack game works is each player will have a " +
                    "chance to match the previous player's value. ");
            System.out.println("Meaning that if player one no longer wants to hit, and player two has a greater value" +
                    "but player 2's value is less than 21 than player one will get a chance to hit again" +
                    "since both players can see the screen. The same goes for player two if both players" +
                    "are dont with the initial hit if player 1 has hit again after stating they want to stay" +
                    "and then player 2 has hit if player 2 wants to go again they are allowed to ");
            System.out.println("Since both players can see the screen");
            System.out.println("To determine who goes first each player will guess a number between one and ten " +
                    "and whoever is closer goes first");
            System.out.println("This is because the person who goes first will not have an advantage");

            System.out.print("Who wants to go first to guess the number enter your number >>> ");
            playerOne = sc.nextInt();

            System.out.println("Next player enter your number >>> ");
            playerTwo = sc.nextInt();

            playerOneCompare = Math.abs(number - playerOne);
            playerTwoCompare = Math.abs(number - playerTwo);

            while (playerOneCompare == playerTwoCompare)
            {
                System.out.println("The values were the same please try again ");
                System.out.print("First player guess again >>> ");
                playerOne = sc.nextInt();
                System.out.print("Second player guess again >>> ");
                playerTwo = sc.nextInt();
            }
            if (playerOneCompare > playerTwoCompare)
            {
                System.out.println("Second player Won, player who went first goes first in Blackjack");
            }
            else if (playerTwoCompare > playerOneCompare)
            {
                System.out.println("First player Won, player who went second goes first in Blackjack");
            }




            objOne.testWinner();
            objOne.printWinner();




        }


    }
}
