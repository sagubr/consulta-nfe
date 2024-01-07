package br.com.bgs.consultanfe.controller;

import br.com.bgs.consultanfe.entities.Address;
import br.com.bgs.consultanfe.services.DataParsingService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Tag(name = "Inspetor", description = "Recebe os endpoints referentes a NF-c")
@RestController
@RequestMapping("inspector")
public class InspectorController {

    @Autowired
    DataParsingService dataParsingService;

    @Operation(summary = "Processa a url do QRCODE")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Informações da NF-c foram persistidas no Banco de Dados"),
            @ApiResponse(responseCode = "500", description = "Foi gerada uma exceção"),
    })
    @PostMapping(value = "/process-url", produces = "application/json")
    public ResponseEntity<String> processUrl(@RequestBody Address address) {

        //dataParsingService.parseAndSaveData(htmlResponse);

        return ResponseEntity.ok("Processamento concluído com sucesso." + address.getUrl());
    }

}
