package system;

import assistant.TextToSpeech;

public class WeatherService {

    static TextToSpeech tts = new TextToSpeech();

    public static void tellWeather() {
        tts.speak("Opening weather information");
        try {
            Runtime.getRuntime().exec(
                    "cmd /c start https://www.google.com/search?q=current+weather"
            );
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
