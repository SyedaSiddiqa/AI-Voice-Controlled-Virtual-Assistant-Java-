package commands;

import assistant.TextToSpeech;
import system.FileManager;
import system.WebSearch;

import java.util.HashMap;

public class CommandProcessor {

    private final CommandQueue queue = new CommandQueue();
    private final HashMap<String, Runnable> commands = CommandMapper.map();
    private final TextToSpeech tts = new TextToSpeech();

    public void process(String input) {

        queue.add(input);

        while (!queue.isEmpty()) {
            String cmd = queue.next().toLowerCase().trim();
            boolean matched = false;

            // 1️⃣ Check predefined commands (apps, time, date, weather)
            for (String key : commands.keySet()) {
                if (cmd.contains(key)) {
                    tts.speak("Executing " + key);
                    commands.get(key).run();
                    matched = true;
                    break;
                }
            }

            // 2️⃣ Dynamic folder opening: "open folder <folder name>"
            if (!matched && cmd.startsWith("open folder ")) {
                String folderName = cmd.replace("open folder ", "").trim();
                tts.speak("Opening folder " + folderName);
                FileManager.openAnyFolder(folderName);
                matched = true;
            }

            // 3️⃣ Dynamic search command: "search <query>"
            if (!matched && cmd.startsWith("search ")) {
                String query = cmd.replace("search ", "").trim();
                tts.speak("Searching for " + query);
                WebSearch.search(query);
                matched = true;
            }

            // 4️⃣ If still not recognized
            if (!matched) {
                tts.speak("Command not recognized");
            }
        }
    }
}
