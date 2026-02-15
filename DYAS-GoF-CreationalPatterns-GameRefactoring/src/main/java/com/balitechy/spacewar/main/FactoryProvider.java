package com.balitechy.spacewar.main;

public class FactoryProvider {
    public static VisualFactory getFactory() {
        String style = System.getProperty("visual.style", "").trim().toLowerCase();
        if(style.isEmpty()) {
            // fallback: validar archivo o default
            style = "sprite";
        }
        switch(style) {
            case "vector":
            case "vectorial-style":
                return new VectorFactory();
            case "colorful-vectorial-style":
                return new ColorfulVectorFactory();
            case "sprite":
            default:
                return new SpriteFactory();
        }
    }
}
