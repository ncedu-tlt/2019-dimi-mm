package com.ncedu.eventx.model.DTO;

public class CityDTO {

    private int id;
    private String cityId;
    private String name;

    public CityDTO() {
    }

    public CityDTO(int id, String cityId, String name) {
        this.id = id;
        this.cityId = cityId;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCityId() {
        return cityId;
    }

    public void setCityId(String cityId) {
        this.cityId = cityId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
