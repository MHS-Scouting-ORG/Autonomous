package frc.robot.commands.ArmCommands;

import edu.wpi.first.wpilibj2.command.ParallelCommandGroup;
import edu.wpi.first.wpilibj2.command.SelectCommand;
import frc.robot.commands.ElevatorCommands.HighPosition;
import frc.robot.commands.PivotCommands.PivotHighCmd;
import frc.robot.subsystems.ElevatorSubsystem;
import frc.robot.subsystems.PivotSubsystem;

public class HighAutoPositionParallel extends ParallelCommandGroup {

  //PARALLEL COMMAND FOR HIGH POSITION IN AUTO 
  public HighAutoPositionParallel(PivotSubsystem pivotSub, ElevatorSubsystem elevSub) {
    addCommands(new HighPosition(elevSub), new PivotHighCmd(pivotSub));
  }
}