package logica;

import igu.Pantalla;

public class AgendaElectronica {
    public static void main(String[] args) {
        Pantalla panta = new Pantalla();
        panta.setVisible(true);
        panta.setLocationRelativeTo(null);
    }
}

/*
javac -d out src/main/java/igu/Pantalla.java src/main/java/logica/AgendaElectronica.java
java -cp out logica.AgendaElectronica
*/