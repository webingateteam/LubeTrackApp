package com.example.lubetrackapp.Utils;

import com.google.gson.annotations.SerializedName;

public class AuditReportResponse {

    @SerializedName("Id") private int Id;
    @SerializedName("flag") private String flag;
    @SerializedName("description") private String description;
    @SerializedName("Reportdatetime") private String Reportdatetime;
    @SerializedName("supervisorApprovalTime") private String supervisorApprovalTime;
    @SerializedName("Supervisorcomments") private String Supervisorcomments;
    @SerializedName("conductedBy") private int conductedBy;
    @SerializedName("reportcontent") private String reportcontent;
    @SerializedName("InspectedArea") private String InspectedArea;
    @SerializedName("Issue") private String Issue;
    @SerializedName("TypeOfInfestation") private String TypeOfInfestation;
    @SerializedName("ActionPlanSuggested") private String ActionPlanSuggested;
    @SerializedName("ClientActionPlanSuggested") private String ClientActionPlanSuggested;
    @SerializedName("ActionTaken") private String ActionTaken;
    @SerializedName("ClientActionTaken") private String ClientActionTaken;
    @SerializedName("AuditReportImgContent") private String AuditReportImgContent;
    @SerializedName("ActionTakenOn") private String ActionTakenOn;
    @SerializedName("ClientActionTakenOn") private String ClientActionTakenOn;

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public String getFlag(){return flag;}
    public void setFlag(String Flag){
        flag = Flag;
    }

    public String getDescription(){return description;}
    public void setDescription(String Description){
        description = Description;
    }
    public String getReportdatetime(){return Reportdatetime;}
    public void setReportdatetime(String Reportdate){
        Reportdatetime = Reportdate;
    }


}
