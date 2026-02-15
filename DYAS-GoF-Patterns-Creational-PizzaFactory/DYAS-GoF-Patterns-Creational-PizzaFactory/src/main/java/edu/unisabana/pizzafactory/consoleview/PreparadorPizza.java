package edu.unisabana.pizzafactory.consoleview;

import edu.unisabana.pizzafactory.model.*;
import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;


public class PreparadorPizza {

    private final PizzaFactory factory;

    public PreparadorPizza(PizzaFactory factory) {
        this.factory = factory;
    }

    public static void main(String[] args) {

        try {
            // ===== MENÚ TIPO DE PIZZA =====
            String[] tiposPizza = {
                "Pizza delgada",
                "Pizza gruesa",
                "Pizza integral"
            };

            int opcionPizza = JOptionPane.showOptionDialog(
                    null,
                    "Seleccione el tipo de pizza",
                    "Fábrica de Pizzas",
                    JOptionPane.DEFAULT_OPTION,
                    JOptionPane.INFORMATION_MESSAGE,
                    null,
                    tiposPizza,
                    tiposPizza[0]
            );

            if (opcionPizza == -1) {
                System.exit(0);
            }

            PizzaFactory factory;

            switch (opcionPizza) {
                case 0:
                    factory = new PizzaDelgadaFactory();
                    break;
                case 1 :
                    factory = new PizzaGruesaFactory();
                    break;
                case 2:
                    factory = new PizzaIntegralFactory();
                    break;
                default:
                    throw new ExcepcionParametrosInvalidos("Tipo de pizza inválido");
            }

            // ===== MENÚ TAMAÑO =====
            String[] tamanos = {"Pequeña", "Mediana"};

            int opcionTam = JOptionPane.showOptionDialog(
                    null,
                    "Seleccione el tamaño de la pizza",
                    "Tamaño",
                    JOptionPane.DEFAULT_OPTION,
                    JOptionPane.QUESTION_MESSAGE,
                    null,
                    tamanos,
                    tamanos[0]
            );

            if (opcionTam == -1) {
                System.exit(0);
            }

            Tamano tam = (opcionTam == 0) ? Tamano.PEQUENO : Tamano.MEDIANO;

            // ===== INGREDIENTES (FIJOS POR AHORA) =====
            Ingrediente[] ingredientes = {
                new Ingrediente("queso", 1),
                new Ingrediente("jamon", 2)
            };

            PreparadorPizza preparador = new PreparadorPizza(factory);
            preparador.prepararPizza(ingredientes, tam);

            JOptionPane.showMessageDialog(
                    null,
                    "¡Pizza preparada con éxito! 🍕",
                    "Proceso finalizado",
                    JOptionPane.INFORMATION_MESSAGE
            );

        } catch (ExcepcionParametrosInvalidos e) {
            Logger.getLogger(PreparadorPizza.class.getName())
                    .log(Level.SEVERE, e.getMessage(), e);

            JOptionPane.showMessageDialog(
                    null,
                    e.getMessage(),
                    "Error",
                    JOptionPane.ERROR_MESSAGE
            );
        }
    }

    public void prepararPizza(Ingrediente[] ingredientes, Tamano tam)
            throws ExcepcionParametrosInvalidos {

        Amasador am = factory.crearAmasador();
        Moldeador mp = factory.crearMoldeador();
        Horneador hpd = factory.crearHorneador();

        am.amasar();

        if (tam == Tamano.PEQUENO) {
            mp.moldearPizzaPequena();
        } else if (tam == Tamano.MEDIANO) {
            mp.moldearPizzaMediana();
        } else {
            throw new ExcepcionParametrosInvalidos("Tamaño inválido: " + tam);
        }

        aplicarIngredientes(ingredientes);
        hpd.hornear();
    }

    private void aplicarIngredientes(Ingrediente[] ingredientes) {
        Logger.getLogger(PreparadorPizza.class.getName())
                .log(Level.INFO, "APLICANDO INGREDIENTES: {0}",
                        Arrays.toString(ingredientes));
    }
}
