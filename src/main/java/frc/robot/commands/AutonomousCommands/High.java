package frc.robot.commands.AutonomousCommands;

import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import frc.robot.commands.ClawCommands.Claw;
import frc.robot.commands.MovementCommands.DriveBackwardCommand;
import frc.robot.commands.MovementCommands.DriveForwardCommand;
import frc.robot.subsystems.ClawSubsystem;
import frc.robot.subsystems.SwerveSubsystem;

public class High extends SequentialCommandGroup {

  //SCORE CONE ON HIGH NODE 
  public High(SwerveSubsystem swerve, ClawSubsystem claw) {

    addCommands(
      // High goal position (elevator up, pivot out) (parallel cmd)

      // Move forward
      new DriveForwardCommand(swerve, 100),

      // Open claw
      new Claw(claw),

      // Move backward
      new DriveBackwardCommand(swerve, 100)

      // Arm in resting position (pivot in, elevator down) 

    );
  }
}
