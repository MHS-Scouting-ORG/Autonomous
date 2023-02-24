package frc.robot.commands.AutonomousCommands;

import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import frc.robot.subsystems.SwerveSubsystem;

public class MidHighBalance extends SequentialCommandGroup {

  // Start at middle position
  // Place pre-load at high
  // Balance onto charge station

  private final SwerveSubsystem swerve;

  public MidHighBalance(SwerveSubsystem newSwerve) {
    swerve = newSwerve;

    addCommands(


    );

  }
}
