package com.example.targetcasestudy.service;

import com.example.targetcasestudy.entity.ParkingLot;
import com.example.targetcasestudy.entity.Ticket;
import com.example.targetcasestudy.model.response.ParkingLotWebResponse;
import com.example.targetcasestudy.model.response.TicketWebResponse;

/**
 * @author vishnupriyaamara
 * @since 13/03/21.
 */
public interface ParkingLotResponseConstructor {

  /**
   * Convert parkingLot to parkingLotWebResponse
   *
   * @param parkingLot object to convert
   * @return parkingLotWebResponse
   */
  ParkingLotWebResponse convert(ParkingLot parkingLot);

  /**
   * Convert ticket to ticketWebResponse
   *
   * @param ticket object to convert
   * @return ticketWebResponse
   */
  TicketWebResponse convert(Ticket ticket);
}
