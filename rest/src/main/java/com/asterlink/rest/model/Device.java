package com.asterlink.rest.model;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.MappedSuperclass;
import jakarta.persistence.Column;
import jakarta.persistence.Id;

/**
 * Abstract class for devices.
 * Outlines shared properties.
 * @author jrubow
 */

@MappedSuperclass
public abstract class Device {

    @Id
    @Column(name = "device_id")
    @JsonProperty("device_id")  // Enforce consistent JSON field name
    private long deviceId;

    @Column(name = "latitude")
    @JsonProperty("latitude")
    private double latitude;

    @Column(name = "longitude")
    @JsonProperty("longitude")
    private double longitude;

    @Column(name = "battery_life")
    @JsonProperty("battery_life")
    private double batteryLife;

    @Column(name = "last_online")
    @JsonProperty("last_online")
    private LocalDateTime lastOnline;

    @Column(name = "deployed")
    @JsonProperty("deployed")
    private boolean deployed;

    @Column(name = "deployed_date")
    @JsonProperty("deployed_date")
    private LocalDateTime deployedDate;

    @Column(name = "is_connected")
    @JsonProperty("is_connected")
    private boolean isConnected;

    // Default constructor
    public Device() {}

    // Parameterized constructor
    public Device(long deviceId, double latitude, double longitude, double batteryLife, LocalDateTime lastOnline,
                    LocalDateTime deployedDate, boolean deployed) {
        this.deviceId = deviceId;
        this.latitude = latitude;
        this.longitude = longitude;
        this.batteryLife = batteryLife;
        this.lastOnline = lastOnline;
        this.deployed = deployed;
        this.deployedDate = deployedDate;
        this.isConnected = false;
    }

    // Short constructor
    public Device(long deviceId) {
        this.deviceId = deviceId;
        this.latitude = 0.0;
        this.longitude = 0.0;
        this.batteryLife = 0.0;
        this.lastOnline = null;
        this.deployed = false;
        this.deployedDate = null;
        this.isConnected = false;
    }

    // Getters and Setters
    public long getDeviceId() { return deviceId; }
    public void setDeviceId(int deviceId) { this.deviceId = deviceId; }
    public double getLatitude() { return latitude; }
    public void setLatitude(double latitude) { this.latitude = latitude; }
    public double getBatteryLife() { return batteryLife; }
    public void setBatteryLife(double batteryLife) { this.batteryLife = batteryLife; }
    public LocalDateTime getLastOnline() { return lastOnline; }
    public void setLastOnline(LocalDateTime lastOnline) { this.lastOnline = lastOnline; }
    public double getLongitude() { return longitude; }
    public void setLongitude(double longitude) { this.longitude = longitude; }
    public boolean isDeployed() { return deployed; }
    public void setDeployed(boolean deployed) { this.deployed = deployed; }
    public LocalDateTime getDeployedDate() { return deployedDate; }
    public void setDeployedDate(LocalDateTime deployedDate) { this.deployedDate = deployedDate; }
    public boolean getIsConnected() { return isConnected; }
    public void setIsConnected(boolean isConnected) { this.isConnected = isConnected; }
}
