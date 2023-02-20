package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.SwerveSubsystem;

public class BackwardsUntilOnStationCommand extends CommandBase {
  private final SwerveSubsystem swerve;
  private double currentPitch;

  public BackwardsUntilOnStationCommand(SwerveSubsystem newSwerve) {
    swerve = newSwerve;

    addRequirements(swerve);
  }

  @Override
  public void initialize() {
    swerve.stopModules();
  }

  @Override
  public void execute() {
    currentPitch = swerve.getRoll();

    swerve.driveBackward();
  }

  @Override
  public void end(boolean interrupted) {
    swerve.stopModules();
  }

  @Override
  public boolean isFinished() {
    return currentPitch > 8;
  }
}
