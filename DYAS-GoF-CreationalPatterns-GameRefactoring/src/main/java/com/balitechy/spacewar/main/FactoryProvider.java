package com.balitechy.spacewar.main;

public class FactoryProvider {

    public static VisualFactory getFactory(String style) {

        if (style == null || style.isEmpty()) {
            style = "sprite";
        }

        switch (style.toLowerCase()) {
            case "vector":
                return new VectorFactory();

            case "colorful-vectorial-style":
                return new ColorfulVectorFactory();

            case "sprite":
            default:
                return new SpriteFactory();
        }
    }
}
