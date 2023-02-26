package frc.robot.commands.AutonomousCommands;

import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;

public class SideHighPickup extends SequentialCommandGroup {

  public SideHighPickup() {

    addCommands(
      // High goal position (elevator up, pivot out) (parallel cmd)
      // Move forward
      // Open claw
      // Move backward
      // Arm in resting position (pivot in, elevator down)
      // Turn 180
      // Move forward while tracking cube
      // Pick-up cube
    );
  }
}
