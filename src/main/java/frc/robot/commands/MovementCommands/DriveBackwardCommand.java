package frc.robot.commands.MovementCommands;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.SwerveSubsystem;

public class DriveBackwardCommand extends CommandBase {
  private final SwerveSubsystem swerve; 
  private double desiredEnc; 
  private Timer timer; 

  public DriveBackwardCommand(SwerveSubsystem newSwerve) {
    swerve = newSwerve; 
    timer = new Timer(); 

    addRequirements(swerve);
  }

  @Override
  public void initialize() {
    timer.reset();
    timer.start();
  }

  @Override
  public void execute() {
    SmartDashboard.putString("Current Command", getName());
    SmartDashboard.putNumber("Timer", timer.get()); 
  }

  @Override
  public void end(boolean interrupted) {
    timer.stop();
  }

  @Override
  public boolean isFinished() {
    return timer.get() >= 3; 
  }
}
