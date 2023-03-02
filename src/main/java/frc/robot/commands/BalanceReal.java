package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import frc.robot.subsystems.SwerveSubsystem;

public class BalanceReal extends SequentialCommandGroup {

  public BalanceReal(SwerveSubsystem swerve) {
    addCommands(
      new PitchBalance(swerve), 

      new PitchBalance(swerve)
    );
  }
}
