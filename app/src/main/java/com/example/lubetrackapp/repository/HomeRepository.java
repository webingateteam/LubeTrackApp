package com.example.lubetrackapp.repository;


import com.example.lubetrackapp.object.DashboardVO;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;


import java.util.ArrayList;

public class HomeRepository {

    public static ArrayList<DashboardVO> getAdminCommonFunc() {
        return new Gson().fromJson(AdminCommonFunc, new TypeToken<ArrayList<DashboardVO>>() {
        }.getType());
    }

    public static ArrayList<DashboardVO> ClientLocations() {
        return new Gson().fromJson(ClientLocations, new TypeToken<ArrayList<DashboardVO>>() {
        }.getType());
    }

    public static ArrayList<DashboardVO> EquipTypes() {
        return new Gson().fromJson(EquipTypes, new TypeToken<ArrayList<DashboardVO>>() {
        }.getType());
    }



    private static String AdminCommonFunc = "[{\n" +
            "  \"id\": \"client1\",\n" +
            "  \"icon\": \"pin\",\n" +
            "   \"name\": \"Client Locations\"\n" +
            " },\n" +
            "  {\n" +
            "  \"id\": \"Client2\",\n" +
            "  \"icon\": \"report_history\",\n" +
            "   \"name\": \"Reports\"\n" +
            " }\n" +
            "]";

    private static String ClientLocations = "[{\n" +
            "  \"id\": \"location1\",\n" +
            "  \"icon\": \"clientlocation\",\n" +
            "   \"name\": \"Location 1\"\n" +
            " },\n" +
            "  {\n" +
            "    \"id\": \"location2\",\n" +
            "    \"icon\": \"clientlocation\",\n" +
            "    \"name\": \"Location 2\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"id\": \"location3\",\n" +
            "    \"icon\": \"clientlocation\",\n" +
            "    \"name\": \"Location 3\"\n" +
            "  }\n" +
            "]";

    private static String EquipTypes = "[{\n" +
            "  \"id\": \"product11\",\n" +
            "  \"icon\": \"trap\",\n" +
            "   \"name\": \"Traps\"\n" +
            " },\n" +
            "  {\n" +
            "    \"id\": \"product52\",\n" +
            "    \"icon\": \"report_history\",\n" +
            "    \"name\": \"Reports\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"id\": \"product52\",\n" +
            "    \"icon\": \"audit_report\",\n" +
            "    \"name\": \"Documents\"\n" +
            "  }\n" +
            "]";


    private static String GreasingEquipments = "[{\n" +
            "  \"id\": \"product11\",\n" +
            "  \"icon\": \"trap\",\n" +
            "   \"name\": \"Traps\"\n" +
            " },\n" +
            "  {\n" +
            "    \"id\": \"product52\",\n" +
            "    \"icon\": \"report_history\",\n" +
            "    \"name\": \"Reports\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"id\": \"product52\",\n" +
            "    \"icon\": \"audit_report\",\n" +
            "    \"name\": \"Documents\"\n" +
            "  }\n" +
            "]";





}
