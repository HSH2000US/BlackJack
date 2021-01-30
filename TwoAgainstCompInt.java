import java.util.Random;
import java.util.Scanner;

public class TwoAgainstCompInt implements HumanPlayers
{
    private int yourValue;
    private boolean stay;
    private String name;
    private String hit;




    @Override
    public int setYourValues()
    {
        Scanner sc = new Scanner (System.in);
        System.out.print("Each player will enter their name so. Yo enter your name fam. >>> ");
        name = sc.nextLine();
        Random rn = new Random();
        int firstCard = rn.nextInt(11) + 1;
        if (firstCard == 10)
            System.out.println(name + "first card is a face card and is equal to " + firstCard);

        else if ( firstCard != 1 && firstCard != 11)
            System.out.println(name + " first card is " + firstCard);

        else if (firstCard == 11 || firstCard == 1 )
        {
            System.out.print("The card " + name + " has chosen is an Ace. Does " + name + " want the value to be 1 or 11>>> ");
            int Ace = sc.nextInt();
            firstCard = Ace;
            // 10 + 10 + 10 or 11, option of choosing 1 or 11 but can't change even tho in real black jack you could
        }

        int secondCard = rn.nextInt(11) + 1;

        if (secondCard == 10)
            System.out.println(name + " second card is a face card and is equal to " + secondCard);

        else if (secondCard != 1 && secondCard != 11)
            System.out.println(name + " second card is " + secondCard);

        else if (secondCard == 11 || secondCard == 1)
        {
            System.out.print("The card " + name + " have chosen is an Ace. Does " + name + " want the value to be 1 or 11 >>> ");
            int Ace = sc.nextInt();
            secondCard = Ace;
        }
        yourValue = firstCard + secondCard;
        System.out.println(name + " total value is " + yourValue);
        return yourValue;
    }

    @Override
    public int addingValues()
    {
        Scanner sc = new Scanner(System.in);
        Random rn = new Random();
        System.out.println("This is message is a done to point out that this either your first round, your chance to match, or the game is over");
        if (yourValue < 21)
        {
            System.out.print("Based on " + name + "'s current " + yourValue + " would " + name + " like to hit Answer YES or NO >>> ");
            hit = sc.nextLine();
        }
        while (hit.toUpperCase().equals("YES") && yourValue < 21)
        {
            if (yourValue < 21)
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
                System.out.println(name + " new total is >>> " + yourValue);

                if (yourValue < 21)
                {
                    System.out.print("Based on " + name + "'s current " + yourValue + " would " + name + " like to hit Answer YES or NO >>> ");
                    hit = sc.nextLine();
                }

            }

        }


        return yourValue;

    }
}
