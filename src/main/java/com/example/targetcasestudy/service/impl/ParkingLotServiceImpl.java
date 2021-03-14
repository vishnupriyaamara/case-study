package com.example.targetcasestudy.service.impl;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.example.targetcasestudy.BusinessException;
import com.example.targetcasestudy.entity.Car;
import com.example.targetcasestudy.entity.Error;
import com.example.targetcasestudy.entity.ParkingLot;
import com.example.targetcasestudy.entity.Slot;
import com.example.targetcasestudy.entity.Ticket;
import com.example.targetcasestudy.model.request.IssueTicketWebRequest;
import com.example.targetcasestudy.model.response.ParkingLotWebResponse;
import com.example.targetcasestudy.model.response.TicketWebResponse;
import com.example.targetcasestudy.service.ParkingLotResponseConstructor;
import com.example.targetcasestudy.service.ParkingLotService;

/**
 * @author vishnupriyaamara
 * @since 12/03/21.
 */

@Service
public class ParkingLotServiceImpl implements ParkingLotService {

  private ParkingLot parkingLot;

  @Autowired
  private ParkingLotResponseConstructor parkingLotResponseConstructor;

  @Override
  public ParkingLotWebResponse createParkingLot(int totalStoreys, int totalSlots) {
    if (totalSlots <= 0 || totalStoreys <= 0 || totalSlots % totalStoreys != 0) {
      throw new BusinessException(Error.INVALID_INPUT_FOR_STOREYS_AND_SLOTS);
    }
    parkingLot = ParkingLot.getInstance(totalStoreys, totalSlots);

    return parkingLotResponseConstructor.convert(parkingLot);
  }

  @Override
  public TicketWebResponse issueTicket(IssueTicketWebRequest issueTicketWebRequest) {
    validateRequest(issueTicketWebRequest);
    Ticket ticket = new Ticket(allocateSlot(issueTicketWebRequest));

    return parkingLotResponseConstructor.convert(ticket);
  }

  @Override
  public ParkingLotWebResponse exitCar(int slotNumber) {
    Optional<Slot> slotOptional = parkingLot.getAllocatedSlots().stream()
        .filter(slot -> slot.getSlotNumber() == slotNumber)
        .findFirst();

    if (!slotOptional.isPresent()) {
      throw new BusinessException(Error.SLOT_IS_ALREADY_FREE);
    }
    parkingLot.getAllocatedSlots().remove(slotOptional.get());
    parkingLot.getFreeSlots().add(slotOptional.get());

    return parkingLotResponseConstructor.convert(parkingLot);
  }

  @Override
  public List<String> findAllCarsByColour(String colour) {
    return parkingLot.getAllocatedSlots().stream()
        .filter(slot -> slot.getCar().getColour().equals(colour))
        .map(slot -> slot.getCar().getRegistrationNumber())
        .collect(Collectors.toList());
  }

  @Override
  public int findSlotByCarRegistrationNumber(String carRegistrationNumber) {
    Optional<Slot> optionalSlot = parkingLot.getAllocatedSlots().stream()
        .filter(slot -> slot.getCar().getRegistrationNumber().equals(carRegistrationNumber))
        .findFirst();

    if (!optionalSlot.isPresent()) {
      throw new BusinessException(Error.NO_CAR_WITH_REG_NUMBER);
    }

    return optionalSlot.get().getSlotNumber();
  }

  @Override
  public List<Integer> findSlotsByCarColor(String colour) {
    return parkingLot.getAllocatedSlots().stream()
        .filter(slot -> slot.getCar().getColour().equals(colour))
        .map(Slot::getSlotNumber)
        .collect(Collectors.toList());
  }

  /**
   * Validates car details to issue ticket
   *
   * @param issueTicketWebRequest details of car
   */
  private void validateRequest(IssueTicketWebRequest issueTicketWebRequest) {
    if(!StringUtils.hasLength(issueTicketWebRequest.getCarRegistrationNumber())){
      throw new BusinessException(Error.CAR_REGISTRATION_NUMBER_BLANK);
    }
    if(!StringUtils.hasLength(issueTicketWebRequest.getCarColour())){
      throw new BusinessException(Error.CAR_COLOUR_BLANK);
    }

    Optional<Slot> slotOptional = parkingLot.getAllocatedSlots().stream()
        .filter(slot -> slot.getCar().getRegistrationNumber()
            .equals(issueTicketWebRequest.getCarRegistrationNumber()))
        .findFirst();

    if (slotOptional.isPresent()) {
      throw new BusinessException(Error.REGISTRATION_NUMBER_ALREADY_EXIST);
    }
  }

  /**
   * Allocate slot to park the car
   *
   * @param issueTicketWebRequest details of car
   * @return allocated slot
   */
  private Slot allocateSlot(IssueTicketWebRequest issueTicketWebRequest) {
    if (parkingLot.getFreeSlots().size() == 0) {
      throw new BusinessException(Error.NO_FREE_SLOTS_AVAILABLE);
    }

    Slot slot = parkingLot.getFreeSlots().first();
    parkingLot.getFreeSlots().remove(slot);
    slot.setCar(new Car(issueTicketWebRequest.getCarRegistrationNumber(),
        issueTicketWebRequest.getCarColour()));
    parkingLot.getAllocatedSlots().add(slot);

    return slot;
  }

}
