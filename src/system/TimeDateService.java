package system;

import assistant.TextToSpeech;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.TextStyle;
import java.util.Locale;

public class TimeDateService {

    static TextToSpeech tts = new TextToSpeech();

    public static void tellTime() {
        LocalTime time = LocalTime.now();
        String speakTime = time.getHour() + " hours and " + time.getMinute() + " minutes";
        tts.speak("The current time is " + speakTime);
    }

    public static void tellDate() {
        LocalDate date = LocalDate.now();
        String month = date.getMonth().getDisplayName(TextStyle.FULL, Locale.ENGLISH);
        tts.speak("Today's date is " + date.getDayOfMonth() + " " + month + " " + date.getYear());
    }
}
