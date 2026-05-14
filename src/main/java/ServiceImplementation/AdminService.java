package ServiceImplementation;

import DAO.AdminRepository;
import Service.AdminServiceDao;
import models.Admin;

import java.util.List;
import java.util.Optional;

public class AdminService implements AdminServiceDao {
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

    @Override
    public Optional<Admin> getById(int id) {
        if(id < 0){
            System.out.println("Le id est obligatoire.");
        }
        adminRepository.getById(id);
        return Optional.empty();
    }

    @Override
    public List<Admin> getAll() {
        return adminRepository.getAll();
    }

    @Override
    public void update(int id) {
        if(id < 0) {
            System.out.println("Le id est obligatoire.");
            return;
        }
        adminRepository.update(id);
    }

    @Override
    public void delete(int id) {
        if(id < 0) {
            System.out.println("Le id est obligatoire.");
            return;
        }
        adminRepository.delete(id);
    }



}
