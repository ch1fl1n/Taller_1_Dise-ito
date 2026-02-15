package edu.unisabana.pizzafactory.model;

public interface PizzaFactory {
    Amasador crearAmasador();
    Moldeador crearMoldeador();
    Horneador crearHorneador();
}
