import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class MBTIPersonalityTest {

    public static void main(String[] args) {
        administerMBTITest();
    }

    private static void administerMBTITest() {
        String[] questions = {
                "1) A. Expend energy, enjoy groups.          B. Conserve energy, one-on-one",
                "2) A. Interpret literally.                 B. Look for meaning and possibilities",
                "3) A. Logical, thinking, questioning.      B. Empathetic, feeling, accommodating",
                "4) A. Organized, orderly.                  B. Flexible, adaptable",
                "5) A. More outgoing, think out loud.       B. More reserved, think to yourself.",
                "6) A. Practical, realistic, experiential.  B. Imagination, innovative, theoretical.",
                "7) A. Candid, straight forward, frank.     B. Tactful, kind, encouraging.",
                "8) A. Plan, schedule.                      B. Unplanned, spontaneous",
                "9) A. Seek many tasks, public activities, interaction with others.  B. Seek private, solitary activities with quiet to concentrate.",
                "10) A. Standard, usual, conventional.      B. Different, novel, unique.",
                "11) A. Firm, tend to criticize, hold the line.  B. Gentle, tend to appreciate, conciliate.",
                "12) A. Regulated, structured.              B. Easygoing, live and let live.",
                "13) A. External, communicative, express yourself.  B. Internal, reticent, keep to yourself.",
                "14) A. Focus on here-and-now.              B. Look to the future, global perspective, 'big picture'.",
                "15) A. Tough-minded, just.                 B. Tender-hearted, merciful.",
                "16) A. Preparation, plan ahead.            B. Go with the flow, adapt as you go.",
                "17) A. Active, initiate.                   B. Reflective, deliberate.",
                "18) A. Facts, things, 'what is'.           B. Ideas, dreams, 'what could be', philosophical.",
                "19) A. Matter of fact, issue oriented.     B. Sensitive, people-oriented, compassionate.",
                "20) A. Control, govern.                    B. Latitude, freedom."
        };

        Map<Integer, String> responses = new HashMap<>();

        System.out.print("Enter your name: ");
        Scanner scanner = new Scanner(System.in);
        String userName = scanner.nextLine();

        System.out.println("\nHello " + userName + ". You selected: \n");

        System.out.println("Welcome to the MBTI Personality Test!");
        System.out.println("For each question, enter your response as 'A' or 'B'.");
        System.out.println("----------------------------------------------------");

        for (int i = 0; i < questions.length; i++) {
            while (true) {
                System.out.println(questions[i]);
                String userInput = scanner.nextLine().trim().toLowerCase();
                if (userInput.equals("a") || userInput.equals("b")) {
                    responses.put(i + 1, userInput.toUpperCase());
                    break;
                } else {
                    System.out.println("Invalid input. Please enter 'A' or 'B'.");
                }
            }
        }

        scanner.close();

        System.out.println("\nThank you for completing the test!");
        System.out.println("Your responses:");

        int groupSize = 5;
        for (int i = 1; i <= questions.length; i++) {
            System.out.println(responses.get(i));
            if (i % groupSize == 0 || i == questions.length) {
                int startQuestion = (i / groupSize) * groupSize - groupSize + 1;
                int endQuestion = i;
                int countA = 0;
                int countB = 0;
                for (int j = startQuestion; j <= endQuestion; j++) {
                    if (responses.get(j).equals("A")) {
                        countA++;
                    } else {
                        countB++;
                    }
                }
                System.out.println("\nNumber of A selected: " + countA);
                System.out.println("Number of B selected: " + countB);
                System.out.println();
            }
        }

        displayPersonalityTrait(responses);
    }

    private static void displayPersonalityTrait(Map<Integer, String> responses) {
        int countA = 0, countB = 0;
        for (String response : responses.values()) {
            if (response.equals("A")) {
                countA++;
            } else {
                countB++;
            }
        }

        StringBuilder personalityTrait = new StringBuilder();
        personalityTrait.append(countA >= 10 ? "I" : "E");
        personalityTrait.append(countA % 2 == 0 ? "S" : "N");
        personalityTrait.append(countA % 4 < 2 ? "T" : "F");
        personalityTrait.append(countA % 8 < 4 ? "J" : "P");

        System.out.println("\nYour personality trait:");
        System.out.println(personalityTrait.toString());
    }
}
