package com.uptc.frw.aparatoselectronicos.resolver;

import com.uptc.frw.aparatoselectronicos.model.Repair;
import com.uptc.frw.aparatoselectronicos.service.RepairService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@Controller
public class RepairsDataFetcher {
    @Autowired
    private RepairService repairService;

    @QueryMapping
    public List<Repair> getRepairs() {
        return repairService.findAllRepairs();
    }

    @QueryMapping
    public Repair getRepairById(@Argument Long id) {
        return repairService.findRepairById(id);
    }

    @MutationMapping
    public Repair createRepair(@Argument Long id, @Argument String description, @Argument Date date, @Argument Long apparatusId, @Argument Long clientId) {
        Repair repair = new Repair();
        repair.setId(id);
        repair.setDescription(description);
        repair.setApparatusId(apparatusId);
        repair.setClientId(clientId);
        repair.setDate(date);
        return repairService.saveRepair(repair);
    }

    @MutationMapping
    public Repair updateRepair(@Argument Long id, @Argument String description, @Argument String date, @Argument Long apparatusId, @Argument Long clientId) {
        Repair repair = new Repair();
        repair.setId(id);
        repair.setDescription(description);
        repair.setApparatusId(apparatusId);
        repair.setClientId(clientId);
        repair.setDate(new Date(date));
        return repairService.updateRepair(repair);
    }

    @MutationMapping
    public void deleteRepair(@Argument Long id) {
        repairService.deleteReapir(id);
    }

}
