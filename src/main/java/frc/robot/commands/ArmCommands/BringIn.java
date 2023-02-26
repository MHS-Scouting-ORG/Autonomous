package frc.robot.commands.ArmCommands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.ElevatorSubsystem;
import frc.robot.subsystems.PivotSubsystem;

public class BringIn extends CommandBase {

  PivotSubsystem pivotSub;
  ElevatorSubsystem elevSub;
  public BringIn(PivotSubsystem pivotSub, ElevatorSubsystem elevSub) {
    this.pivotSub = pivotSub;
    this.elevSub = elevSub;

    addRequirements(pivotSub, elevSub);
  }

  @Override
  public void initialize() {
    if(elevSub.getEncoder() < 50){
      new TuckedFromBottom(pivotSub, elevSub);
    }
    else{
      new TuckedFromTop(pivotSub, elevSub);
    }
  }

  @Override
  public void execute() {}
    

  @Override
  public void end(boolean interrupted) {}

  @Override
  public boolean isFinished() {
    return true;
  }
}