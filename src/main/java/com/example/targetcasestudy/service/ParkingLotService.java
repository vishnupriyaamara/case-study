package com.example.targetcasestudy.service;

import java.util.List;

import com.example.targetcasestudy.model.request.IssueTicketWebRequest;
import com.example.targetcasestudy.model.response.ParkingLotWebResponse;
import com.example.targetcasestudy.model.response.TicketWebResponse;

/**
 * @author vishnupriyaamara
 * @since 12/03/21.
 */

public interface ParkingLotService {

  /**
   * Create parkingLot with given storeys and slots
   *
   * @param totalStoreys in the parkingLot
   * @param totalSlots in the parkingLot
   * @return parkingLotWebResponse
   */
  ParkingLotWebResponse createParkingLot(int totalStoreys, int totalSlots);

  /**
   * Issue ticket for the car to park at a particular slot
   *
   * @param issueTicketWebRequest details of car
   * @return ticketWebResponse
   */
  TicketWebResponse issueTicket(IssueTicketWebRequest issueTicketWebRequest);

  /**
   * Exit car from a given slot
   *
   * @param slotNumber of the car
   * @return parkingLotWebResponse
   */
  ParkingLotWebResponse exitCar(int slotNumber);

  /**
   * Find all car registration numbers with a given colour
   *
   * @param colour of the car
   * @return list of registration numbers
   */
  List<String> findAllCarsByColour(String colour);

  /**
   * Find slot number of a car with given registration number
   *
   * @param carRegistrationNumber identifier for car
   * @return slot number
   */
  int findSlotByCarRegistrationNumber(String carRegistrationNumber);

  /**
   * Find all slots with a given car colour
   *
   * @param colour of the car
   * @return list of slot numbers
   */
  List<Integer> findSlotsByCarColor(String colour);
}
