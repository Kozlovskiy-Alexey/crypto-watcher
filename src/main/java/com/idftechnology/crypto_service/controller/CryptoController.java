package com.idftechnology.crypto_service.controller;

import com.idftechnology.crypto_service.dto.CryptoDto;
import com.idftechnology.crypto_service.dto.CryptoPageDto;
import com.idftechnology.crypto_service.service.api.ICryptoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/crypto")
public class CryptoController {

    private final ICryptoService cryptoService;

    public CryptoController(ICryptoService cryptoService) {
        this.cryptoService = cryptoService;
    }

    @GetMapping
    public ResponseEntity<CryptoPageDto> getCryptoPage(@RequestParam(name = "page", defaultValue = "0") int page,
                                           @RequestParam(name = "size", defaultValue = "20") int size) {
        CryptoPageDto dto = cryptoService.getCryptoPage(page, size);
        return new ResponseEntity<>(dto, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<CryptoDto> getCryptoById(@PathVariable(name = "id") int id) {
        CryptoDto dto = cryptoService.get(id);
        return new ResponseEntity<>(dto, HttpStatus.OK);
    }
}
