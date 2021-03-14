package com.example.targetcasestudy.service.impl;

import org.springframework.stereotype.Service;

import com.example.targetcasestudy.entity.Car;
import com.example.targetcasestudy.entity.ParkingLot;
import com.example.targetcasestudy.entity.Slot;
import com.example.targetcasestudy.entity.Ticket;
import com.example.targetcasestudy.model.response.CarWebResponse;
import com.example.targetcasestudy.model.response.ParkingLotWebResponse;
import com.example.targetcasestudy.model.response.SlotWebResponse;
import com.example.targetcasestudy.model.response.TicketWebResponse;
import com.example.targetcasestudy.service.ParkingLotResponseConstructor;

/**
 * @author vishnupriyaamara
 * @since 13/03/21.
 */

@Service
public class ParkingLotResponseConstructorImpl implements ParkingLotResponseConstructor {

  @Override
  public ParkingLotWebResponse convert(ParkingLot parkingLot) {
    return new ParkingLotWebResponse(parkingLot.getFreeSlots().size(),
        parkingLot.getAllocatedSlots().size());
  }

  @Override
  public TicketWebResponse convert(Ticket ticket) {
    return new TicketWebResponse(ticket.getTicketNumber(), convert(ticket.getAllotedSlot()));
  }

  /**
   * Convert slot to slotWebResponse
   *
   * @param slot object to convert
   * @return slotWebResponse
   */
  private SlotWebResponse convert(Slot slot) {
    return new SlotWebResponse(slot.getStoreyNumber(), slot.getSlotNumber(),
        convert(slot.getCar()));
  }

  /**
   * Convert car to carWebResponse
   *
   * @param car object to convert
   * @return carWebResponse
   */
  private CarWebResponse convert(Car car) {
    return new CarWebResponse(car.getRegistrationNumber(), car.getColour());
  }
}
