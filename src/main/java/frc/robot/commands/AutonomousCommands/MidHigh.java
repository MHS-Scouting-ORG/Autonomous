package frc.robot.commands.AutonomousCommands;

import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;

public class MidHigh extends SequentialCommandGroup {

  public MidHigh() {
    // score cone on high node 
    addCommands(
      //claw in 
      // elev up 
      //pivot out 
      //move forward
      //release claw 
      //move backward 
      //pivot in 
      //elev down
    );
  }
}
