package frc.robot.commands.AutonomousCommands;

import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;

public class Hybrid extends SequentialCommandGroup {

  public Hybrid() {
    
    addCommands(
      // Arm in hybrid goal position (pivot out, elevator down) 
      // Move forward 
      // Open claw 
      // Move backward
      // Arm in resting position (pivot in, elevator down) 
    );
  }
}
