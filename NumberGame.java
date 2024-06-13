import java.util.Scanner;
public class NumberGame
{
    public static void main(String arg[])
    {
        Scanner sc=new Scanner(System.in);
        int chances=8;
        int finals=0;
        boolean playAgain=true;
        System.out.println("Now Start a NumberGame");
        System.out.println("Hey You Have About  "+chances+"  To Win The Game");
        while(playAgain){
            int rand=getrandN(1,100);
            boolean guess=false;
            for(int i=0;i<chances;i++){
                System.out.println("Chance"+(i+1)+"Enter your guess:");
                int user=sc.nextInt();
                if(user==rand){
                    guess=true;
                    finals+=1;
                    System.out.println("You Won It.");
                    break;
                }
                else if(user>rand){
                    System.out.println("Too High");

                }
                else{
                    System.out.println("Too Low");
                }
            }
            if(guess==false)
            {
                System.out.println("Sorry ,You Lose The Chances. The Number is "+rand);

            }
            System.out.println("Do You Want To Play Again(y/n)");
            String pA=sc.next();
            playAgain=pA.equalsIgnoreCase("y");
        }   
                 System.out.println("That's it , Hope you Enjoy it");
                 System.out.println("Here is your Score"+finals);
    }
                 public static int getrandN(int min, int max){
                    return(int)(Math.random()*(max-min+1)+min);
                 }

    }
