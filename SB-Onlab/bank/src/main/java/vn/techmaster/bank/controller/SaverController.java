package vn.techmaster.bank.controller;

import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import vn.techmaster.bank.request.CloseSaverRequest;
import vn.techmaster.bank.request.OpenSaverRequest;
import vn.techmaster.bank.response.OpenSaver;
import vn.techmaster.bank.service.SaverService;

@RestController
@RequestMapping("/saver")
public class SaverController {

    @Autowired private SaverService saverService;

    @PostMapping("/open-in-account-source")
    @Operation(summary = "Open saver account")
    public ResponseEntity<OpenSaver> Open(@RequestBody OpenSaverRequest saverRequest){
        return ResponseEntity.ok(saverService.deposit(saverRequest));
    }

    @PostMapping("/close-in-account-source")
    @Operation(summary = "Close saver account")
    public ResponseEntity<String> Close(@RequestBody CloseSaverRequest saverRequest){
        return ResponseEntity.ok(saverService.close(saverRequest));
    }

}
