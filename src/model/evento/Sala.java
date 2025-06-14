package model.evento;

public class Sala {
    private String numero;
    private String predio;

    public Sala(String numero, String predio) {
        this.numero = numero;
        this.predio = predio;
    }

    @Override
    public String toString() {
        return "Sala " + numero + " - Prédio " + predio;
    }
}