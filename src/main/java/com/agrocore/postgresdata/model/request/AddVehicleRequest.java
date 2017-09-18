package com.agrocore.postgresdata.model.request;

public class AddVehicleRequest {
    private String name;
    private String polygon;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPolygon() {
        return polygon;
    }

    public void setPolygon(String polygon) {
        this.polygon = polygon;
    }
}
