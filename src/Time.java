/**
 * The Time class represents a specific time of day in military time.
 * A time consists of hours, minutes, and seconds.
 */
public class Time {
    private int hours;
    private int minutes;
    private int seconds;

    /**
     * Constructor for the Time class. This creates a new instance of Time given
     * the specified hours, minutes, and seconds.
     *
     * @param hours   an integer representing the hour of the Time
     * @param minutes an integer representing the minute of the Time
     * @param seconds an integer representing the second of the Time
     */
    public Time(int hours, int minutes, int seconds) {
        this.hours = hours;
        this.minutes = minutes;
        this.seconds = seconds;
    }

    /**
     * The tick method advances the time by one second.
     * If seconds overflow to 60, they reset to 0, and minutes are incremented.
     * Similarly, if minutes or hours overflow, they reset appropriately.
     */
    public void tick() {
        seconds++;
        if (seconds == 60) {
            seconds = 0;
            minutes++;
        }
        if (minutes == 60) {
            minutes = 0;
            hours++;
        }
        if (hours == 24) {
            hours = 0;
        }
    }

    /**
     * The add method adds another Time object to this time.
     * Any overflow in seconds, minutes, or hours is handled to ensure the time remains valid.
     *
     * @param secondTime a Time object to add to the current time
     */
    public void add(Time secondTime) {
        hours = hours + secondTime.hours;
        minutes = minutes + secondTime.minutes;
        seconds = seconds + secondTime.seconds;

        if (seconds >= 60) {
            seconds -= 60;
            minutes++;
        }
        if (minutes >= 60) {
            minutes -= 60;
            hours++;
        }
        if (hours >= 24) {
            hours -= 24;
        }
    }

    /**
     * The toString method returns a String representation of the time in the
     * format HH:MM:SS. Each component of the Time is zero-padded to ensure two digits.
     *
     * @return a String in the format HH:MM:SS representing the time
     */
    public String toString() {
        String stringH = String.valueOf(hours);
        String stringM = String.valueOf(minutes);
        String stringS = String.valueOf(seconds);
        if (hours < 10) {
            stringH = "0" + stringH;
        }
        if (minutes < 10) {
            stringM = "0" + stringM;
        }
        if (seconds < 10) {
            stringS = "0" + stringS;
        }
        return stringH + ":" + stringM + ":" + stringS;
    }
}