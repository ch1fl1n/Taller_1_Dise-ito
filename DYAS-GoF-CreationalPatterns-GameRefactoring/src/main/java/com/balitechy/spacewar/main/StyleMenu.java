package com.balitechy.spacewar.main;

import javax.swing.JOptionPane;

public class StyleMenu {

    public static String show() {
        String[] options = {
            "Sprite (Retro)",
            "Vector",
            "Vector Colorido"
        };

        int choice = JOptionPane.showOptionDialog(
            null,
            "Seleccione el estilo visual del juego",
            "Menú de Estilo",
            JOptionPane.DEFAULT_OPTION,
            JOptionPane.INFORMATION_MESSAGE,
            null,
            options,
            options[0]
        );

        switch (choice) {
            case 1: return "vector";
            case 2: return "colorful-vectorial-style";
            case 0:
            default: return "sprite";
        }
    }
}
