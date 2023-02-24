package frc.robot.commands.AutonomousCommands;

import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import frc.robot.subsystems.SwerveSubsystem;

public class SideHybrid extends SequentialCommandGroup {

  // Start at community edge
  // Drop pre-load into hybrid

  private final SwerveSubsystem swerve;

  public SideHybrid(SwerveSubsystem newSwerve) {
    swerve = newSwerve;

    addCommands(


    );

  }
}
