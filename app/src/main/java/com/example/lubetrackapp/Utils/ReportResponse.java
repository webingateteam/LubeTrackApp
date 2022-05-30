package com.example.lubetrackapp.Utils;

import com.google.gson.annotations.SerializedName;

public class ReportResponse {

    @SerializedName("Id") private int Id;
    @SerializedName("TrapCode") private String TrapCode;
    @SerializedName("Reportdatetime") private String Reportdatetime;
    @SerializedName("scannedon") private String scannedon;
    @SerializedName("TypeofInfestation") private int TypeofInfestation;
    @SerializedName("Reportdate") private String Reportdate;
    @SerializedName("notscannedcount") private int notscannedcount;
    @SerializedName("scannedcount") private int scannedcount;
    @SerializedName("totalcount") private int totalcount;
    @SerializedName("clientsign") private String clientsign;
    @SerializedName("supervisorsign") private String supervisorsign;
    @SerializedName("sapprovaltime") private String sapprovaltime;
    @SerializedName("capprovaltime") private String capprovaltime;
    @SerializedName("clientapproval") private int clientapproval;
    @SerializedName("supervisorapproval") private int supervisorapproval;
    @SerializedName("clientsignstatus") private int clientsignstatus;
    @SerializedName("supervisorsignstatus") private int supervisorsignstatus;
    @SerializedName("ReportTitle") private String ReportTitle;
    @SerializedName("SSignImageURL") private String SSignImageURL;
    @SerializedName("CSignImageURL") private String CSignImageURL;




    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public String getTrapCode() {
        return TrapCode;
    }

    public void setTrapCode(String trapCode) {
        TrapCode = trapCode;
    }

    public String getReportdatetime() {
        return Reportdatetime;
    }

    public void setReportdatetime(String reportdatetime) {
        Reportdatetime = reportdatetime;
    }

    public String getScannedon() {
        return scannedon;
    }

    public void setScannedon(String scannedon) {
        this.scannedon = scannedon;
    }

    public int getTypeofInfestation() {
        return TypeofInfestation;
    }

    public void setTypeofInfestation(int typeofInfestation) {
        TypeofInfestation = typeofInfestation;
    }

    public String getReportdate() {
        return Reportdate;
    }

    public void setReportdate(String reportdate) {
        Reportdate = reportdate;
    }

    public int getNotscannedcount() {
        return notscannedcount;
    }

    public void setNotscannedcount(int notscannedcount) {
        this.notscannedcount = notscannedcount;
    }

    public int getScannedcount() {
        return scannedcount;
    }

    public void setScannedcount(int scannedcount) {
        this.scannedcount = scannedcount;
    }

    public int getTotalcount() {
        return totalcount;
    }

    public void setTotalcount(int totalcount) {
        this.totalcount = totalcount;
    }

    public String getClientsign() {
        return clientsign;
    }

    public void setClientsign(String clientsign) {
        this.clientsign = clientsign;
    }

    public String getSupervisorsign() {
        return supervisorsign;
    }

    public void setSupervisorsign(String supervisorsign) {
        this.supervisorsign = supervisorsign;
    }

    public String getSapprovaltime() {
        return sapprovaltime;
    }

    public void setSapprovaltime(String sapprovaltime) {
        this.sapprovaltime = sapprovaltime;
    }

    public String getCapprovaltime() {
        return capprovaltime;
    }

    public void setCapprovaltime(String capprovaltime) {
        this.capprovaltime = capprovaltime;
    }

    public int getClientapproval() {
        return clientapproval;
    }

    public void setClientapproval(int clientapproval) {
        this.clientapproval = clientapproval;
    }

    public int getSupervisorapproval() {
        return supervisorapproval;
    }

    public void setSupervisorapproval(int supervisorapproval) {
        this.supervisorapproval = supervisorapproval;
    }

    public int getClientsignstatus() {
        return clientsignstatus;
    }

    public void setClientsignstatus(int clientsignstatus) {
        this.clientsignstatus = clientsignstatus;
    }

    public int getSupervisorsignstatus() {
        return supervisorsignstatus;
    }

    public void setSupervisorsignstatus(int supervisorsignstatus) {
        this.supervisorsignstatus = supervisorsignstatus;
    }

    public String getReportTitle() {
        return ReportTitle;
    }

    public void setReportTitle(String reportTitle) {
        ReportTitle = reportTitle;
    }

    public String getSSignImageURL() {
        return SSignImageURL;
    }

    public void setSSignImageURL(String SSignImageURL) {
        this.SSignImageURL = SSignImageURL;
    }

    public String getCSignImageURL() {
        return CSignImageURL;
    }

    public void setCSignImageURL(String CSignImageURL) {
        this.CSignImageURL = CSignImageURL;
    }
}
