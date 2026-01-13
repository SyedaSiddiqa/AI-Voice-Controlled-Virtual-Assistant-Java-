package assistant;

import commands.CommandProcessor;
import java.util.Scanner;

public class MainAssistant {

    public static void main(String[] args) {

        TextToSpeech tts = new TextToSpeech();
        VoiceListener voiceListener = new VoiceListener();
        CommandProcessor processor = new CommandProcessor();

        tts.speak("AI Voice Controlled Virtual Assistant activated");
        System.out.println("AI Voice-Controlled Virtual Assistant Activated");
        System.out.println("Type your command OR press ENTER to speak");
        System.out.println("Type 'exit' to quit");

        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.print("> ");
            String input = scanner.nextLine().toLowerCase();

            // Exit
            if (input.equals("exit")) {
                tts.speak("Allah hafiz");
                System.out.println("Allah hafiz");
                break;
            }

            // Voice Mode (ENTER pressed)
            if (input.trim().isEmpty()) {
                String voiceCommand = voiceListener.startVoiceInteraction();
                if (!voiceCommand.isEmpty()) {
                    processor.process(voiceCommand);
                }
            }
            // Text Mode
            else {
                processor.process(input);
            }
        }
        scanner.close();
    }
}
