package br.com.crud_system;

import br.com.crud_system.controller.CrudController;

public class App {
    public static void main(String[] args) {
        CrudController controller = new CrudController();
        controller.iniciar();
    }
}

