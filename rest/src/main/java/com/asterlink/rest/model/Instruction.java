package com.asterlink.rest.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

/**
 * Instruction class.
 * Outlines the instruction that are sent to/between sentinel devices.
 * @author gl3bert
 */

@Entity
@Table(name="instructions")
public class Instruction {

    @Id
    @Column(name = "instruction_id")
    @JsonProperty("instruction_id")
    private int instructionId;

    @Column(name = "sentinel_id")
    @JsonProperty("sentinel_id")
    private long sentinelId;

    @Column(name = "device_id")
    @JsonProperty("device_id")
    private long deviceId;

    @Column(name = "instruction_type")
    @JsonProperty("instruction_type")
    private int instructionType;

    @Column(name = "status")
    @JsonProperty("status")
    private int status;

    @Column(name = "error_id")
    @JsonProperty("error_id")
    private int errorId;

    // Default empty constructor.
    public Instruction() {}

    // Default constructor.
    public Instruction(
            @JsonProperty("sentinel_id") long sentinelId,
            @JsonProperty("device_id") long deviceId,
            @JsonProperty("instruction_type") int instructionType) {
        this.sentinelId = sentinelId;
        this.deviceId = deviceId;
        this.instructionType = instructionType;
        this.status = 0;
        this.errorId = 0;
    }

    // Default constructor.
    public Instruction(long sentinelId, long deviceId, int instructionType, int status, int errorId) {
        this.sentinelId = sentinelId;
        this.deviceId = deviceId;
        this.instructionType = instructionType;
        this.status = status;
        this.errorId = errorId;
    }

    // Getters and Setters.
    public int getInstructionId() { return instructionId; }
    public void setInstructionId(int instructionId) { this.instructionId = instructionId; }
    public long getSentinelId() { return sentinelId; }
    public void setSentinelId(int sentinelId) { this.sentinelId = sentinelId; }
    public long getDeviceId() { return deviceId; }
    public void setDeviceId(int deviceId) { this.deviceId = deviceId; }
    public int getTypeId() { return instructionType; }
    public void setInstructionType(int instructionType) { this.instructionType = instructionType; }
    public int getStatus() { return status; }
    public void setStatus(int status) { this.status = status; }
    public int getErrorId() { return errorId; }
    public void setErrorId(int errorId) { this.errorId = errorId; }
}
