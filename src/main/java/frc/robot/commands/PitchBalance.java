package frc.robot.commands;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Constants.AutoConsts;
import frc.robot.subsystems.SwerveSubsystem;

public class PitchBalance extends CommandBase {
  private final SwerveSubsystem swerve;
  private boolean readyToEnd;

  // MOVE UNTIL 13.5 IS READ A SECOND TIME (WHEN IT'S GOING DOWN FROM 15 DEGREES)
  public PitchBalance(SwerveSubsystem newSwerve) {
    swerve = newSwerve;
    readyToEnd = false;

    addRequirements(swerve);
  }

  @Override
  public void initialize() {
    // Reset boolean to false
    readyToEnd = false;
  }

  @Override
  public void execute() {
    // Prints if readyToEnd
    SmartDashboard.putBoolean("Ready To End?", readyToEnd);

    // Strafes right onto charge station
    swerve.strafeRight(AutoConsts.driveTranslationSpeed);
    
    // Checks if pitch is greater than 13.5
    if (swerve.getPitch() > AutoConsts.balanceThreshhold){
      readyToEnd = true;
    }
  }

  @Override
  public void end(boolean interrupted) {
    // Stop then lock drive
    swerve.stopModules();
    swerve.lock();
  }

  @Override
  public boolean isFinished() {
    // Checks a second time if pitch is greater than 13.5, ends if true
    return readyToEnd && swerve.getPitch() > AutoConsts.balanceThreshhold;
  }
}
