package Incident;

import android.content.Intent;

import com.google.android.gms.maps.model.LatLng;

public class Incident {

    String recordid;
    String calldatetime;
    String priority;
    String district;
    String description;
    String callnumber;
    String incidentlocation;
    LatLng location;
    String locationState;
    String locationAddress;
    String locationZip;
    String locationCity;


    public Incident(String a, String b, String c, String d, String e, LatLng f, String g, String h, String i, String j, String k, String l)
    {
        calldatetime = a;
        callnumber = b;
        description = c;
        district = d;
        incidentlocation = e;
        location = f;
        locationAddress = g;
        locationCity = h;
        locationState = i;
        locationZip = j;
        priority = k;
        recordid = l;
    }

    String getRecordID(){
        return recordid;
    }

    String getCalldatetime(){
        return calldatetime;
    }

    String getPriority(){
        return priority;
    }

    String getDistrict(){
        return district;
    }

    String getDescription(){
        return description;
    }

    String getCallumber(){
        return callnumber;
    }

    String getRecordid(){
        return recordid;
    }

    String getIncidentlocation(){
        return incidentlocation;
    }

    LatLng getLocation(){
        return location;
    }

    String getLocationState(){
        return locationState;
    }

    String getLocationAddress(){
        return locationAddress;
    }

    String getLocationZip(){
        return locationZip;
    }

    String getLocationCity(){
        return locationCity;
    }

    public void setRecordid(String recordid) {
        this.recordid = recordid;
    }

    public void setCalldatetime(String calldatetime) {
        this.calldatetime = calldatetime;
    }

    public void setPriority(String priority) {
        this.priority = priority;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setCallnumber(String callnumber) {
        this.callnumber = callnumber;
    }

    public void setIncidentlocation(String incidentlocation) {
        this.incidentlocation = incidentlocation;
    }

    public void setLocation(LatLng location) {
        this.location = location;
    }

    public void setLocationState(String locationState) {
        this.locationState = locationState;
    }

    public void setLocationAddress(String locationAddress) {
        this.locationAddress = locationAddress;
    }

    public void setLocationZip(String locationZip) {
        this.locationZip = locationZip;
    }

    public void setLocationCity(String locationCity) {
        this.locationCity = locationCity;
    }





}
