package hexlet.code.games;

import hexlet.code.Engine;

public class Even {
    private static final String INSTRUCTION = "Answer 'yes' if number even otherwise answer 'no'.";
    private static final String[] QUESTIONS = questionsInEvenGame();
    private static final String[] ANSWERS = answersInEvenGame(QUESTIONS);

    public static String[] getQuestions() {
        return QUESTIONS;
    }

    public static String[] getAnswers() {
        return ANSWERS;
    }

    public static String getInstruction() {
        return INSTRUCTION;
    }

    public static String generateQuestionInEvenGame() {
        var number = (int) ((Math.random() * Engine.getMaxRandomNumber()) + 1);
        return Integer.toString(number);
    }

    public static String[] questionsInEvenGame() {
        String[] questions = new String[Engine.ROUND_COUNT];
        for (var i = 0; i < questions.length; i++) {
            questions[i] = generateQuestionInEvenGame();
        }
        return questions;
    }

    public static String[] answersInEvenGame(String[] questions) {
        String[] answers = new String[Engine.ROUND_COUNT];
        int index = 0;
        for (var question : questions) {
            if (Integer.parseInt(question) % 2 == 0) {
                answers[index] = "yes";
            } else {
                answers[index] = "no";
            }
            index++;
        }
        return answers;
    }

}














