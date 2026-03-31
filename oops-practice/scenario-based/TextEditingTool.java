import java.util.Scanner;

class TextEditingTool {

    public static String autoCorrect(String para) {

        if (para == null || para.trim().isEmpty()) {
            return para;
        }

        StringBuilder sb = new StringBuilder();
        boolean capitalizeNext = true;

        for (int i = 0; i < para.length(); i++) {
            char ch = para.charAt(i);

            // Remove extra spaces
            if (ch == ' ' && (sb.length() == 0 || sb.charAt(sb.length() - 1) == ' ')) {
                continue;
            }

            // Capitalize when required
            if (Character.isLetter(ch) && capitalizeNext) {
                sb.append(Character.toUpperCase(ch));
                capitalizeNext = false;
            } else {
                sb.append(ch);
            }

            // Handle punctuation
            if (ch == '.' || ch == '!' || ch == '?') {
                capitalizeNext = true;

                // Ensure one space after punctuation
                if (i + 1 < para.length() && para.charAt(i + 1) != ' ') {
                    sb.append(' ');
                }
            }
        }

        return sb.toString().trim();
    }

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        System.out.print("Enter paragraph: ");
        String para = input.nextLine();

        String result = autoCorrect(para);
        System.out.println("Corrected paragraph:");
        System.out.println(result);
    }
}
