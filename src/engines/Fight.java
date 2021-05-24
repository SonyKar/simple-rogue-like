package engines;

import java.util.HashMap;

/*
 * Fire -> Wood
 * Fire -> Metal
 * Earth -> Fire
 * Earth -> Water
 * Metal -> Earth
 * Metal -> Wood
 * Water -> Metal
 * Water -> Fire
 * Wood -> Water
 * Wood -> Earth
 */

public class Fight {
    public enum Element {
        FIRE, // 0
        WOOD, // 1
        METAL, // 2
        WATER, // 3
        EARTH // 4
    }

    /*protected static final HashMap<Element, Element[]> rules = new HashMap<>() {{
        put(Element.FIRE, new Element[]{Element.WOOD, Element.METAL});
        put(Element.EARTH, new Element[]{Element.FIRE, Element.WATER});
        put(Element.METAL, new Element[]{Element.EARTH, Element.WOOD});
        put(Element.WATER, new Element[]{Element.FIRE, Element.METAL});
        put(Element.WOOD, new Element[]{Element.WATER, Element.EARTH});
    }};*/

    protected static final HashMap<Element, Element[]> rules = new HashMap<>() {{
        put(Element.FIRE, new Element[]{Element.EARTH, Element.WATER});
        put(Element.EARTH, new Element[]{Element.METAL, Element.WOOD});
        put(Element.METAL, new Element[]{Element.FIRE, Element.WATER});
        put(Element.WATER, new Element[]{Element.EARTH, Element.WOOD});
        put(Element.WOOD, new Element[]{Element.METAL, Element.FIRE});
    }};
}
