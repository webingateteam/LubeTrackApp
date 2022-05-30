package com.example.lubetrackapp.Utils;

import com.google.gson.annotations.SerializedName;

public class EquipmentMaster {

    @SerializedName("Id") private int Id;
    @SerializedName("Address") private String Address;
    @SerializedName("BuildingName") private String BuildingName;
    @SerializedName("Buildingcode") private String Buildingcode;
    @SerializedName("ClientName") private String ClientName;
    @SerializedName("Code") private String Code;
    @SerializedName("DepartmentName") private String DepartmentName;
    @SerializedName("EquipmentComponent") private String EquipmentComponent;
    @SerializedName("GreasingPoints") private int GreasingPoints;
    @SerializedName("LocationName") private String LocationName;
    @SerializedName("Name") private String Name;
    @SerializedName("contactname") private String contactname;
    @SerializedName("Active") private int Active;
    @SerializedName("Description") private String Description;


        public int getActive() {
                return Active;
        }

        public void setActive(int active) {
                Active = active;
        }

        public String getAddress() {
                return Address;
        }

        public void setAddress(String address) {
                Address = address;
        }

        public String getBuildingName() {
                return BuildingName;
        }

        public void setBuildingName(String buildingName) {
                BuildingName = buildingName;
        }

        public String getBuildingcode() {
                return Buildingcode;
        }

        public void setBuildingcode(String buildingcode) {
                Buildingcode = buildingcode;
        }

        public String getClientName() {
                return ClientName;
        }

        public void setClientName(String clientName) {
                ClientName = clientName;
        }

        public String getCode() {
                return Code;
        }

        public void setCode(String code) {
                Code = code;
        }

        public String getDepartmentName() {
                return DepartmentName;
        }

        public void setDepartmentName(String departmentName) {
                DepartmentName = departmentName;
        }

        public String getEquipmentComponent() {
                return EquipmentComponent;
        }

        public void setEquipmentComponent(String equipmentComponent) {
                EquipmentComponent = equipmentComponent;
        }

        public int getGreasingPoints() {
                return GreasingPoints;
        }

        public void setGreasingPoints(int greasingPoints) {
                GreasingPoints = greasingPoints;
        }

        public String getLocationName() {
                return LocationName;
        }

        public void setLocationName(String locationName) {
                LocationName = locationName;
        }

        public String getName() {
                return Name;
        }

        public void setName(String name) {
                Name = name;
        }

        public String getContactname() {
                return contactname;
        }

        public void setContactname(String contactname) {
                this.contactname = contactname;
        }


    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }
}
