package varol.pelin.sena.flight_search_api.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import varol.pelin.sena.flight_search_api.service.MockService;

@RestController
@RequestMapping("/api/mock")
@RequiredArgsConstructor
public class MockController {
 private final MockService mockService;

 @GetMapping("/import/flights")
 public ResponseEntity<String> updateFlights() {
     System.out.println("controller çalıştı");
         mockService.getApiFlightData();
         return new ResponseEntity<>("Random flights datas are added to the database successfully!", HttpStatus.OK);
 }
}
