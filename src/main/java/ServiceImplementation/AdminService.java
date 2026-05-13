package ServiceImplementation;

import DAO.AdminRepository;
import models.Admin;

public class AdminService {
    private final AdminRepository adminRepository ;

    public AdminService(AdminRepository adminRepository){
        this.adminRepository = adminRepository;
    }

    public void add(Admin admin){
        if(admin.getNom() == null || admin.getNom().trim().isEmpty()){
            System.out.println("le nom est obligatoire.");
            return;
        }
        if(admin.getPrenom() == null || admin.getPrenom().trim().isEmpty()){
            System.out.println("le prenom est obligatoire.");
            return;
        }
        if(admin.getEmail() == null || admin.getEmail().trim().isEmpty()){
            System.out.println("le email est obligatoire.");
            return;
        }
        if (admin.getTelephone()==null || admin.getTelephone().trim().isEmpty()){
            System.out.println("le telephone est obligatoire.");
            return;
        }
        if (admin.getMotDePasse()==null || admin.getMotDePasse().trim().isEmpty()){
            System.out.println("le motDePasse est obligatoire.");
            return;
        }
        adminRepository.add(admin);
    }
    public void delete(Admin admin){
        if(admin.getIdUtilisateur() < 0) {
            System.out.println("Le id est obligatoire.");
            return;
        }
        adminRepository.delete(admin.getIdUtilisateur());
    }
    public void update(Admin admin){
        if(admin.getIdUtilisateur() < 0) {
            System.out.println("Le id est obligatoire.");
            return;
        }
        adminRepository.update(admin.getIdUtilisateur());
    }



}
