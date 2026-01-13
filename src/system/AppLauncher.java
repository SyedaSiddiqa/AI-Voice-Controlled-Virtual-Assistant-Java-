package system;

public class AppLauncher {

    public static void openApp(String app) {
        try {
            switch (app) {

                case "chrome":
                    Runtime.getRuntime().exec("cmd /c start chrome");
                    break;

                case "vscode":
                    Runtime.getRuntime().exec("cmd /c code");
                    break;

                case "word":
                    Runtime.getRuntime().exec("cmd /c start winword");
                    break;

                case "excel":
                    Runtime.getRuntime().exec("cmd /c start excel");
                    break;

                case "powerpoint":
                    Runtime.getRuntime().exec("cmd /c start powerpnt");
                    break;

                case "media":
                    Runtime.getRuntime().exec("cmd /c start wmplayer");
                    break;

                case "snip":
                    Runtime.getRuntime().exec("cmd /c start ms-screenclip:");
                    break;

                case "copilot":
                    Runtime.getRuntime().exec("cmd /c start ms-copilot:");
                    break;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
