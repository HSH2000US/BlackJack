public class Player
{
    private int playerGameModeOption = 0;

    public  int setGameMode(int askPlayer)
    {
        playerGameModeOption = askPlayer;
        return playerGameModeOption;
    }
    public int getPlayerGameMode()
    {
        return playerGameModeOption;
    }

}
