package commands;

import java.util.LinkedList;
import java.util.Queue;

public class CommandQueue {
    private Queue<String> queue = new LinkedList<>();

    public void add(String cmd) {
        queue.add(cmd);
    }

    public String next() {
        return queue.poll();
    }

    public boolean isEmpty() {
        return queue.isEmpty();
    }
}
