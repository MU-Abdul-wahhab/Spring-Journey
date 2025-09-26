package com.spring.journey.beans;

public class Phone {
    private String brand = "Samsung";
    private String model = "S24 Ultra";

    private Display display;
    private BackPanel backPanel;
    private OS os;

    public OS getOs() {
        return os;
    }

    public void setOs(OS os) {
        this.os = os;
    }

    public BackPanel getBackPanel() {
        return backPanel;
    }

    public void setBackPanel(BackPanel backPanel) {
        this.backPanel = backPanel;
    }

    public Display getDisplay() {
        return display;
    }

    public void setDisplay(Display display) {
        this.display = display;
    }

    public String getBrand() {
        return brand;
    }

    public String getModel() {
        return model;
    }
}
