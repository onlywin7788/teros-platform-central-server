package com.teros.central_server.controller.api.v1.database.apiservice.plan;

import com.teros.central_server.entity.apiservice.plan.PlanEntity;
import com.teros.central_server.model.apiservice.plan.ModelParamPlan;
import com.teros.central_server.model.response.CommonResult;
import com.teros.central_server.model.response.ListResult;
import com.teros.central_server.model.response.SingleResult;
import com.teros.central_server.service.database.apiservice.plan.PlanService;
import com.teros.central_server.service.database.apiservice.response.ResponseService;
import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.*;

@Api(tags = {"api-service : plan"})
@RestController
@RequestMapping(value = "/v1")
public class PlanRestController {

    private final PlanService planService;
    private final ResponseService responseService;

    public PlanRestController(PlanService planService, ResponseService responseService) {
        this.planService = planService;
        this.responseService = responseService;
    }

    @GetMapping(value = "/plan/{id}")
    public SingleResult<PlanEntity> getPlan(@PathVariable long id) {
        return responseService.getSingleResult(planService.getPlan(id));
    }

    @GetMapping(value = "/plan")
    public ListResult<PlanEntity> getPlanList() {
        return responseService.getListResult(planService.getPlanList());
    }

    @PostMapping(value = "/plan")
    public void insertPlan(@RequestBody ModelParamPlan modelParamPlan) {
        planService.savePlan(modelParamPlan);
    }

    @PutMapping(value = "/plan/{id}")
    public Long updatePlan(@PathVariable long id, @RequestBody ModelParamPlan modelParamPlan) {
        return planService.updatePlan(id, modelParamPlan);
    }

    @DeleteMapping(value = "/plan/{id}")
    public CommonResult deletePlan(@PathVariable long id) {
        boolean ret = planService.deletePlan(id);
        return responseService.getResult(ret);
    }
}