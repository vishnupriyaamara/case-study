package com.example.targetcasestudy.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.targetcasestudy.BusinessException;
import com.example.targetcasestudy.entity.Error;
import com.example.targetcasestudy.model.request.CreateParkingLotWebRequest;
import com.example.targetcasestudy.model.request.IssueTicketWebRequest;
import com.example.targetcasestudy.model.response.BaseResponse;
import com.example.targetcasestudy.model.response.ParkingLotWebResponse;
import com.example.targetcasestudy.model.response.TicketWebResponse;
import com.example.targetcasestudy.service.ParkingLotService;

/**
 * @author vishnupriyaamara
 * @since 12/03/21.
 */

@RestController
public class ParkingLotController {

  @Autowired
  private ParkingLotService parkingLotService;

  @PostMapping(value = "/parkingLot")
  public BaseResponse<ParkingLotWebResponse> createParkingLot(
      @RequestBody CreateParkingLotWebRequest request) {
    ParkingLotWebResponse parkingLotWebResponse = null;
    try {
      parkingLotWebResponse =
          parkingLotService.createParkingLot(request.getTotalStoreys(), request.getTotalSlots());
    } catch (BusinessException be) {
      return new BaseResponse<>(be.getMessage(), be.getCode(), false);
    } catch (Exception e) {
      return new BaseResponse<>(Error.SYSTEM_ERROR.getMessage(), Error.SYSTEM_ERROR.getCode(),
          false);
    }
    return new BaseResponse<>(true, parkingLotWebResponse);
  }

  @PostMapping(value = "/ticket")
  public BaseResponse<TicketWebResponse> issueTicket(@RequestBody IssueTicketWebRequest request) {
    TicketWebResponse ticketWebResponse = null;
    try {
      ticketWebResponse = parkingLotService.issueTicket(request);
    } catch (BusinessException be) {
      return new BaseResponse<>(be.getMessage(), be.getCode(), false);
    } catch (Exception e) {
      return new BaseResponse<>(Error.SYSTEM_ERROR.getMessage(), Error.SYSTEM_ERROR.getCode(),
          false);
    }
    return new BaseResponse<>(true, ticketWebResponse);
  }

  @PutMapping(value = "/ticket")
  public BaseResponse<ParkingLotWebResponse> exitCar(@RequestParam int slotNumber) {
    ParkingLotWebResponse parkingLotWebResponse = null;
    try {
      parkingLotWebResponse = parkingLotService.exitCar(slotNumber);
    } catch (BusinessException be) {
      return new BaseResponse<>(be.getMessage(), be.getCode(), false);
    } catch (Exception e) {
      return new BaseResponse<>(Error.SYSTEM_ERROR.getMessage(), Error.SYSTEM_ERROR.getCode(),
          false);
    }
    return new BaseResponse<>(true, parkingLotWebResponse);
  }

  @GetMapping(value = "/cars/colour")
  public BaseResponse<List<String>> findAllCarsByColour(@RequestParam String colour) {
    List<String> result;
    try {
      result = parkingLotService.findAllCarsByColour(colour);
    } catch (Exception e) {
      return new BaseResponse<>(Error.SYSTEM_ERROR.getMessage(), Error.SYSTEM_ERROR.getCode(),
          false);
    }
    return new BaseResponse<>(true, result);
  }

  @GetMapping(value = "/slot")
  public BaseResponse<Integer> findSlotByCarRegistrationNumber(
      @RequestParam String carRegistrationNumber) {
    int result;
    try {
      result = parkingLotService.findSlotByCarRegistrationNumber(carRegistrationNumber);;
    } catch (BusinessException be) {
      return new BaseResponse<>(be.getMessage(), be.getCode(), false);
    } catch (Exception e) {
      return new BaseResponse<>(Error.SYSTEM_ERROR.getMessage(), Error.SYSTEM_ERROR.getCode(),
          false);
    }
    return new BaseResponse<>(true, result);
  }

  @GetMapping(value = "/slots/colour")
  public BaseResponse<List<Integer>> findSlotsByCarColor(@RequestParam String colour) {
    List<Integer> result;
    try {
      result = parkingLotService.findSlotsByCarColor(colour);
    } catch (Exception e) {
      return new BaseResponse<>(Error.SYSTEM_ERROR.getMessage(), Error.SYSTEM_ERROR.getCode(),
          false);
    }
    return new BaseResponse<>(true, result);
  }

}
