package com.app.controllers;

import java.util.List;
import java.util.Optional;

import com.app.model.Etape;
import com.app.services.EtapeService;

public class EtapeController {
    private final EtapeService etapeService;

    public EtapeController(EtapeService etapeService) {
        this.etapeService = etapeService;
    }

    public boolean createEtape(Etape etape) {
        return etapeService.createEtape(etape);
    }

    public Optional<Etape> getEtape(int id) {
        return etapeService.getEtapeById(id);
    }

    public List<Etape> getAllEtapes() {
        return etapeService.getAllEtapes();
    }

    public boolean updateEtape(Etape etape) {
        return etapeService.updateEtape(etape);
    }

    public boolean deleteEtape(int id) {
        return etapeService.deleteEtape(id);
    }
}
