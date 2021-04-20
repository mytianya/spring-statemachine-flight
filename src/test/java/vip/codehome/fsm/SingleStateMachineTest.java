package vip.codehome.fsm;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.statemachine.StateMachine;
import org.springframework.statemachine.config.StateMachineFactory;
import org.springframework.test.context.junit4.SpringRunner;
import vip.codehome.fsm.flight.FlightApplication;
import vip.codehome.fsm.flight.config.StateMachineBuilderConfig;
import vip.codehome.fsm.flight.enums.FlightEvents;
import vip.codehome.fsm.flight.enums.FlightStates;

/***
 * @author 道士吟诗
 * @date 2021/4/20-下午10:21
 * @description
 ***/
@RunWith(SpringRunner.class)
@SpringBootTest(classes = FlightApplication.class)
public class SingleStateMachineTest {
//    @Autowired
//    private StateMachine stateMachine;
//    @Test
//    public void testSingle() throws InterruptedException {
//        stateMachine.start();
//        stateMachine.sendEvent(FlightEvents.DEP);
//        System.out.println(stateMachine.getState().getId());
//        Thread.sleep(5000);
//    }
    //状态机工厂
//    @Autowired
//    StateMachineFactory<FlightStates,FlightEvents> factory;
//    @Test
//    public void createNewMachine(){
//        StateMachine<FlightStates,FlightEvents> m1=factory.getStateMachine("m1");
//        StateMachine<FlightStates,FlightEvents> m2=factory.getStateMachine("m2");
//        StateMachine<FlightStates,FlightEvents> m1old=factory.getStateMachine("m1");
//        StateMachine<FlightStates,FlightEvents> newM=factory.getStateMachine();
//        m1.start();
//        m2.start();
//        m1.sendEvent(FlightEvents.DEP);
//        System.out.println(m1.getState().getId());
//        System.out.println(m1.getId());
//        System.out.println(m2.getState().getId());
//        System.out.println(m2.getId());
//        System.out.println(newM.getState().getId());
//        System.out.println(newM.getId());
//        System.out.println(m1old.getState().getId());
//        System.out.println(m1old.getId());
//    }
    @Autowired
    StateMachineBuilderConfig stateMachineBuilderConfig;
    @Test
    public void testMultiSM() throws Exception {
        StateMachine m1= stateMachineBuilderConfig.build();
        StateMachine m2= stateMachineBuilderConfig.build();
        m1.start();
        m2.start();
        m1.sendEvent(FlightEvents.DEP);
        System.out.println(m1.getState().getId());
        System.out.println(m1.getId());
        System.out.println(m2.getState().getId());
        System.out.println(m2.getId());
    }
}
