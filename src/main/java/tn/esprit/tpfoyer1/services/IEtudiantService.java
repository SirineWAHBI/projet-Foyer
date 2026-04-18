package tn.esprit.tpfoyer1.services;

import tn.esprit.tpfoyer1.entity.Etudiant;

import java.util.List;

public interface IEtudiantService {

    Etudiant addEtudiant(Etudiant etudiant);

    List<Etudiant> getAllEtudiants();

    Etudiant getEtudiantById(Long id);

    void deleteEtudiant(Long id);

    Etudiant updateEtudiant(Etudiant etudiant);
}
