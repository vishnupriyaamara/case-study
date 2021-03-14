package com.example.targetcasestudy.model.response;

/**
 * @author vishnupriyaamara
 * @since 12/03/21.
 */

public class SlotWebResponse {

  private int storeyNumber;
  private int slotNumber;
  private CarWebResponse carWebResponse;

  public SlotWebResponse(int storeyNumber, int slotNumber, CarWebResponse carWebResponse) {
    this.storeyNumber = storeyNumber;
    this.slotNumber = slotNumber;
    this.carWebResponse = carWebResponse;
  }

  public int getStoreyNumber() {
    return storeyNumber;
  }

  public void setStoreyNumber(int storeyNumber) {
    this.storeyNumber = storeyNumber;
  }

  public int getSlotNumber() {
    return slotNumber;
  }

  public void setSlotNumber(int slotNumber) {
    this.slotNumber = slotNumber;
  }

  public CarWebResponse getCarWebResponse() {
    return carWebResponse;
  }

  public void setCarWebResponse(CarWebResponse carWebResponse) {
    this.carWebResponse = carWebResponse;
  }
}
