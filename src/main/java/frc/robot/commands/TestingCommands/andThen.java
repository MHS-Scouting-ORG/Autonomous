package frc.robot.commands.TestingCommands;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj2.command.CommandBase;
import edu.wpi.first.wpilibj2.command.Commands;
import frc.robot.commands.MovementCommands.DriveBackwardCommand;
import frc.robot.commands.MovementCommands.DriveForwardCommand;
import frc.robot.subsystems.SwerveSubsystem;

public class andThen extends CommandBase {
private SwerveSubsystem swerve; 
private int counter; 
private Timer timer; 

  public andThen(SwerveSubsystem newSwerve) {
    swerve = newSwerve; 
    timer = new Timer(); 

    addRequirements(swerve);
  }

  @Override
  public void initialize() {
    swerve.resetEnc();
    swerve.resetNavx();
    counter = 0; 
    timer.reset();
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
        Commands.runOnce( () -> new DriveBackwardCommand(swerve, 2).andThen( () -> new DriveForwardCommand(swerve, 2)), swerve);
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {}

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
