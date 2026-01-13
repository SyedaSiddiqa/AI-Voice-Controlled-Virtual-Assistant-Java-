package system;

public class WebSearch {

    public static void search(String query) {
        try {
            // Replace spaces with + for Google search URL
            String url = "https://www.google.com/search?q=" + query.replace(" ", "+");
            Runtime.getRuntime().exec("cmd /c start " + url);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
