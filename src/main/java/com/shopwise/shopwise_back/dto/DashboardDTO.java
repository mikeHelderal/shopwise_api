package com.shopwise.shopwise_back.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DashboardDTO {
    private long totalClients;
    private long rdvDuJour;
    private long produitsEnAlerte;

    public DashboardDTO() {}

    public DashboardDTO(long totalClients, long rdvDuJour, long produitsEnAlerte) {
        this.totalClients = totalClients;
        this.rdvDuJour = rdvDuJour;
        this.produitsEnAlerte = produitsEnAlerte;
    }
}
