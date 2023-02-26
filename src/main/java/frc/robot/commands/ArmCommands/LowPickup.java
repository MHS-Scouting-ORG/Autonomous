package frc.robot.commands.ArmCommands;

import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import frc.robot.commands.ElevatorCommands.LowPosition;
import frc.robot.commands.ElevatorCommands.MidPosition;
import frc.robot.commands.PivotCommands.PivotLowCmd;
import frc.robot.subsystems.ElevatorSubsystem;
import frc.robot.subsystems.PivotSubsystem;

public class LowPickup extends SequentialCommandGroup {

  // MOVE PIVOT AND ELEV TO GROUND PICKUP POSITION 
  public LowPickup(PivotSubsystem pivotSub, ElevatorSubsystem elevSub) {

    addCommands(new MidPosition(elevSub), new PivotLowCmd(pivotSub), new LowPosition(elevSub));
  }
}