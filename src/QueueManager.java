import java.util.*;

public class QueueManager {

    Queue<Token> normalQueue = new LinkedList<>();
    Queue<Token> priorityQueue = new LinkedList<>();

    int tokenCounter = 1;

    // Generate Token
    public Token generateToken(String type) {
        Token t = new Token(tokenCounter++, type);

        if ("PRIORITY".equals(type)) {
            priorityQueue.add(t);
        } else {
            normalQueue.add(t);
        }
        return t;
    }

    // Serve Token
    public Token serveNext() {
        if (!priorityQueue.isEmpty()) {
            return priorityQueue.poll();
        } else if (!normalQueue.isEmpty()) {
            return normalQueue.poll();
        }
        return null;
    }

    // Reset Queue
    public void resetQueue() {
        normalQueue.clear();
        priorityQueue.clear();
        tokenCounter = 1;
    }
}
