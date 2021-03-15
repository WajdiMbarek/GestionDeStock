package com.wajdi.GestionDeStock.dto;


import com.wajdi.GestionDeStock.model.Roles;
import lombok.*;



@Data
@Builder
public class RolesDto{

    private Integer id;

    private String roleName;

    private UtilisateurDto utilisateur;

    public static  RolesDto fromEntity(Roles role){
        if (role == null){
            return null;
            // TODO throw an exception
        }
        return RolesDto.builder()
                .id(role.getId())
                .roleName(role.getRoleName())
                .utilisateur(UtilisateurDto.fromEntity(role.getUtilisateur()))
                .build();
    }
    public static  Roles toEntity(RolesDto rolesDto){
        if (rolesDto == null){
            return null;
            // TODO throw an exception
        }
        Roles roles = new Roles();
        roles.setId(rolesDto.getId());
        roles.setRoleName(rolesDto.getRoleName());
        roles.setUtilisateur(UtilisateurDto.toEntity(rolesDto.getUtilisateur()));
        return roles;

    }




}
