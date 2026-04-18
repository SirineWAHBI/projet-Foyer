package tn.esprit.tpfoyer1.services;

import tn.esprit.tpfoyer1.dto.BlocDTO;

import java.util.List;

public interface IBlocService {

    BlocDTO addBloc(BlocDTO dto);

    BlocDTO updateBloc(BlocDTO dto);

    void deleteBloc(Long id);

    BlocDTO getBlocById(Long id);

    List<BlocDTO> getAllBlocs();
}