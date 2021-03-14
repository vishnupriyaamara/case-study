package com.example.targetcasestudy.model.response;

/**
 * @author vishnupriyaamara
 * @since 12/03/21.
 */

public class ParkingLotWebResponse {

  private int freeSlots;
  private int allocatedSlots;

  public ParkingLotWebResponse(int freeSlots, int allocatedSlots) {
    this.freeSlots = freeSlots;
    this.allocatedSlots = allocatedSlots;
  }

  public int getFreeSlots() {
    return freeSlots;
  }

  public void setFreeSlots(int freeSlots) {
    this.freeSlots = freeSlots;
  }

  public int getAllocatedSlots() {
    return allocatedSlots;
  }

  public void setAllocatedSlots(int allocatedSlots) {
    this.allocatedSlots = allocatedSlots;
  }
}
