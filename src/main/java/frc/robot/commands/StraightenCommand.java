package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.SwerveSubsystem;

public class StraightenCommand extends CommandBase {

  private final SwerveSubsystem swerve;

  public StraightenCommand(SwerveSubsystem newSwerve) {
    swerve = newSwerve;
  }

  @Override
  public void initialize() {}

  @Override
  public void execute() {}

  @Override
  public void end(boolean interrupted) {}

  @Override
  public boolean isFinished() {
    return false;
  }
}
