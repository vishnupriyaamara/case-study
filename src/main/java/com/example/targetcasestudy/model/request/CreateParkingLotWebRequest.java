package com.example.targetcasestudy.model.request;

/**
 * @author vishnupriyaamara
 * @since 12/03/21.
 */

public class CreateParkingLotWebRequest {

  private int totalStoreys;
  private int totalSlots;

  public int getTotalStoreys() {
    return totalStoreys;
  }

  public void setTotalStoreys(int totalStoreys) {
    this.totalStoreys = totalStoreys;
  }

  public int getTotalSlots() {
    return totalSlots;
  }

  public void setTotalSlots(int totalSlots) {
    this.totalSlots = totalSlots;
  }
}
