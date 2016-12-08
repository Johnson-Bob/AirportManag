package com.brainacademy.airport.model;

import java.io.Serializable;

/**
 * Created by gladi on 22.11.2016.
 */
public class Terminals implements Model {
    private int terminalId;
    private String terminal;

    public Terminals() {
    }

    public String getTerminal() {
        return terminal;
    }

    public void setTerminal(String terminal) {
        this.terminal = terminal;
    }

    @Override
    public int getId() {
        return terminalId;
    }

    @Override
    public void setId(int id) {
        terminalId = id;
    }
}
