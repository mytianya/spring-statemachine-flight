package vip.codehome.fsm.flight.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.statemachine.annotation.OnTransition;
import org.springframework.statemachine.annotation.WithStateMachine;

/***
 * @author 道士吟诗
 * @date 2021/4/20-下午10:18
 * @description
 ***/
@WithStateMachine(name = "flightSingleMachine",id = "FLIGHT")
@Slf4j
public class FlightSingleEventConfig {
    @OnTransition(target ="PLAN")
    public void plan(){
      log.info("---航班计划飞行---");
    }
    @OnTransition(source = "PLAN",target = "FLY")
    public void fly(){
        log.info("-----航班起飞----");
    }
}
