import java.util.*;

class Guesser{
    int guesserNumber;
    public int takeNumberGuesser(){
        System.out.println("Guesser guess a number : ");
        Scanner sc = new Scanner(System.in);
        guesserNumber = sc.nextInt();
        return guesserNumber;
    }
}

class Player{
    int playerNumber;
    public int takeNumberPlayer(){
        System.out.println("Player guess a number : ");
        Scanner sc = new Scanner(System.in);
        playerNumber = sc.nextInt();
        return playerNumber;
    }
}

class Umpire{
    int numFromGuesser;
    int numFromPlayer1;
    int numFromPlayer2;
    int numFromPlayer3;

    void CollectionFromGuesser(){
        Guesser g = new Guesser();
        numFromGuesser = g.takeNumberGuesser();
    }
    void CollectionFromPlayer(){
        Player P1 = new Player();
        numFromPlayer1 = P1.takeNumberPlayer();

        Player P2 = new Player();
        numFromPlayer2 = P2.takeNumberPlayer();

        Player P3 = new Player();
        numFromPlayer3 = P3.takeNumberPlayer();
    }
    void compare(){
        if(numFromPlayer1 == numFromGuesser){
            if(numFromPlayer2==numFromGuesser && numFromPlayer3==numFromGuesser){
                System.out.println("All players won the game");
            }
            else if(numFromPlayer2==numFromGuesser){
                System.out.println("Only Player1 and Player2 won the game");
            }
            else if(numFromPlayer3==numFromGuesser){
                System.out.println("Only Player1 and Player3 won the game");
            }
            else{
                System.out.println("Only Player1 won the game");
            }
        }
        else if(numFromPlayer2==numFromGuesser){
            if(numFromPlayer3==numFromGuesser){
                System.out.println("Only Player2 and Player3 won the game");
            }
            else{
                System.out.println("Only Player2 won the game");
            }
        }
        else if(numFromPlayer3==numFromGuesser){
            System.out.println("Only Player3 won the game");
        }
        else{
            System.out.println("No player won the game");
        }
    }
}


public class guesserGameProject {
    public static void main(String[] args) {
        Umpire u = new Umpire();
        u.CollectionFromGuesser();
        u.CollectionFromPlayer();;
        u.compare();
    }
}
