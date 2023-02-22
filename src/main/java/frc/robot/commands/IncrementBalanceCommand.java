package frc.robot.commands;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.CommandBase;
import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import frc.robot.subsystems.SwerveSubsystem;
import frc.robot.commands.MovementCommands.DriveForwardCommand;
import frc.robot.commands.MovementCommands.DriveBackwardCommand;

public class IncrementBalanceCommand extends CommandBase {

  // Unused command, use Balance.java for used incrementation command


  private final SwerveSubsystem swerve;
  private final Timer timer; 
  private final Timer autoTimer; 
  private double prevPitch; 
  private double currentPitch; 

  public IncrementBalanceCommand(SwerveSubsystem newSwerve) {
    swerve = newSwerve; 

    // Instantiate timers
    timer = new Timer(); 
    autoTimer = new Timer(); 

    addRequirements(swerve);
  }

  @Override
  public void initialize() {
  
  // Start timers, set the previous pitch to 0
  timer.start();
  autoTimer.start();

  prevPitch = 0; 
  }

  @Override
  public void execute() {

    // Print timers to SmartDashboard
    SmartDashboard.putNumber("Timer", timer.get());
    SmartDashboard.putString("Current Command", getName());

    // Wait 1 second, then drive backwards
    if (timer.get() >= 1) {
      swerve.driveBackward(); 
      timer.reset();
    } 
    
    // Set prevpitch to the previous pitch, then get the new current pitch
    prevPitch = currentPitch; 
    currentPitch = swerve.getRoll();
  }

  @Override
  public void end(boolean interrupted) {

    // Stop and lock drive
    swerve.lock(); 
    SmartDashboard.putString("Current Command", "");
  }

  @Override
  public boolean isFinished() {
    /*navx reads drop or autonomous period ends  */
    return Math.abs(currentPitch - prevPitch) >= 5 || autoTimer.get() >= 14.5; //change timer bool later  if need
  }
}
