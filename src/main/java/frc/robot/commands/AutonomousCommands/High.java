package frc.robot.commands.AutonomousCommands;

import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;

public class High extends SequentialCommandGroup {

  public High() {

    addCommands(
      // High goal position (elevator up, pivot out) (parallel cmd)
      // Move forward
      // Open claw
      // Move backward
      // Arm in resting position (pivot in, elevator down) 
    );
  }
}
