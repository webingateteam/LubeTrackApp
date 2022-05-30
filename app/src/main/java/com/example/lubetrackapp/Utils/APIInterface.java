package com.example.lubetrackapp.Utils;

import com.google.gson.JsonObject;

import java.util.List;

import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;
import rx.Observable;

public interface APIInterface {

    @GET("api/Common/GetGeaserTypepaging")
    public Observable<List<EquipmentMaster>> GetGeaserTypepaging(@Query ("curpage") int curpage,
                                                                 @Query ("maxrows") int maxrows,
                                                                 @Query ("EquipmentType") int EquipmentType);

    @GET("api/Report/GetDailyReports")
    public Observable<List<ReportResponse>> GetReports(@Query ("Id") int Id);

    @GET("api/Trap/GetBuildings")
    public Observable<List<BuildingResponse>> GetBuildings(@Query ("Id") int Id);

    @GET("api/Trap/GetFloors")
    public Observable<List<BuildingResponse>> GetFloors(@Query ("Id") int Id);

    @GET("api/Trap/GetZones")
    public Observable<List<BuildingResponse>> GetZones(@Query ("Id") int Id);

    @POST("api/Users/GetUsersLogin")
    public Observable<List<UserResponse>> GetUsersLogin(@Body JsonObject jsonObject);

    @POST("api/Report/UpdateReports")
    public Observable<List<ReportResponse>> UpdateReports(@Body JsonObject jsonObject);

    @GET("api/Common/GetTypes")
    public Observable<List<BuildingResponse>> GetTypes(@Query ("Id") int Id);

    @POST("api/Users/GetForgotPassword")
    public Observable<List<UserResponse>> GetForgotPassword(@Body JsonObject jsonObject);

    @POST("api/Users/OTPVerification")
    public Observable<List<UserResponse>> OTPVerification(@Body JsonObject jsonObject);

    @POST("api/Users/UpdatePassword")
    public Observable<List<UserResponse>> UpdatePassword(@Body JsonObject jsonObject);


    @GET("api/Common/GetCustomers")
    public Observable<List<BuildingResponse>> GetCustomers(@Query ("Id") int Id);

    @GET("api/Common/GetClientLocations")
    public Observable<List<BuildingResponse>> GetCustomerLocations();

    @GET("api/Common/GetMasterDataTypeById")
    public Observable<List<EquipmentMaster>> GetTypesByGroup(@Query ("TypeGroupId") int Id);

    @GET("api/MobileApp/GetEquipments")
    public Observable<List<EquipmentMaster>> GetEquipments(@Query ("TypeId") int Id);

}
