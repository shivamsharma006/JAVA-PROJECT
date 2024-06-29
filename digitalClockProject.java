
import java.util.Scanner;

class digitalClock{
    private int hours;
    private int minutes;
    private int seconds;

    public digitalClock(){
        this.hours = 0;
        this.minutes = 0;
        this.seconds = 0;
    }

    public void setTime(int hours,int minutes, int seconds){
        this.hours = hours;
        this.minutes = minutes;
        this.seconds = seconds;
    }

    public void displayTime(){
        String amPm = (this.hours>12)? "PM":"AM";
        int displayHours = (this.hours>12)? (this.hours-12):(this.hours);
        System.out.printf("%02d:%02d:%02d %s",displayHours,this.minutes,this.seconds,amPm);
    }
}

public class digitalClockProject {
    public static void main(String[] args) {
        digitalClock t = new digitalClock();
        Scanner sc = new Scanner(System.in);
        int hours,minutes,seconds;
        System.out.println("Enter Hours (0-23):-");
        hours = sc.nextInt();
        System.out.println("Enter Minutes (0-59):-");
        minutes = sc.nextInt();
        System.out.println("Enter Seconds (0-59):-");
        seconds = sc.nextInt();
        t.setTime(hours, minutes, seconds);
        t.displayTime();
    }
}
