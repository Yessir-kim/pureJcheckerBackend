package edu.isel.csee.TesterForDB.controller.api;

import edu.isel.csee.TesterForDB.domain.document.Policy;
import edu.isel.csee.TesterForDB.service.PolicyService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor // Not required @Autowired
@RequestMapping(value="/api/policy") // base url
public class PolicyController {

    private PolicyService policyService;

    @RequestMapping(value="/post", method= RequestMethod.POST)
    public void savePolicy(@RequestBody Policy policy) {
        policyService.savePost(policy);
    }
}
