package com.example.lubetrackapp.Utils;

import com.google.gson.annotations.SerializedName;

public class BuildingResponse {
    @SerializedName("Id") private int Id;
    @SerializedName("Name") private String Name;
    @SerializedName("buildingcode") private String buildingcode;
    @SerializedName("floortitle") private String floortitle;
    @SerializedName("floorcode") private String floorcode;
    @SerializedName("zonetitle") private String zonetitle;
    @SerializedName("zonecode") private String zonecode;
    @SerializedName("active") private int active;
    @SerializedName("ClientName") private String ClientName;
    @SerializedName("LocationName") private String LocationName;
    @SerializedName("Address") private String Address;

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getBuildingcode() {
        return buildingcode;
    }

    public void setBuildingcode(String buildingcode) {
        this.buildingcode = buildingcode;
    }

    public String getFloortitle() {
        return floortitle;
    }

    public void setFloortitle(String floortitle) {
        this.floortitle = floortitle;
    }

    public String getFloorcode() {
        return floorcode;
    }

    public void setFloorcode(String floorcode) {
        this.floorcode = floorcode;
    }

    public String getZonetitle() {
        return zonetitle;
    }

    public void setZonetitle(String zonetitle) {
        this.zonetitle = zonetitle;
    }

    public String getZonecode() {
        return zonecode;
    }

    public void setZonecode(String zonecode) {
        this.zonecode = zonecode;
    }

    public int getActive() {
        return active;
    }

    public void setActive(int active) {
        this.active = active;
    }

    public String getClientName() {
        return ClientName;
    }

    public void setClientName(String ClientName) {
        this.ClientName = ClientName;
    }

    public String getLocationName() {
        return LocationName;
    }

    public void setLocationName(String LocationName) {
        this.LocationName = LocationName;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String address) {
        Address = address;
    }
}
