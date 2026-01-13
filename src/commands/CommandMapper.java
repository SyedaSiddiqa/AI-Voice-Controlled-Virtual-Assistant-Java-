package commands;

import system.*;

import java.util.HashMap;

public class CommandMapper {

    public static HashMap<String, Runnable> map() {

        HashMap<String, Runnable> commands = new HashMap<>();

        // Browsers & Editors
        commands.put("open chrome", () -> AppLauncher.openApp("chrome"));
        commands.put("open vscode", () -> AppLauncher.openApp("vscode"));
        commands.put("open visual studio code", () -> AppLauncher.openApp("vscode"));

        // Microsoft Office
        commands.put("open word", () -> AppLauncher.openApp("word"));
        commands.put("open excel", () -> AppLauncher.openApp("excel"));
        commands.put("open powerpoint", () -> AppLauncher.openApp("powerpoint"));

        // System Apps
        commands.put("open media player", () -> AppLauncher.openApp("media"));
        commands.put("open snipping tool", () -> AppLauncher.openApp("snip"));
        commands.put("open copilot", () -> AppLauncher.openApp("copilot"));

        // Folders
        commands.put("open documents", () -> FileManager.openKnownFolder("Documents"));
        commands.put("open pictures", () -> FileManager.openKnownFolder("Pictures"));
        commands.put("open downloads", () -> FileManager.openKnownFolder("Downloads"));

        // Time / Date / Weather
        commands.put("time", TimeDateService::tellTime);
        commands.put("date", TimeDateService::tellDate);
        commands.put("weather", WeatherService::tellWeather);

        return commands;
    }
}
