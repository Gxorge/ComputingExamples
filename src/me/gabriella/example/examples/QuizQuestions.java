package me.gabriella.example.examples;

public enum QuizQuestions {

    TEN("What platform can you play the game Beat Saber on?", "PC", "Console", "VR", "C"),
    NINE("Android or Apple?", "Apple", "Android", "Let's not start this now!", "B"),
    EIGHT("What subject teachers does not like George?", "Science", "Drama", "Who wouldn't like George? (laughs in ego)", "B"),
    SEVEN("What country is the home to Anime?", "China", "Korea", "Japan", "C"),
    SIX("Where in the world is Mount Everest", "Japan", "Nepal and China", "Russia", "B"),
    FIVE("Which group made the song \"Rockabye\"", "Anne-Marie", "The 1975", "Clean Bandit", "C"),
    FOUR("How many computing papers are there?", "1", "2", "3", "B"),
    THREE("Which leader told people to drink disinfectants to prevent COVID-19?", "Boris Johnson", "Kim Jong Un", "Donald Trump", "C"),
    TWO("Should Year 10 and 12 exams be made easier?", "Yes", "No", "I don't really care", "A"),
    ONE("Which is the best subject?", "Drama", "Computing", "PE", "B");

    private String question;
    private String A;
    private String B;
    private String C;
    private String answer;

    private QuizQuestions(String question, String A, String B, String C, String answer) {
        this.question = question;
        this.A = A;
        this.B = B;
        this.C = C;
        this.answer = answer;
    }

    public String getQuestion() { return question; }
    public String getA() { return A; }
    public String getB() { return B; }
    public String getC() { return C; }
    public String getAnswer() { return answer; }

    public static QuizQuestions getQuestionFromInt(int q) {
        switch (q) {
            case 1:
                return ONE;
            case 2:
                return TWO;
            case 3:
                return THREE;
            case 4:
                return FOUR;
            case 5:
                return FIVE;
            case 6:
                return SIX;
            case 7:
                return SEVEN;
            case 8:
                return EIGHT;
            case 9:
                return NINE;
            case 10:
                return TEN;
            default:
                return null;
        }
    }
}
