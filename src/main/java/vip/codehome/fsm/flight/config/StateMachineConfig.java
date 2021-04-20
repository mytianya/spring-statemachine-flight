package vip.codehome.fsm.flight.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.statemachine.config.EnableStateMachine;
import org.springframework.statemachine.config.EnableStateMachineFactory;
import org.springframework.statemachine.config.EnumStateMachineConfigurerAdapter;
import org.springframework.statemachine.config.builders.StateMachineStateConfigurer;
import org.springframework.statemachine.config.builders.StateMachineTransitionConfigurer;
import vip.codehome.fsm.flight.FlightApplication;
import vip.codehome.fsm.flight.enums.FlightEvents;
import vip.codehome.fsm.flight.enums.FlightStates;

import java.util.EnumSet;

/***
 * @author 道士吟诗
 * @date 2021/4/20-下午10:05
 * @description
 ***/
@Configuration
//@EnableStateMachine
//@EnableStateMachineFactory(name = "flightSingleMachine")
public class StateMachineConfig extends EnumStateMachineConfigurerAdapter<FlightStates, FlightEvents> {

    @Override
    public void configure(StateMachineStateConfigurer<FlightStates, FlightEvents> states) throws Exception {
        states.withStates().initial(FlightStates.PLAN).states(EnumSet.allOf(FlightStates.class));
    }

    @Override
    public void configure(StateMachineTransitionConfigurer<FlightStates, FlightEvents> transitions) throws Exception {
        transitions.withExternal().source(FlightStates.PLAN).target(FlightStates.FLY).event(FlightEvents.DEP)
                .and()
                .withExternal().source(FlightStates.FLY).target(FlightStates.DONE).event(FlightEvents.ARR);
    }
}
