package com.example.targetcasestudy.entity;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.SortedSet;
import java.util.TreeSet;

/**
 * @author vishnupriyaamara
 * @since 12/03/21.
 */

public class ParkingLot {

  private static ParkingLot parkingLot = null;

  private int totalStoreys;
  private int totalSlots;
  private List<Slot> allocatedSlots;
  private SortedSet<Slot> freeSlots;

  public static ParkingLot getInstance(int totalStoreys, int totalSlots) {
    if (parkingLot == null) {
      return new ParkingLot(totalStoreys, totalSlots);
    }
    return parkingLot;
  }

  private ParkingLot(int totalStoreys, int totalSlots) {
    this.allocatedSlots = new ArrayList<>();
    this.freeSlots = new TreeSet<>(Comparator.comparing(Slot::getSlotNumber));

    this.totalStoreys = totalStoreys;
    this.totalSlots = totalSlots;

    int slotsPerStorey = totalSlots / totalStoreys;

    for (int i = 1; i <= totalStoreys; i++) {
      for (int j = (100 * i) + 1; j <= (100 * i) + slotsPerStorey; j++) {
        this.freeSlots.add(new Slot(j, i));
      }
    }
    System.out.println("Created parkingLot with totalSlots: " + totalSlots);
  }

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

  public SortedSet<Slot> getFreeSlots() {
    return freeSlots;
  }

  public void setFreeSlots(SortedSet<Slot> freeSlots) {
    this.freeSlots = freeSlots;
  }

  public List<Slot> getAllocatedSlots() {
    return allocatedSlots;
  }
}
