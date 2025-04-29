package ap.exercises.ex4;

public class Main_EX4_3_15 {
    public static void main(String[] args) {
        Letter myLetter = new Letter("Hirad", "Akbari");

        myLetter.addLine("I am great");
        myLetter.addLine("I wish you the best");

        System.out.println(myLetter.getText());
    }
}

class Letter {
    private String from;
    private String to;
    private String body;

    public Letter(String from, String to) {
        this.from = from;
        this.to = to;
        this.body = "";
    }

    public void addLine(String line) {
        body = body.concat(line).concat("\n");
    }

    public String getText() {
        String fullText = "Dear " + to + ":\n\n";
        fullText = fullText.concat(body);
        fullText = fullText.concat("\nSincerely,\n\n");
        fullText = fullText.concat(from);
        return fullText;
    }
}

