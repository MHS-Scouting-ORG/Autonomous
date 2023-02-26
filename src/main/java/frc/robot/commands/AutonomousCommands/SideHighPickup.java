package frc.robot.commands.AutonomousCommands;

import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import frc.robot.commands.ClawCommands.Claw;
import frc.robot.commands.MovementCommands.DriveBackwardCommand;
import frc.robot.commands.MovementCommands.DriveForwardCommand;
import frc.robot.commands.MovementCommands.RotateRightCommand;
import frc.robot.subsystems.ClawSubsystem;
import frc.robot.subsystems.SwerveSubsystem;

public class SideHighPickup extends SequentialCommandGroup {

  public SideHighPickup(SwerveSubsystem swerve, ClawSubsystem claw) {

    // SCORE CONE ON HIGH NODE, PICK UP CUBE 
    addCommands(
      // High goal position (elevator up, pivot out) (parallel cmd)

      // Move forward
      new DriveForwardCommand(swerve, 0),

      // Open claw
      new Claw(claw),

      // Move backward
      new DriveBackwardCommand(swerve, 0),

      // Arm in pickup position (pivot in, elevator down)

      // Turn 180
      new RotateRightCommand(swerve, 0),

      // Move forward while tracking cube
      new DriveForwardCommand(swerve, 0),

      // Claw close
      new Claw(claw)

    );
  }
}
