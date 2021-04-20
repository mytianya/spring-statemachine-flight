package vip.codehome.fsm.flight.config;

import org.springframework.statemachine.StateMachine;
import org.springframework.statemachine.config.StateMachineBuilder;
import org.springframework.stereotype.Component;
import vip.codehome.fsm.flight.enums.FlightEvents;
import vip.codehome.fsm.flight.enums.FlightStates;

import java.util.EnumSet;

/***
 * @author 道士吟诗
 * @date 2021/4/20-下午11:12
 * @description
 ***/
@Component
public class StateMachineBuilderConfig {
    public StateMachine<FlightStates, FlightEvents> build() throws Exception {
        StateMachineBuilder.Builder<FlightStates, FlightEvents> builder= StateMachineBuilder.builder();
        builder.configureConfiguration()
                .withConfiguration()
                .machineId("FLIGHT");
        builder.configureStates().withStates().initial(FlightStates.PLAN).states(EnumSet.allOf(FlightStates.class));
        builder.configureTransitions().withExternal().source(FlightStates.PLAN).target(FlightStates.FLY).event(FlightEvents.DEP)
                .and()
                .withExternal().source(FlightStates.FLY).target(FlightStates.DONE).event(FlightEvents.ARR);

        return builder.build();
    }
}
