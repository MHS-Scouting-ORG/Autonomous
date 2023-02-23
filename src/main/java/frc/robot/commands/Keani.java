package frc.robot.commands;

import java.io.FilenameFilter;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.SwerveSubsystem;

public class Keani extends CommandBase {

  private final SwerveSubsystem swerve;

  public Keani(SwerveSubsystem newSwerve) {
    swerve = newSwerve;
  }

  @Override
  public void initialize() {
    SmartDashboard.putString("Current Command", getName());
  }

  @Override
  public void execute() {}

  @Override
  public void end(boolean interrupted) {
    swerve.keaniIsSortaCool();
  }

  @Override
  public boolean isFinished() {
    return true;
  }
}
