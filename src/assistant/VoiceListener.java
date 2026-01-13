package assistant;

public class VoiceListener {

    private static final String WAKE_WORD = "hey assistant";

    private final SpeechRecognizer recognizer;
    private final TextToSpeech tts;

    public VoiceListener() {
        recognizer = new SpeechRecognizer();
        tts = new TextToSpeech();
    }

    public String startVoiceInteraction() {

        tts.speak("Listening for wake word");
        System.out.println("Listening for wake word...");

        String wakeInput = recognizer.listen().toLowerCase();

        if (wakeInput.contains(WAKE_WORD)) {
            tts.speak("Wake word activated");
            System.out.println("Wake word detected");

            tts.speak("Listening for command");
            System.out.println("Listening for command...");

            return recognizer.listen().toLowerCase();
        } else {
            tts.speak("Wake word not detected");
            System.out.println("Wake word not detected");
            return "";
        }
    }
}
