package com.example.targetcasestudy.entity;

/**
 * @author vishnupriyaamara
 * @since 12/03/21.
 */

public class Slot {

  private int slotNumber;
  private int storeyNumber;
  private Car car;

  public Slot(int slotNumber, int storeyNumber) {
    this.slotNumber = slotNumber;
    this.storeyNumber = storeyNumber;
  }

  public int getSlotNumber() {
    return slotNumber;
  }

  public void setSlotNumber(int slotNumber) {
    this.slotNumber = slotNumber;
  }

  public int getStoreyNumber() {
    return storeyNumber;
  }

  public void setStoreyNumber(int storeyNumber) {
    this.storeyNumber = storeyNumber;
  }

  public Car getCar() {
    return car;
  }

  public void setCar(Car car) {
    this.car = car;
  }

}
