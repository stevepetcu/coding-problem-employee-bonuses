package com.stefanpetcu.api.employeebonuses.presentation;

import com.stefanpetcu.api.employeebonuses.application.EmployeeBonusesCalculatorService;
import com.stefanpetcu.api.employeebonuses.presentation.requests.BonusesRequestModel;
import com.stefanpetcu.api.employeebonuses.presentation.responses.BonusesDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmployeeController {
    final private EmployeeBonusesCalculatorService employeeBonusesCalculator;

    public EmployeeController(EmployeeBonusesCalculatorService employeeBonusesCalculator) {
        this.employeeBonusesCalculator = employeeBonusesCalculator;
    }

    @PostMapping(value = "/bonuses", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<BonusesDto> bonuses(@RequestBody BonusesRequestModel bonusesRequest) {
        BonusesDto bonuses = new BonusesDto(employeeBonusesCalculator.bonusesFor(bonusesRequest.getEmployeesCodeOutputs()));
        return new ResponseEntity<>(bonuses, HttpStatus.OK);
    }

    // TODO: [23/11/2021]
    //  -- [ ] Add PACTs between the input "REST" APIs and the events consuming APIs ------------------------------------------------------------------------------------------------------------------------------------------------------------- 2.50 hours ---> Tue
    //  -- [ ] Make an API that can connect to a DB; implement an AGGREGATE pattern; parametrise the DB URL based on application config; make the DB run as a Docker container and add integration tests ------------------------------------------ 6.00 hours ---> Next --> Tue, Wed
    //  -- [ ] For the previous API, add error logging; parametrise the error logging URL based on application config; make the app "polymorphic" and log errors to the console when ran "locally", or to another API when the env is different --- 3.00 hours ---> Next, next, next --> Thu
    //  -- [ ] Read: books, read up on TG, read up on TG's CEO, complete my Mural & plan TG inception and first 30 - 60 days ---------------------------------------------------------------------------------------------------------------------- 3h - 5h/day --> Wed, Thu, Fri, Sat, Sun
    //  -- [ ] See how I can make these APIs push their responses onto an SQS -------------------------------------------------------------------------------------------------------------------------------------------------------------------- 1.00 hours ---> [OPTIONAL] Next, next, next, next
    //  -- [ ] Implement that stuff on AWS, using CDK to store the infra (make a common-infra repo in Kotlin or TS) ------------------------------------------------------------------------------------------------------------------------------ 5.00 hours ---> [OPTIONAL] Next, next, next, next
    //  -- [ ] Make another Java API that can subscribe to that queue (SNS??) and log the events to the console as they come --------------------------------------------------------------------------------------------------------------------- 6.00 hours ---> [OPTIONAL] Next, next, next, next
    //  ==================================================================================================================================================
    //  -- Total: ----------------------------------------------------------------------------------------------------------------------------- 31.00 hours [52 hours with the optionals]
    //  -- Available [23/11/2021] ------------------------------------------------------------------------------------------ Min: ~40.00, Max: ~55.00 hours
    //  -- Christmas vacation: most of the above should be done (75% or more). Start reading! Read all the most relevant parts of the books I've saved and update my apps as well. Reallllly refine my plan for bootstrapping the team, including: inception, storming, team canvas, feature leads, technologies adopted, team ways of working, team coding standards, addressing tech debt, team building and fun activities, team champions (like fun champion), wiki pages outline
    //  -- Clean up my Trello, optimise it with the Mural board; clean up my reminders; clean up my flat; clean up my schedule (including starting to go to the gym 1 - 2 times a week (Saturdays?)); re-energise and re-start!
    //  -- At the end, I need 3 - 4 days of complete rest before my new job
    //  ==> 20 - 21.11.2021: practice optionals; focus on my Mural and making my plan -- add these dates and my reading list there; adapt reading list based on Mural; also start reading 2h/day; be selective and make relevant notes. Start with: DDD + Effective Java & reading on Kotlin; next: Tech leading, Agile estimating and planning, other Agile stuff (from my Mural); next: Clean Architecture and Concurrency in Practice; next: Tricks to Appear Smart in Meetings; next: Persuasion, more TL
}
