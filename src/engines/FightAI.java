package engines;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public class FightAI extends Fight{
    private final ArrayList<Element> playerMoves = new ArrayList<>();

    public void addPlayerMove(Element element) {
        playerMoves.add(element);
    }

    public Element generateRandomMove() {
        int randomElementNumber = new Random().nextInt(5);
        return Element.values()[randomElementNumber];
    }

    // Markov Chains
    public Element generateMove(int depth) {
        Element opponentsElement;
        if (playerMoves.isEmpty()) {
            opponentsElement = generateRandomMove();
        } else {
            int n = playerMoves.size();
            while (n <= depth) {
                depth--;
            }
            if (depth > 1) {
                Element[] combination = new Element[depth];
                for (int i = 1; i <= depth; i++) {
                    combination[depth - i] = playerMoves.get(n - i);
                }
                System.out.println(playerMoves);
                System.out.println(Arrays.toString(combination));

                Element mostLikelyChoice = null;
                for (int tmpDepth = depth; tmpDepth > 1; tmpDepth--) {
                    int numberOfCoincidences = 0;
                    for (int i = 0; i < n - 1; i++) {
                        if (numberOfCoincidences == tmpDepth) {
                            mostLikelyChoice = playerMoves.get(i);
                            break;
                        }
                        if (playerMoves.get(i) == combination[numberOfCoincidences]) {
                            numberOfCoincidences++;
                        } else {
                            numberOfCoincidences = 0;
                        }
                    }
                    if (mostLikelyChoice != null) {
                        break;
                    } else {
                        System.arraycopy(combination, 1, combination, 0, tmpDepth - 1);
                        System.out.print("Depth " + tmpDepth + " : ");
                        System.out.println(Arrays.toString(combination));
                    }
                }
                if (mostLikelyChoice == null) {
                    opponentsElement = generateRandomMove();
                } else {
                    Element[] weakneses = rules.get(mostLikelyChoice);
                    opponentsElement = weakneses[0];
                    System.out.println("The Most Likely Choice " + mostLikelyChoice);
                }

            } else {
                opponentsElement = generateRandomMove();
            }
        }

        return opponentsElement;
    }
}
