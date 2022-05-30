package com.example.lubetrackapp.object;

import com.google.gson.annotations.SerializedName;

public class DashboardVO {

    @SerializedName("id")
    private String id;

    @SerializedName("TypeId")
    private int TypeId;

    @SerializedName("icon")
    private String icon;

    @SerializedName("name")
    private String name;

    @SerializedName("selectedicon")
    private String selectedicon;

    @SerializedName("isselected")
    private String isselected;


    public DashboardVO() {
    }

    public DashboardVO(String id, String icon, String name) {
        this.id = id;
        this.icon = icon;
        this.name = name;
    }

    public DashboardVO(String id, String icon, String name, String selectedicon) {
        this.id = id;
        this.icon = icon;
        this.name = name;
        this.selectedicon =selectedicon;

    }
    public DashboardVO(String id, String icon, String name, String selectedicon, String isselected ) {
        this.id = id;
        this.icon = icon;
        this.name = name;
        this.selectedicon =selectedicon;
        this.isselected=isselected;
    }

    public String getId() {
        return id;
    }
    public int getTypeId(){return TypeId;}

    public String getIcon() {
        return icon;
    }

    public String getSelectedIcon() {
        return selectedicon;
    }

    public String getName() {
        return name;
    }
    public String getselected() {
        return isselected;
    }

    public int setTypeId(int TypeId){
        return this.TypeId = TypeId;
    }
    public String setName(String name){
        return this.name = name;
    }
}
