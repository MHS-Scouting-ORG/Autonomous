package frc.robot.commands;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj2.command.CommandBase;
import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import frc.robot.subsystems.SwerveSubsystem;
import frc.robot.commands.MovementCommands.DriveForwardCommand;

public class IncrementBalanceCommand extends CommandBase {
  private final SwerveSubsystem swerve; 
  private Timer timer; 

  public IncrementBalanceCommand(SwerveSubsystem newSwerve) {
    swerve = newSwerve; 
    timer = new Timer(); 

    addRequirements(swerve);
  }

  @Override
  public void initialize() {
  timer.reset();
  }

  @Override
  public void execute() {
    //dummy value
    new DriveForwardCommand(swerve, 100); 
  }

  @Override
  public void end(boolean interrupted) {
    swerve.lock(); 
  }

  @Override
  public boolean isFinished() {
    return false;
  }
}
