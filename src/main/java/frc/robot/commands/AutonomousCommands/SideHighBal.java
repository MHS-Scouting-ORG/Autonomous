package frc.robot.commands.AutonomousCommands;

import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;

public class SideHighBal extends SequentialCommandGroup {

  public SideHighBal() {

    addCommands(
      // High goal position (elevator up, pivot out) 
      // Move forward 
      // Open claw 
      // Move backward 
      // Arm in grabbing position (pivot in, elevator down) 
      // Turn to face cube 
      // Forwards while tracking cube 
      // Claw in 
      // Arm in resting/storage position (elevator up, pivot in) 
      // Strafe left (on left side it would be right)
      // Backward onto Charge Station and balance
    );
  }
}
