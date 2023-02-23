package frc.robot.commands;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Constants.AutoConsts;
import frc.robot.subsystems.SwerveSubsystem;

public class IncrementBalanceCommand extends CommandBase {
  private final SwerveSubsystem swerve;
  private final Timer timer, autoTimer; 
  private int counter;

  private double lSpeed; 
  private double rSpeed; 

  public IncrementBalanceCommand(SwerveSubsystem newSwerve) {
    swerve = newSwerve;
    timer = new Timer();
    autoTimer = new Timer(); 

    addRequirements(swerve);
  }

  private boolean robotRight() {
    return swerve.getYawAngle() > 0 && swerve.getYawAngle() < 90; 
  }

  private boolean robotLeft() {
    return swerve.getYawAngle() < 360 && swerve.getYawAngle() > 270; 
  }

  @Override
  public void initialize() {
    autoTimer.start();
    swerve.resetEnc();
    counter = 0;
  }

  @Override
  public void execute() {
/* 
    if (robotRight()) {
      lSpeed = AutoConsts.driTranslationSlowSpeed; 
      rSpeed = AutoConsts.driveTranslationSpeed; 
    } else if (robotLeft()) {
      lSpeed = AutoConsts.driveTranslationSpeed; 
      rSpeed = AutoConsts.driTranslationSlowSpeed; 
    } else {
      lSpeed = AutoConsts.driveTranslationSpeed; 
      rSpeed = AutoConsts.driveTranslationSpeed; 
    } */
    //swerve.setTank(lSpeed, rSpeed);

    switch (counter) {
      case 0: //drive until -12 deg (initial startup)
        if (swerve.getRoll() <= AutoConsts.initialPitch) {
          swerve.stopModules();
          swerve.resetEnc();
          counter++; 
        } else {
          swerve.driveBackward();
        }
      break; 

      case 1: // drive a little
      swerve.resetEnc();
        if (swerve.getEnc() < AutoConsts.incrementalEncValue) {
          swerve.stopModules();
          counter++;
        } else {
          swerve.driveBackward();
        }

      break;
      
      case 2: // wait and check if roll goes below 10??? deg and go back to case 1 if not 
      timer.start();
      if (timer.get() > 2) { //wait 2 sec 

        //if level, stop 
        if (swerve.getRoll() > AutoConsts.balanceThreshhold) {
          counter++;
        } else {
          counter = 1;
        }

        timer.stop();
        timer.reset();

      }

      break;
      
    }

    /* * * Smart Dashboard * * */
    SmartDashboard.putString("Current Command", getName());
    SmartDashboard.putNumber("Balance Counter", counter);
    SmartDashboard.putNumber("Auto Timer", autoTimer.get());
    SmartDashboard.putNumber("Timer", timer.get());
    SmartDashboard.putNumber("Encoder", swerve.getEnc()); 
  }

  @Override
  public void end(boolean interrupted) {
    SmartDashboard.putString("Current Command", "");
    swerve.stopModules();
    swerve.lock();
  }

  @Override
  public boolean isFinished() {
    //FIXME change pls; actually ends at 3 
    //start off slower; align wheels at init
    return counter == 3 || autoTimer.get() >= 14.5;
  }
}