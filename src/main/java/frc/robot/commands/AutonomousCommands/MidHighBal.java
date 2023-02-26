package frc.robot.commands.AutonomousCommands;

import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;

public class MidHighBal extends SequentialCommandGroup {

  public MidHighBal() {

    addCommands(
      // High goal position (elevator up, pivot out) (parallel cmd) 
      // Move forward
      // Open claw
      // Move backward
      // Arm in resting position (pivot in, elevator down)
      // Move backward onto Charge Station and balance
    );
  }
}
