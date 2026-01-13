package assistant;

import org.vosk.Model;
import org.vosk.Recognizer;

import javax.sound.sampled.*;
import java.io.IOException;

public class SpeechRecognizer {

    private static final String MODEL_PATH = "C:\\Users\\Azeem\\IdeaProjects\\aiAssistant\\model\\vosk-model-small-en-us-0.15";

    public String listen() {

        StringBuilder resultText = new StringBuilder();

        try {
            // Load VOSK Model
            Model model = new Model(MODEL_PATH);
            Recognizer recognizer = new Recognizer(model, 16000);

            // Microphone format
            AudioFormat format = new AudioFormat(
                    16000,
                    16,
                    1,
                    true,
                    false
            );

            DataLine.Info info = new DataLine.Info(TargetDataLine.class, format);

            if (!AudioSystem.isLineSupported(info)) {
                System.err.println("Microphone not supported");
                return "";
            }

            // Open microphone
            TargetDataLine microphone = (TargetDataLine) AudioSystem.getLine(info);
            microphone.open(format);
            microphone.start();

            System.out.println("🎤 Microphone activated, speak now...");

            byte[] buffer = new byte[4096];

            while (true) {
                int bytesRead = microphone.read(buffer, 0, buffer.length);
                if (bytesRead < 0) break;

                if (recognizer.acceptWaveForm(buffer, bytesRead)) {
                    String result = recognizer.getResult();
                    resultText.append(result);
                    break;
                }
            }

            microphone.stop();
            microphone.close();
            recognizer.close();
            model.close();

        } catch (LineUnavailableException | IOException e) {
            e.printStackTrace();
        }

        // Extract recognized text
        String recognized = resultText.toString()
                .replaceAll("[^a-zA-Z ]", "")
                .toLowerCase();

        System.out.println("Recognized: " + recognized);
        return recognized;
    }
}
