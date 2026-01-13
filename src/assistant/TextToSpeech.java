package assistant;

public class TextToSpeech {

    public void speak(String text) {
        try {
            String command =
                    "powershell -Command \"Add-Type -AssemblyName System.Speech;" +
                            "(New-Object System.Speech.Synthesis.SpeechSynthesizer)" +
                            ".Speak('" + text + "');\"";
            Runtime.getRuntime().exec(command);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
